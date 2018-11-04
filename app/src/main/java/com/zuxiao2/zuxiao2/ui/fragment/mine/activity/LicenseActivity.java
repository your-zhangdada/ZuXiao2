package com.zuxiao2.zuxiao2.ui.fragment.mine.activity;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;
import com.zuxiao2.zuxiao2.bean.ApplyBean;
import com.zuxiao2.zuxiao2.bean.MerChantentryBean;
import com.zuxiao2.zuxiao2.contract.ApplyContract;
import com.zuxiao2.zuxiao2.presenter.ApplyPresenter;
import com.zuxiao2.zuxiao2.utils.SpUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 *   TODO 营业执照认证  以完成
 */
public class LicenseActivity extends BaseActivity<ApplyPresenter> implements ApplyContract.View,View.OnClickListener {
    private TextView tv_delete_jpg_one,tv_delete_jpg_two;
    private ImageView im_zz_one,im_zz_two,im_back;
    private Button btn_zz_sc,tv_huitui;
    private int pcount = 1;
    private Uri imageUri;
    public static File tempFile;
    private String zz_two;
    private String zz_one;

    @Override
    protected void initTitle() {
    }
    @Override
    protected int getContentView() {
        return R.layout.activity_license;
    }

    @Override
    protected void initView() {
        im_back = findViewById(R.id.im_back);
        im_back.setOnClickListener(this);
       // 点击 X  删除照片
        tv_delete_jpg_one = findViewById(R.id.tv_delete_jpg_one);
        tv_delete_jpg_two = findViewById(R.id.tv_delete_jpg_two);
        tv_delete_jpg_one.setOnClickListener(this);
        tv_delete_jpg_two.setOnClickListener(this);
        // 营业执照  与 扫描件
        im_zz_one = findViewById(R.id.im_zz_one);
        im_zz_two = findViewById(R.id.im_zz_two);
        im_zz_one.setOnClickListener(this);
        im_zz_two.setOnClickListener(this);
        //立即上传
        btn_zz_sc = findViewById(R.id.btn_zz_sc);
        btn_zz_sc.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.im_back:
                finish();
                break;
            case R.id.tv_delete_jpg_one:// 点击 X  删除照片
                break;
            case R.id.tv_delete_jpg_two:// 点击 X  删除照片
                break;
            case R.id.im_zz_one:// 营业执照  与 扫描件
                showDiaLog(10,7);
                break;
            case R.id.im_zz_two:// 营业执照  与 扫描件
                showDiaLog(12,9);
                break;
            case R.id.btn_zz_sc:  //立即上传
                getLicensePost();
                break;
        }
    }

    private void showDiaLog(final int sys, final int open) {
        new AlertDialog.Builder(this)
                .setMessage("选着相册/拍照").setIcon(R.mipmap.icon)
                .setPositiveButton("相册", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getSystemCamera(sys);
                    }
                })
                .setNegativeButton("拍照", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        openCamera(LicenseActivity.this, open);
                    }
                }).create().show();
    }

    /**
     *   TODO 系统相册
     * @param sys
     */
    private void getSystemCamera(int sys){
        //调用相册
        Intent intent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, sys);
    }

    /**
     *   TODO 打开相机拍照
     */
    public void openCamera(Activity activity, int PHOTO_REQUEST_CAREMA) {
        int currentapiVersion = android.os.Build.VERSION.SDK_INT;
        // 激活相机
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // 判断存储卡是否可以用，可用进行存储
        if (hasSdcard()) {
            SimpleDateFormat timeStampFormat = new SimpleDateFormat(
                    "yyyy_MM_dd_HH_mm_ss");
            String filename = timeStampFormat.format(new Date());
            tempFile = new File(Environment.getExternalStorageDirectory(),
                    filename + ".jpg");
            if (currentapiVersion < 24) {
                // 从文件中创建uri
                imageUri = Uri.fromFile(tempFile);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
            } else {
                //兼容android7.0 使用共享文件的形式
                ContentValues contentValues = new ContentValues(1);
                contentValues.put(MediaStore.Images.Media.DATA, tempFile.getAbsolutePath());
                //检查是否有存储权限，以免崩溃
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
                    //申请WRITE_EXTERNAL_STORAGE权限
                    Toast.makeText(this, "请开启存储权限", Toast.LENGTH_SHORT).show();
                    return;
                }
                imageUri = activity.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
            }
        }
        // 开启一个带有返回值的Activity，请求码为PHOTO_REQUEST_CAREMA
        activity.startActivityForResult(intent, PHOTO_REQUEST_CAREMA);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10 && resultCode == Activity.RESULT_OK && data != null) {
            Uri selectedImage = data.getData();
            String[] filePathColumns = {MediaStore.Images.Media.DATA};
            Cursor c = getContentResolver().query(selectedImage, filePathColumns, null, null, null);
            c.moveToFirst();
            int columnIndex = c.getColumnIndex(filePathColumns[0]);
            String imagePath = c.getString(columnIndex);
            Bitmap bm = BitmapFactory.decodeFile(imagePath);
            im_zz_one.setImageBitmap(bm);
            c.close();
        }
        if (requestCode == 12 && resultCode == Activity.RESULT_OK && data != null) {
            Uri selectedImage = data.getData();
            String[] filePathColumns = {MediaStore.Images.Media.DATA};
            Cursor c = getContentResolver().query(selectedImage, filePathColumns, null, null, null);
            c.moveToFirst();
            int columnIndex = c.getColumnIndex(filePathColumns[0]);
            String imagePath = c.getString(columnIndex);
            Bitmap bm = BitmapFactory.decodeFile(imagePath);
            im_zz_two.setImageBitmap(bm);
            c.close();
        }
        switch (requestCode){
            case 7:
                if (resultCode == RESULT_OK) {
                    Intent intent = new Intent("com.android.camera.action.CROP");
                    intent.setDataAndType(imageUri, "image/*");
                    intent.putExtra("scale", true);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                    startActivityForResult(intent, 8); // 启动裁剪程序
                }
                break;
            case 8:
                if (resultCode == RESULT_OK) {
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver()
                                .openInputStream(imageUri));
                        im_zz_one.setImageBitmap(bitmap);

                        RequestBody fileBody = RequestBody.create(MediaType.parse("multipart/form-data"), tempFile);

                        MultipartBody.Part part = MultipartBody.Part.createFormData("request", tempFile.getName(), fileBody);
                        pcount = 4;
                        presenter.getCommitImgBean(part);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 9:
                if (resultCode == RESULT_OK) {
                    Intent intent = new Intent("com.android.camera.action.CROP");
                    intent.setDataAndType(imageUri, "image/*");
                    intent.putExtra("scale", true);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                    startActivityForResult(intent, 11); // 启动裁剪程序
                }
                break;
            case 11:
                if (resultCode == RESULT_OK) {
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver()
                                .openInputStream(imageUri));
                        im_zz_two.setImageBitmap(bitmap);
                        RequestBody fileBody = RequestBody.create(MediaType.parse("multipart/form-data"), tempFile);

                        MultipartBody.Part part = MultipartBody.Part.createFormData("request", tempFile.getName(), fileBody);
                        pcount = 5;
                        presenter.getCommitImgBean(part);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }
    /*
     * 判断sdcard是否被挂载
     */
    public static boolean hasSdcard() {
        return Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED);
    }
    private void getLicensePost() {
        String url = "https://zux2.oss-cn-beijing.aliyuncs.com/2018/10/17/59ab06b676a842abb3c5925dae879db3.jpg";
        Map<String,String> map = new HashMap<>();
        map.put("authType",3+"");//认证大类型 1、学生认证，2、个人认证，3、企业认证
        map.put("authTypeLast",10+"");//认证小类型 1、身份证认证 2、学生证认证 3、运营商认证 4、芝麻信用 5、社保卡认证 6、学历认证 7、公司信息认证 8、固定资产认证、 9法人认证 10、营业执照认证 11、企业信息认证 12、委托人认证 13、委托书认证
        map.put("businessLicense",zz_one+","+zz_two);//营业执照
        HashMap<String, String> header = new HashMap<>();
        header.put("user_login",SpUtils.getUserKey(this));
        header.put("uuid",SpUtils.getUserId());
        presenter.getLicenseApply(header,map);
    }

    @Override
    public void showApplyBean(ApplyBean applyBean) {
       // TODO 营业执照 返回数据
        Toast.makeText(this, applyBean.toString(), Toast.LENGTH_SHORT).show();
        if (applyBean.getMsg().equals("ok")){
            Toast.makeText(this,"上传成功，等待审核。", Toast.LENGTH_SHORT).show();
            finish();
        }else {
            Toast.makeText(this,"上传失败，重新上传。", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showCommitImgBean(MerChantentryBean merChantentryBean) {
        if (merChantentryBean.getCode().equals("0")) {
        if (pcount == 4) {
            zz_one = merChantentryBean.getData();
//上传营业执照照片 第一张
        }
        if (pcount == 5) {
            zz_two = merChantentryBean.getData();
//上传营业执照照片 第二、张
        }
    } else {
        Toast.makeText(this, merChantentryBean.getMsg(), Toast.LENGTH_SHORT).show();
    }
    }
}
