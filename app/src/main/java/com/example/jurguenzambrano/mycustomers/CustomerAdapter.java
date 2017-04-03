package com.example.jurguenzambrano.mycustomers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Jurguen Zambrano on 2/04/2017.
 */

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.ViewHolder> {
    List<Customer> customers;

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public CustomerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.card_customer, parent, false));
    }

    @Override
    public void onBindViewHolder(CustomerAdapter.ViewHolder holder, final int position) {
        holder.nameTextView.setText(customers.get(position).getName());
        holder.pictureImageView.setImageResource(customers.get(position).getPictureId());
        holder.titleTextView.setText(customers.get(position).getTitle());
        holder.companyTextView.setText(customers.get(position).getCompany());
        holder.personCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("currentPosition", position);
                Intent iconIntent = new Intent(view.getContext(), AboutCustomerActivity.class);
                iconIntent.putExtras(bundle);
                view.getContext().startActivity(iconIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return customers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView personCardView;
        ImageView pictureImageView;
        TextView nameTextView;
        TextView titleTextView;
        TextView companyTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            personCardView = (CardView) itemView.findViewById(R.id.customerCardView);
            pictureImageView = (ImageView) itemView.findViewById(R.id.pictureImageView);
            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            titleTextView = (TextView) itemView.findViewById(R.id.titleTextView);
            companyTextView = (TextView) itemView.findViewById(R.id.companyTextView);
        }
    }
}
