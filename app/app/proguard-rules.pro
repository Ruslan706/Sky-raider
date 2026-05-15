# Keep WebView JavaScript interface methods
-keepclassmembers class com.skyraider.game.GameWebView$SaveBridge {
    public *;
}
-keepattributes JavascriptInterface

# Keep all game classes
-keep class com.skyraider.game.** { *; }
