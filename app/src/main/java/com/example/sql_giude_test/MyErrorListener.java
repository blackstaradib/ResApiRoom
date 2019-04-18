package com.example.sql_giude_test;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;

public class MyErrorListener implements Response.ErrorListener {
    Context c;

    public MyErrorListener(Context co) {
        c = co;
    }

    @SuppressLint("LongLogTag")
    @Override
    public void onErrorResponse(VolleyError error) {
        Log.e("dffddfgdfg","ffddsfdsfs");
        //Handle Error
        String message = null;
        if (error instanceof NetworkError) {
            Log.e("", error.networkResponse + " ");
            message = "Cannot connect to Internet...Please check your connection!";
        } else if (error instanceof ServerError) {
            //Log.e("", error.networkResponse + " ");
           // Log.e("", "The user name or password is incorrect" + " ");
            message = "The server could not be found. Please try again after some time!!";
        } else if (error instanceof AuthFailureError) {
            Log.e("", error.networkResponse + " ");
            message = "Cannot connect to Internet...Please check your connection!";
        } else if (error instanceof ParseError) {
            Log.e("", error.networkResponse + " ");
            message = "Parsing error! Please try again after some time!!";
        } else if (error instanceof NoConnectionError) {
            Log.e("", error.networkResponse + " ");
            message = "Cannot connect to Internet...Please check your connection!";
        } else if (error instanceof TimeoutError) {
            Log.e("", error.networkResponse + " ");
            message = "Connection TimeOut! Please check your internet connection.";
        } else {
            message = error.getMessage();
            Log.d("volley", "error : " + error.getMessage());
        }
        Toast.makeText(c, message, Toast.LENGTH_SHORT).show();
    }
}