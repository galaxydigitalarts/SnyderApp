package com.galaxyda.snyder;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    //Variables
    private WebView webView;
    private ImageButton economicCollapseButton;
    private ImageButton endOfTheAmericanDreamButton;
    private ImageButton mostImportantNewsButton;
    private LinearLayout linearLayout;

// -----------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// ------------------------------------------------------------------------

        // Set the initial in-app browser and layout
        webView = findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        homeButtonPress();

        economicCollapseButton = findViewById(R.id.economicCollapseButton);
        endOfTheAmericanDreamButton = findViewById(R.id.endOfTheAmericaDreamButton);
        mostImportantNewsButton = findViewById(R.id.theMostImportantNewsButton);

        linearLayout = findViewById(R.id.linearlayout);
        linearLayout.setVisibility(View.INVISIBLE);

// ------------------------------------------------------------------------

        // initialize and assign variable
        final BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.home);

        // Check which button is pressed
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        linearLayout.setVisibility(View.INVISIBLE);
                        overridePendingTransition(0, 0);

                        webView.loadUrl("http://theeconomiccollapseblog.com");
                        webView.setWebViewClient(new WebViewClient() {
                            @Override
                            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {

                                if ((String.valueOf(request.getUrl())).contains("theeconomiccollapseblog.com") && !(String.valueOf(request.getUrl())).contains("twitter.com") && !(String.valueOf(request.getUrl())).contains("facebook.com")) {
                                    view.loadUrl(String.valueOf(request.getUrl()));

                                } else {
                                    Intent intent = new Intent(Intent.ACTION_VIEW, request.getUrl());
                                    view.getContext().startActivity(intent);
                                }
                                return true;
                            }
                        });
                        return true;

                    case R.id.mywebsites:
                        websiteButtonPress();

                        return true;

                    case R.id.about:
                        linearLayout.setVisibility(View.INVISIBLE);
                        overridePendingTransition(0, 0);
                        webView.loadUrl("http://theeconomiccollapseblog.com/contact");
                        webView.setWebViewClient(new WebViewClient() {
                            @Override
                            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {

                                if ((String.valueOf(request.getUrl())).contains("theeconomiccollapseblog.com") && !(String.valueOf(request.getUrl())).contains("twitter.com") && !(String.valueOf(request.getUrl())).contains("facebook.com")) {
                                    view.loadUrl(String.valueOf(request.getUrl()));
                                } else {
                                    Intent intent = new Intent(Intent.ACTION_VIEW, request.getUrl());
                                    view.getContext().startActivity(intent);
                                }
                                return true;
                            }
                        });
                        return true;

                    case R.id.mybooks:
                        linearLayout.setVisibility(View.INVISIBLE);
                        overridePendingTransition(0, 0);
                        webView.loadUrl("https://amazon.com/Michael-Snyder/e/B01DUPOJL2/ref=as_li_ss_tl?ie=UTF8&linkCode=sl2&tag=theeconomiccollapse-20&linkId=95cce845b8e91c9963f44a8bc7dc32df");
                        webView.setWebViewClient(new WebViewClient() {
                            @Override
                            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {

                                if ((String.valueOf(request.getUrl())).contains("amazon.com")) {
                                    Intent intent = new Intent(Intent.ACTION_VIEW, request.getUrl());
                                    view.getContext().startActivity(intent);
                                    finish(); //no double webview load, but on backpress, the app is closed.
                                }
                                return true;
                            }
                        });
                        return true;

                    case R.id.socialmedia:
                        linearLayout.setVisibility(View.INVISIBLE);
                        overridePendingTransition(0, 0);
                        webView.loadUrl("https://twitter.com/Revelation1217");
                        webView.setWebViewClient(new WebViewClient() {
                            @Override
                            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {

                                if ((String.valueOf(request.getUrl())).contains("twitter.com")) {
                                    Intent intent = new Intent(Intent.ACTION_VIEW, request.getUrl());
                                    view.getContext().startActivity(intent);
                                    finish();
                                }
                                return true;
                            }
                        });
                        return true;
                }
                return false;
            }
        });
    }

// ------------------------------------------------------------------------

    // Method for going back in the browser
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.reload();
            webView.goBack();
        }

        if (webView.getUrl().contentEquals("http://theeconomiccollapseblog.com/")) {
            super.onBackPressed();
        }

        if (webView.getUrl().contentEquals("http://theeconomiccollapseblog.com/contact")) {
            super.onBackPressed();
        }

        if (webView.getUrl().contentEquals("http://endoftheamericandream.com/")) {
            super.onBackPressed();
        }

        if (webView.getUrl().contentEquals("http://themostimportantnews.com/")) {
            super.onBackPressed();
        }
    }

// ------------------------------------------------------------------------

    // Method for when the home button is pressed.
    public void homeButtonPress() {
        webView.loadUrl("http://theeconomiccollapseblog.com/");
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {

                if ((String.valueOf(request.getUrl())).contains("theeconomiccollapseblog.com") && !(String.valueOf(request.getUrl())).contains("twitter.com") && !(String.valueOf(request.getUrl())).contains("facebook.com")) {
                    view.loadUrl(String.valueOf(request.getUrl()));
                } else {
                    Intent intent = new Intent(Intent.ACTION_VIEW, request.getUrl());
                    view.getContext().startActivity(intent);
                }
                return true;

            }
        });
    }

// ------------------------------------------------------------------------

    // Method to control opening the website links.
    public void websiteButtonPress() {
        linearLayout.setVisibility(View.VISIBLE);
        economicCollapseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout.setVisibility(View.INVISIBLE);
                webView.loadUrl("http://theeconomiccollapseblog.com");

                webView.setWebViewClient(new WebViewClient() {
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {

                        if ((String.valueOf(request.getUrl())).contains("theeconomiccollapseblog.com") && !(String.valueOf(request.getUrl())).contains("twitter.com") && !(String.valueOf(request.getUrl())).contains("facebook.com")) {
                            view.loadUrl(String.valueOf(request.getUrl()));

                        } else {
                            Intent intent = new Intent(Intent.ACTION_VIEW, request.getUrl());
                            view.getContext().startActivity(intent);
                        }
                        return true;
                    }
                });
            }
        });

        endOfTheAmericanDreamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout.setVisibility(View.INVISIBLE);
                webView.loadUrl("http://endoftheamericandream.com");

                webView.setWebViewClient(new WebViewClient() {
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {

                        if ((String.valueOf(request.getUrl())).contains("endoftheamericandream.com") && !(String.valueOf(request.getUrl())).contains("twitter.com") && !(String.valueOf(request.getUrl())).contains("facebook.com")) {
                            view.loadUrl(String.valueOf(request.getUrl()));
                        } else {
                            Intent intent = new Intent(Intent.ACTION_VIEW, request.getUrl());
                            view.getContext().startActivity(intent);
                        }

                        return true;
                    }
                });
            }
        });

        mostImportantNewsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout.setVisibility(View.INVISIBLE);
                webView.loadUrl("http://themostimportantnews.com/");

                webView.setWebViewClient(new WebViewClient() {
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {

                        if ((String.valueOf(request.getUrl())).contains("themostimportantnews.com") && !(String.valueOf(request.getUrl())).contains("twitter.com") && !(String.valueOf(request.getUrl())).contains("facebook.com")) {
                            view.loadUrl(String.valueOf(request.getUrl()));

                        } else {
                            Intent intent = new Intent(Intent.ACTION_VIEW, request.getUrl());
                            view.getContext().startActivity(intent);
                        }
                        return true;
                    }
                });
            }
        });
    }
}