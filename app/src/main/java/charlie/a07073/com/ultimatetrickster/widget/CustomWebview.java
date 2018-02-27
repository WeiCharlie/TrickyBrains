package charlie.a07073.com.ultimatetrickster.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import charlie.a07073.com.ultimatetrickster.base.ConstantUrl;

/**
 * Created by Charlie Wei on 2017/7/6.
 */

public class CustomWebview extends WebView {
    private WebViewLoadListener loadListener;
    private boolean isFist = true;

    /**
     * 进度条
     */
    public interface WebViewLoadListener {
        void onLoadFinish();

        void onLoading(int progress);// 加载过程中

    }

    public void setWebViewListener(WebViewLoadListener webViewLoadListener) {
        loadListener = webViewLoadListener;
    }

    public CustomWebview(Context context, AttributeSet attrs) {
        super(context, attrs);
        getSettings().setJavaScriptCanOpenWindowsAutomatically(true);//设置js可以直接打开窗口，如window.open()，默认为false
        getSettings().setJavaScriptEnabled(true);//是否允许执行js，默认为false。设置true时，会提醒可能造成XSS漏洞
        getSettings().setSupportZoom(true);//是否可以缩放，默认true
        getSettings().setBuiltInZoomControls(false);//是否显示缩放按钮，默认false
        getSettings().setUseWideViewPort(true);//设置此属性，可任意比例缩放。大视图模式
        getSettings().setLoadWithOverviewMode(true);//和setUseWideViewPort(true)一起解决网页自适应问题
        getSettings().setAppCacheEnabled(true);//是否使用缓存
        getSettings().setDomStorageEnabled(true);//DOM Storage

        // 保存图片使用↓
        getSettings().setAllowFileAccess(true);// 设置允许访问文件数据
        getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        getSettings().setDatabaseEnabled(true);
        getSettings().setGeolocationEnabled(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {// 5.0后https与http混合模式，否则单独https下不显示图片
            getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }

// getSettings().setUserAgentString("User-Agent:Android");//设置用户代理，一般不用
        setWebChromeClient(new WebChromeClient());
        setWebViewClient(new WebViewClient());
        String ua = getSettings().getUserAgentString();

        // 修改ua使得web端正确判断(替换)
//        getSettings().setUserAgentString(ConstantUrl.WINDOWS_TAG);
    }

    public class WebChromeClient extends android.webkit.WebChromeClient {

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            if (newProgress == 100) {
                loadListener.onLoadFinish();
            } else {
                loadListener.onLoading(newProgress);
            }
            super.onProgressChanged(view, newProgress);
        }

    }
}
