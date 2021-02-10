package com.currencyinformation.currencyinfo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Myadapter extends RecyclerView.Adapter<Myadapter.other> {

    private static final int AUD_CAD_5_SMA =0 ;
    private static final int AUD_CHF_5_SMA =0 ;
    private static final int AUD_JPY_5_SMA =0 ;
    private static final int AUD_NZD_5_SMA =0 ;
    private static final int AUD_USD_5_SMA =0 ;
    private static final int CAD_CHF_5_SMA = 0;
    private static final int CAD_JPY_5_SMA =0 ;
    private static final int CHF_JPY_5_SMA =0 ;
    private static final int EUR_AUD_5_SMA =0 ;
    private static final int EUR_CAD_5_SMA =0;
    private static final int EUR_CHF_5_SMA =0 ;
    private static final int EUR_GBP_5_SMA =0 ;
    private static final int EUR_JPY_5_SMA =0 ;
    private static final int EUR_USD_5_SMA =0 ;
    private static final int GBP_CAD_5_SMA = 0;
    private static final int GBP_JPY_5_SMA =0 ;
    private static final int GBP_USD_5_SMA =0 ;
    private static final int NZD_CAD_5_SMA =0 ;
    private static final int NZD_CHF_5_SMA =0 ;
    private static final int NZD_JPY_5_SMA =0 ;
    private static final int NZD_USD_5_SMA =0 ;
    private static final int USD_CAD_5_SMA =0 ;
    private static final int USD_CHF_5_SMA =0 ;
    private static final int USD_JPY_5_SMA =0 ;
    Context context;
    int i=0;
    ArrayList<Model> arrayList=new ArrayList<>();
    DatabaseReference databaseReference;
    String[] fivevar={String.valueOf(AUD_CAD_5_SMA), String.valueOf(AUD_CHF_5_SMA), String.valueOf(AUD_JPY_5_SMA),
            String.valueOf(AUD_NZD_5_SMA), String.valueOf(AUD_USD_5_SMA), String.valueOf(CAD_CHF_5_SMA),
            String.valueOf(CAD_JPY_5_SMA), String.valueOf(CHF_JPY_5_SMA), String.valueOf(EUR_AUD_5_SMA),
            String.valueOf(EUR_CAD_5_SMA), String.valueOf(EUR_CHF_5_SMA), String.valueOf(EUR_GBP_5_SMA),
            String.valueOf(EUR_JPY_5_SMA), String.valueOf(EUR_USD_5_SMA), String.valueOf(GBP_CAD_5_SMA),
            String.valueOf(GBP_JPY_5_SMA), String.valueOf(GBP_USD_5_SMA), String.valueOf(NZD_CAD_5_SMA)
            , String.valueOf(NZD_CHF_5_SMA), String.valueOf(NZD_JPY_5_SMA), String.valueOf(NZD_USD_5_SMA),
            String.valueOf(USD_CAD_5_SMA), String.valueOf(USD_CHF_5_SMA), String.valueOf(USD_JPY_5_SMA)};
    String[] five1={"AUD_CAD","AUD_CHF","AUD_JPY","AUD_NZD","AUD_USD","CAD_CHF",
            "CAD_JPY","CHF_JPY","EUR_AUD","EUR_CAD"
            ,"EUR_CHF","EUR_GBP","EUR_JPY","EUR_USD","GBP_CAD","GBP_JPY",
            "GBP_USD","NZD_CAD"
            ,"NZD_CHF","NZD_JPY","NZD_USD","USD_CAD","USD_CHF","USD_JPY"};
    int sma_5min=1;
    int sma_15min=0;
    int sma_30min=-1;
    int sma_day=1;



        Myadapter(Context context,ArrayList<Model> arrayList)
    {
this.context=context;
this.arrayList=arrayList;
    }
    @NonNull
    @Override
    public other onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_layout,parent,false);

        return new other(view);
    }

    @Override
    public void onBindViewHolder(final other holder, int position) {
        /*for(i=0;i<five1.length;i++) {
            // Log.d(String.valueOf(idflag[7]), "flag");
            databaseReference = FirebaseDatabase.getInstance().getReference().child(five1[i]).child("5");
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    fivevar[i-1] = snapshot.child("STDP").getValue().toString();
                    Log.d(fivevar[i-1],"yesadapter");
                    int a= Integer.parseInt(fivevar[i-1]);
                    if(a==0 )
                    {
                        holder.five.setImageResource(R.drawable.timer);
                    }
                    else if(a>0)
                    {
                       holder.five.setImageResource(R.drawable.bull1);

                    }
                    else
                    {
                        holder.five.setImageResource(R.drawable.bear1);
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
*/

            final Model model = arrayList.get(position);
holder.currency_img.setImageResource(model.getCurrency_img());
holder.five.setImageResource(model.getFive());
holder.fifteen.setImageResource(model.getFifteen());
holder.hour.setImageResource(model.getHour());
holder.day.setImageResource(model.getDay());
holder.firstcurrency.setText(model.getFirstcurrency());
holder.secondcurrency.setText(model.getSecondcurrency());
    }





    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class other extends RecyclerView.ViewHolder

    {
ImageView currency_img,five,fifteen,hour,day;
TextView firstcurrency,secondcurrency;


        public other(@NonNull View itemView) {
            super(itemView);
           /* for(i=0;i<five1.length;i++) {
                // Log.d(String.valueOf(idflag[7]), "flag");
                databaseReference = FirebaseDatabase.getInstance().getReference().child(five1[i]).child("5");
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        fivevar[i-1] = snapshot.child("STDP").getValue().toString();
                        Log.d(fivevar[i-1],"yesa");
                        int a= Integer.parseInt(fivevar[i-1]);
                        if(a==0 )
                        {

                        }
                        else if(a>0)
                        {


                        }
                        else
                        {

                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
*/
            currency_img=itemView.findViewById(R.id.design_img_currency);
           five=itemView.findViewById(R.id.design_img_five);
           fifteen=itemView.findViewById(R.id.design_img_fifteen);
           hour=itemView.findViewById(R.id.design_img_hour);
           day=itemView.findViewById(R.id.design_img_day);
           firstcurrency=itemView.findViewById(R.id.design_txt_firstcurrency);
           secondcurrency=itemView.findViewById(R.id.design_txt_secondcurrency);

        }
    }
}
