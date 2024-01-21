package com.jpura.gpacalculatorpro.utils

import android.app.Activity
import android.content.Context
import android.util.Log
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.OnUserEarnedRewardListener
import com.google.android.gms.ads.rewarded.RewardedAd
import com.jpura.gpacalculatorpro.model.Module

class Utils {
    companion object{
        fun calculateGPA(modules: ArrayList<Module>): Float {
            var totalCreditPoints = 0.0f
            var totalCredits = 0.0f

            for (module in modules) {
                val creditPoints = module.credit * module.myCredit
                totalCreditPoints += creditPoints
                totalCredits += module.credit
            }

            // Avoid division by zero
            if (totalCredits == 0.0f) {
                return 0.0f
            }

            val result = totalCreditPoints / totalCredits

            return "%.2f".format(result).toFloat()
        }

        fun setUpBannerAd(adView: AdView) {
            val adRequest = AdRequest.Builder().build()
            adView.loadAd(adRequest)
        }

        fun showRewardAd(TAG: String, rewardedAd: RewardedAd, context: Activity) {
            rewardedAd?.let { ad ->
                ad.show(context, OnUserEarnedRewardListener { rewardItem ->
                    // Handle the reward.
                    val rewardAmount = rewardItem.amount
                    val rewardType = rewardItem.type
                    Log.d(TAG, "User earned the reward.")
                })
            } ?: run {
                Log.d(TAG, "The rewarded ad wasn't ready yet.")
            }
        }

    }


}