package com.example.lenovo.foyerapplication;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
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
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class Activity2 extends AppCompatActivity {
EditText name,pass; public static final int code = 9; Realm r;
    TextView check;
    String sname,spass;
    Context cv= this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        check = (TextView)findViewById(R.id.check);

        Button button1 = (Button) findViewById(R.id.login);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                check.setVisibility(View.INVISIBLE);
                sname="";
                spass="";
                name = (EditText) findViewById(R.id.username);
                pass = (EditText) findViewById(R.id.password);
                sname = name.getText().toString();
                spass = pass.getText().toString();

                boolean login=false;

                r = Realm.getDefaultInstance();
                RealmQuery<Data> query = r.where(Data.class);
                query.equalTo("username",sname).equalTo("password",spass);
                RealmResults<Data> result1 = query.findAll();

                result1.load();

                String out="";
                for(Data data:result1){

                    out+=data.toString();
                }


                Log.v("data",out);
                //[{username:a},{password:a}]
                    if(!result1.isEmpty()) {
                        Intent myIntent = new Intent(getApplicationContext(), Activity3.class);
                        myIntent.putExtra("Name",sname);
                        startActivityForResult(myIntent,1);
                        finish();
                    }else{

                        check.setVisibility(View.VISIBLE);
                    }
            }

    });









}
public void perform_action(View v){
    TextView button2 = (TextView) findViewById(R.id.sign);
        Intent myIntent = new Intent(Activity2.this,

        Activity6Sign.class);
    button2.setTextColor(Color.RED);
        startActivity(myIntent);
}
}





