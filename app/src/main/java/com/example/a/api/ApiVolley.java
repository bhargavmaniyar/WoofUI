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
import com.example.a.model.WalkInfo;
import com.example.a.model.WalkReq;
import com.example.a.woofui.AvailableWalk;
import com.example.a.woofui.PostWalk;
import com.example.a.woofui.R;
import com.example.a.woofui.RequestedWalk;
import com.example.a.woofui.RequestsWalk;
import com.example.a.woofui.SignUpDetails;
import com.example.a.woofui.WalkActivity;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.spec.ECField;
import java.text.SimpleDateFormat;
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


    //Dog Walk Api class start
    public  void postDogWalk(final WalkActivity activity, final WalkInfo walkInfo)
    {
        String url =activity.getResources().getString(R.string.postWalk_api);
        final List<String> stList=new ArrayList<>();

        final ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'"));
//        Gson gson = new Gson();
//        JsonObject obj1 = new JsonParser().parse(gson.toJson(walkInfo)).getAsJsonObject();
        JSONObject obj=null;
        try {
            obj =new JSONObject( objectMapper.writeValueAsString(walkInfo));
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
                        activity.walkPosted(true);
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

                Log.e("J",error.toString());
                activity.walkPosted(false);

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

    public  void getAvailableWalkList(final AvailableWalk activity, final int ownerId,final int zip)
    {

        String url =activity.getResources().getString(R.string.availableWalkList_api);
        //url+="/"+ownerDetails.getOwnerId();
        url+="/"+"2"+ "/"+"1";
        final List<String> stList=new ArrayList<>();
        final ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        // Request a string response from the provided URL.
        final JsonArrayRequest stringRequest = new JsonArrayRequest (Request.Method.GET, url,null,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        List<WalkInfo> list=null;
                        try {


                            list=objectMapper.readValue(response.toString(),new TypeReference<List<WalkInfo>>(){});
                        }
                        catch (Exception e)
                        {
                            Log.e("JSONPARSE", e.getMessage());
                        }
                        finally {
                            activity.populateData(list);
                        }

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

        };
// Add the request to the RequestQueue.
        queue.add(stringRequest);

    }


    public  void getPostWalkList(final PostWalk activity, final int id)
    {

        String url =activity.getResources().getString(R.string.walkList_api);
        //url+="/"+ownerDetails.getOwnerId();
        url+="/"+id;
        final List<String> stList=new ArrayList<>();
        final ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        // Request a string response from the provided URL.
        final JsonArrayRequest stringRequest = new JsonArrayRequest (Request.Method.GET, url,null,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        List<WalkInfo> list=null;
                        try {


                            list=objectMapper.readValue(response.toString(),new TypeReference<List<WalkInfo>>(){});
                        }
                        catch (Exception e)
                        {
                            Log.e("JSONPARSE", e.getMessage());
                        }
                        finally {
                            activity.populateData(list);
                        }

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

        };
// Add the request to the RequestQueue.
        queue.add(stringRequest);

    }


    public  void   getRequestedWalkList(final RequestedWalk activity, final int id)
    {

        String url =activity.getResources().getString(R.string.requestedWalkList_api);
        //url+="/"+ownerDetails.getOwnerId();
        url+="/"+id;
        final List<String> stList=new ArrayList<>();
        final ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        // Request a string response from the provided URL.
        final JsonArrayRequest stringRequest = new JsonArrayRequest (Request.Method.GET, url,null,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        List<WalkReq> list=null;
                        try {


                            list=objectMapper.readValue(response.toString(),new TypeReference<List<WalkReq>>(){});
                        }
                        catch (Exception e)
                        {
                            Log.e("JSONPARSE", e.getMessage());
                        }
                        finally {
                            activity.populateData(list);
                        }

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

        };
// Add the request to the RequestQueue.
        queue.add(stringRequest);

    }



    public  void   getPendingRequestsWalkList(final RequestsWalk activity, final int id)
    {

        String url =activity.getResources().getString(R.string.pendingRequestWalkList_api);
        //url+="/"+ownerDetails.getOwnerId();
        url+="/"+id;
        final List<String> stList=new ArrayList<>();
        final ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        // Request a string response from the provided URL.
        final JsonArrayRequest stringRequest = new JsonArrayRequest (Request.Method.GET, url,null,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        List<WalkReq> list=null;
                        try {


                            list=objectMapper.readValue(response.toString(),new TypeReference<List<WalkReq>>(){});
                        }
                        catch (Exception e)
                        {
                            Log.e("JSONPARSE", e.getMessage());
                        }
                        finally {
                            activity.populateData(list);
                        }

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

        };
// Add the request to the RequestQueue.
        queue.add(stringRequest);

    }

    //Dog Walk Api class ends

}
