package com.cookandroid.project6_2;

import android.webkit.WebView;

interface CookWebviewClient {
    boolean shouldOverrideUrlLoading(WebView, String url);
}
