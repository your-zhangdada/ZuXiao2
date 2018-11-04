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
 * TODO 企业信息认证   已完成
 */
public class EnterpriseActivity extends BaseActivity<ApplyPresenter> implements ApplyContract.View,View.OnClickListener {

  private EditText ed_company_name;
  private EditText ed_person_number;
  private EditText ed_address;
  private ImageView im_site_photos_one,im_back;
  private ImageView im_site_photos_two;
  private ImageView im_site_photos_three;
  private ImageView im_Assets_photos_one;
  private ImageView im_Assets_photos_two;
  private ImageView im_Assets_photos_three;
  private ImageView im_patent_photos_one;
  private ImageView im_patent_photos_two;
  private ImageView im_patent_photos_three;
  private Button btn_qiye_upload;
  private String company_name;
  private String person_number;
  private String address;
    private ImageView im_site_photos_one_delete;
    private ImageView im_site_photos_two_delete;
    private ImageView im_site_photos_three_delete;
    private ImageView im_assets_photos_one_delete;
    private ImageView im_assets_photos_two_delete;
    private ImageView im_assets_photos_three_delete;
    private ImageView im_patent_photos_one_delete;
    private ImageView im_patent_photos_two_delete;
    private ImageView im_patent_photos_three_delete;
  private int pcount = 1;
  private Uri imageUri;
  public static File tempFile;
  private String photos_one,photos_two,photos_three;  //请您上传场地租赁合同照片
  private String assets_photos_one,assets_photos_two,assets_photos_three;//请您上传公司固定资产相关证件照片
  private String patent_photos_one,patent_photos_two,patent_photos_three;//请您上传公司相关专利证书照片

  @Override
    protected void initTitle() {

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_enterprise;
    }

