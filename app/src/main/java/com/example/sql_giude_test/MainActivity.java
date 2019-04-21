package com.example.sql_giude_test;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.sql_giude_test.Adapter.CategoriesListAdapter;
import com.example.sql_giude_test.Repository.WebCategoryRepository;
import com.example.sql_giude_test.db.entity.CategoryEntity;
import com.example.sql_giude_test.viewmodel.CategoryViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


//    private CategoryAdapter categoryAdapter;
    public List<CategoryEntity> mCategories;
//    private CategoryViewModel categoryViewModel;

    private WebCategoryRepository webCategoryRepository;

    CategoryViewModel categoryViewModel;
    CategoriesListAdapter categoriesListAdapter;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



//        List<CategoryEntity> categoryEntities = null;
        recyclerView=findViewById(R.id.recyclerHome);
        categoriesListAdapter=new CategoriesListAdapter(this);
        recyclerView.setAdapter(categoriesListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        categoryViewModel = ViewModelProviders.of(this).get(CategoryViewModel.class);
        categoryViewModel.getAllCategories().observe(this, new Observer<List<CategoryEntity>>() {
            @Override
            public void onChanged(@Nullable List<CategoryEntity> categories) {
                categoriesListAdapter.setCategory(categories);
//                categoriesListAdapter.notifyItemChanged();
                Toast.makeText(getApplicationContext(), "AAAAAA", Toast.LENGTH_SHORT).show();
            }
        });
//        List<CategoryEntity> categoryEntities = null;
//        recyclerView=findViewById(R.id.recyclerHome);
//        categoriesListAdapter=new CategoriesListAdapter(categoryEntities,this);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        SwipeRefreshLayout swipeRefreshLayout= (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        //swipeRefreshLayout.setRefreshing(true);
//        swipeRefreshLayout.setColorSchemeResources(R.color.accent_green,R.color.md_red_800,R.color.md_blue_500,R.color.purple);
//        categoryEntities = new ArrayList<CategoryEntity>();
//        recyclerView.setAdapter(categoriesListAdapter);



//        setListPostFrag();

//        categoryAdapter = new CategoryAdapter(mCategories, getApplicationContext(), false, false);

//        categoryViewModel = ViewModelProviders.of(this).get(CategoryViewModel.class);
//        categoryViewModel.getCategories().observe(this, new Observer<List<CategoryEntity>>() {
//            @Override
//            public void onChanged(@Nullable List<CategoryEntity> categories) {
//                categoryAdapter.SetCate(categories);
//                Toast.makeText(getApplicationContext(), "AAAAAA", Toast.LENGTH_SHORT).show();
//            }
//        });


//        webCategoryRepository=new WebCategoryRepository(getApplication());
//        webCategoryRepository.providesWebCategory();
//        LiveData<List<CategoryEntity>> listLiveData;
//        listLiveData=webCategoryRepository.getAllCategoriesTasks();
//        List<CategoryEntity> categoryEntities=listLiveData.getValue();
//        int i=3;



//        CategoriesListAdapter categoriesListAdapter= new CategoriesListAdapter(getApplicationContext());
//        RecyclerView recyclerView=findViewById(R.idrecyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(categoriesListAdapter);

//        categoryViewModel= ViewModelProviders.of(this).get(CategoryViewModel.class);
//        categoryViewModel.getAllCategories().observe(this, new Observer<List<CategoryEntity>>() {
//            @Override
//            public void onChanged(@Nullable List<CategoryEntity> categoryEntities) {
//                // Update the cached copy of the categories in the adapter.
//                if(categoryEntities == null){
//                    categoryEntities = new ArrayList<>();
//                }
//                categoriesListAdapter.setCategories(categoryEntities);
//            }
//        });

//ArrayList<CategoryEntity> e = new ArrayList<>();
//e.add(new CategoryEntity(1,"asdf","asdf"));
//categoriesListAdapter.setCategories(e);

    }



//    private void setListPostFrag() {
//        FragmentManager fm=getSupportFragmentManager();
//        CategoryFragment categoryFragment=new CategoryFragment();
//        FragmentTransaction ft=fm.beginTransaction();
//        ft.addToBackStack(null);
//        ft.replace(R.id.container, categoryFragment, CategoryFragment.TAG);
//        ft.commit();
//
//    }


}
