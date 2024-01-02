package com.example.fruitapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ProfileActivity extends AppCompatActivity implements OnMapReadyCallback{
    private GoogleMap mMap;
    Button favButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        favButton = (Button) findViewById(R.id.favorite_page_intent);
        favButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                favoriteIntent();
            }
        });

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.profile_maps);
    }
    public void favoriteIntent(){
        Intent favIntent = new Intent(ProfileActivity.this, FavoriteFragment.class);
        startActivity(favIntent);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        LatLng jakarta = new LatLng(-6.2017532,106.7796851);
        mMap.addMarker(new MarkerOptions().position(jakarta).title("Bina Nusantara"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(jakarta));
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}
