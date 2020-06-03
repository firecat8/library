package com.library.ui.request;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.NetworkError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.library.rest.api.request.LoginRequest;
import com.library.rest.api.vo.user.UserVo;

import java.lang.reflect.Array;
import java.util.List;

public class RequestFactory {
    private static final String TAG = "RequestFactory";
    private static RequestFactory instance;
    private final Gson gson = new Gson();
    private Context context;
    private RequestQueue requestQueue;

    private RequestFactory(Context context) {
        this.context = context;
        this.requestQueue = getRequestQueue();
    }

    public static synchronized RequestFactory getInstance(Context context) {
        if (instance == null) {
            instance = new RequestFactory(context);
        }
        return instance;
    }

    public void makeLoginRequest(String svcURL, LoginRequest request, Response.Listener<UserVo> listener) {
        makeRequest(Request.Method.POST, svcURL + "/login", gson.toJson(request), UserVo.class, listener);
    }

    public <T, Req> void makeSaveRequest(String svcURL, Req request, Class<T> clazz, Response.Listener<T> listener) {
        makeRequest(Request.Method.POST, svcURL + "/save", gson.toJson(request), clazz, listener);
    }

    public <T, Req> void makeUpdateRequest(String svcURL, Req request, Class<T> clazz, Response.Listener<T> listener) {
        makeRequest(Request.Method.POST, svcURL + "/update", gson.toJson(request), clazz, listener);
    }

    public <T, Req> void makeLoadRequest(String svcURL, Req request, Class<T> clazz, Response.Listener<T> listener) {
        makeRequest(Request.Method.GET, svcURL + "/load", gson.toJson(request), clazz, listener);
    }

    public <T, Req> void makeDeleteRequest(String svcURL, Req request, Class<T> clazz, Response.Listener<T> listener) {
        makeRequest(Request.Method.DELETE, svcURL + "/delete", gson.toJson(request), clazz, listener);
    }

    public <T, Req> void makeLoadAllRequest(String svcURL, Req request, Class<T> clazz, Response.Listener<T> listener) {
        makeRequest(Request.Method.GET, svcURL + "/loadAll", request == null ? null : gson.toJson(request), clazz,
               // new TypeToken<T>() { }.getType(),
                listener);
    }

    private <T> void makeRequest(int method, String url, String requestBody, Class<T> clazz, Response.Listener<T> listener) {
        addToRequestQueue(new JsonRequest<T>(method, url, requestBody, clazz, null, context, listener, getErrorListener()));
    }

    private RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context);
        }
        return requestQueue;
    }

    private <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

    private Response.ErrorListener getErrorListener() {
        return error -> {
            if (error.getCause() != null) {
                Log.i(TAG, "\n"+error.getCause().getMessage()+"\n");
            }
            if (error.getMessage() != null) {
                Log.i(TAG, "\n"+error.getMessage()+"\n");
            }
            if (error instanceof NetworkError) {
                Toast.makeText(context, "No network is available", Toast.LENGTH_LONG).show();
                return;
            }
            Toast.makeText(context, error.getMessage(), Toast.LENGTH_LONG).show();
        };
    }

}
