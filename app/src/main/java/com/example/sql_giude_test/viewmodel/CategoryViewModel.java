package com.example.sql_giude_test.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.sql_giude_test.Repository.CategoryRepository;
import com.example.sql_giude_test.Repository.WebCategoryRepository;
import com.example.sql_giude_test.db.entity.CategoryEntity;

import java.util.List;

public class CategoryViewModel extends AndroidViewModel {

    CategoryRepository categoryRepository;
    private WebCategoryRepository webCategoryRepository;
    private LiveData<List<CategoryEntity>> allCategories;
    private int index;

//    private final LiveData<List<CategoryEntity>> apiObservable;



    public CategoryViewModel(@NonNull Application application) {

        super(application);
//        categoryRepository= new CategoryRepository(application);
        webCategoryRepository=new WebCategoryRepository(application,this);
        webCategoryRepository.providesWebService();
//        categoryRepository.insertCategories(apiObservable.getValue());
//        allCategories=categoryRepository.getAllCategory();

    }


    public LiveData<List<CategoryEntity>>getAllCategories(){
        return allCategories;
    }

    public void setCategoryRepository(LiveData<List<CategoryEntity>> categoryRepository){
        allCategories=categoryRepository;
    }

//    public MutableLiveData<List<CategoryEntity>> getwebCategory{return webCategoryRepository;}


//    public int getChangeIndex(){
//        return index;
//    }

}
