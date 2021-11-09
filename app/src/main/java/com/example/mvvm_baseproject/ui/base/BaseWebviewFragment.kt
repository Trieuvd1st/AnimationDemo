package com.example.mvvm_baseproject.ui.base

import android.graphics.Bitmap
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding

abstract class BaseWebViewFragment<BD : ViewDataBinding, VM : BaseViewModel>(@LayoutRes id: Int) :
    BaseFragment<BD>(id) {

    fun loadData(webView: WebView, url: String) {
        webView.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                showHideLoading(true)
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                showHideLoading(false)
            }
        }

        webView.apply {
            settings.javaScriptEnabled = true
            settings.javaScriptCanOpenWindowsAutomatically = true
            settings.domStorageEnabled = true
            settings.useWideViewPort = true
            settings.loadWithOverviewMode = true
            settings.allowContentAccess = true
            settings.allowFileAccess = true
            settings.databaseEnabled = true
            settings.setSupportZoom(true)
            loadUrl(url)
        }
    }
}