package com.zuxiao2.zuxiao2.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.zuxiao2.zuxiao2.application.MyApplication;

public class SpUtils {
    public static void saveUserId(String id) {
        SharedPreferences sharedPreferences = MyApplication.context.getSharedPreferences("SpUtils", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("id", id);
        edit.commit();
    }

    public static String getUserId() {
        SharedPreferences sharedPreferences = MyApplication.context.getSharedPreferences("SpUtils", Context.MODE_PRIVATE);
        String id = sharedPreferences.getString("id",null);
        if (TextUtils.isEmpty(id + "")) {
            return null;
        }
        return id;
    }
    public static void saveUserPhoto(String photo) {
        SharedPreferences sharedPreferences = MyApplication.context.getSharedPreferences("UserPhoto", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("photo", photo);
        edit.commit();
    }

    public static String getUserPhoto() {
        SharedPreferences sharedPreferences = MyApplication.context.getSharedPreferences("UserPhoto", Context.MODE_PRIVATE);
        String id = sharedPreferences.getString("photo",null);
        if (TextUtils.isEmpty(id )) {
            return null;
        }
        return id;
    }
    public static void saveNikeName(String name) {
        SharedPreferences sharedPreferences = MyApplication.context.getSharedPreferences("UserName", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("name", name);
        edit.commit();
    }

    public static String getNikeName(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("UserName", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("name", null);
        return name;
    }
    public static void saveUserNo(String userNo) {
        SharedPreferences sharedPreferences = MyApplication.context.getSharedPreferences("UserNo", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("userNo", userNo);
        edit.commit();
    }

    public static String getUserNo() {
        SharedPreferences sharedPreferences = MyApplication.context.getSharedPreferences("UserNo", Context.MODE_PRIVATE);
        String userNo = sharedPreferences.getString("userNo", null);
        if (userNo == null) {
            return "没有数据";
        }
        return userNo;
    }

    public static boolean isLogin() {
        if (TextUtils.isEmpty(MyApplication.context.getSharedPreferences("UserNo", Context.MODE_PRIVATE).getString("userNo",null))) {
            return false;
        }
        return true;
    }


    public static void clear() {
        SharedPreferences sharedPreferences = MyApplication.context.getSharedPreferences("UserNo", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.clear();
        edit.commit();
    }

}
