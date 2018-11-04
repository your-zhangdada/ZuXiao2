package com.zuxiao2.zuxiao2.ui.fragment.mine.activity;

import android.Manifest;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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

//  TODO 省份证认证  已完成
public class SengfenActivity extends BaseActivity<ApplyPresenter> implements ApplyContract.View, View.OnClickListener {

    private EditText tv_sfname,tv_sfz_hm,tv_sfz_dz;
    private ImageView im_shenfengoen,im_shenfengtwo,im_id,im_sc_zhenmian;
    private Button bt_id_au;
    private String sfname;
    private String sfz_hm;
    private String sfz_dz;
    public static File tempFile;
    private Uri imageUri;
    private int pcount = 1;
    private String sfz_dataOne;
    private String sfz_dataTwo;
    private String sc_sfzData;
    private ImageView im_back;

    @Override
    protected void initTitle() {

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_sengfen;
    }

    @Override
    protected void initView() {
        im_back = findViewById(R.id.im_back);
        im_back.setOnClickListener(this);
         tv_sfname = findViewById(R.id.tv_sfname);//省份证姓名
        sfname = tv_sfname.getText().toString();
        tv_sfz_hm = findViewById(R.id.tv_sfz_hm); //省份证号
        sfz_hm = tv_sfz_hm.getText().toString();
        tv_sfz_dz = findViewById(R.id.tv_sfz_dz);//省份地址
        sfz_dz = tv_sfz_dz.getText().toString();
        im_shenfengoen = findViewById(R.id.im_shenfengoen);//身份证正面照
        im_shenfengoen.setOnClickListener(this);
        im_shenfengtwo = findViewById(R.id.im_shenfengtwo);//省份证 反面照
        im_shenfengtwo.setOnClickListener(this);
        im_id = findViewById(R.id.im_id);//点击拍照
        im_id.setOnClickListener(this);
        im_sc_zhenmian = findViewById(R.id.im_sc_zhenmian);//拍照完成的图片
        bt_id_au = findViewById(R.id.bt_id_au);//立即上传
        bt_id_au.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.im_shenfengoen://身份证正面照
                openCamera(this,1); //调起相机拍照
                break;
            case R.id.im_shenfengtwo://省份证 反面照
                openCamera(this,3); //调起相机拍照
                break;
            case R.id.im_id://点击拍照 手持省份证照
                openCamera(this, 5);   //调起相机拍照
                break;
            case R.id.bt_id_au://立即上传
                getApply();
                break;
            case R.id.im_back:
                finish();
                break;
        }
    }
    // TODO //调起相机拍照  （1）
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
//        if (requestCode == 10 && resultCode == Activity.RESULT_OK && data != null) {
//            Uri selectedImage = data.getData();
//            String[] filePathColumns = {MediaStore.Images.Media.DATA};
//            Cursor c = getContentResolver().query(selectedImage, filePathColumns, null, null, null);
//            c.moveToFirst();
//            int columnIndex = c.getColumnIndex(filePathColumns[0]);
//            String imagePath = c.getString(columnIndex);
//            Bitmap bm = BitmapFactory.decodeFile(imagePath);
//            im_yingyezao1.setImageBitmap(bm);
//            c.close();
//        }
//        if (requestCode == 12 && resultCode == Activity.RESULT_OK && data != null) {
//            Uri selectedImage = data.getData();
//            String[] filePathColumns = {MediaStore.Images.Media.DATA};
//            Cursor c = getContentResolver().query(selectedImage, filePathColumns, null, null, null);
//            c.moveToFirst();
//            int columnIndex = c.getColumnIndex(filePathColumns[0]);
//            String imagePath = c.getString(columnIndex);
//            Bitmap bm = BitmapFactory.decodeFile(imagePath);
//            im_yingyezao2.setImageBitmap(bm);
//            c.close();
//        }
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    Intent intent = new Intent("com.android.camera.action.CROP");
                    intent.setDataAndType(imageUri, "image/*");
                    intent.putExtra("scale", true);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                    startActivityForResult(intent, 2); // 启动裁剪程序
                }
                break;
            case 2:
                if (resultCode == RESULT_OK) {
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver()
                                .openInputStream(imageUri));
                        im_shenfengoen.setImageBitmap(bitmap);

                        RequestBody fileBody = RequestBody.create(MediaType.parse("multipart/form-data"), tempFile);

                        MultipartBody.Part part = MultipartBody.Part.createFormData("request", tempFile.getName(), fileBody);
                        pcount = 1;
                        presenter.getCommitImgBean(part);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 3:
                if (resultCode == RESULT_OK) {
                    Intent intent = new Intent("com.android.camera.action.CROP");
                    intent.setDataAndType(imageUri, "image/*");
                    intent.putExtra("scale", true);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                    startActivityForResult(intent, 4); // 启动裁剪程序
                }
                break;
            case 4:
                if (resultCode == RESULT_OK) {
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver()
                                .openInputStream(imageUri));
                        im_shenfengtwo.setImageBitmap(bitmap);

                        RequestBody fileBody = RequestBody.create(MediaType.parse("multipart/form-data"), tempFile);

                        MultipartBody.Part part = MultipartBody.Part.createFormData("request", tempFile.getName(), fileBody);
                        pcount = 2;
                        presenter.getCommitImgBean(part);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 5:
                if (resultCode == RESULT_OK) {
                    Intent intent = new Intent("com.android.camera.action.CROP");
                    intent.setDataAndType(imageUri, "image/*");
                    intent.putExtra("scale", true);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                    startActivityForResult(intent, 6); // 启动裁剪程序
                }
                break;
            case 6:
                if (resultCode == RESULT_OK) {
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver()
                                .openInputStream(imageUri));
                        im_sc_zhenmian.setImageBitmap(bitmap);
                        RequestBody fileBody = RequestBody.create(MediaType.parse("multipart/form-data"), tempFile);
                        MultipartBody.Part part = MultipartBody.Part.createFormData("request", tempFile.getName(), fileBody);
                        pcount = 3;
                        presenter.getCommitImgBean(part);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 7:
                if (resultCode == RESULT_OK) {
                    Intent intent = new Intent("com.android.camera.action.CROP");
                    intent.setDataAndType(imageUri, "image/*");
                    intent.putExtra("scale", true);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                    startActivityForResult(intent, 8); // 启动裁剪程序
                }
                break;
