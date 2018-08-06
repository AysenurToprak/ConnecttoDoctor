package com.aysenurtoprak.connecttodoctor;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class KullaniciGirisi extends AppCompatActivity {
    Button btngiris,btnkayıtol;
    EditText txtmail,txtsifre;

    public static String userNameM, userPasswordM = null;
    private Bundle bundle = null;


    private FirebaseAuth mAuth;
    private FirebaseUser firebaseUser;

    private FirebaseAuth.AuthStateListener mAuthListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kullanici_girisi);
        btngiris = (Button) findViewById(R.id.btngiris);
        btnkayıtol = (Button) findViewById(R.id.btnkayitol) ;


        txtmail = (EditText) findViewById(R.id.edtMail);
        txtsifre = (EditText) findViewById(R.id.edtSifre);




        txtmail.setText(userPasswordM);
        txtsifre.setText(userNameM);

        mAuth = FirebaseAuth.getInstance();
        firebaseUser = mAuth.getCurrentUser();

        btnkayıtol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(KullaniciGirisi.this,MainActivity.class);
                startActivity(i);
            }
        });

        btngiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userNameM = txtmail.getText().toString();
                userPasswordM = txtsifre.getText().toString();
                if (userNameM.isEmpty() || userPasswordM.isEmpty()) {

                    Toast.makeText(getApplicationContext(), "Lütfen gerekli alanları doldurunuz!", Toast.LENGTH_SHORT).show();

                } else {

                    loginFunc();

                }

            }
        });


    }
    private void loginFunc() {
        mAuth.signInWithEmailAndPassword(userNameM, userPasswordM).addOnCompleteListener(KullaniciGirisi.this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Intent i = new Intent(KullaniciGirisi.this, Anasayfa.class);
                            startActivity(i);
                            finish();

                        } else {
                            Toast.makeText(getApplicationContext(), "Kullanıcı Adı veya Şifre Geçersiz", Toast.LENGTH_SHORT).show();
                        }
                    }

                });
    }


    @Override
    protected void onStart() {
        super.onStart();
        FirebaseAuth.getInstance().addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onStop() {
        FirebaseAuth.getInstance().addAuthStateListener(mAuthListener);
        super.onStop();
    }


}
