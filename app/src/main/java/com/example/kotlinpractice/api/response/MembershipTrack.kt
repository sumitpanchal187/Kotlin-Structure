package com.example.kotlinpractice.api.response


import com.google.gson.annotations.SerializedName

data class MembershipTrack(
    @SerializedName("availablePoints")
    val availablePoints: Int,
    @SerializedName("birthdayPoints")
    val birthdayPoints: Int,
    @SerializedName("bonusPoints")
    val bonusPoints: Int,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("createdIstAt")
    val createdIstAt: String,
    @SerializedName("earnedPoints")
    val earnedPoints: Int,
    @SerializedName("feedbackPoints")
    val feedbackPoints: Int,
    @SerializedName("finacialPoints")
    val finacialPoints: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("isFeedback")
    val isFeedback: Int,
    @SerializedName("isProfileUpdate")
    val isProfileUpdate: Int,
    @SerializedName("memberShipId")
    val memberShipId: String,
    @SerializedName("membershipLevel")
    val membershipLevel: String,
    @SerializedName("membershipStatus")
    val membershipStatus: String,
    @SerializedName("profilePoints")
    val profilePoints: Int,
    @SerializedName("sellerId")
    val sellerId: Int,
    @SerializedName("throughoutTheYearPoints")
    val throughoutTheYearPoints: Int,
    @SerializedName("tierBenefitsPoints")
    val tierBenefitsPoints: Int,
    @SerializedName("tierEntryDate")
    val tierEntryDate: String,
    @SerializedName("totalPoints")
    val totalPoints: Int,
    @SerializedName("updateByStaff")
    val updateByStaff: Any,
    @SerializedName("updatedAt")
    val updatedAt: String,
    @SerializedName("updatedIstAt")
    val updatedIstAt: String
)