plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.orgjetbrainskotlinkapt)
}

android {
    namespace = "com.example.data"
    compileSdk = 34



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
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(project(":domain"))
    implementation(libs.transport.runtime)
    implementation(project(":feature"))
    implementation(libs.androidx.room.ktx)
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
    implementation("io.reactivex.rxjava2:rxjava:2.2.21")
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation("io.reactivex.rxjava2:rxkotlin:2.4.0")
    implementation("com.jakewharton.rxbinding3:rxbinding:3.1.0")
    implementation("androidx.room:room-ktx:2.6.0")
    implementation("androidx.room:room-rxjava2:2.6.0")
    kapt("androidx.room:room-compiler:2.6.0")
    implementation ("com.jakewharton.timber:timber:5.0.1")

}