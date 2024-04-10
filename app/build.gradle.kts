plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.orgjetbrainskotlinkapt)
}

android {
    namespace = "com.example.historybrowser"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.historybrowser"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes += "/META-INF/gradle/incremental.annotation.processors"

        }
    }
}



dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(project(":domain"))
    implementation(project(":feature"))
    implementation(project(":data"))
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation("javax.inject:javax.inject:1")
    implementation("com.google.dagger:dagger:2.48.1")
    implementation("com.google.dagger:dagger-compiler:2.48.1")
    implementation("com.google.dagger:dagger-android:2.48.1")
    implementation("com.google.dagger:dagger-android-support:2.48.1")
    implementation("com.google.dagger:dagger-android-processor:2.48.1")
    kapt("com.google.dagger:dagger-compiler:2.48.1")
    kapt("com.google.dagger:dagger-android-processor:2.48.1")

}