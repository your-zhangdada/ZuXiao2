package com.zuxiao2.zuxiao2.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.zuxiao2.zuxiao2.application.MyApplication;

public class SpUtils {

    private static SharedPreferences sharedPreferences;

    public SpUtils() {
        sharedPreferences = MyApplication.context.getSharedPreferences("userMessage", Context.MODE_PRIVATE);

    }

    public static void setUserId(String id){
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("userid",id);
        edit.commit();
    }
    public static String getUserId(){
        return sharedPreferences.getString("userid","");
    }
    public static void setUserPhone(String phone){
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("userphone",phone);
        edit.commit();
    }
    public static String getUserPhone(){
        return sharedPreferences.getString("userphone","");
    }
    public static void setUserName(String name){
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("username",name);
        edit.commit();
    }
    public static String getUserName(){
        return sharedPreferences.getString("username","");
    }
}
