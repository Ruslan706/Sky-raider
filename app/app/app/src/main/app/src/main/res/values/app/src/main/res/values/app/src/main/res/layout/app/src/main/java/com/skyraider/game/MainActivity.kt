package com.skyraider.game

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.WindowInsetsController
import android.view.WindowInsets
import androidx.appcompat.app.AppCompatActivity
import com.skyraider.game.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.gameWebView.loadGame()
    }

    override fun onResume() {
        super.onResume()
        hideSystemUI()
        binding.gameWebView.onResume()
    }

    override fun onPause() {
        super.onPause()
        binding.gameWebView.onPause()
    }

    @Suppress("DEPRECATION")
    override fun onBackPressed() {
        binding.gameWebView.evaluateJavascript(
            "if(typeof goMap==='function')goMap();", null)
    }

    @Suppress("DEPRECATION")
    private fun hideSystemUI() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.let {
                it.hide(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
                it.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        } else {
            window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            )
        }
    }
}
