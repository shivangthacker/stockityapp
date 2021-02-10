package com.currencyinformation.currencyinfo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.IUnityAdsListener;
import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.UnityAds;

import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.services.UnityServices;
import com.unity3d.services.ads.UnityAdsImplementation;
import com.unity3d.services.monetization.IUnityMonetizationListener;
import com.unity3d.services.monetization.UnityMonetization;
import com.unity3d.services.monetization.placementcontent.core.PlacementContent;
import com.unity3d.services.monetization.UnityMonetization;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;



public class MainActivity extends AppCompatActivity {
    Context context;
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    FirebaseAuth firebaseAuth;
    GoogleSignInClient googleSignInClient;
    private boolean doubleBackToExitPressedOnce;
    RecyclerView recyclerView;
    private AdView mAdView;
    final String GameID="3942387";
    final boolean testMode=true;
    final String fullscreen="Interstitial";
    ImageView feedback;
    private InterstitialAd mInterstitialAd;
    private Object UnityInterstitialadlistner;


    // @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
feedback=findViewById(R.id.toolbar_img_feedback);
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("Device ID")
                .build();


        mAdView.loadAd(adRequest);
final UnityInterstitialadlistner unityInterstitialadlistner=new UnityInterstitialadlistner();
        UnityAds.setListener(unityInterstitialadlistner);
        

        UnityAds.initialize(MainActivity.this,GameID, (IUnityAdsListener) unityInterstitialadlistner,testMode,true);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//InterstitialAd interstitialAd=new InterstitialAd(MainActivity.this);
                 if(UnityAds.isSupported())
                 {
                     Toast.makeText(MainActivity.this, "true", Toast.LENGTH_SHORT).show();
                 }
                 else
                 {
                     Toast.makeText(MainActivity.this, "false", Toast.LENGTH_SHORT).show();
                 }

               UnityAds.load(fullscreen);
                UnityAds.show(MainActivity.this,fullscreen);



               /* Dialogfragment_feedback dialogfragment_feedback=new Dialogfragment_feedback();
                dialogfragment_feedback.show(getSupportFragmentManager(),"dialog fragment feedback");*/
            }
        });

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                            UnityAds.show(MainActivity.this,fullscreen);
                        //prepareAD();
                    }
                });
            }
        },10,10, TimeUnit.MINUTES);

        initializefirebaseauth();
        initializesigninclient();

        toolbar=findViewById(R.id.main_toolbar);
       // getSupportActionBar().setIcon(R.drawable.ic_setting);

        viewPager=findViewById(R.id.main_viewpager);
         setFeatureDrawableUri();

        tabLayout=findViewById(R.id.main_tablayout);
        tabLayout.setupWithViewPager(viewPager);



    }



    private void initializesigninclient()
    {
        googleSignInClient = GoogleSignIn.getClient(MainActivity.this, GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN);

    }

    private void initializefirebaseauth() {

        firebaseAuth= FirebaseAuth.getInstance();
        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        if(firebaseUser != null)
        {
            //Toast.makeText(this, "you have already logged in by google", Toast.LENGTH_SHORT).show();
        }
    }

    private void setFeatureDrawableUri()
    {
         Fragmentadapter fragmentadapter=new Fragmentadapter(getSupportFragmentManager());
//fragmentadapter.addtab(new Sma_Crossing(),"Sma Crossing");
  //      fragmentadapter.addtab(new Engulfing(),"Engulfing");
    //    fragmentadapter.addtab(new Candle7(),"Candle/7");
        fragmentadapter.addtab(new Subscribe(),"Subscribe");

        viewPager.setAdapter(fragmentadapter);

    }

    private void Diasplayfullscreenad() {

        if (UnityAds.isReady(fullscreen))
        {
            UnityAds.show(MainActivity.this,fullscreen);
        }
    }


    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            finishAffinity();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "press BACK again", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }


    public void prepareAD()
    { UnityAds.load(fullscreen);
       /* mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
mInterstitialAd.loadAd(new AdRequest.Builder().build());*/
    }
    private class UnityInterstitialadlistner implements IUnityAdsListener{





        @Override
        public void onUnityAdsReady(String s) {

        }

        @Override
        public void onUnityAdsStart(String s) {

        }

        @Override
        public void onUnityAdsFinish(String s, UnityAds.FinishState finishState) {

        }

        @Override
        public void onUnityAdsError(UnityAds.UnityAdsError unityAdsError, String s) {
            Toast.makeText(MainActivity.this, unityAdsError.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}