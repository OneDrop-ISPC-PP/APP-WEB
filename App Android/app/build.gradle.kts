plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.one_drop_cruds"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.one_drop_cruds"
        minSdk = 27
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

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
    buildFeatures{
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-fragment:2.7.7")
    implementation("androidx.navigation:navigation-ui:2.7.7")
    implementation("androidx.activity:activity:1.9.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


    implementation ("com.github.PhilJay:MPAndroidChart:v3.1.0")
    implementation ("org.mindrot:jbcrypt:0.4")

    implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0") // para peticiones HTTP
    implementation ("com.squareup.retrofit2:converter-gson:2.6.4") // aca deberia ser converter-jackson QUE ES EL QUE USO EN BACK.. AVERIGUAR VERSION!
    implementation ("com.google.code.gson:gson:2.8.9")

}