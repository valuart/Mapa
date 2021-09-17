package com.example.mapa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity {
 private LatLng SANLUIS = new LatLng(-33.2659278,-66.2962204);
 private LatLng ULP = new LatLng(-33.148987,-66.324876);
 private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMapAsync(new MapaActual());

    }

    private class MapaActual implements OnMapReadyCallback {
        @Override
        public void onMapReady(GoogleMap mapa) {
            map = mapa;
            mapa.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

            CameraPosition camPos = new CameraPosition.Builder()
                    .target(SANLUIS)
                    .zoom(19)
                    .bearing(45)
                    .tilt(70)
                    .build();
            CameraUpdate camUpdICT = CameraUpdateFactory.newCameraPosition(camPos);


            mapa.animateCamera(camUpdICT);

            MarkerOptions marcadorSanLuis = new MarkerOptions();
            marcadorSanLuis.position(SANLUIS);
            marcadorSanLuis.title("San Luis");

            mapa.addMarker(marcadorSanLuis);
            mapa.addMarker(new MarkerOptions().position(ULP).title("ULP"));
        }

    }

}