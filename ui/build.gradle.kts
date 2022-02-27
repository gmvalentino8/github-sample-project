plugins {
    id(Dependencies.Plugin.androidLibrary)
    id(Dependencies.Plugin.kotlinAndroid)
    id(Dependencies.Plugin.kotlinKapt)
    id(Dependencies.Plugin.parcelize)
    id(Dependencies.Plugin.hilt)
    id(Dependencies.Plugin.safeArgs)
}

setupAndroid()
setupJetpackCompose()

dependencies {
    project(Modules.Presentation)
    project(Modules.Domain)
    projectTest(Modules.Test)

    implementation(Dependencies.Kotlinx.coroutinesCore)
    implementation(Dependencies.Kotlinx.coroutinesAndroid)
    implementation(Dependencies.Kotlinx.datetime)
    implementation(Dependencies.AndroidX.core)
    implementation(Dependencies.AndroidX.appCompat)
    implementation(Dependencies.AndroidX.lifecycleViewModel)
    implementation(Dependencies.AndroidX.lifecycleSavedState)
    implementation(Dependencies.AndroidX.navigationUi)
    implementation(Dependencies.AndroidX.navigationFragment)
    implementation(Dependencies.Compose.runtime)
    implementation(Dependencies.Compose.material)
    implementation(Dependencies.Compose.ui)
    implementation(Dependencies.Compose.uiGraphics)
    implementation(Dependencies.Compose.uiTooling)
    implementation(Dependencies.Compose.uiToolingPreview)
    implementation(Dependencies.Compose.material)
    implementation(Dependencies.Compose.foundation)
    implementation(Dependencies.Compose.foundationLayout)
    implementation(Dependencies.Coil.core)
    implementation(Dependencies.Coil.compose)
    implementation(Dependencies.Accompanist.swipeRefresh)
    implementation(Dependencies.Hilt.android)
    kapt(Dependencies.Hilt.compiler)
}
