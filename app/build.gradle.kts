plugins {
    id("com.android.application")


}

android {

    namespace = "com.example.planirfinansov6"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.planirfinansov6"
        minSdk = 30
        targetSdk = 33
        versionCode = 3
        versionName = "3.1"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8


    }
    externalNativeBuild {
        cmake {
            path = file("src/main/cpp/CMakeLists.txt")
            version = "3.22.1"
        }
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")









    implementation("com.google.android.material:material:1.8.0")  // было
    /*implementation("com.google.android.material:material:1.12.0") */  // для конфети но не идет


    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation ("com.github.PhilJay:MPAndroidChart:v3.1.0")     // Библиотека Графиков

    implementation ("info.hoang8f:fbutton:1.0.5")   // Библиотека разновидностей кнопок


  /*  implementation ("com.google.android.exoplayer:exoplayer-core:2.19.1")

    implementation ("com.google.android.exoplayer:exoplayer-hls:2.19.1")

    implementation ("androidx.recyclerview:recyclerview:1.3.2")*/   // ВРОДЕ реклама ???



   /* implementation ("nl.dionsegijn:konfetti-xml:2.0.3")*/
    implementation ("com.github.jinatonic.confetti:confetti:1.1.0")   // Библиотека конфети


    /*implementation ("androidx.viewpager2:viewpager2:1.0.0")  // Библиотека перелистывания*/

  /*  implementation ("com.google.android.gms:play-services-ads:23.0.0")*/



    /* implementation ("com.google.android.gms:play-services-ads-identifier:18.0.1")
    implementation ("com.my.target:mytarget-sdk:5.20.1")
   implementation ("com.my.target:mytarget-sdk:3.2.0") */  // Вроде реклама

}