    @Override
    protected void initView() {

      im_back = findViewById(R.id.im_back); //返回键
      im_back.setOnClickListener(this);

      ed_company_name =  findViewById(R.id.ed_company_name);//公司名称
      company_name = ed_company_name.getText().toString();
      ed_person_number =  findViewById(R.id.ed_person_number);//员工人数
      person_number = ed_person_number.getText().toString();
      ed_address =  findViewById(R.id.ed_address);//办公地址
      address = ed_address.getText().toString();

      im_site_photos_one =  findViewById(R.id.im_site_photos_one);//上传场地租赁合同照片  1
      im_site_photos_one_delete = findViewById(R.id.im_site_photos_one_delete);//点击删除照片 1
      im_site_photos_one.setOnClickListener(this);
      im_site_photos_one_delete.setOnClickListener(this);

      im_site_photos_two =  findViewById(R.id.im_site_photos_two);//上传场地租赁合同照片  2
        im_site_photos_two_delete = findViewById(R.id.im_site_photos_two_delete);     //点击删除照片 2
      im_site_photos_two.setOnClickListener(this);
        im_site_photos_two_delete.setOnClickListener(this);

      im_site_photos_three =  findViewById(R.id.im_site_photos_three);//上传场地租赁合同照片  3
        im_site_photos_three_delete = findViewById(R.id.im_site_photos_three_delete);//点击删除 照片 3
        im_site_photos_three_delete.setOnClickListener(this);
      im_site_photos_three.setOnClickListener(this);

      im_Assets_photos_one =  findViewById(R.id.im_Assets_photos_one);//上传公司固定资产相关证件照片 1
        im_assets_photos_one_delete = findViewById(R.id.im_Assets_photos_one_delete); //点击删除照片  1  公司固定资产相关照
        im_assets_photos_one_delete.setOnClickListener(this);
      im_Assets_photos_one.setOnClickListener(this);

      im_Assets_photos_two =  findViewById(R.id.im_Assets_photos_two);//上传公司固定资产相关证件照片 2
        im_assets_photos_two_delete = findViewById(R.id.im_Assets_photos_two_delete);//点击删除照片  2  公司固定资产相关照
        im_assets_photos_two_delete.setOnClickListener(this);
      im_Assets_photos_two.setOnClickListener(this);

      im_Assets_photos_three =  findViewById(R.id.im_Assets_photos_three);//上传公司固定资产相关证件照片 3
        im_assets_photos_three_delete = findViewById(R.id.im_Assets_photos_three_delete);//点击删除照片  3  公司固定资产相关照
        im_assets_photos_three_delete.setOnClickListener(this);
      im_Assets_photos_three.setOnClickListener(this);

      im_patent_photos_one =  findViewById(R.id.im_patent_photos_one);//上传公司相关专利证书照片 1
        im_patent_photos_one_delete = findViewById(R.id.im_patent_photos_one_delete); //点击删除照片  1 公司相关专利证书照片
        im_patent_photos_one_delete.setOnClickListener(this);
      im_patent_photos_one.setOnClickListener(this);

      im_patent_photos_two =  findViewById(R.id.im_patent_photos_two);//上传公司相关专利证书照片 2
        im_patent_photos_two_delete = findViewById(R.id.im_patent_photos_two_delete);//点击删除照片  2 公司相关专利证书照片
        im_patent_photos_two_delete.setOnClickListener(this);
      im_patent_photos_two.setOnClickListener(this);

      im_patent_photos_three =  findViewById(R.id.im_patent_photos_three);//上传公司相关专利证书照片 3
        im_patent_photos_three_delete = findViewById(R.id.im_patent_photos_three_delete);//点击删除照片  3 公司相关专利证书照片
        im_patent_photos_three_delete.setOnClickListener(this);
      im_patent_photos_three.setOnClickListener(this);

      btn_qiye_upload =  findViewById(R.id.btn_qiye_upload);// 立即上传
      btn_qiye_upload.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

  @Override
  public void onClick(View v) {
    switch (v.getId()){
      case R.id.im_back: // 返回键
        finish();
        break;
      case R.id.im_site_photos_one://上传场地租赁合同照片  1
        showDiaLog(10,7);
        break;
        case R.id.im_site_photos_one_delete://点击删除图片 1
            break;
      case R.id.im_site_photos_two://上传场地租赁合同照片  2
        showDiaLog(12,9);
        break;
        case R.id.im_site_photos_two_delete://点击删除图片 2
            break;
      case R.id.im_site_photos_three://上传场地租赁合同照片  3
        showDiaLog(14,11);
        break;
        case R.id.im_site_photos_three_delete://点击删除照片 3
            break;
      case R.id.im_Assets_photos_one://上传公司固定资产相关证件照片 1
        showDiaLog(16,13);
        break;
        case R.id.im_Assets_photos_one_delete://点击删除照片 1
            break;
      case R.id.im_Assets_photos_two://上传公司固定资产相关证件照片 2
        showDiaLog(18,15);
        break;
        case R.id.im_Assets_photos_two_delete://点击删除照片 2
            break;
      case R.id.im_Assets_photos_three://上传公司固定资产相关证件照片 3
        showDiaLog(20,17);
        break;
        case R.id.im_Assets_photos_three_delete://点击删除照片 3
            break;
      case R.id.im_patent_photos_one://上传公司相关专利证书照片 1
        showDiaLog(22,19);
        break;
        case R.id.im_patent_photos_one_delete://点击删除照片 1
            break;
      case R.id.im_patent_photos_two://上传公司相关专利证书照片 2
        showDiaLog(24,21);
        break;
        case R.id.im_patent_photos_two_delete://点击删除照片 2
            break;
      case R.id.im_patent_photos_three://上传公司相关专利证书照片 3
        showDiaLog(26,23);
        break;
        case R.id.im_patent_photos_three_delete://点击删除照片 2
            break;
      case R.id.btn_qiye_upload://立即上传
        setAssetsPost();
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
                openCamera(EnterpriseActivity.this, open);
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

  @Override
  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    //  TODO 上传场地租赁合同照片  1
    if (requestCode == 10 && resultCode == Activity.RESULT_OK && data != null) {
      Uri selectedImage = data.getData();
      String[] filePathColumns = {MediaStore.Images.Media.DATA};
      Cursor c = getContentResolver().query(selectedImage, filePathColumns, null, null, null);
      c.moveToFirst();
      int columnIndex = c.getColumnIndex(filePathColumns[0]);
      String imagePath = c.getString(columnIndex);
      Bitmap bm = BitmapFactory.decodeFile(imagePath);
      im_site_photos_one.setImageBitmap(bm);
      c.close();
    }
    //  TODO 上传场地租赁合同照片  2
    if (requestCode == 12 && resultCode == Activity.RESULT_OK && data != null) {
      Uri selectedImage = data.getData();
      String[] filePathColumns = {MediaStore.Images.Media.DATA};
      Cursor c = getContentResolver().query(selectedImage, filePathColumns, null, null, null);
      c.moveToFirst();
      int columnIndex = c.getColumnIndex(filePathColumns[0]);
      String imagePath = c.getString(columnIndex);
      Bitmap bm = BitmapFactory.decodeFile(imagePath);
      im_site_photos_two.setImageBitmap(bm);
      c.close();
    }
    // TODO 上传场地租赁合同照片  3
    if (requestCode == 14 && resultCode == Activity.RESULT_OK && data != null){
      Uri selectedImage = data.getData();
      String[] filePathColumns = {MediaStore.Images.Media.DATA};
      Cursor c = getContentResolver().query(selectedImage, filePathColumns, null, null, null);
      c.moveToFirst();
      int columnIndex = c.getColumnIndex(filePathColumns[0]);
      String imagePath = c.getString(columnIndex);
      Bitmap bm = BitmapFactory.decodeFile(imagePath);
      im_site_photos_three.setImageBitmap(bm);
      c.close();
    }
// TODO 上传公司固定资产相关证件照片 1
    if (requestCode == 16 && resultCode == Activity.RESULT_OK && data != null){
      Uri selectedImage = data.getData();
      String[] filePathColumns = {MediaStore.Images.Media.DATA};
      Cursor c = getContentResolver().query(selectedImage, filePathColumns, null, null, null);
      c.moveToFirst();
      int columnIndex = c.getColumnIndex(filePathColumns[0]);
      String imagePath = c.getString(columnIndex);
      Bitmap bm = BitmapFactory.decodeFile(imagePath);
      im_Assets_photos_one.setImageBitmap(bm);
      c.close();
    }
    // TODO 上传公司固定资产相关证件照片 2
    if (requestCode == 18 && resultCode == Activity.RESULT_OK && data != null){
      Uri selectedImage = data.getData();
      String[] filePathColumns = {MediaStore.Images.Media.DATA};
      Cursor c = getContentResolver().query(selectedImage, filePathColumns, null, null, null);
      c.moveToFirst();
      int columnIndex = c.getColumnIndex(filePathColumns[0]);
      String imagePath = c.getString(columnIndex);
      Bitmap bm = BitmapFactory.decodeFile(imagePath);
      im_Assets_photos_two.setImageBitmap(bm);
      c.close();
    }
    //  TODO 上传公司固定资产相关证件照片 3
    if (requestCode == 20 && resultCode == Activity.RESULT_OK && data != null){
      Uri selectedImage = data.getData();
      String[] filePathColumns = {MediaStore.Images.Media.DATA};
      Cursor c = getContentResolver().query(selectedImage, filePathColumns, null, null, null);
      c.moveToFirst();
      int columnIndex = c.getColumnIndex(filePathColumns[0]);
      String imagePath = c.getString(columnIndex);
      Bitmap bm = BitmapFactory.decodeFile(imagePath);
      im_Assets_photos_three.setImageBitmap(bm);
      c.close();
    }
//  TODO 上传公司相关专利证书照片 1
    if (requestCode == 22 && resultCode == Activity.RESULT_OK && data != null){
      Uri selectedImage = data.getData();
      String[] filePathColumns = {MediaStore.Images.Media.DATA};
      Cursor c = getContentResolver().query(selectedImage, filePathColumns, null, null, null);
      c.moveToFirst();
      int columnIndex = c.getColumnIndex(filePathColumns[0]);
      String imagePath = c.getString(columnIndex);
      Bitmap bm = BitmapFactory.decodeFile(imagePath);
      im_patent_photos_one.setImageBitmap(bm);
      c.close();
    }
    //  TODO 上传公司相关专利证书照片 2
    if (requestCode == 24 && resultCode == Activity.RESULT_OK && data != null){
      Uri selectedImage = data.getData();
      String[] filePathColumns = {MediaStore.Images.Media.DATA};
      Cursor c = getContentResolver().query(selectedImage, filePathColumns, null, null, null);
      c.moveToFirst();
      int columnIndex = c.getColumnIndex(filePathColumns[0]);
      String imagePath = c.getString(columnIndex);
      Bitmap bm = BitmapFactory.decodeFile(imagePath);
      im_patent_photos_two.setImageBitmap(bm);
      c.close();
    }
    //  TODO 上传公司相关专利证书照片 3
    if (requestCode == 26 && resultCode == Activity.RESULT_OK && data != null){
      Uri selectedImage = data.getData();
      String[] filePathColumns = {MediaStore.Images.Media.DATA};
      Cursor c = getContentResolver().query(selectedImage, filePathColumns, null, null, null);
      c.moveToFirst();
      int columnIndex = c.getColumnIndex(filePathColumns[0]);
      String imagePath = c.getString(columnIndex);
      Bitmap bm = BitmapFactory.decodeFile(imagePath);
      im_patent_photos_three.setImageBitmap(bm);
      c.close();
    }

    switch (requestCode){
      //  TODO 上传场地租赁合同照片  1
      case 7:
        if (resultCode == RESULT_OK) {
          Intent intent = new Intent("com.android.camera.action.CROP");
          intent.setDataAndType(imageUri, "image/*");
          intent.putExtra("scale", true);
          intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
          startActivityForResult(intent, 80); // 启动裁剪程序
        }
        break;
      case 80:
        if (resultCode == RESULT_OK) {
          try {
            Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver()
                    .openInputStream(imageUri));
            im_site_photos_one.setImageBitmap(bitmap);

            RequestBody fileBody = RequestBody.create(MediaType.parse("multipart/form-data"), tempFile);

            MultipartBody.Part part = MultipartBody.Part.createFormData("request", tempFile.getName(), fileBody);
            pcount = 410;
            presenter.getCommitImgBean(part);
          } catch (FileNotFoundException e) {
            e.printStackTrace();
          }
        }
        break;
      //  TODO 上传场地租赁合同照片  2
      case 9:
        if (resultCode == RESULT_OK) {
          Intent intent = new Intent("com.android.camera.action.CROP");
          intent.setDataAndType(imageUri, "image/*");
          intent.putExtra("scale", true);
          intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
          startActivityForResult(intent, 110); // 启动裁剪程序
        }
        break;
      case 110:
        if (resultCode == RESULT_OK) {
          try {
            Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver()
                    .openInputStream(imageUri));
            im_site_photos_two.setImageBitmap(bitmap);
            RequestBody fileBody = RequestBody.create(MediaType.parse("multipart/form-data"), tempFile);

            MultipartBody.Part part = MultipartBody.Part.createFormData("request", tempFile.getName(), fileBody);
            pcount = 420;
            presenter.getCommitImgBean(part);
          } catch (FileNotFoundException e) {
            e.printStackTrace();
          }
        }
        break;
      //  TODO 上传场地租赁合同照片  3
      case 11:
        if (resultCode == RESULT_OK) {
          Intent intent = new Intent("com.android.camera.action.CROP");
          intent.setDataAndType(imageUri, "image/*");
          intent.putExtra("scale", true);
          intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
          startActivityForResult(intent, 130); // 启动裁剪程序
        }
        break;
      case 130:
        if (resultCode == RESULT_OK) {
          try {
            Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver()
                    .openInputStream(imageUri));
            im_site_photos_three.setImageBitmap(bitmap);
            RequestBody fileBody = RequestBody.create(MediaType.parse("multipart/form-data"), tempFile);

            MultipartBody.Part part = MultipartBody.Part.createFormData("request", tempFile.getName(), fileBody);
            pcount = 430;
            presenter.getCommitImgBean(part);
          } catch (FileNotFoundException e) {
            e.printStackTrace();
          }
        }
        break;
      // TODO 上传公司固定资产相关证件照片 1
      case 13:
        if (resultCode == RESULT_OK) {
          Intent intent = new Intent("com.android.camera.action.CROP");
          intent.setDataAndType(imageUri, "image/*");
          intent.putExtra("scale", true);
          intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
          startActivityForResult(intent, 140); // 启动裁剪程序
        }
        break;
      case 140:
        if (resultCode == RESULT_OK) {
          try {
            Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver()
                    .openInputStream(imageUri));
            im_Assets_photos_one.setImageBitmap(bitmap);
            RequestBody fileBody = RequestBody.create(MediaType.parse("multipart/form-data"), tempFile);

            MultipartBody.Part part = MultipartBody.Part.createFormData("request", tempFile.getName(), fileBody);
            pcount = 440;
            presenter.getCommitImgBean(part);
          } catch (FileNotFoundException e) {
            e.printStackTrace();
          }
        }
        break;
      // TODO 上传公司固定资产相关证件照片 2
      case 15:
        if (resultCode == RESULT_OK) {
          Intent intent = new Intent("com.android.camera.action.CROP");
          intent.setDataAndType(imageUri, "image/*");
          intent.putExtra("scale", true);
          intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
          startActivityForResult(intent, 160); // 启动裁剪程序
        }
        break;
      case 160:
        if (resultCode == RESULT_OK) {
          try {
            Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver()
                    .openInputStream(imageUri));
            im_Assets_photos_two.setImageBitmap(bitmap);
            RequestBody fileBody = RequestBody.create(MediaType.parse("multipart/form-data"), tempFile);

            MultipartBody.Part part = MultipartBody.Part.createFormData("request", tempFile.getName(), fileBody);
            pcount = 450;
            presenter.getCommitImgBean(part);
          } catch (FileNotFoundException e) {
            e.printStackTrace();
          }
        }
        break;
      // TODO 上传公司固定资产相关证件照片 3
      case 17:
        if (resultCode == RESULT_OK) {
          Intent intent = new Intent("com.android.camera.action.CROP");
          intent.setDataAndType(imageUri, "image/*");
          intent.putExtra("scale", true);
          intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
          startActivityForResult(intent, 180); // 启动裁剪程序
        }
        break;
      case 180:
        if (resultCode == RESULT_OK) {
          try {
            Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver()
                    .openInputStream(imageUri));
            im_Assets_photos_three.setImageBitmap(bitmap);
            RequestBody fileBody = RequestBody.create(MediaType.parse("multipart/form-data"), tempFile);

            MultipartBody.Part part = MultipartBody.Part.createFormData("request", tempFile.getName(), fileBody);
            pcount = 460;
            presenter.getCommitImgBean(part);
          } catch (FileNotFoundException e) {
            e.printStackTrace();
          }
        }
        break;
      // TODO 上传公司相关专利证书照片 1
      case 19:
        if (resultCode == RESULT_OK) {
          Intent intent = new Intent("com.android.camera.action.CROP");
          intent.setDataAndType(imageUri, "image/*");
          intent.putExtra("scale", true);
          intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
          startActivityForResult(intent, 200); // 启动裁剪程序
        }
        break;
      case 200:
        if (resultCode == RESULT_OK) {
          try {
            Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver()
                    .openInputStream(imageUri));
            im_patent_photos_one.setImageBitmap(bitmap);
            RequestBody fileBody = RequestBody.create(MediaType.parse("multipart/form-data"), tempFile);

            MultipartBody.Part part = MultipartBody.Part.createFormData("request", tempFile.getName(), fileBody);
            pcount = 470;
            presenter.getCommitImgBean(part);
          } catch (FileNotFoundException e) {
            e.printStackTrace();
          }
        }
        break;

      // TODO 上传公司相关专利证书照片 2
      case 21:
        if (resultCode == RESULT_OK) {
          Intent intent = new Intent("com.android.camera.action.CROP");
          intent.setDataAndType(imageUri, "image/*");
          intent.putExtra("scale", true);
          intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
          startActivityForResult(intent, 220); // 启动裁剪程序
        }
        break;
      case 220:
        if (resultCode == RESULT_OK) {
          try {
            Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver()
                    .openInputStream(imageUri));
            im_patent_photos_two.setImageBitmap(bitmap);
            RequestBody fileBody = RequestBody.create(MediaType.parse("multipart/form-data"), tempFile);

            MultipartBody.Part part = MultipartBody.Part.createFormData("request", tempFile.getName(), fileBody);
            pcount = 480;
            presenter.getCommitImgBean(part);
          } catch (FileNotFoundException e) {
            e.printStackTrace();
          }
        }
        break;
      // TODO 上传公司相关专利证书照片 3
      case 23:
        if (resultCode == RESULT_OK) {
          Intent intent = new Intent("com.android.camera.action.CROP");
          intent.setDataAndType(imageUri, "image/*");
          intent.putExtra("scale", true);
          intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
          startActivityForResult(intent, 240); // 启动裁剪程序
        }
        break;
      case 240:
        if (resultCode == RESULT_OK) {
          try {
            Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver()
                    .openInputStream(imageUri));
            im_patent_photos_three.setImageBitmap(bitmap);
            RequestBody fileBody = RequestBody.create(MediaType.parse("multipart/form-data"), tempFile);
            MultipartBody.Part part = MultipartBody.Part.createFormData("request", tempFile.getName(), fileBody);
            pcount = 490;
            presenter.getCommitImgBean(part);
          } catch (FileNotFoundException e) {
            e.printStackTrace();
          }
        }
        break;
    }
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
  /*
   * 判断sdcard是否被挂载
   */
  public static boolean hasSdcard() {
    return Environment.getExternalStorageState().equals(
            Environment.MEDIA_MOUNTED);
  }
  private void setAssetsPost() {
          String url = "https://zux2.oss-cn-beijing.aliyuncs.com/2018/10/17/59ab06b676a842abb3c5925dae879db3.jpg";
          HashMap<String, String> header = new HashMap<>();
          header.put("user_login",SpUtils.getUserKey(this));
          header.put("uuid",SpUtils.getUserId());
          Map<String,String> map = new HashMap<>();
          map.put("authType",3+"");//认证大类型 1、学生认证，2、个人认证，3、企业认证
          map.put("authTypeLast",11+"");// 认证小类型 1、身份证认证 2、学生证认证 3、运营商认证 4、芝麻信用 5、社保卡认证 6、学历认证 7、公司信息认证 8、固定资产认证、 9法人认证 10、营业执照认证 11、企业信息认证 12、委托人认证 13、委托书认证
          map.put("companyName",company_name);//公司名称
          map.put("employeeCount",person_number);//员工人数
          map.put("companyAddress",address);//企业地址
          map.put("companyAddPact",photos_one+","+photos_two+","+photos_three);//场地租赁合同照片   多图数据用  ， 号 隔开
          map.put("companyFixedPact",assets_photos_one+","+assets_photos_two+","+assets_photos_three);//公司固定资产相关证件照片  多图数据用  ， 号 隔开
          map.put("companyPatent",patent_photos_one+","+patent_photos_two+","+patent_photos_three);//公司相关专利证书照片    多图数据用  ， 号 隔开
          presenter.getEnterpriseApply(header,map);
  }

  @Override
  public void showApplyBean(final ApplyBean applyBean) {
    if (applyBean.getCode().equals("ok")){
      Toast.makeText(this,"上传成功，等待审核。", Toast.LENGTH_SHORT).show();
      finish();
    }else {
      Toast.makeText(this,"上传失败，重新上传。", Toast.LENGTH_SHORT).show();
    }
  }

  @Override
  public void showCommitImgBean(MerChantentryBean merChantentryBean) {
        if (merChantentryBean.getCode().equals("0")){
          if (pcount == 410) {
            photos_one = merChantentryBean.getData();
            //请您上传场地租赁合同照片 第一，张
          }
          if (pcount == 420) {
            photos_two = merChantentryBean.getData();
            //请您上传场地租赁合同照片 第二、张
          }
          if (pcount == 430) {
            photos_three = merChantentryBean.getData();
            //请您上传场地租赁合同照片 第三、张
          }
          if (pcount == 440) {
            assets_photos_one = merChantentryBean.getData();
            //请您上传公司固定资产相关证件照片 第一、张
          }
          if (pcount == 450) {
            assets_photos_two = merChantentryBean.getData();
            //请您上传公司固定资产相关证件照片 第二、张
          }
          if (pcount == 460) {
            assets_photos_three = merChantentryBean.getData();
            //请您上传公司固定资产相关证件照片 第三、张
          }
          if (pcount == 470) {
            patent_photos_one = merChantentryBean.getData();
            //请您上传公司相关专利证书照片 第一、张
          }
          if (pcount == 480) {
            patent_photos_two = merChantentryBean.getData();
            //请您上传公司相关专利证书照片 第二、张
          }
          if (pcount == 490) {
            patent_photos_three = merChantentryBean.getData();
            //请您上传公司相关专利证书照片 第三、张
          }
        }
  }
}
