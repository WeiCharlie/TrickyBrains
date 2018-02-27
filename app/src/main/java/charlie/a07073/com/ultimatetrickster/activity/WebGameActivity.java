package charlie.a07073.com.ultimatetrickster.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ProgressBar;

import charlie.a07073.com.ultimatetrickster.R;
import charlie.a07073.com.ultimatetrickster.base.ConstantUrl;
import charlie.a07073.com.ultimatetrickster.widget.CustomWebview;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class WebGameActivity extends AppCompatActivity implements CustomWebview.WebViewLoadListener {

    private CustomWebview customWebview;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_game);
        customWebview = (CustomWebview) findViewById(R.id.custom_webview);
        customWebview.setWebViewListener(this);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);

        String gameUrl = getIntent().getStringExtra("gameUrl");

        customWebview.loadUrl(gameUrl);
    }

    @Override
    protected void onPause() {
        super.onPause();
        customWebview.stopLoading();
    }

    @Override
    protected void onResume() {
        super.onResume();
        customWebview.reload();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (customWebview.canGoBack()) {
                customWebview.goBack();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);

    }

    @Override
    public void onLoadFinish() {
        if (progressBar.getVisibility() == VISIBLE)
            progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onLoading(int progress) {
        if (progressBar.getVisibility() == GONE)
            progressBar.setVisibility(VISIBLE);
        progressBar.setProgress(progress);
    }
}
