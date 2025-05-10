package com.example.kotlinpractice.utilss

import java.util.regex.Pattern

object Constants {

    // Shared Preference name and password key from API that must be 32 character long
    const val ENCRYPTED_SHARED_PREF_NAME = "app_shared_prefs_encrypted"
    const val PER_PAGE_RECORDS = 20
    const val MAX_FOLD_DEVICE_WIDTH = 1080

    // Display date formats
    const val DISPLAY_DATE_TIME_FORMAT = "dd MMM yyyy · h:mma"
    const val DISPLAY_DATE_FORMAT = "dd MMM yyyy"

    // API date formats
    const val API_DATE_TIME_FORMAT = "yyyy-MM-dd hh:mm:ss"
    const val API_DATE_AND_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss"
    const val API_DATE_AND_TIME_FORMAT_WITH_MS = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
    const val LOCAL_DATE_FORMAT = "dd MMM yyyy"
    const val API_DATE_TIME_MS_FORMAT_X = "yyyy-MM-dd'T'HH:mm:ssXXX"
    const val API_DATE_TIME_MS_FORMAT_WITH_OFFSET = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX"
    const val API_DATE_FORMAT = "yyyy-MM-dd"

    // Network
    const val CONNECT_TIMEOUT = 60
    const val WRITE_TIMEOUT = 60
    const val READ_TIMEOUT = 90

    //response codes
    const val RESPONSE_CODE_UNAUTHORIZED = 401
    const val NETWORK_OTHER_ERROR_CODE = 0
    const val RESPONSE_CODE_400 = 400
    const val RESPONSE_CODE_404 = 404
    const val RESPONSE_CODE_406 = 406
    const val RESPONSE_CODE_444 = 444
    const val RESPONSE_CODE_409 = 409
    const val RESPONSE_CODE_434 = 434
    const val RESPONSE_CODE_449 = 449
    const val RESPONSE_CODE_429 = 429
    const val RESPONSE_CODE_422 = 422
    const val RESPONSE_CODE_423 = 423
    const val RESPONSE_CODE_403 = 403
    const val RESPONSE_CODE_425 = 425
    const val RESPONSE_CODE_426 = 426
    const val RESPONSE_CODE_200 = 200
    const val RESPONSE_CODE_201 = 201
    const val RESPONSE_CODE_202 = 202
    const val RESPONSE_CODE_203 = 203
    const val RESPONSE_CODE_302 = 302
    const val RESPONSE_CODE_500 = 500

    const val ERROR_CODE_210 = 210
    const val ERROR_CODE_0 = 0
    const val ERROR_CODE_231 = 231
    const val ERROR_CODE_232 = 232
    const val ERROR_CODE_239 = 239
    const val MAX_KIDS_CARDS = 4

    var NOTIFICATION_COUNT = 0

    const val UNKNOWN_API_ERROR_MSG = "Oops! Something went wrong"
    const val NETWORK_ERROR_MSG = "Internet connection is not available."
    const val ERROR_TITLE_OOPS = "Oops!"

    // filter
    const val FILTER_STORE_TYPES = "Types"
    const val FILTER_STORE_CATEGORIES = "Categories"
    const val FILTER_CATALOGUE_TYPES = "Types"
    const val FILTER_CATALOGUE_GROUP = "Group"
    const val FILTER_CATALOGUE_CATEGORIES = "Categories"

    //BroadCast
    const val BROADCAST_UPDATE_ON_VIDEO_CACHED = "broadcastOnVideoCached"

    //Profile
    const val DYNAMIC_FIELDS_MOBILEVERIFIED = "MobileVerified"
    const val DYNAMIC_FIELDS_MIGRATEDMEMBER = "MigratedMember"
    const val DYNAMIC_FIELDS_COLVALUE_YES = "Yes"
    const val DYNAMIC_FIELDS_COLVALUE_NO = "No"

    // Registration
    const val FIELD_MOBILE = "Mobile"
    const val FIELD_EMAIL = "Email"
    const val GENDER_MALE = "male"
    const val GENDER_FEMALE = "female"
    const val GENDER_DO_NOT_DISCLOSE = "Do not wish to disclose"
    const val MAIL_SUBSCRIPTION_NAME_VIVO_CITY = "VivoCity"
    const val SIGNUP_LOCATION_CODE = "App"
    const val MEMBERSHIP_TYPE_VIVOREWARDS = "VivoRewards"
    const val MEMBERSHIP_TIER_BASIC = "Basic"
    const val MEMBERSHIP_TIER_GUEST = "Guest"

