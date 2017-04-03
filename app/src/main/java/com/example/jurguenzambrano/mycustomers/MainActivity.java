package com.example.jurguenzambrano.mycustomers;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    static final String TAG = "MyLocation";
    String locationProvider = LocationManager.GPS_PROVIDER;
    LocationManager locationManager;
    LocationListener locationListener;
    final static int PERMISSIONS_REQUEST_ACCESS_LOCATION = 100;
    boolean locationPermissionGranted = false;
    //TextView locationTextView;

    List<Customer> customers;
    RecyclerView.LayoutManager customerLayoutManager;
    RecyclerView customerRecyclerView;
    CustomerAdapter customerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CustomerService service = new CustomerService(this);
        customers = service.getCustomer();
        customerLayoutManager = new LinearLayoutManager(this);
        customerAdapter = new CustomerAdapter();
        customerAdapter.setCustomers(customers);
        customerRecyclerView = (RecyclerView) findViewById(R.id.customerRecyclerView);
        customerRecyclerView.setLayoutManager(customerLayoutManager);
        customerRecyclerView.setAdapter(customerAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void validatePermissions() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.ACCESS_COARSE_LOCATION},
                        PERMISSIONS_REQUEST_ACCESS_LOCATION);
            }
        } else {
            locationPermissionGranted = true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSIONS_REQUEST_ACCESS_LOCATION: {
                if (grantResults.length > 0 && grantResults[0] ==
                        PackageManager.PERMISSION_GRANTED) {
// permission was granted, yay! Do the
// contacts-related task you need to do.
                    locationPermissionGranted = true;
                } else {
// permission denied, boo! Disable the
// functionality that depends on this permission.
                    locationPermissionGranted = false;
                }
                return;
            }
// other 'case' lines to check for other
// permissions this app might request
        }
    }

    private void refreshCurrentLocation(Location location) {
        String locationDescription = "Latitude: " +
                String.valueOf(location.getLatitude()) + " Longitude: " +
                String.valueOf(location.getLongitude());
        Log.d(TAG, locationDescription);
        //locationTextView.setText("My Current Location is " + locationDescription);
    }

    private void setupLocationUpdates() {
        validatePermissions();
        if (locationPermissionGranted) {
            locationManager = (LocationManager)
                    this.getSystemService(Context.LOCATION_SERVICE);
// Define a listener that responds to location updates
            locationListener = new LocationListener() {
                public void onLocationChanged(Location location) {
// Called when a new location is found by the network location provider.
                    refreshCurrentLocation(location);
                }

                public void onStatusChanged(String provider, int status, Bundle extras) {
                }

                public void onProviderEnabled(String provider) {
                }

                public void onProviderDisabled(String provider) {
                }
            };
            if (ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                    ActivityCompat.checkSelfPermission(this,
                            Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            locationManager.requestLocationUpdates(locationProvider, 0, 0,
                    locationListener);
            refreshCurrentLocation(locationManager.getLastKnownLocation(locationProvider));
        }
    }
}
