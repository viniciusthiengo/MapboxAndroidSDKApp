package br.com.thiengo.myfirstglapp;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.annotations.PolygonOptions;
import com.mapbox.mapboxsdk.annotations.Sprite;
import com.mapbox.mapboxsdk.annotations.SpriteFactory;
import com.mapbox.mapboxsdk.constants.Style;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.views.MapView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MapView mapView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mapView = (MapView) findViewById(R.id.mapView);
        mapView.setStyleUrl(Style.MAPBOX_STREETS );
        mapView.setZoomControlsEnabled(true);
        mapView.setZoomLevel(11);
        mapView.setLogoVisibility(View.INVISIBLE );

        /*mapView.setMyLocationEnabled(true);
        if( mapView.getMyLocation() != null ){
            LatLng latLng = new LatLng( mapView.getMyLocation().getLatitude(), mapView.getMyLocation().getLongitude() );

            mapView.setCenterCoordinate(latLng);
        }*/

        SpriteFactory spriteFactory = mapView.getSpriteFactory();
        Drawable drawable = ContextCompat.getDrawable(this, R.mipmap.ic_directions_car_black_24dp);
        Sprite icon = spriteFactory.fromDrawable(drawable);

        mapView.addMarker( new MarkerOptions()
                .position( new LatLng(42.296169, -83.027266) )
                .title("Test")
                .snippet("Description test").icon( icon ));

        mapView.setCenterCoordinate(new LatLng(42.296169, -83.027266));


        ArrayList<LatLng> polygon = new ArrayList<>();

        polygon.add(new LatLng(45.522585, -122.685699));
        polygon.add(new LatLng(45.534611, -122.708873));
        polygon.add(new LatLng(45.530883, -122.678833));
        polygon.add(new LatLng(45.547115, -122.667503));
        polygon.add(new LatLng(45.530643, -122.660121));
        polygon.add(new LatLng(45.533529, -122.636260));
        polygon.add(new LatLng(45.521743, -122.659091));
        polygon.add(new LatLng(45.510677, -122.648792));
        polygon.add(new LatLng(45.515008, -122.664070));
        polygon.add(new LatLng(45.502496, -122.669048));
        polygon.add(new LatLng(45.515369, -122.678489));
        polygon.add(new LatLng(45.506346, -122.702007));
        polygon.add(new LatLng(45.522585, -122.685699));

        mapView.addPolygon(new PolygonOptions()
                .addAll(polygon)
                .fillColor(Color.parseColor("#3bb2d0")));
        mapView.setCenterCoordinate(new LatLng(45.522585, -122.685699));

        mapView.onCreate(savedInstanceState);
    }


    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onPause()  {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
}
