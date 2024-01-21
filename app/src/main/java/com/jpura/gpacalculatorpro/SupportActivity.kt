package com.jpura.gpacalculatorpro

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.ads.MobileAds
import com.jpura.gpacalculatorpro.databinding.ActivitySupportBinding
import com.jpura.gpacalculatorpro.utils.Utils

class SupportActivity : AppCompatActivity() {

    lateinit var binding: ActivitySupportBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySupportBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MobileAds.initialize(this) {}
        Utils.setUpBannerAd(binding.supportAdView)

        binding.emailTv.setOnClickListener {
            copyToClipboard(binding.emailTv.text.toString())
            showToast("Email address copied!")
            true
        }
        binding.linkedinTv.setOnClickListener {
            copyToClipboard(binding.linkedinTv.text.toString())
            showToast("Copied!")
            true
        }
        binding.fiverrTv.setOnClickListener {
            copyToClipboard(binding.fiverrTv.text.toString())
            showToast("Copied!")
            true
        }
    }

    private fun copyToClipboard(text: String) {
        val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("Copied Text", text)
        clipboard.setPrimaryClip(clip)
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}