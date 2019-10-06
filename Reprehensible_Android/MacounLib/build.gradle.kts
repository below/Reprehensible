import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.kotlin.native.cocoapods")

}

version = "1.0"

kotlin {
    jvm("android")

    sourceSets["commonMain"].dependencies {
        implementation("org.jetbrains.kotlin:kotlin-stdlib-common")
    }

    sourceSets["androidMain"].dependencies {
        implementation("org.jetbrains.kotlin:kotlin-stdlib")
    }

    val buildForDevice = project.findProperty("kotlin.native.cocoapods.target") == "ios_arm"
    if (buildForDevice) {
        iosArm64("iOS64")
        iosArm32("iOS32")

        val iOSMain by sourceSets.creating
        sourceSets["iOS64Main"].dependsOn(iOSMain)
        sourceSets["iOS32Main"].dependsOn(iOSMain)
    } else {
        iosX64("iOS")
    }

    cocoapods {
        // Configure fields required by CocoaPods.
        summary = "Macoun Sample Lib"
        homepage = "www.macoun.de"
    }
}