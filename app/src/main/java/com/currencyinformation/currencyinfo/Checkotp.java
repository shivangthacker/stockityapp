package com.currencyinformation.currencyinfo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Checkotp extends AppCompatActivity {

    EditText checkotp_edt;
    Button checkotp_btn;
String check_phonenumber,check_email;
String otpid;
FirebaseAuth mAuth;
FirebaseFirestore fstore;
String userID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkotp);

        check_phonenumber=getIntent().getStringExtra("phonenumber").toString();
        check_email=getIntent().getStringExtra("email").toString();
    checkotp_edt=findViewById(R.id.checkotp_edt);
    checkotp_btn=findViewById(R.id.checkotp_btn);
    fstore=FirebaseFirestore.getInstance();
    mAuth=FirebaseAuth.getInstance();

initiateotp();
checkotp_btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        if(checkotp_edt.toString().isEmpty())
        {
            Toast.makeText(Checkotp.this, "Blank field can not be processed", Toast.LENGTH_SHORT).show();
        }
        else if(checkotp_edt.getText().toString().length()!=6){
            Toast.makeText(Checkotp.this, "Invalid otp", Toast.LENGTH_SHORT).show();
        }
        else {
            PhoneAuthCredential credential = PhoneAuthProvider.getCredential(otpid,checkotp_edt.getText().toString());
            signInWithPhoneAuthCredential(credential);
        }

    }
});
    }

    private void initiateotp() {


        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber(check_phonenumber)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(Checkotp.this)                 // Activity (for callback binding)
                        .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks()
                        {

                            @Override
                            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                otpid=s;
                            }

                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                signInWithPhoneAuthCredential(phoneAuthCredential);
                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                Toast.makeText(Checkotp.this, e.getMessage(), Toast.LENGTH_LONG).show();

                            }
                        })          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);

    }
    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Checkotp.this, "success", Toast.LENGTH_SHORT).show();
                            userID = mAuth.getCurrentUser().getUid();
                            DocumentReference documentReference =fstore.collection("emails").document(userID);
                            Map<String,Object>  user = new HashMap<>();
                            user.put("email",check_email);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(Checkotp.this, "email submitted", Toast.LENGTH_SHORT).show();
                                        Log.d("success","done"+userID);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(Checkotp.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                    Log.d("fail",e.toString());
                                }
                            });
                            Intent intent= new Intent(Checkotp.this,MainActivity.class);
                            startActivity(intent);
                            finish();



                        } else {
                            Toast.makeText(Checkotp.this, "Sign in Code Error", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}