package com.currencyinformation.currencyinfo;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Candle7 extends Fragment {
    private static final int AUD_CAD_5_cd =0 ;
    private static final int AUD_CHF_5_cd =0 ;
    private static final int AUD_JPY_5_cd =0 ;
    private static final int AUD_NZD_5_cd =0 ;
    private static final int AUD_USD_5_cd =0 ;
    private static final int CAD_CHF_5_cd = 0;
    private static final int CAD_JPY_5_cd =0 ;
    private static final int CHF_JPY_5_cd =0 ;
    private static final int EUR_AUD_5_cd =0 ;
    private static final int EUR_CAD_5_cd =0;
    private static final int EUR_CHF_5_cd =0 ;
    private static final int EUR_GBP_5_cd =0 ;
    private static final int EUR_JPY_5_cd =0 ;
    private static final int EUR_USD_5_cd =0 ;
    private static final int GBP_CAD_5_cd = 0;
    private static final int GBP_JPY_5_cd =0 ;
    private static final int GBP_USD_5_cd =0 ;
    private static final int NZD_CAD_5_cd =0 ;
    private static final int NZD_CHF_5_cd =0 ;
    private static final int NZD_JPY_5_cd =0 ;
    private static final int NZD_USD_5_cd =0 ;
    private static final int USD_CAD_5_cd =0 ;
    private static final int USD_CHF_5_cd =0 ;
    private static final int USD_JPY_5_cd =0 ;


    private static final int AUD_CAD_15_cd =0 ;
    private static final int AUD_CHF_15_cd =0 ;
    private static final int AUD_JPY_15_cd =0 ;
    private static final int AUD_NZD_15_cd =0 ;
    private static final int AUD_USD_15_cd =0 ;
    private static final int CAD_CHF_15_cd = 0;
    private static final int CAD_JPY_15_cd =0 ;
    private static final int CHF_JPY_15_cd =0 ;
    private static final int EUR_AUD_15_cd =0 ;
    private static final int EUR_CAD_15_cd =0;
    private static final int EUR_CHF_15_cd =0 ;
    private static final int EUR_GBP_15_cd =0 ;
    private static final int EUR_JPY_15_cd =0 ;
    private static final int EUR_USD_15_cd =0 ;
    private static final int GBP_CAD_15_cd = 0;
    private static final int GBP_JPY_15_cd =0 ;
    private static final int GBP_USD_15_cd =0 ;
    private static final int NZD_CAD_15_cd =0 ;
    private static final int NZD_CHF_15_cd =0 ;
    private static final int NZD_JPY_15_cd =0 ;
    private static final int NZD_USD_15_cd =0 ;
    private static final int USD_CAD_15_cd =0 ;
    private static final int USD_CHF_15_cd =0 ;
    private static final int USD_JPY_15_cd =0 ;

    private static final int AUD_CAD_60_cd =0 ;
    private static final int AUD_CHF_60_cd =0 ;
    private static final int AUD_JPY_60_cd =0 ;
    private static final int AUD_NZD_60_cd =0 ;
    private static final int AUD_USD_60_cd =0 ;
    private static final int CAD_CHF_60_cd = 0;
    private static final int CAD_JPY_60_cd =0 ;
    private static final int CHF_JPY_60_cd =0 ;
    private static final int EUR_AUD_60_cd =0 ;
    private static final int EUR_CAD_60_cd =0;
    private static final int EUR_CHF_60_cd =0 ;
    private static final int EUR_GBP_60_cd =0 ;
    private static final int EUR_JPY_60_cd =0 ;
    private static final int EUR_USD_60_cd =0 ;
    private static final int GBP_CAD_60_cd = 0;
    private static final int GBP_JPY_60_cd =0 ;
    private static final int GBP_USD_60_cd =0 ;
    private static final int NZD_CAD_60_cd =0 ;
    private static final int NZD_CHF_60_cd =0 ;
    private static final int NZD_JPY_60_cd =0 ;
    private static final int NZD_USD_60_cd =0 ;
    private static final int USD_CAD_60_cd =0 ;
    private static final int USD_CHF_60_cd =0 ;
    private static final int USD_JPY_60_cd =0 ;

    private static final int AUD_CAD_1_cd =0 ;
    private static final int AUD_CHF_1_cd =0 ;
    private static final int AUD_JPY_1_cd =0 ;
    private static final int AUD_NZD_1_cd =0 ;
    private static final int AUD_USD_1_cd =0 ;
    private static final int CAD_CHF_1_cd = 0;
    private static final int CAD_JPY_1_cd =0 ;
    private static final int CHF_JPY_1_cd =0 ;
    private static final int EUR_AUD_1_cd =0 ;
    private static final int EUR_CAD_1_cd =0;
    private static final int EUR_CHF_1_cd =0 ;
    private static final int EUR_GBP_1_cd =0 ;
    private static final int EUR_JPY_1_cd =0 ;
    private static final int EUR_USD_1_cd =0 ;
    private static final int GBP_CAD_1_cd = 0;
    private static final int GBP_JPY_1_cd =0 ;
    private static final int GBP_USD_1_cd =0 ;
    private static final int NZD_CAD_1_cd =0 ;
    private static final int NZD_CHF_1_cd =0 ;
    private static final int NZD_JPY_1_cd =0 ;
    private static final int NZD_USD_1_cd =0 ;
    private static final int USD_CAD_1_cd =0 ;
    private static final int USD_CHF_1_cd =0 ;
    private static final int USD_JPY_1_cd =0 ;


    //static final int[] idArray={};
    int i ;
    int x;
    int y;
    int z;
    int d;

    View view;
    RecyclerView recyclerView;
    ArrayList<Model> arrayList;
    String[] five={String.valueOf(AUD_CAD_5_cd), String.valueOf(AUD_CHF_5_cd), String.valueOf(AUD_JPY_5_cd),
            String.valueOf(AUD_NZD_5_cd), String.valueOf(AUD_USD_5_cd), String.valueOf(CAD_CHF_5_cd),
            String.valueOf(CAD_JPY_5_cd), String.valueOf(CHF_JPY_5_cd), String.valueOf(EUR_AUD_5_cd),
            String.valueOf(EUR_CAD_5_cd), String.valueOf(EUR_CHF_5_cd), String.valueOf(EUR_GBP_5_cd),
            String.valueOf(EUR_JPY_5_cd), String.valueOf(EUR_USD_5_cd), String.valueOf(GBP_CAD_5_cd),
            String.valueOf(GBP_JPY_5_cd), String.valueOf(GBP_USD_5_cd), String.valueOf(NZD_CAD_5_cd)
            , String.valueOf(NZD_CHF_5_cd), String.valueOf(NZD_JPY_5_cd), String.valueOf(NZD_USD_5_cd),
            String.valueOf(USD_CAD_5_cd), String.valueOf(USD_CHF_5_cd), String.valueOf(USD_JPY_5_cd)};
    String[] fifteen={String.valueOf(AUD_CAD_15_cd), String.valueOf(AUD_CHF_15_cd), String.valueOf(AUD_JPY_15_cd),
            String.valueOf(AUD_NZD_15_cd), String.valueOf(AUD_USD_15_cd), String.valueOf(CAD_CHF_15_cd),
            String.valueOf(CAD_JPY_15_cd), String.valueOf(CHF_JPY_15_cd), String.valueOf(EUR_AUD_15_cd),
            String.valueOf(EUR_CAD_15_cd), String.valueOf(EUR_CHF_15_cd), String.valueOf(EUR_GBP_15_cd),
            String.valueOf(EUR_JPY_15_cd), String.valueOf(EUR_USD_15_cd), String.valueOf(GBP_CAD_15_cd),
            String.valueOf(GBP_JPY_15_cd), String.valueOf(GBP_USD_15_cd), String.valueOf(NZD_CAD_15_cd)
            , String.valueOf(NZD_CHF_15_cd), String.valueOf(NZD_JPY_15_cd), String.valueOf(NZD_USD_15_cd),
            String.valueOf(USD_CAD_15_cd), String.valueOf(USD_CHF_15_cd), String.valueOf(USD_JPY_15_cd)};
    String[] day={String.valueOf(AUD_CAD_1_cd), String.valueOf(AUD_CHF_1_cd), String.valueOf(AUD_JPY_1_cd),
            String.valueOf(AUD_NZD_1_cd), String.valueOf(AUD_USD_1_cd), String.valueOf(CAD_CHF_1_cd),
            String.valueOf(CAD_JPY_1_cd), String.valueOf(CHF_JPY_1_cd), String.valueOf(EUR_AUD_1_cd),
            String.valueOf(EUR_CAD_1_cd), String.valueOf(EUR_CHF_1_cd), String.valueOf(EUR_GBP_1_cd),
            String.valueOf(EUR_JPY_1_cd), String.valueOf(EUR_USD_1_cd), String.valueOf(GBP_CAD_1_cd),
            String.valueOf(GBP_JPY_1_cd), String.valueOf(GBP_USD_1_cd), String.valueOf(NZD_CAD_1_cd)
            , String.valueOf(NZD_CHF_1_cd), String.valueOf(NZD_JPY_1_cd), String.valueOf(NZD_USD_1_cd),
            String.valueOf(USD_CAD_1_cd), String.valueOf(USD_CHF_1_cd), String.valueOf(USD_JPY_1_cd)};
    String[] sixty={String.valueOf(AUD_CAD_60_cd), String.valueOf(AUD_CHF_60_cd), String.valueOf(AUD_JPY_60_cd),
            String.valueOf(AUD_NZD_60_cd), String.valueOf(AUD_USD_60_cd), String.valueOf(CAD_CHF_60_cd),
            String.valueOf(CAD_JPY_60_cd), String.valueOf(CHF_JPY_60_cd), String.valueOf(EUR_AUD_60_cd),
            String.valueOf(EUR_CAD_60_cd), String.valueOf(EUR_CHF_60_cd), String.valueOf(EUR_GBP_60_cd),
            String.valueOf(EUR_JPY_60_cd), String.valueOf(EUR_USD_60_cd), String.valueOf(GBP_CAD_60_cd),
            String.valueOf(GBP_JPY_60_cd), String.valueOf(GBP_USD_60_cd), String.valueOf(NZD_CAD_60_cd)
            , String.valueOf(NZD_CHF_60_cd), String.valueOf(NZD_JPY_60_cd), String.valueOf(NZD_USD_60_cd),
            String.valueOf(USD_CAD_60_cd), String.valueOf(USD_CHF_60_cd), String.valueOf(USD_JPY_60_cd)};
    String[] five1={"AUD_CAD","AUD_CHF","AUD_JPY","AUD_NZD","AUD_USD","CAD_CHF",
            "CAD_JPY","CHF_JPY","EUR_AUD","EUR_CAD"
            ,"EUR_CHF","EUR_GBP","EUR_JPY","EUR_USD","GBP_CAD","GBP_JPY",
            "GBP_USD","NZD_CAD"
            ,"NZD_CHF","NZD_JPY","NZD_USD","USD_CAD","USD_CHF","USD_JPY"};
    String[] currency1={"AUD","cad","AUD","cad","AUD","cad","AUD","cad",
            "AUD","cad","AUD","cad","AUD","cad","AUD","cad",
            "AUD","cad", "AUD","cad","AUD","cad","AUD","USD"
    };
    public   int[] idflag={R.drawable.audcad,R.drawable.audchf,R.drawable.audjpy,R.drawable.audnzd,R.drawable.audusd,R.drawable.cadchf,
            R.drawable.cadjpy,R.drawable.chfjpy,R.drawable.euraud,R.drawable.eurcad,R.drawable.eurchf,R.drawable.eurgbp,
            R.drawable.eurjpy,R.drawable.eurusd,R.drawable.gbpcad,R.drawable.gbpjpy,R.drawable.gbpusd,R.drawable.nzdcad,
            R.drawable.nzdchf,R.drawable.nzdjpy,R.drawable.nzdusd,R.drawable.usdcad,R.drawable.usdchf,R.drawable.usdjpy};

    DatabaseReference databaseReference;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view=inflater.inflate(R.layout.fragment_candle7,container,false);

        arrayList = new ArrayList<>();

        recyclerView = view.findViewById(R.id.sma_crossing_recyclerview);


        for(i=0;i<five1.length;i++) {
            databaseReference = FirebaseDatabase.getInstance().getReference().child(five1[i]);


            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    five[i-1] = snapshot.child("5").child("Candles").getValue().toString();
                    Log.d(five[i-1],"1234");
                    fifteen[i-1] = snapshot.child("15").child("Candles").getValue().toString();
                    Log.d(fifteen[i-1],"122345");
                    sixty[i-1] = snapshot.child("60").child("Candles").getValue().toString();
                    Log.d(sixty[i-1],"123456");
                    day[i-1] = snapshot.child("D").child("Candles").getValue().toString();
                    Log.d(day[i-1],"1234567");

                    if (Integer.parseInt(five[i-1]) == 0)
                    {
                        x = R.drawable.timer;

                    } else if (Integer.parseInt(five[i-1]) > 0) {Log.d(five[i-1],"doitp");
                        x = R.drawable.bull1;


                    } else if(Integer.parseInt(five[i-1]) < 0){
                        x = R.drawable.bear1;
                        Log.d(five[i-1], "doit");
                    }
                    if (Integer.parseInt(fifteen[i-1]) == 0)
                    {
                        y = R.drawable.timer;

                    } else if (Integer.parseInt(fifteen[i-1]) > 0) {
                        y = R.drawable.bull1;


                    } else if(Integer.parseInt(fifteen[i-1]) < 0){
                        y = R.drawable.bear1;

                    }
                    if (Integer.parseInt(sixty[i-1]) == 0)
                    {
                        z = R.drawable.timer;

                    } else if (Integer.parseInt(sixty[i-1]) > 0) {
                        z = R.drawable.bull1;


                    } else if(Integer.parseInt(sixty[i-1]) < 0){
                        z = R.drawable.bear1;

                    } if (Integer.parseInt(day[i-1]) == 0)
                    {
                        d = R.drawable.timer;

                    } else if (Integer.parseInt(day[i-1]) > 0) {
                        d = R.drawable.bull1;


                    } else if(Integer.parseInt(day[i-1]) < 0){
                        d = R.drawable.bear1;
                    }
                    Log.d(currency1[2],"even");
                    Log.d(currency1[1],"odd");
                    arrayList.add(new Model(idflag[i-1],x,y,z,d,currency1[i-1],"AUD"));

                    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                    recyclerView.setHasFixedSize(true);
                    Myadapter myadapter = new Myadapter(getActivity(), arrayList);
                    recyclerView.setAdapter(myadapter);
                    //}



                }


                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            }); }


        return view;
    }
}
