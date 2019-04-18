package com.example.sql_giude_test.Repository;


import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.util.SortedList;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.sql_giude_test.MyErrorListener;
import com.example.sql_giude_test.db.AppDatabase;
import com.example.sql_giude_test.db.dao.CategoryDao;
import com.example.sql_giude_test.db.entity.CategoryEntity;
import com.example.sql_giude_test.viewmodel.CategoryViewModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class WebCategoryRepository {
    private final String JSON_URL = "https://jsonplaceholder.typicode.com/posts/1/comments";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private Application application;
    private CategoryViewModel model;
//    private AppDatabase db;

    List<CategoryEntity> webserviceResponseList = new ArrayList<>();

    public WebCategoryRepository(Application application, CategoryViewModel model) {
        this.application = application;
        catRepo = new CategoryRepository(application);
//        db= AppDatabase.getInstance(context);
        this.model =model;
    }



//    public void insertCategoryTask(CategoryEntity categoryEntity) {
//
//
//        new AsyncTask<CategoryEntity, Void, Void>() {
//            @Override
//            protected Void doInBackground(CategoryEntity... categoryEntities) {
//                db.categoryDao().insert(categoryEntities[0]);
//                return null;
//            }
//
//        }.execute(categoryEntity);
//    }

//    public void insertAllCategoryTask(List<CategoryEntity> categoryEntities) {
//        new AsyncTask<Void, Void, Void>() {
//            @Override
//            protected Void doInBackground(Void... voids) {
//                db.categoryDao().insertAll(categoryEntities);
//                return null;
//            }
//        }.execute();
//    }
//
//    public LiveData<CategoryEntity> getCategoryTask(int id) {
//        return db.categoryDao().loadCategory(id);
//    }
//
//    public LiveData<List<CategoryEntity>> getAllCategoriesTasks() {
//        return db.categoryDao().loadAllCategory();
//    }

    private CategoryRepository catRepo;


    public LiveData<List<CategoryEntity>> providesWebCategory() {

        final MutableLiveData<List<CategoryEntity>> data = new MutableLiveData<>();
        model.allCategories = data;
        try {
            request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    JSONObject jsonObject  = null ;
                    Log.e("dffddfgdfg","ffddsfdsfs");
                    for (int i = 0 ; i < response.length(); i++ ) {
                        try {
                            jsonObject = response.getJSONObject(i) ;

                            int id=jsonObject.getInt("postId");
                            String type=jsonObject.getString("name");
                            String descreption=jsonObject.getString("body");

                            webserviceResponseList.add(new CategoryEntity(id,type,descreption));
                            catRepo.insertCategories(webserviceResponseList);
                            data.postValue(webserviceResponseList);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    // setuprecyclerview(lstCategories);
                }
            }, new MyErrorListener(application.getApplicationContext()));
            requestQueue = Volley.newRequestQueue(application.getApplicationContext());
            requestQueue.add(request);
        }catch (Exception e){
            e.printStackTrace();
        }
        return data;

    }



//    private class insertCategoryTask extends AsyncTask<CategoryEntity,Void,Void> {
//
//
//        @Override
//        protected Void doInBackground(CategoryEntity... categoryEntities) {
//
//            db.categoryDao().insert(categoryEntities[0]);
//
//            return null;
//
//        }
//
//        @Override
//        protected void onPostExecute(Void aVoid) {
//            super.onPostExecute(aVoid);
//
////            contactsAdapter.notifyDataSetChanged();
//        }
//
//    }
//
//
//    private void insertCategory(int id,String type,String descreption ){
//        final Executor executor = Executors.newFixedThreadPool(2);
//        executor.execute(new Runnable() {
//            @Override
//            public void run() {
//                db.categoryDao().insert(new CategoryEntity(id, type, descreption));
//            }
//        });
//        new insertCategoryTask().execute(new CategoryEntity(id,type,descreption));
//    }



}