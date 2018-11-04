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

/**
 * TODO 社保卡认证  已完成
 */
public class SBKActivity extends BaseActivity<ApplyPresenter> implements ApplyContract.View, View.OnClickListener {

    private ImageView im_pz;
    private Button btn_tijiao;
    private EditText ed_sbk,ed_sfz,ed_sf_name;
    private String name,sfz,sbk;
    private Uri imageUri;
    public static File tempFile;
    private int pcount = 1;
    private String data;
    private ImageView im_back;

    @Override
    protected void initTitle() {

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_sbk;
    }

    @Override
    protected void initView() {
        im_back = findViewById(R.id.im_back);
        im_back.setOnClickListener(this);
        ed_sf_name = findViewById(R.id.ed_sf_name);//省份证姓名
        name = ed_sf_name.getText().toString();
        ed_sfz = findViewById(R.id.ed_sfz);// 省份证号
        sfz = ed_sfz.getText().toString();
        ed_sbk = findViewById(R.id.ed_sbk);//社保卡号
        sbk = ed_sbk.getText().toString();
        im_pz = findViewById(R.id.im_pz);//拍照
        im_pz.setOnClickListener(this);
        btn_tijiao = findViewById(R.id.btn_tijiao);// 提交
        btn_tijiao.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.im_pz: //拍照
                openCamera(this, 1);
                break;
            case R.id.btn_tijiao:// 提交
                initCardPost();

                break;
            case R.id.im_back:
                finish();
                break;
        }
    }
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
    private void initCardPost() { //社保卡
        String url = "https://zux2.oss-cn-beijing.aliyuncs.com/2018/10/17/59ab06b676a842abb3c5925dae879db3.jpg";
        Map<String,String> map = new HashMap<>();
        map.put("authType",2+"");//认证大类型 1、学生认证，2、个人认证，3、企业认证
        map.put("authTypeLast",5+"");//认证小类型 1、身份证认证 2、学生证认证 3、运营商认证 4、芝麻信用 5、社保卡认证 6、学历认证 7、公司信息认证 8、固定资产认证、 9法人认证 10、营业执照认证 11、企业信息认证 12、委托人认证 13、委托书认证
        map.put("idCardName",name);//省份证名称
        map.put("idCardNum",sfz);//省份证号码
        map.put("socialSecurityNum",sbk);//社保卡
        map.put("socialSecurityPic",data);//社保卡照片
        HashMap<String, String> header = new HashMap<>();
        header.put("user_login",SpUtils.getUserKey(this));
        header.put("uuid",SpUtils.getUserId());
        presenter.getApplyCard(header,map);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
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
                        im_pz.setImageBitmap(bitmap);

                        RequestBody fileBody = RequestBody.create(MediaType.parse("multipart/form-data"), tempFile);

                        MultipartBody.Part part = MultipartBody.Part.createFormData("request", tempFile.getName(), fileBody);
                        pcount = 1;
                        presenter.getCommitImgBean(part);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;

        }
    }

    @Override
    public void showApplyBean(final ApplyBean applyBean) {//社保卡返回数据
        if (applyBean.getMsg().equals("ok")){
             Log.e("applyBean.toString()",applyBean.toString());
            Toast.makeText(SBKActivity.this, "提交成功，等待审核。", Toast.LENGTH_SHORT).show();
            finish();
        }else {
            Toast.makeText(SBKActivity.this, "提交失败，重新提交。", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showCommitImgBean(MerChantentryBean merChantentryBean) {
            if (merChantentryBean.getCode().equals("0")){
                if (pcount == 1){
                    data = merChantentryBean.getData();
                }else {
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
