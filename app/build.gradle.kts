plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("de.mannodermaus.android-junit5")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdkVersion(AppConfig.compileSdk)
    buildToolsVersion(AppConfig.buildTools)

    defaultConfig {
        applicationId = "com.abdelrahman.myskeletonapp"
        minSdkVersion(AppConfig.minSdk)
        targetSdkVersion(AppConfig.targetSdk)
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName
        testInstrumentationRunner = AppConfig.androidTestInstrumentation
        buildConfigField("String", "UNSPLASH_ACCESS_KEY", "\"K7PPvdelDvrFKhVcPS7kogggqZCGcHhB7Zd-BI-zGp4\"")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        getByName("debug") {
            isMinifyEnabled = false
            isTestCoverageEnabled = true
        }
    }

    sourceSets {
        val sharedTestDir = "src/sharedTest/java"
        getByName("androidTest") {
            java.srcDirs(sharedTestDir)
        }
        getByName("test") {
            java.srcDirs(sharedTestDir)
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlinx.coroutines.ExperimentalCoroutinesApi"
        freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlinx.coroutines.FlowPreview"
    }
    testOptions.unitTests {
        isIncludeAndroidResources = true
    }
    buildFeatures.viewBinding = true
    buildFeatures.dataBinding = true

    packagingOptions {
        exclude("META-INF/AL2.0")
        exclude("META-INF/LGPL2.1")
    }
}

configurations.all {
    resolutionStrategy {
        force("androidx.test:monitor:1.4.0-alpha04")
    }
}

dependencies {
    implementation(AppDependencies.kotlinStdLib)
    implementation(AppDependencies.kotlinCoroutinesAndroid)
    implementation(AppDependencies.coreKtx)
    implementation(AppDependencies.appCompat)
    implementation(AppDependencies.material)
    implementation(AppDependencies.constraintLayout)
    implementation(AppDependencies.navFragment)
    implementation(AppDependencies.navUi)
    implementation(AppDependencies.lifecycleLiveData)
    implementation(AppDependencies.lifecycleViewModel)
    implementation(AppDependencies.hiltAndroid)
    kapt(AppDependencies.hiltCompiler)
    implementation(AppDependencies.timber)
    implementation(AppDependencies.retrofit)
    implementation(AppDependencies.retrofitGsonConverter)
    implementation(AppDependencies.loggingInterceptor)
    implementation(AppDependencies.room)
    kapt(AppDependencies.roomCompiler)
    implementation(AppDependencies.roomKtx)
    implementation(AppDependencies.workManger)
    implementation(AppDependencies.paging)
    kapt(AppDependencies.glideCompiler)
    implementation(AppDependencies.glide)

    // test libs

    testImplementation(UnitTest.jupiterApi)
    testImplementation(UnitTest.jupiterParams)
    testRuntimeOnly(UnitTest.jupiterEngine)
    testImplementation(AppDependencies.mockk)
    testImplementation(AppDependencies.coreTesting)
    testImplementation(AppDependencies.coroutineTest)
    testImplementation(AppDependencies.hamcrest)

    androidTestImplementation(AppDependencies.androidxJunit)
    androidTestImplementation(AppDependencies.coreTesting)
    androidTestImplementation(AppDependencies.espressoCore)
    androidTestImplementation(AppDependencies.espressoContrib)
    androidTestImplementation(AppDependencies.workTesting)
    androidTestImplementation(AppDependencies.mockkAndroid)
    androidTestImplementation(AppDependencies.coroutineTest)
    debugImplementation(AppDependencies.fragmentTesting)
    androidTestImplementation(AppDependencies.hiltTesting)
    kaptAndroidTest(AppDependencies.hiltCompiler)
}
