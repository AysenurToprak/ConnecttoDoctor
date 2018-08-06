package com.aysenurtoprak.connecttodoctor;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText edtAdı, edtmail, edtNumara, edtsifre, edtsifretekrar, edtSoyad, edttc;
    Spinner spAlani, spuzmanlıgı;
    Button btngiris, btnkayıtOl;
    ProgressBar pgr;
    private DatabaseReference databaseReferenceCustomers;
    private List<Kullanici> kullanicis;
    private final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    public static String userName, userPassword;

    private FirebaseAuth mAuth;
    private FirebaseUser firebaseUser;

    private FirebaseAuth.AuthStateListener mAuthListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mAuth = FirebaseAuth.getInstance();
        firebaseUser = mAuth.getCurrentUser();

        //   edtAdı = (EditText) findViewById(R.id.edtAdı);
        edtmail = (EditText) findViewById(R.id.edtKmail);
        //  edtNumara = (EditText) findViewById(R.id.edtNumara);
        edtsifre = (EditText) findViewById(R.id.edtKsifre);
        //   edtSoyad = (EditText) findViewById(R.id.edtSoyad);
        //   edttc = (EditText) findViewById(R.id.edttc);


        //   spAlani = (Spinner) findViewById(R.id.spAlani);
        // spuzmanlıgı = (Spinner) findViewById(R.id.spuzmanlıgı);


        btngiris = (Button) findViewById(R.id.btngiris);
        btnkayıtOl = (Button) findViewById(R.id.btnKkayıtOl);

        btnkayıtOl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName = edtmail.getText().toString();
                userPassword = edtsifre.getText().toString();
                if (userName.isEmpty() || userPassword.isEmpty()) {

                    Toast.makeText(getApplicationContext(), "Lütfen gerekli alanları doldurunuz!", Toast.LENGTH_SHORT).show();

                } else {

                    mAuth.createUserWithEmailAndPassword(userName, userPassword)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(MainActivity.this, "Kullanıcı Tanımlandı", Toast.LENGTH_LONG).show();
                                        sendMail();

                                        Intent intent = new Intent(MainActivity.this, KullaniciGirisi.class);
                                        startActivity(intent);

                                    } else {
                                        Toast.makeText(getApplicationContext(), "Başarısız", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });


                    edtmail.getText().clear();
                    edtsifre.getText().clear();
                }


            }
        });
    }



    public void sendMail(){

            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(MainActivity.this,"Mailinizi kontrol ediniz",Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(MainActivity.this,"Mail Gönderirken Sorun Oluştu"+task.getException(),Toast.LENGTH_LONG).show();
                    }

                }
            });

        }









}
