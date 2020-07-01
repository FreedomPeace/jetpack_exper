package com.example.jetpack_exper;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Query("Select * from user")
    List<User> getUsers();

    @Insert
    void insertAll(User... user);

    @Query("select * from user where id in (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("select * from user where first_name like :first and last_name like :last limit 1")
    User findByName(String first, String last);

    @Delete
    void delete(User user);
}
