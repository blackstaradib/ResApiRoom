package com.example.sql_giude_test.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.sql_giude_test.Repository.CategoryRepository;
import com.example.sql_giude_test.Repository.WebCategoryRepository;
import com.example.sql_giude_test.db.entity.CategoryEntity;

import java.util.List;

public class CategoryViewModel extends AndroidViewModel {

    private WebCategoryRepository webCategoryRepository;
    public LiveData<List<CategoryEntity>> allCategories;

    private final LiveData<List<CategoryEntity>> apiObservable;



    public CategoryViewModel(@NonNull Application application) {

        super(application);
        webCategoryRepository=new WebCategoryRepository(application,this);
        apiObservable=webCategoryRepository.providesWebCategory();

    }


    public LiveData<List<CategoryEntity>>getAllCategories(){
        return allCategories;
    }


}
