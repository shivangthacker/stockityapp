package com.currencyinformation.currencyinfo;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

public class Subscribe extends Fragment {

    View view;

    TabLayout tabLayout_sub;
    TextView premium_txt_facilities,premium_txt_suggestion;
    Button premium_btn_month,premium_btn_year,premium_btn_PrivacyPolicy,premium_btn_Termsofuse;
    ViewPager viewPager_sub;
    WebView webView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_subscribe,container,false);




        //viewPager_sub=view.findViewById(R.id.subscribe_viewpager);
        //setFeatureDrawableUri();

        tabLayout_sub=view.findViewById(R.id.subscribe_tablayout);
        //tabLayout_sub.setupWithViewPager(viewPager_sub);

tabLayout_sub.addTab(tabLayout_sub.newTab().setText("Premium Plans"));
        premium_txt_facilities=view.findViewById(R.id.premium_txt_facilities);
        premium_txt_suggestion=view.findViewById(R.id.premium_txt_suggestion);
        premium_btn_month=view.findViewById(R.id.premium_btn_month);
        premium_btn_year=view.findViewById(R.id.premium_btn_year);
        premium_btn_PrivacyPolicy=view.findViewById(R.id.premium_btn_PrivacyPolicy);
        premium_btn_Termsofuse=view.findViewById(R.id.premium_btn_Termsofuse);



        premium_txt_facilities.setText("No advertisement. Access to popular , exotic pairs of Forex and cryptocurrencies. Receive alerts for all" +
                "timeframes. Display signals for all timeframes on the panel.");

        premium_txt_suggestion.setText("All subscription will be automatically renewed at the end of the billing cycle." +
                " When you cancel a subscription you'll still be able to use your subscription for the time you've already paid");

premium_btn_PrivacyPolicy.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Dialogfragment_privacy dialogfragment_privacy=new Dialogfragment_privacy();
        dialogfragment_privacy.show(getFragmentManager(),"dialog fragment policy");

       /* Dialog dialog=new Dialog(getActivity());
        dialog.setContentView(R.layout.customdialog_privacy);

        webView=view.findViewById(R.id.privacy_webview);
        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://mail.google.com/mail/u/0/#inbox/FMfcgxwJXxqmGqFSlZRKrMQZtnhmjbzg");
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setUseWideViewPort(true);

        dialog.show();*/

    }
});

premium_btn_Termsofuse.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Dialogfragment_Terms dialogfragment_terms=new Dialogfragment_Terms();
        dialogfragment_terms.show(getFragmentManager(),"dialog fragment terms");

    }
});

        return view;
    }

   /* private void setFeatureDrawableUri()
    {
        Fragmentadaforsub fragmentadaforsub=new Fragmentadaforsub(getFragmentManager());
        fragmentadaforsub.addtab_sub(new PremiumPlans(),"Premium Plans");
viewPager_sub.setAdapter(fragmentadaforsub);
    }*/
}