//            case 8:
//                if (resultCode == RESULT_OK) {
//                    try {
//                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver()
//                                .openInputStream(imageUri));
//                        im_yingyezao1.setImageBitmap(bitmap);
//                        // HashMap<String, RequestBody> mMap = new HashMap<>();
//                        RequestBody fileBody = RequestBody.create(MediaType.parse("multipart/form-data"), tempFile);
//                       /* RequestBody requestBody = new MultipartBody.Builder()
//                                .setType(MultipartBody.FORM)
//                                .addFormDataPart("file", "request", fileBody)
//                                .addFormDataPart("imagetype", "jpg")
//                                .build();
//                        mMap.put("request",requestBody);*/
//                        MultipartBody.Part part = MultipartBody.Part.createFormData("request", tempFile.getName(), fileBody);
//                        pcount = 4;
//                        presenter.getCommitImgBean(part);
//                    } catch (FileNotFoundException e) {
//                        e.printStackTrace();
//                    }
//                }
//                break;
            case 9:
                if (resultCode == RESULT_OK) {
                    Intent intent = new Intent("com.android.camera.action.CROP");
                    intent.setDataAndType(imageUri, "image/*");
                    intent.putExtra("scale", true);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                    startActivityForResult(intent, 11); // 启动裁剪程序
                }
                break;
//            case 11:
////                if (resultCode == RESULT_OK) {
////                    try {
////                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver()
////                                .openInputStream(imageUri));
////                        im_yingyezao2.setImageBitmap(bitmap);
////                        // HashMap<String, RequestBody> mMap = new HashMap<>();
////                        RequestBody fileBody = RequestBody.create(MediaType.parse("multipart/form-data"), tempFile);
////                       /* RequestBody requestBody = new MultipartBody.Builder()
////                                .setType(MultipartBody.FORM)
////                                .addFormDataPart("file", "request", fileBody)
////                                .addFormDataPart("imagetype", "jpg")
////                                .build();
////                        mMap.put("request",requestBody);*/
////                        MultipartBody.Part part = MultipartBody.Part.createFormData("request", tempFile.getName(), fileBody);
////                        pcount = 5;
////                        presenter.getCommitImgBean(part);
////                    } catch (FileNotFoundException e) {
////                        e.printStackTrace();
////                    }
////                }
////                break;
        }
    }


    private void getApply() {

        String url = "https://zux2.oss-cn-beijing.aliyuncs.com/2018/10/17/59ab06b676a842abb3c5925dae879db3.jpg";
        Map<String,String> map = new HashMap<>();
        map.put("authType",1+""); //认证大类型 1、学生认证，2、个人认证，3、企业认证
        map.put("authTypeLast",1+"");//认证小类型 1、身份证认证 2、学生证认证 3、运营商认证 4、芝麻信用 5、社保卡认证 6、学历认证 7、公司信息认证 8、固定资产认证、 9法人认证 10、营业执照认证 11、企业信息认证 12、委托人认证 13、委托书认证
        map.put("stuCardFront",sfz_dataOne);//证件正面-学生证或者身份证
        map.put("stuCardBehind",sfz_dataTwo);//证件反面
        map.put("idCardName",sfname);//身份证名称
        map.put("idCardNum",sfz_hm);//身份证号码
        map.put("idCardAddress",sfz_dz);//身份证地址
        map.put("idCardHands",sc_sfzData);//手持身份证

        HashMap<String, String> header = new HashMap<>();
        header.put("user_login",SpUtils.getUserKey(this));
        header.put("uuid",SpUtils.getUserId());
        if (!SpUtils.getNikeName(this).isEmpty()){
            presenter.getApplyBean(header,map);
        }
    }
    @Override
    public void showApplyBean(final ApplyBean applyBean) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (applyBean.getMsg().equals("ok")){
                    Toast.makeText(SengfenActivity.this, "上传成功,请耐心等待审核。", Toast.LENGTH_SHORT).show();
                    Log.e("GET",applyBean.toString());
                    finish();
                }else {
                    Toast.makeText(SengfenActivity.this, "上传失败,请重新上传。", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void showCommitImgBean(MerChantentryBean merChantentryBean) {
        if (merChantentryBean.getCode().equals("0")) {
            if (pcount == 1) {
 //代表身份证正面 照片
                sfz_dataOne = merChantentryBean.getData();
            }
            if (pcount == 2) {
//代表身份证反面照片
                sfz_dataTwo = merChantentryBean.getData();
            }
            if (pcount == 3) {
//代表手持身份照片
                sc_sfzData = merChantentryBean.getData();
            } else {
                Toast.makeText(this, merChantentryBean.getMsg(), Toast.LENGTH_SHORT).show();
            }
        }
    }
    /*
     * 判断sdcard是否被挂载
     */
    public static boolean hasSdcard() {
        return Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED);
    }
}
