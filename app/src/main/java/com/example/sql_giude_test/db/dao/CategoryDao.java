package com.example.sql_giude_test.db.dao;




import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.sql_giude_test.db.entity.CategoryEntity;

import java.util.List;


@Dao
public interface CategoryDao {

    @Query("SELECT * FROM Category")
    LiveData<List<CategoryEntity>> loadAllCategory();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<CategoryEntity> categories);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(CategoryEntity category);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(CategoryEntity categoryEntity);

    @Delete
    void delete(CategoryEntity categoryEntity);

    @Query("SELECT * FROM category where id = :categoryId")
    LiveData<CategoryEntity> loadCategory(int categoryId);

    @Query("SELECT * FROM category where id = :categoryId")
    CategoryEntity loadCategorySync(int categoryId);


    @Query("DELETE FROM category")
    void deleteAll();


}
