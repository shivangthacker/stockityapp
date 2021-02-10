package com.currencyinformation.currencyinfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PremiumPlans extends Fragment {
View view;
TextView premium_txt_facilities,premium_txt_suggestion;
Button premium_btn_month,premium_btn_year;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_premiumplans,container,false);

        premium_txt_facilities=view.findViewById(R.id.premium_txt_facilities);
        premium_txt_suggestion=view.findViewById(R.id.premium_txt_suggestion);
        premium_btn_month=view.findViewById(R.id.premium_btn_month);
        premium_btn_year=view.findViewById(R.id.premium_btn_year);


        premium_txt_facilities.setText("No advertisement. Access to popular , exotic pairs of Forex and cryptocurrencies. Receive alerts for all" +
                "timeframes. Display signals for all timeframes on the panel.");

        premium_txt_suggestion.setText("All subscription will be automatically renewed at the end of the billing cycle." +
                " When you cancel a subscription you'll still be able to use your subscription for the time you've already paid");

        return view;
    }
}
