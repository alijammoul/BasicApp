package com.example.lenovo.foyerapplication;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.*;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class Activity4Add extends AppCompatActivity {
private Button send;
    private TextView tv;
    private RequestQueue r;
    private StringRequest sr;
    //String url = "http://192.168.56.1//C://wamp//www//example.html";
    String url ="https://jsonplaceholder.typicode.com/posts ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Cache c = new DiskBasedCache(getCacheDir(),1024*1024);
        Network n = new BasicNetwork(new HurlStack());
        r = new RequestQueue(c,n);
        r.start();
        setContentView(R.layout.activity4_add);
tv = (TextView)findViewById(R.id.tv);
        send = (Button)findViewById(R.id.send);





        send.setOnClickListener(new View.OnClickListener(){
@Override
            public void onClick(View v){

                uhh();
    }
        });
    }
public static void getinformation(){

}

    private void uhh(){
        r= Volley.newRequestQueue(this);
        sr = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            tv.setText(response);
r.stop();



            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tv.setText(" OHHHHH NOOOOOOO ");
            }
        });
r.add(sr);
    }
}
