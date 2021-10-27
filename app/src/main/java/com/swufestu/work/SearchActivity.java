package com.swufestu.work;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Bundle data = getIntent().getExtras();
        String username = data.getString("username");
        String word_now=data.getString("word_now");
        Toast.makeText(getApplicationContext(), "当前看到："+word_now, Toast.LENGTH_SHORT).show();


        String url="http://m.youdao.com/";
        WebView browser = (WebView) findViewById(R.id.web);
        browser.loadUrl(url);

        WebSettings webSettings = browser.getSettings();
        webSettings.setJavaScriptEnabled(true); //启用javascript
        webSettings.setAppCacheEnabled(true);   //启用appCache
        webSettings.setDatabaseEnabled(true);
        webSettings.setDomStorageEnabled(true);

        //设置可自由缩放网页、JS生效
        //webSettings.setSupportZoom(true);
        //webSettings.setBuiltInZoomControls(true);

        // 如果页面中链接，如果希望点击链接继续在当前browser中响应，
        // 而不是新开Android的系统browser中响应该链接，必须覆盖webview的WebViewClient对象
        browser.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //  重写此方法表明点击网页里面的链接还是在当前的webview里跳转，不跳到浏览器那边
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                view.loadUrl("javascript:document.getElementById('b_footer').style.display = 'none'; void(0);");
                //view.loadUrl("javascript:document.getElementById('ft').style.display = 'none'; void(0);");
                //view.loadUrl("javascript:getClass(document,'other-links')[0].style.display='none'; void(0);");
                //view.loadUrl("getClass(document,'logo')[0].style.minWidth=0; void(0);");
            }

        });
        browser.loadUrl(url);






        BottomNavigationView bottomnavigationview = findViewById(R.id.bottom_navigation);

        bottomnavigationview.setSelectedItemId(R.id.search);

        bottomnavigationview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuitem) {
                switch(menuitem.getItemId())
                {
                    case R.id.home:
                        Intent intent =new Intent(getApplicationContext(),HomeActivity.class);
                        intent.putExtras(data);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.search:
                        return true;

                    case R.id.user:
                        Intent intent_ =new Intent(getApplicationContext(),UserActivity.class);
                        intent_.putExtras(data);
                        startActivity(intent_);
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}