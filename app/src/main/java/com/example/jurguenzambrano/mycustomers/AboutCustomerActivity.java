package com.example.jurguenzambrano.mycustomers;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AboutCustomerActivity extends AppCompatActivity {

    Customer customer;
    ImageView pictureImageView;
    TextView companyTextView;
    TextView contactTextView;
    TextView addressTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_customer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        companyTextView =  (TextView) findViewById(R.id.companyTextView);
        contactTextView = (TextView) findViewById(R.id.contactTextView);
        addressTextView = (TextView) findViewById(R.id.addressTextView);
        pictureImageView = (ImageView) findViewById(R.id.pictureImageView);

        CustomerService service = new CustomerService(this);
        customer = service.getCustomer().get(getIntent().getExtras().getInt("currentPosition"));
        contactTextView.setText(customer.getName());
        companyTextView.setText(customer.getCompany());

        pictureImageView.setImageResource(customer.getPictureId());

        Button mEmailSignInButton = (Button) findViewById(R.id.buttonCustomerMap);
        mEmailSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onViewMap();
            }
        });
    }

    public void onViewMap(){
        Intent intent = new Intent(this, CustomerMapActivity.class);
        intent.putExtra("altitud",customer.getAltitud());
        intent.putExtra("latitud",customer.getLatitud());
        startActivity(intent);
    }

}
