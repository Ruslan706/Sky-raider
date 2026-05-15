package com.skyraider.game

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.util.AttributeSet
import android.webkit.*
import org.json.JSONObject

@SuppressLint("SetJavaScriptEnabled")
class GameWebView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : WebView(context, attrs) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences("skyraider_save", Context.MODE_PRIVATE)

    init {
        setupWebView()
    }

    private fun setupWebView() {
        setLayerType(LAYER_TYPE_HARDWARE, null)

        settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
            allowFileAccess = true
            allowContentAccess = true
            mediaPlaybackRequiresUserGesture = false
            useWideViewPort = true
            loadWithOverviewMode = true
            setSupportZoom(false)
            builtInZoomControls = false
            displayZoomControls = false
        }

        isScrollbarFadingEnabled = false
        isVerticalScrollBarEnabled = false
        isHorizontalScrollBarEnabled = false

        addJavascriptInterface(SaveBridge(), "AndroidSave")

        webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                loadSavedData()
            }
        }

        webChromeClient = object : WebChromeClient() {
            override fun onConsoleMessage(msg: ConsoleMessage): Boolean {
                android.util.Log.d(
