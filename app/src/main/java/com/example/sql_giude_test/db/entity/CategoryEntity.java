package com.example.sql_giude_test.db.entity;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.example.sql_giude_test.model.Category;


@Entity(tableName = "Category")
public class CategoryEntity implements Category {

    @PrimaryKey
    private int id;
    private String type;
    private String descreption;

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id; }

    @Override
    public String getType() {
        return type;
    }

    public void setType(String CategoryType) {
        this.type = type;
    }

    @Override
    public String getDescreption() { return descreption; }

    public void setDescreption(String descreption) { this.descreption = descreption; }


    public CategoryEntity() {
    }

    @Ignore
    public CategoryEntity(int id, String type, String descreption) {
        this.id = id;
        this.type = type;
        this.descreption = descreption;
    }

    @Ignore
    public CategoryEntity(Category category){

        this.id = category.getId();
        this.type = category.getType();
        this.descreption = category.getDescreption();
    }
}