    const val REGISTRATION_STEP_ONE = "RegistrationStepOne"
    const val REGISTRATION_STEP_TWO = "RegistrationStepTwo"
    const val REGISTRATION_STEP_THREE = "RegistrationStepThree"
    const val REGISTRATION_STEP_FOUR = "RegistrationStepFour"
    const val REGISTRATION_STEP_FIVE = "RegistrationStepFive"
    const val REGISTRATION_STEP_SIX = "RegistrationStepSix"
    const val CONVERT_VOUCHER_STEP_ONE = "ConvertVoucherStepOne"

    var USER_EMAIL = ""

    //Restricted Wall
    const val NOT_ACTIVE_ACCOUNT_USER = "Not Active Account User"
    const val NOT_ACTIVE_ACCOUNT_USER_GUEST = "Not Account User Guest"

    //
    const val MOBILE_ANDROID = "mobile-android"
    const val API_APP_NAME = "VivoCity"


    //Home
    const val VOUCHER_TYPE_CASH = "Cash"
    const val CARDS_MEMBERSHIP_STATUS_CODE_ACTIVE = "ACTIVE"
    const val HOME_CATALOGUE_MAX_COUNT = 15
    const val CMS_CATALOGUE_TYPE_CATALOGUE = "catalogue"
    const val CMS_CATALOGUE_TYPE_WHATS_NEW = "whatsnew"
    const val DISPLAY_TYPE_SELECT_BY_TYPE = "select_by_type"
    const val DISPLAY_TYPE_SELECT_ALL_GROUP = "select_all_group"

    // Wallet
    const val VIP_VOUCHER_PREFIX = "CPVIPZONE"
    const val FREE_2HR_PARKING_PREFIX = "CPVIP2HR"
    const val FREE_PARKING_VOUCHERS_TYPE = "FreeParkingVouchers"

    //Splash
    const val CACHE_DIR_ADVERTISEMENT_VIDEO = "advertisement"
    const val CACHE_DIR_HOME_BANNER_VIDEO = "home_banner"

    const val TEST_OTP = "123456"
    //Activities vrPoint
    const val SALES = "SALES"
    const val RECEIPT = "RECEIPT"
    const val PLUS_ADJUSTMENT = "PLUS ADJUSTMENT"
    const val ADDITIONAL_REWARDS = "ADDITIONAL REWARDS"
    const val VOUCHER_ISSUANCE_WITH_POINTS = "VOUCHER ISSUANCE WITH POINTS"
    const val POINTS_REDEMPTION = "POINTS REDEMPTION"
    const val POINTS_EXPIRY = "POINTS EXPIRY"
    const val MINUS_ADJUSTMENT = "MINUS ADJUSTMENT"

    //Activities transaction history
    const val EARNED = "EARNED"
    const val TRANSFER_IN = "TRANSFER IN"
    const val PLUS_ADJ = "PLUS ADJ"
    const val MINUS_ADJ = "MINUS ADJ"
    const val TRANSFER_OUT = "TRANSFER OUT"
    const val REDEEMED = "REDEEMED"
    const val BENEFIT_REDEEMED = "BENEFIT REDEEMED"
    const val TRANJECT_TYPE_VOUCHER_ISSUANCE_WITH_POINTS = "VOUCHER ISSUANCE WITH POINTS"

    var KEY_VENDOR_CRM_TOKEN: String? = null

    const val TAG_CAMERA = "camera"


    // pay with wallet
    const val VOUCHER_TYPE_FILTER_TENANT_CASH = "TenantCash"
    const val VOUCHER_TYPE_FILTER_TENANT_PRODUCT = "TenantProduct"
    const val VOUCHER_TYPE_FILTER_VIVOCITY_CASH = "Cash"
    const val VOUCHER_TYPE_FILTER_VIVOCITY_REWARDS = "Rewards"
    const val PAY_WITH_WALLET_QR_SCAN = "QR scan"
    const val PAY_WITH_WALLET_MAX_RESULT_COUNT = 500

    // Wallet Voucher Filter
    const val VOUCHER_TYPE_FILTER_VIVOCITY = "Cash,Rewards"
    const val VOUCHER_TYPE_FILTER_RETAILER = "TenantCash,TenantProduct"
    const val VOUCHER_TYPE_FILTER_PARKING = "FreeParkingVouchers"

    // Submit Receipt
    const val RECEIPT_MAX_SIZE_IM_MB = 5
    const val RECEIPT_MAX_HEIGHT_WIDTH = 2048

    //Kids Club Registration
    const val KIDS_CLUB_REGISTRATION_CAMPAIGN_TYPE = "Registration Campaign"
    const val KIDS_CLUB_REGISTRATION_CAMPAIGN_CODE = "Registration_KidsClub"
    const val KIDS_CLUB_REGISTRATION_TIER_CODE = "KidsClub"

    // FB Log Event
    const val FB_EVENT_COMPLETED_REGISTRATION = "CompletedRegistration"
}