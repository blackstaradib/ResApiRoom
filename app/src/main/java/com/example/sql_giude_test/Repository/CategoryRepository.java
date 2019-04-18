package com.example.sql_giude_test.Repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.sql_giude_test.db.AppDatabase;
import com.example.sql_giude_test.db.dao.CategoryDao;
import com.example.sql_giude_test.db.entity.CategoryEntity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CategoryRepository {

    private CategoryDao categoryDao;
    private LiveData<List<CategoryEntity>> allCategory;

    public CategoryRepository(Application application) {

        AppDatabase db= AppDatabase.getInstance(application);
        categoryDao=db.categoryDao();
        allCategory=categoryDao.loadAllCategory();
    }


    public LiveData<List<CategoryEntity>> getAllCategory(){
        return allCategory;
    }






    public void insertCategories(List<CategoryEntity> categoryEntities){
        CategoryEntity[] e = new CategoryEntity[categoryEntities.size()];

        new insertsAsyncTask(categoryDao).execute(categoryEntities.toArray(e));
    }

    private static class insertsAsyncTask extends AsyncTask<CategoryEntity, Void, Void> {

        private CategoryDao AsyncCategoryDao;

        public insertsAsyncTask(CategoryDao categoryDao) {
            AsyncCategoryDao=categoryDao;
        }

        @Override
        protected Void doInBackground(CategoryEntity... params) {

            AsyncCategoryDao.insertAll(Arrays.asList(params));
            return null;
        }
    }


}
