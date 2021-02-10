package com.currencyinformation.currencyinfo;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import javax.mail.Session;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;

import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class Dialogfragment_feedback extends DialogFragment {
    View view;
    EditText feedbacksubject,feedbackmessage;
    Button feedbacksend;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dialogfragment_feedback, container, false);
 feedbacksubject=view.findViewById(R.id.dialogfeedback_edt_subject);
        feedbackmessage=view.findViewById(R.id.dialogfeedback_edt_message);
        feedbacksubject=view.findViewById(R.id.dialogfeedback_edt_subject);
feedbacksend=view.findViewById(R.id.dialogfeedback_btn_send);

feedbacksend.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        String recipient="teamstockity@gmail.com";
        String[] recipients=recipient.split(",");

        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,recipients);
        intent.putExtra(intent.EXTRA_SUBJECT,feedbacksubject.getText().toString());
        intent.putExtra(intent.EXTRA_TEXT,feedbackmessage.getText().toString());
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"Choose an email account"));

    }
});

        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);



        return view;



    }
}
