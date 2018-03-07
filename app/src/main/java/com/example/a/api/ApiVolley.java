package com.example.a.api;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Cache;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.a.model.OwnerDetails;
import com.example.a.woofui.R;
import com.example.a.woofui.SignUpDetails;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * Created by A on 3/6/2018.
 */

public class ApiVolley  {

    static RequestQueue queue;
    public ApiVolley(Context context){

        if(queue==null)
            queue = Volley.newRequestQueue(context);

    }
    public  void postSignUp( final SignUpDetails activity,final OwnerDetails ownerDetails)
    {
        String url =activity.getResources().getString(R.string.signup_api);
        final List<String> stList=new ArrayList<>();
        final ObjectMapper objectMapper=new ObjectMapper();
        JSONObject obj=null;
            try {
            obj =new JSONObject( objectMapper.writeValueAsString(ownerDetails));
        }catch (Exception e)
        {
            Log.e("JSONPARSE", e.getMessage());
        }

        // Request a string response from the provided URL.
        final JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.POST, url,obj,

                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Calling function after getting response.
                        activity.showToast(response.toString());
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Log.e("J",error.toString());

            }


        }){
            @Override
            public Map<String,String> getHeaders()
            {

                Map<String, String>  params = new HashMap<>();
                params.put("Accept","application/json");
                return  params;
            }
            @Override
            public String getBodyContentType()
            {
                return "application/json";
            }

            @Override
            protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
                Response res= super.parseNetworkResponse(response);
                if(response.statusCode>=200 || response.statusCode<=204)
                {
                    try {
                        return  Response.success(new JSONObject("{\"d\":\"d\"}"), null);
                    }
                    catch (Exception e)
                    {
                        Log.e("JSONParse", e.getMessage());
                        return  res;
                    }
                }
                else
                    return res;
            }


        };
    // Add the request to the RequestQueue.
            queue.add(jsonRequest);

}

    public  void getOwnerDetails(final SignUpDetails activity,final OwnerDetails ownerDetails)
    {

        String url =activity.getResources().getString(R.string.signup_api);
        //url+="/"+ownerDetails.getOwnerId();
        url+="/15";
        final List<String> stList=new ArrayList<>();
        final ObjectMapper objectMapper=new ObjectMapper();

        // Request a string response from the provided URL.
        final JsonObjectRequest  stringRequest = new JsonObjectRequest (Request.Method.GET, url,null,

                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        activity.showToast(response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Log.e("J",error.toString());

            }


        }){

            @Override
            public Map<String,String> getHeaders()
            {

                Map<String, String>  params = new HashMap<>();
                params.put("Accept","application/json");
                return  params;
            }
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<>();
                try {


                    params.put("json", objectMapper.writeValueAsString(ownerDetails));
                }
                catch(Exception e)
                {
                    Log.e("JSON ERROR",e.getMessage());
                }

                return params;
            }
            @Override
            public String getBodyContentType()
            {
                return "application/json";
            }

        };
// Add the request to the RequestQueue.
        queue.add(stringRequest);

    }


    public  void putOwnerDetails(final SignUpDetails activity,final OwnerDetails ownerDetails)
    {

        String url =activity.getResources().getString(R.string.signup_api);
        final List<String> stList=new ArrayList<>();
        final ObjectMapper objectMapper=new ObjectMapper();
        JSONObject obj=null;
        try {
             obj =new JSONObject( objectMapper.writeValueAsString(ownerDetails));
        }catch (Exception e)
        {
                Log.e("JSONPARSE", e.getMessage());
        }

        // Request a string response from the provided URL.
        final JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.PUT, url,obj,

                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        activity.showToast(response.toString());
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Log.e("J",error.toString());

            }


        }){
            @Override
            public Map<String,String> getHeaders()
            {

                Map<String, String>  params = new HashMap<>();
                params.put("Accept","application/json");
                return  params;
            }
            @Override
            public String getBodyContentType()
            {
                return "application/json";
            }

            @Override
            protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
                 Response res= super.parseNetworkResponse(response);
                 if(response.statusCode>=200 || response.statusCode<=204)
                 {
                     try {
                     return  Response.success(new JSONObject("{\"d\":\"d\"}"), null);
                     }
                     catch (Exception e)
                     {
                        Log.e("JSONParse", e.getMessage());
                        return  res;
                     }
                 }
                 else
                     return res;
            }


        };
// Add the request to the RequestQueue.
        queue.add(jsonRequest);

    }


    public  void getAllOwners(final SignUpDetails activity,final OwnerDetails ownerDetails)
    {

        String url =activity.getResources().getString(R.string.signup_api);
        //url+="/"+ownerDetails.getOwnerId();
        url+="/15";
        final List<String> stList=new ArrayList<>();
        final ObjectMapper objectMapper=new ObjectMapper();

        // Request a string response from the provided URL.
        final JsonArrayRequest stringRequest = new JsonArrayRequest (Request.Method.GET, url,null,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        activity.showToast(response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Log.e("J",error.toString());

            }


        }){

            @Override
            public Map<String,String> getHeaders()
            {

                Map<String, String>  params = new HashMap<>();
                params.put("Accept","application/json");
                return  params;
            }
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<>();
                try {


                    params.put("json", objectMapper.writeValueAsString(ownerDetails));
                }
                catch(Exception e)
                {
                    Log.e("JSON ERROR",e.getMessage());
                }

                return params;
            }
            @Override
            public String getBodyContentType()
            {
                return "application/json";
            }

        };
// Add the request to the RequestQueue.
        queue.add(stringRequest);

    }
}