package com.zuxiao2.zuxiao2.ui.hometabftagment.tabfragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseFragment;


public class ShopMessageFragment extends BaseFragment {

    private WebView webView;
    private String url;

    @Override
    protected int getCreateView() {
        return R.layout.fragment_shop_message;
    }

    @Override
    protected void initView(View view) {
        Bundle arguments =this.getArguments();
        url = arguments.getString("contentUrl");
        webView = view.findViewById(R.id.webview);
        WebSettings settings = webView.getSettings();
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(false);
    }

    @Override
    protected void initData(View view) {
        if (url==null&&url.equals("")){
            Toast.makeText(getActivity(), "没有数据", Toast.LENGTH_SHORT).show();
        }else {
            String content = "<head><style>img{width:100%}</style></head>"+url;
            webView.loadData(content, "text/html", "UTF-8");
        }

    }

}
