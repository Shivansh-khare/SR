package com.example.sr;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.firebase.geofire.GeoFire;
import com.firebase.geofire.GeoLocation;
import com.firebase.geofire.LocationCallback;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
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
        final LatLng[] a = new LatLng[1];
        double[] aloc = {0.0,0.0};
        final MarkerOptions[] marker = new MarkerOptions[1];

        DatabaseReference mRef = FirebaseDatabase.getInstance().getReference("Trans");
        mRef.child(getIntent().getStringExtra("busId")).child("lat").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                aloc[0]=(double)snapshot.getValue();
                a[0] = new LatLng(aloc[0],aloc[1]);
//                    System.out.println(String.format("The location for key %s is [%f,%f]", key, location.latitude, location.longitude));
                marker[0] = new MarkerOptions().position(a[0]).title("Bus location");
                mMap.clear();
                mMap.addMarker(marker[0]);
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(a[0],20));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        mRef.child(getIntent().getStringExtra("busId")).child("lon").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                aloc[1]=(double)snapshot.getValue();
                a[0] = new LatLng(aloc[0],aloc[1]);
//                    System.out.println(String.format("The location for key %s is [%f,%f]", key, location.latitude, location.longitude));
                marker[0] = new MarkerOptions().position(a[0]).title("Bus location");
                mMap.clear();
                mMap.addMarker(marker[0]);
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(a[0],20));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}