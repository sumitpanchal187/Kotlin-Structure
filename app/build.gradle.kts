plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("org.jetbrains.kotlin.kapt")


}

android {
    namespace = "com.example.kotlinpractice"
    compileSdk = 35
    flavorDimensions += "environment"
    productFlavors {
        create("dev") {
            dimension = "environment"
            applicationIdSuffix = ".dev"
            buildConfigField("String", "BASE_URL", "\"https://dev-api.example.com/\"")
            resValue("string", "app_name", "KotlinPractice Dev")
        }

        create("qa") {
            dimension = "environment"
            applicationIdSuffix = ".qa"
            buildConfigField("String", "BASE_URL", "\"https://qa-api.example.com/\"")
            resValue("string", "app_name", "KotlinPractice QA")
        }
        create("staging") {
            dimension = "environment"
            applicationIdSuffix = ".staging"
            buildConfigField("String", "BASE_URL", "\"https://staging-api.example.com/\"")
            buildConfigField("String", "API_KEY", "\"staging_api_key\"")
            resValue("string", "app_name", "KotlinPractice Staging")
        }
        create("prod") {
            dimension = "environment"
            buildConfigField("String", "BASE_URL", "\"https://api.example.com/\"")
            resValue("string", "app_name", "KotlinPractice")
        }
    }

    buildTypes {
        debug {
            isDebuggable = true
            isMinifyEnabled = false
        }
        release {
            isDebuggable = false
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    defaultConfig {
        applicationId = "com.example.kotlinpractice"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
        buildConfig = true
    }


}

dependencies {

    //Dagger - Hilt
    implementation (libs.hilt.android)
    kapt (libs.hilt.android.compiler)
    kapt (libs.hilt.compiler)

    // Retrofit + OKHttp
    implementation (libs.retrofit)
    implementation (libs.okhttp)

    // Retrofit gson converter
    implementation (libs.converter.gson)
    implementation (libs.converter.scalars)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation (libs.logging.interceptor)
}