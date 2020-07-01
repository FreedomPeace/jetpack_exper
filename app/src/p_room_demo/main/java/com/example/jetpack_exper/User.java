package com.example.jetpack_exper;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
class User {
     @PrimaryKey @ColumnInfo(name = "id") public int uid;
     @ColumnInfo(name = "first_name")
     public String firstName;
     @ColumnInfo(name = "last_name")
     public String lastName;
}
