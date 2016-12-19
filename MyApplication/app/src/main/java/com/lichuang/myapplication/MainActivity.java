package com.lichuang.myapplication;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    public final static String CSS_STYLE_ZHENGCHANG ="<style>* {font-size:16;line-height:146%;margin-top:10;margin-left:0;margin-right:0;margin-bottom:0;padding:0;}body {color:#333333;}</style>";
    public final static String CSS_STYLE_ZHENGCHANG_YEJIAN ="<style>* {font-size:16;line-height:146%;margin-top:10;margin-left:0;margin-right:0;margin-bottom:0;padding:0;}body {color:#7f7b77;}</style>";
    public static String str = "WASHINGTON, Dec. 12 (Xinhua) -- The White House said on Monday the United States remains \"firmly committed\" to one-China policy.\n" +
            "\n" +
            "\"The United States government, under the leadership of President Obama, has been and remains firmly committed to our one-China policy,\" said White House spokesman Josh Earnest at the daily briefing.\n" +
            "\n" +
            "\"That's also the policy, by the way, that previous presidents in both parties have pursued and our country has benefited from adherence to that policy,\" he added.\n" +
            "\n" +
            "It is universally recognized by the international community that there is only one China in the world, and both the mainland and Taiwan belong to one China.\n" +
            "\n" +
            "The Chinese Foreign Ministry has made clear that adherence to one-China policy is the prerequisite for Taiwan to conduct contacts with foreign countries or participate in international activities.\n" +
            "\n";
    WebView wview;
    WebViewClient client = new WebViewClient(){
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            Log.e("lich", "onPageStarted: "+System.currentTimeMillis());

        }

        @Override
        public void onPageCommitVisible(WebView view, String url) {
            super.onPageCommitVisible(view, url);
            Log.e("lich", "onPageCommitVisible: "+System.currentTimeMillis());
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            Log.e("lich", "onPageFinished: "+System.currentTimeMillis());
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wview = (WebView) findViewById(R.id.webViewJiexi);

        wview.setWebViewClient(client);
        wview.loadData(CSS_STYLE_ZHENGCHANG+str,
                "text/html; charset=UTF-8",
                null);

    }
    boolean b =false;
    public void dianwo(View view){
        b=!b;
        if (!b){
            wview.setBackgroundColor(Color.parseColor("#FFFFFF"));
            wview.loadData(CSS_STYLE_ZHENGCHANG+str+str+str+str+str+str+str,
                    "text/html; charset=UTF-8",
                    null);
        }else {
            wview.setBackgroundColor(Color.parseColor("#000000"));
            wview.loadData(CSS_STYLE_ZHENGCHANG_YEJIAN+str+str+str,
                    "text/html; charset=UTF-8",
                    null);
        }
//        Toast.makeText(this,isHaveIllegalChar("daae   dakljeida")+"",Toast.LENGTH_SHORT).show();


    }
    public static boolean isHaveIllegalChar(String str){
        Pattern p = Pattern.compile("[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]");
        Matcher m = p.matcher(str);
        if( m.find()){
            return true;
        }
        if (str.contains(" ")){
            return true;
        }
        return false;
    }
}
