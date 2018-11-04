package com.zuxiao2.zuxiao2.ui.fragment.mine.activity;

import android.Manifest;
import android.app.Activity;
import android.content.ContentValues;
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

/**
 *   TODO 学生认证 以完成
 */
public class StudentActivity extends BaseActivity<ApplyPresenter> implements ApplyContract.View,View.OnClickListener {
    private EditText tv_school_name,tv_school_xuejihao,tv_school_zy,tv_school_dz;
    private ImageView im,student_im;
    private Button bt_upload_immediately;
    public static File tempFile;
    private Uri imageUri;
    private int pcount = 1;
    private String sfz_dataOne,sfz_dataTwo;
    private String school_name;
    private String school_xuejihao;
    private String school_zy;
    private String school_dz;
    private ImageView im_back;

    @Override
    protected void initTitle() {

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_student;
    }

    @Override
    protected void initView() {
        im_back = findViewById(R.id.im_back);
        im_back.setOnClickListener(this);
        tv_school_name = findViewById(R.id.tv_school_name);// 学校名称
        school_name = tv_school_name.getText().toString();
        tv_school_xuejihao = findViewById(R.id.tv_school_xuejihao);//学籍号
        school_xuejihao = tv_school_xuejihao.getText().toString();
        tv_school_zy = findViewById(R.id.tv_school_zy);// 所学专业
        school_zy = tv_school_zy.getText().toString();
        tv_school_dz = findViewById(R.id.tv_school_dz);//学籍地址
        school_dz = tv_school_dz.getText().toString();
        im = findViewById(R.id.im);// 学生证 正面
        im.setOnClickListener(this);
        student_im = findViewById(R.id.student_im);//学生证 反面
        student_im.setOnClickListener(this);
        bt_upload_immediately = findViewById(R.id.bt_upload_immediately);
        bt_upload_immediately.setOnClickListener(this);//立即上传
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.im:// 学生证 正面
                openCamera(this,1); //调起相机拍照
                break;
            case R.id.student_im://学生证 反面
                openCamera(this,3); //调起相机拍照
                break;
            case R.id.bt_upload_immediately://立即上传
                // 如果上传成功 弹窗 提示用户
                getStudentApply();
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
                intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
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

    /**
     * 网络请求
     */
    private void getStudentApply() {
        Map<String,String> map = new HashMap<>();
        map.put("authType",1+"");//认证大类型 1、学生认证，2、个人认证，3、企业认证
        map.put("authTypeLast",2+"");//认证小类型 1、身份证认证 2、学生证认证 3、运营商认证 4、芝麻信用 5、社保卡认证 6、学历认证 7、公司信息认证 8、固定资产认证、 9法人认证 10、营业执照认证 11、企业信息认证 12、委托人认证 13、委托书认证
        map.put("schoolName",school_name);//学校名称
        map.put("schoolRoll",school_xuejihao+"");//学籍号
        map.put("major",school_zy);//所学专业
        map.put("schoolRollAddress",school_dz);//学籍地址
        map.put("stuCardFront",sfz_dataOne);//学生证 正面照
        map.put("stuCardBehind",sfz_dataTwo);//学生证反面照
        HashMap<String, String> header = new HashMap<>();
        header.put("user_login",SpUtils.getUserKey(this));
        header.put("uuid",SpUtils.getUserId());
        presenter.getApplyStu(header,map);
    }

    @Override
    public void showApplyBean(final ApplyBean applyBean) {

        if (applyBean.getMsg().equals("ok")){
            Toast.makeText(StudentActivity.this, "上传成功！等待审核。", Toast.LENGTH_SHORT).show();
            Log.e("学生证认证",applyBean.toString());
            finish();
        }else {
            Toast.makeText(StudentActivity.this, "上传失败。", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void showCommitImgBean(MerChantentryBean merChantentryBean) {
        if (merChantentryBean.getCode().equals("0")) {
            if (pcount == 1) {
                //学生证 正面照
                sfz_dataOne = merChantentryBean.getData();
            }
            if (pcount == 2) {
                //学生证反面照
                sfz_dataTwo = merChantentryBean.getData();
            } else {
                Toast.makeText(this, merChantentryBean.getMsg(), Toast.LENGTH_SHORT).show();
            }
        }
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
            im.setImageBitmap(bm);
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
            student_im.setImageBitmap(bm);
            c.close();
        }
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
                        im.setImageBitmap(bitmap);
                        // HashMap<String, RequestBody> mMap = new HashMap<>();
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
                        student_im.setImageBitmap(bitmap);
                        // HashMap<String, RequestBody> mMap = new HashMap<>();
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
            case 8:
                if (resultCode == RESULT_OK) {
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver()
                                .openInputStream(imageUri));

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
}
