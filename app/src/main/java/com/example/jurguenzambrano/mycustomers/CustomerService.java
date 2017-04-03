package com.example.jurguenzambrano.mycustomers;

import android.content.Context;
import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jurguen Zambrano on 2/04/2017.
 */

public class CustomerService {
    private List<Customer> customers;
    public List<Customer> getCustomer() { return customers; }

    // String name, String title, String company, String contact, String direction
    public CustomerService(Context context) {
        Resources res = context.getResources();
        customers = new ArrayList<>();
        customers.add(new Customer(res.getString(R.string.name_bill_gates),
                res.getString(R.string.title_former_ceo_and_founder),
                res.getString(R.string.company_microsoft),
                res.getString(R.string.bio_bill_gates),
                res.getString(R.string.direccion_01),-12.085403, -77.017330,
                R.drawable.customer_01));
        customers.add(new Customer(res.getString(R.string.name_larry_ellison),
                res.getString(R.string.title_cto),
                res.getString(R.string.company_oracle),
                res.getString(R.string.bio_larry_ellison),
                res.getString(R.string.direccion_02),-12.093708, -77.067232,
                R.drawable.customer_02));
        customers.add(new Customer(res.getString(R.string.name_mark_zuckerberg),
                res.getString(R.string.title_ceo),
                res.getString(R.string.company_facebook),
                res.getString(R.string.bio_mark_zuckerberg),
                res.getString(R.string.direccion_03),-12.064976, -77.102913,
                R.drawable.customer_03));
        customers.add(new Customer(res.getString(R.string.name_steve_jobs),
                res.getString(R.string.title_former_ceo_and_founder),
                res.getString(R.string.company_apple),
                res.getString(R.string.bio_steve_jobs),
                res.getString(R.string.direccion_04),-12.043511, -77.120898,
                R.drawable.customer_04));
        customers.add(new Customer(res.getString(R.string.name_steve_wozniak),
                res.getString(R.string.title_co_founder),
                res.getString(R.string.company_apple),
                res.getString(R.string.bio_steve_wozniak),
                res.getString(R.string.direccion_05),-12.205271, -76.945061,
                R.drawable.customer_05));
    }
}
