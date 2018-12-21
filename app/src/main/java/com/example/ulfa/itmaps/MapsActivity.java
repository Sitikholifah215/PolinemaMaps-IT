package com.example.ulfa.itmaps;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.example.ulfa.itmaps.DirectionHelpers.FetchURL;
import com.example.ulfa.itmaps.DirectionHelpers.TaskLoadedCallback;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Button btnBack;
    TextView kd;
    double latitude, longitude;
//    LocationRequest mLocationRequest;
//    GoogleApiClient mGoogleApiClient;
//    Location mLastLocation;
//    Marker mCurrLocationMarker;
//    MarkerOptions place1, place2;
//    private Polyline currentPolyline;
//    FloatingActionButton getDirection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
//        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            checkLocationPermission();
//        }

        btnBack = findViewById(R.id.btn_Back_Maps);
        kd = findViewById(R.id.txt_nama_g_r);
        final Intent Maps = getIntent();
        String kd_r_g = Maps.getStringExtra("kd");
        latitude = Maps.getDoubleExtra("latitude",0);
        longitude = Maps.getDoubleExtra("longitude",0);
        kd.setText(kd_r_g);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Menambahkan marker untuk kota Malang, memindahkan camera, dan melakukan zoom in
        LatLng tujuan = new LatLng(-7.946534, 112.615122);
        mMap.addMarker(new MarkerOptions().position(tujuan).title("Marker "));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tujuan,14.0f));

    }

//    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
//    public boolean checkLocationPermission(){
//        if (ContextCompat.checkSelfPermission(this,
//                Manifest.permission.ACCESS_FINE_LOCATION)
//                != PackageManager.PERMISSION_GRANTED) {
//            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
//                    Manifest.permission.ACCESS_FINE_LOCATION)) {
//                ActivityCompat.requestPermissions(this,
//                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
//                        MY_PERMISSIONS_REQUEST_LOCATION);
//            } else {
//                ActivityCompat.requestPermissions(this,
//                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
//                        MY_PERMISSIONS_REQUEST_LOCATION);
//            }
//            return false;
//        } else {
//            return true;
//        }
//    }
}