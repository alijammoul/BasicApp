package com.example.lenovo.foyerapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.lenovo.foyerapplication.Object.MySingleton;
import com.example.lenovo.foyerapplication.Object.RecyclerViewAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fragment1 extends Fragment {
    private RequestQueue r;
     StringRequest sr;
    ArrayList<Objects> array = new ArrayList();

private RecyclerView recyclerView;
    private RecyclerViewAdapter rva;


    String url ="https://jsonplaceholder.typicode.com/posts ";
    private RecyclerView.LayoutManager layoutManager;


        public static Fragment1 newInstance() {
            Fragment1 fragment = new Fragment1();
            return fragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);


        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


            View v =  inflater.inflate(R.layout.fragment1, container, false);
            recyclerView=(RecyclerView)v.findViewById(R.id.rv);

            layoutManager=new LinearLayoutManager(getActivity());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setHasFixedSize(true);
            getinfo();;

            return v;
        }
        public void getinfo(){
            sr = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
 GsonBuilder builder = new GsonBuilder();
                    Gson g = builder.create();

                   array.add(   g.fromJson(response,Objects.class));

                    rva = new RecyclerViewAdapter(array);

                    recyclerView.setAdapter(rva);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            MySingleton.getInstance(getContext()).addToRequestQueue(sr);
        }
}
