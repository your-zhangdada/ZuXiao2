package com.zuxiao2.zuxiao2.ui.fragment.fication.activity;

import android.Manifest;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;
import com.zuxiao2.zuxiao2.bean.MerChantentryBean;
import com.zuxiao2.zuxiao2.contract.IMerchantentryContract;
import com.zuxiao2.zuxiao2.presenter.MerchantentryPresenter;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
@RequiresApi(api = Build.VERSION_CODES.N)
public class Merchantentry extends BaseActivity<MerchantentryPresenter> implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, IMerchantentryContract.View {

    private TextView tv_xieyi, im_addres;
    private EditText tv_company_name, tv_staff_Number, tv_shibie_Number, tv_management, tv_name, tv_id_number, ed_name, ed_name_phone, ed_xx_adds;
    private ImageView im_shengfenzhengoen, im_shengfenzhengtwo, im_addphotooen, im_addphototwo, im_yingyezao1, im_yingyezao2, im_yingyezao3;
    private Button btn_sc;
    private CheckBox chechbox_xuanzhe;
    private Bitmap bitmap;
    private String bitmaoStr;

    @Override
    protected void initTitle() {

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_merchantentry;
    }

    @Override
    protected void initView() {
        //公司名称
        tv_company_name = findViewById(R.id.tv_company_name);
        //员工人数
        tv_staff_Number = findViewById(R.id.tv_staff_Number);
        //纳税人识别码
        tv_shibie_Number = findViewById(R.id.tv_shibie_Number);
        //经营范围
        tv_management = findViewById(R.id.tv_management);
        //法人姓名
        tv_name = findViewById(R.id.tv_name);
        //省份证号
        tv_id_number = findViewById(R.id.tv_id_number);
        //  联系人
        ed_name = findViewById(R.id.ed_name);
        //联系电话
        ed_name_phone = findViewById(R.id.ed_name_phone);
        //选着地址
        im_addres = findViewById(R.id.im_addres);
        im_addres.setOnClickListener(this);
        //详细地址
        ed_xx_adds = findViewById(R.id.ed_xx_adds);
        //正面省份证照片 拍照
        im_shengfenzhengoen = findViewById(R.id.im_shengfenzhengoen);
        im_shengfenzhengoen.setOnClickListener(this);
        //反面省份证照片 拍照
        im_shengfenzhengtwo = findViewById(R.id.im_shengfenzhengtwo);
        im_shengfenzhengtwo.setOnClickListener(this);
        //上传手持省份证 拍照
        im_addphotooen = findViewById(R.id.im_addphotooen);
        im_addphotooen.setOnClickListener(this);
        im_addphototwo = findViewById(R.id.im_addphototwo);
        //上传营业执照  相册与拍照
        im_yingyezao1 = findViewById(R.id.im_yingyezao1);
        im_yingyezao1.setOnClickListener(this);
        im_yingyezao2 = findViewById(R.id.im_yingyezao2);
        im_yingyezao2.setOnClickListener(this);
        im_yingyezao3 = findViewById(R.id.im_yingyezao3);
        //选择框
        chechbox_xuanzhe = findViewById(R.id.chechbox_xuanzhe);
        chechbox_xuanzhe.setOnCheckedChangeListener(this);
        //查看协议
        tv_xieyi = findViewById(R.id.tv_xieyi);
        tv_xieyi.setOnClickListener(this);
        //上传
        btn_sc = findViewById(R.id.btn_sc);
        btn_sc.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.im_addres://选着地址
                break;
            case R.id.im_shengfenzhengoen://正面省份证照 拍照
                openCamera(this, 1);
                break;
            case R.id.im_shengfenzhengtwo:// 反面省份证照 拍照
                openCamera(this, 3);
                break;
            case R.id.im_addphotooen: //上传手持省份证 拍照
                openCamera(this, 5);
                break;
            case R.id.im_yingyezao1://上传营业执照  相册和拍照 第一张
                showPopupWindow(10,7,R.layout.getsystemcamera);
                break;
            case R.id.im_yingyezao2://第二张
                showPopupWindow(12,9,R.layout.getsystemcamera);
                break;
            case R.id.tv_xieyi: //查看协议
                break;
            case R.id.btn_sc: //上传
                break;
        }
    }

    private void showPopupWindow(final  int sys,final int open, int id){
        View inflate = LayoutInflater.from(this).inflate(id, null);
       final PopupWindow popupWindow = new PopupWindow(inflate,ViewPager.LayoutParams.WRAP_CONTENT, ViewPager.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        TextView system = inflate.findViewById(R.id.systemcrmera);
        TextView oncamera = inflate.findViewById(R.id.onclickcamera);
        system.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSystemCamera(sys);
                popupWindow.dismiss();
            }
        });
        oncamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCamera(Merchantentry.this, open);
                popupWindow.dismiss();
            }
        });
        popupWindow.showAtLocation(this.getWindow().getDecorView(),Gravity.CENTER,0,0);
    }
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        // 选着框 点击事件
    }

    @Override
    public void showMerchantentryBean(MerChantentryBean merChantentryBean) {

    }

    @Override
    public void showCommitImgBean(MerChantentryBean merChantentryBean) {
        if (merChantentryBean.getCode().equals("0")) {

            if (pcount == 1) {
                //代表身份证正面 照片
            }
            if (pcount == 2) {
//代表身份证反面照片
            }
            if (pcount == 3) {
//代表手持身份照片
            }
            if (pcount == 4) {
//上传营业执照照片 第一张
            }
            if (pcount == 5) {
//上传营业执照照片 第二、张
            }

        } else {
            Toast.makeText(this, merChantentryBean.getMsg(), Toast.LENGTH_SHORT).show();
        }
    }

    private Uri imageUri;

    public static File tempFile;

    private void getSystemCamera(int sys){
        //调用相册
        Intent intent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, sys);
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

    private int pcount = 1;

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
            im_yingyezao1.setImageBitmap(bm);
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
            im_yingyezao2.setImageBitmap(bm);
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
                        im_shengfenzhengoen.setImageBitmap(bitmap);
                        // HashMap<String, RequestBody> mMap = new HashMap<>();
                        RequestBody fileBody = RequestBody.create(MediaType.parse("multipart/form-data"), tempFile);
                       /* RequestBody requestBody = new MultipartBody.Builder()
                                .setType(MultipartBody.FORM)
                                .addFormDataPart("file", "request", fileBody)
                                .addFormDataPart("imagetype", "jpg")
                                .build();
                        mMap.put("request",requestBody);*/
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
                        im_shengfenzhengtwo.setImageBitmap(bitmap);
                        // HashMap<String, RequestBody> mMap = new HashMap<>();
                        RequestBody fileBody = RequestBody.create(MediaType.parse("multipart/form-data"), tempFile);
                       /* RequestBody requestBody = new MultipartBody.Builder()
                                .setType(MultipartBody.FORM)
                                .addFormDataPart("file", "request", fileBody)
                                .addFormDataPart("imagetype", "jpg")
                                .build();
                        mMap.put("request",requestBody);*/
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
                        im_addphotooen.setImageBitmap(bitmap);
                        // HashMap<String, RequestBody> mMap = new HashMap<>();
                        RequestBody fileBody = RequestBody.create(MediaType.parse("multipart/form-data"), tempFile);
                       /* RequestBody requestBody = new MultipartBody.Builder()
                                .setType(MultipartBody.FORM)
                                .addFormDataPart("file", "request", fileBody)
                                .addFormDataPart("imagetype", "jpg")
                                .build();
                        mMap.put("request",requestBody);*/
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
                        im_yingyezao1.setImageBitmap(bitmap);
                        // HashMap<String, RequestBody> mMap = new HashMap<>();
                        RequestBody fileBody = RequestBody.create(MediaType.parse("multipart/form-data"), tempFile);
                       /* RequestBody requestBody = new MultipartBody.Builder()
                                .setType(MultipartBody.FORM)
                                .addFormDataPart("file", "request", fileBody)
                                .addFormDataPart("imagetype", "jpg")
                                .build();
                        mMap.put("request",requestBody);*/
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
                        im_yingyezao2.setImageBitmap(bitmap);
                        // HashMap<String, RequestBody> mMap = new HashMap<>();
                        RequestBody fileBody = RequestBody.create(MediaType.parse("multipart/form-data"), tempFile);
                       /* RequestBody requestBody = new MultipartBody.Builder()
                                .setType(MultipartBody.FORM)
                                .addFormDataPart("file", "request", fileBody)
                                .addFormDataPart("imagetype", "jpg")
                                .build();
                        mMap.put("request",requestBody);*/
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
