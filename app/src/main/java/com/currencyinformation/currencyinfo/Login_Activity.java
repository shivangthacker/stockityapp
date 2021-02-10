package com.currencyinformation.currencyinfo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.hbb20.CountryCodePicker;

public class Login_Activity extends AppCompatActivity {

    Button signInButtongoogle,loginotp;
    GoogleSignInClient googleSignInClient;
    FirebaseAuth firebaseAuth;
    EditText email,phonenumber;
    CountryCodePicker ccp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
        getSupportActionBar().hide();


        phonenumber=findViewById(R.id.login_edt_phone);
        loginotp=findViewById(R.id.login_btn_login_otp);
        ccp=findViewById(R.id.ccp);
        ccp.registerCarrierNumberEditText(phonenumber);
        email=findViewById(R.id.login_edt_email);



        loginotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email=email.getText().toString();
                String Phonenumber=phonenumber.getText().toString();
                if (Email.isEmpty())
                {
                    email.setError("please fill detail here");
                }
                else if(Phonenumber.isEmpty())
                {
                    phonenumber.setError("please fill detail here");
                }
                else if(!Patterns.EMAIL_ADDRESS.matcher(Email).matches())
                {
                    email.setError("put valid email");

                }
                else
                {
                    email.setError(null);
                    Intent intent=new Intent(Login_Activity.this,Checkotp.class);
                    intent.putExtra("email",email.getText().toString());
                    intent.putExtra("phonenumber",ccp.getFullNumberWithPlus().replace(" ",""));
                    startActivity(intent);
                }

            }
        });

signInButtongoogle=findViewById(R.id.login_btn_googlesignin);

        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(

                GoogleSignInOptions.DEFAULT_SIGN_IN
        ).requestIdToken("466125053034-uu2d9qqk57vecqsro2fg64hd7f3a5e63.apps.googleusercontent.com")
                .requestEmail()
                .build();

        googleSignInClient = GoogleSignIn.getClient(Login_Activity.this,googleSignInOptions);
        signInButtongoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = googleSignInClient.getSignInIntent();
                startActivityForResult(intent,100);

            }
        });
        firebaseAuth= FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if (firebaseUser != null){
            startActivity(new Intent(Login_Activity.this,MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100)
        {
            Task<GoogleSignInAccount> signInAccountTask = GoogleSignIn.getSignedInAccountFromIntent(data);
            if(signInAccountTask.isSuccessful())
            {
                String s = "Google sign in successfull";
                Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
                try {
                    GoogleSignInAccount googleSignInAccount = signInAccountTask.getResult(ApiException.class);
                    if(googleSignInAccount != null )
                    {
                        AuthCredential authCredential = GoogleAuthProvider.getCredential(googleSignInAccount.getIdToken(),null);
                        firebaseAuth.signInWithCredential(authCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                  if (task.isSuccessful()) {
                                     startActivity(new Intent(Login_Activity.this,MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                                      Toast.makeText(Login_Activity.this, "Firebase authentication successful", Toast.LENGTH_SHORT).show();
                                  }
                                  else {
                                      Toast.makeText(Login_Activity.this, "Authentication Failed"+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                  }
                            }
                        });
                    }
                } catch (ApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}