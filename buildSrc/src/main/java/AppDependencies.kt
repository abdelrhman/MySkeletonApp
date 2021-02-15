object AppDependencies {
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val kotlinCoroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinCoroutinesAndroid}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val navFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.nav}"
    const val navUi = "androidx.navigation:navigation-ui-ktx:${Versions.nav}"

    // ViewModel
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"

    // LiveData
    const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"

    // Hilt
    const val hiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val hiltTesting = "com.google.dagger:hilt-android-testing:${Versions.hilt}"

    // Timber
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    // Retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"

    // Room
    const val room = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"

    // WorkManger
    const val workManger = "androidx.work:work-runtime-ktx:${Versions.workManger}"

    //Paging
    const val paging = "androidx.paging:paging-runtime:${Versions.paging}"

    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glideVersion}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.glideVersion}"

    //Testing
    const val androidxJunit = "androidx.test.ext:junit:${Versions.androidxJunit}"
    const val coreTesting = "androidx.arch.core:core-testing:${Versions.coreTesting}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    const val workTesting = "androidx.work:work-testing:${Versions.workManger}"
    const val mockk = "io.mockk:mockk:${Versions.mockk}"
    const val mockkAndroid = "io.mockk:mockk-android:${Versions.mockk}"
    const val coroutineTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutineTest}"
    const val hamcrest = "org.hamcrest:hamcrest-all:${Versions.hamcrest}"
}