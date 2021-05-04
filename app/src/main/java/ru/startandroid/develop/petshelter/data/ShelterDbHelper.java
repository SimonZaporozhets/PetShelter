package ru.startandroid.develop.petshelter.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import ru.startandroid.develop.petshelter.data.PetContract;

public class ShelterDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Shelter.db";
    public static final int DATABASE_VERSION = 1;

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + PetContract.PetEntry.TABLE_NAME + " (" +
                    PetContract.PetEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    PetContract.PetEntry.COLUMN_PET_NAME + " TEXT NOT NULL," +
                    PetContract.PetEntry.COLUMN_PET_BREED + " TEXT," +
                    PetContract.PetEntry.COLUMN_PET_GENDER + " INTEGER NOT NULL," +
                    PetContract.PetEntry.COLUMN_PET_WEIGHT + " INTEGER NOT NULL DEFAULT 0)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + PetContract.PetEntry.TABLE_NAME;


    public ShelterDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
