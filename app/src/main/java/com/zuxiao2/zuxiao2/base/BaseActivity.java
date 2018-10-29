package com.zuxiao2.zuxiao2.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.zhy.autolayout.AutoLayoutActivity;
import com.zuxiao2.zuxiao2.application.MyApplication;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by 77 on 2018/5/1.
 */

public abstract class BaseActivity<T extends BasePresenter> extends AutoLayoutActivity {

    private Fragment lastFragment;

    protected T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        MyApplication.context = this;

        //p层自动实例化
        presenter = getPresenter();
        if (presenter != null)
            presenter.attachView(this);
        initView();
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        MyApplication.context = this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null)
            presenter.detachView();
        MyApplication.context=null;
    }
    //  获取Title 标题
    protected  abstract  void  initTitle();
    //获取Activity布局
    protected abstract int getContentView();

    //初始化视图
    protected abstract void initView();

    //初始化数据
    protected abstract void initData();


    //视图切换
    protected BaseFragment setContentView(Class<? extends BaseFragment> fragmentClass, int FrameLayoutId) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        String fragmentName = fragmentClass.getSimpleName();
        BaseFragment fragment = (BaseFragment) fragmentManager.findFragmentByTag(fragmentName);

        try {
            if (fragment == null) {
                fragment = fragmentClass.newInstance();
                transaction.add(FrameLayoutId, fragment, fragmentName);
            }
            if (lastFragment != null)
                transaction.hide(lastFragment);
            transaction.show(fragment);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        lastFragment = fragment;
        transaction.commit();
        return fragment;
    }

    private T getPresenter() {
        Type type = getClass().getGenericSuperclass();
        if (type.equals(BaseActivity.class))
            return null;
        Type[] arguments = ((ParameterizedType) type).getActualTypeArguments();
        if (arguments.length == 0)
            return null;
        Class<T> tClass = (Class<T>) (arguments[0]);
        try {
            return tClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}
