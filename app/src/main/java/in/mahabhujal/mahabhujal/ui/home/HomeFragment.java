package in.mahabhujal.mahabhujal.ui.home;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import in.mahabhujal.mahabhujal.R;

public class HomeFragment extends Fragment implements OnMapReadyCallback {

    private HomeViewModel homeViewModel;
    private GoogleMap googleMap;
    GoogleMap gMap;
    private LocationListener locationListener;
    private LocationManager locationManager;
    private LatLng latLng;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);

        SupportMapFragment supportMapFragment = (SupportMapFragment)
                getChildFragmentManager().findFragmentById(R.id.google_map);
        supportMapFragment.getMapAsync(this);

        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }

        });
        return root;
    }

    private void getSupportFragmentManager() {
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;
        LatLng yedshi = new LatLng(18.31, 75.96);
        gMap.addMarker(new MarkerOptions().position(yedshi).title("Marker at Yedshi"));
        gMap.moveCamera(CameraUpdateFactory.newLatLng(yedshi));

        locationListener = new LocationListener(){
            @Override
            public void onLocationChanged(@NonNull Location location) {
                try {
                    latLng = new LatLng(location.getLatitude(), location.getLongitude());
                    gMap.addMarker(new MarkerOptions().position(latLng).title("New Position"));
                    gMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

                    //String myLatitude=String.valueOf(location.getAltitude());
                    //String myLongitude=String.valueOf(location.getLongitude());

                    //String message="Latitude="+myLatitude+"Longitude="+myLongitude+;


                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };
    }
}

        /*
        gMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() 
        {
            @Override
            public void onMapClick(LatLng latLng) 
            {
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(latLng);
                markerOptions.title(latLng.latitude + " : " + latLng.longitude);
                gMap.clear();
                gMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));
                gMap.addMarker(markerOptions);

            }


            });

         */

