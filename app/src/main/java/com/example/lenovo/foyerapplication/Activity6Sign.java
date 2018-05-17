package com.example.lenovo.foyerapplication;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.foyerapplication.realm.Data;

import io.realm.Realm;

public class Activity6Sign extends AppCompatActivity {
EditText name,password,password2,foyer;
    TextView t;
    Realm r;
    String sname,spassword,spassword2,sfoyer;
    Context cv = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity6_sign);

         r = Realm.getDefaultInstance();





t = (TextView)findViewById(R.id.check);
        t.setVisibility(View.INVISIBLE);
        Button signup =(Button)(findViewById(R.id.signup));
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = (EditText) findViewById(R.id.username);
                password = (EditText) findViewById(R.id.password);
                password2 = (EditText) findViewById(R.id.password2);
                foyer = (EditText) findViewById(R.id.foyername);


                sname = name.getText().toString();
                spassword = password.getText().toString();
                spassword2= password2.getText().toString();
                sfoyer = foyer.getText().toString();

                if(spassword.equals(spassword2)) {
                    writetoDb(sname.trim(), spassword.trim());
                    Intent myIntent = new Intent(Activity6Sign.this,

                            Activity2.class);

                    startActivity(myIntent);
                    finish();
                }else{
                    t.setVisibility(View.VISIBLE);
                }

            }
        });

    }

    private void writetoDb(final String username, final String password) {

        r.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                Data user = bgRealm.createObject(Data.class);
                user.setUsername(username);
                user.setPassword(password);


            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.v("DataBase","Data created");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable r) {
                Log.e("Database",r.getMessage());
            }});
        }



    @Override
    protected void onDestroy(){
        super.onDestroy();
        r.close();
    }
}
