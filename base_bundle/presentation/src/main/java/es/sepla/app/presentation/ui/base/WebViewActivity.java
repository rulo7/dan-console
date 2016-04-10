package es.sepla.app.presentation.ui.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

import butterknife.Bind;
import butterknife.ButterKnife;
import es.sepla.app.presentation.R;

public class WebViewActivity extends AppCompatActivity {

    public static final String URL = "url";
    private static final String TITLE = "title";
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.webview)
    WebView webview;
    @Bind(R.id.progress)
    ProgressBar progressBar;

    public static Intent getCallingIntent(Context context, String url, String title) {
        Intent intent = new Intent(context, WebViewActivity.class);
        intent.putExtra(URL, url);
        intent.putExtra(TITLE, title);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        if (getIntent() != null) {
            setupToolBar(getIntent().getStringExtra(TITLE));
            setupWebView(getIntent().getStringExtra(URL));
        }
    }

    private void setupToolBar(String title) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(title);
    }

    private void setupWebView(String url) {
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                if (progress == 100) {
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
        webview.loadUrl(url);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
        }
        return super.onOptionsItemSelected(item);
    }
}
