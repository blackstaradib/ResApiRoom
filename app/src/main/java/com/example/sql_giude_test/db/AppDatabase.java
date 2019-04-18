package com.example.sql_giude_test.db;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

import com.example.sql_giude_test.db.dao.CategoryDao;
import com.example.sql_giude_test.db.entity.CategoryEntity;

import java.util.List;
import java.util.concurrent.Executors;


@Database(entities = {CategoryEntity.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase sInstance;

    @VisibleForTesting
    public static final String DATABASE_NAME = "offerly";

    public abstract CategoryDao categoryDao();

    private final MutableLiveData<Boolean> mIsDatabaseCreated = new MutableLiveData<>();

    public static AppDatabase getInstance(final Context context) {
        if (sInstance == null) {
            synchronized (AppDatabase.class) {
                if (sInstance == null) {
                    sInstance = buildDatabase(context.getApplicationContext());
                    sInstance.updateDatabaseCreated(context.getApplicationContext());
                }
            }
        }
        return sInstance;
    }


    private static AppDatabase buildDatabase(final Context appContext) {

        return Room.databaseBuilder(appContext, AppDatabase.class, DATABASE_NAME)
                .allowMainThreadQueries()
//                .fallbackToDestructiveMigration()
                .addMigrations(MIGRATION_1_2)
                .addCallback(sRoomDatabaseCallback)
                .build();
    }



    private static Callback sRoomDatabaseCallback=new Callback() {

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsync(sInstance).execute();
        }
    };


    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final CategoryDao categoryDao;

        public PopulateDbAsync(AppDatabase instance) {
            categoryDao=instance.categoryDao();

        }

        @Override
        protected Void doInBackground(Void... voids) {
            categoryDao.deleteAll();
            return null;
        }
    }



    private void updateDatabaseCreated(final Context context) {
        if (context.getDatabasePath(DATABASE_NAME).exists()) {
            setDatabaseCreated();
        }
    }

    private void setDatabaseCreated(){
        mIsDatabaseCreated.postValue(true);
    }

//    private static void insertData(final AppDatabase database, final List<CategoryEntity> categories) {
//
//        database.categoryDao().insertAll(categories);
//
//    }

    public LiveData<Boolean> getDatabaseCreated() {
        return mIsDatabaseCreated;
    }

    private static final Migration MIGRATION_1_2 = new Migration(1, 2) {

        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {

//            database.execSQL("CREATE VIRTUAL TABLE IF NOT EXISTS `categoryFts` USING FTS4("
//                    + "`name` TEXT, `description` TEXT, content=`products`)");

//            database.execSQL("INSERT INTO categoryFts (`rowid`, `name`, `description`) "
//                    + "SELECT `id`, `name`, `description` FROM products");

        }
    };



}
