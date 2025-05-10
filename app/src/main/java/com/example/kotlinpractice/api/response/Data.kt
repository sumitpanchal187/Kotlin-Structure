package com.example.kotlinpractice.api.response


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("accountId")
    val accountId: String,
    @SerializedName("activities")
    val activities: Activities,
    @SerializedName("activityStatus")
    val activityStatus: String,
    @SerializedName("agreedToTerms")
    val agreedToTerms: Int,
    @SerializedName("availablePoints")
    val availablePoints: Int,
    @SerializedName("billingAddress")
    val billingAddress: BillingAddress,
    @SerializedName("contactNo")
    val contactNo: String,
    @SerializedName("dob")
    val dob: String,
    @SerializedName("dobPointStatus")
    val dobPointStatus: Any,
    @SerializedName("earnedPoints")
    val earnedPoints: Int,
    @SerializedName("email")
    val email: String,
    @SerializedName("finacialPoints")
    val finacialPoints: Int,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("gstNo")
    val gstNo: Any,
    @SerializedName("id")
    val id: Int,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("marriageDate")
    val marriageDate: Any,
    @SerializedName("memberShipId")
    val memberShipId: String,
    @SerializedName("membershipLevel")
    val membershipLevel: String,
    @SerializedName("membershipTrack")
    val membershipTrack: List<MembershipTrack>,
    @SerializedName("otp")
    val otp: String,
    @SerializedName("otpCount")
    val otpCount: Int,
    @SerializedName("otpTimeStampAt")
    val otpTimeStampAt: String,
    @SerializedName("preferredContactTime")
    val preferredContactTime: Any,
    @SerializedName("roles")
    val roles: String,
    @SerializedName("sellerId")
    val sellerId: Int,
    @SerializedName("shippingAddress")
    val shippingAddress: ShippingAddress,
    @SerializedName("tierEntryDate")
    val tierEntryDate: String,
    @SerializedName("totalPoints")
    val totalPoints: Int,
    @SerializedName("verified")
    val verified: String
)