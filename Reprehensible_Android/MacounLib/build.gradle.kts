import co.touchlab.kotlinxcodesync.SyncExtension

buildscript {
    repositories {
//        mavenCentral()
    }

    dependencies {
        classpath("co.touchlab:kotlinxcodesync:0.1.5")
    }
}

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.kotlin.native.cocoapods")
}
apply(plugin = "co.touchlab.kotlinxcodesync")

version = "1.0"

kotlin {
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

    jvm ("android")

    sourceSets["commonMain"].dependencies {
        implementation("org.jetbrains.kotlin:kotlin-stdlib-common")
    }

    sourceSets["androidMain"].dependencies {
        implementation("org.jetbrains.kotlin:kotlin-stdlib")
    }

    cocoapods {
        // Configure fields required by CocoaPods.
        summary = "Macoun Sample Lib"
        homepage = "www.macoun.de"
    }

    configure<SyncExtension> {
        projectPath = "../../Reprehensible_iOS/Reprehensible.xcodeproj"
        target = "Reprehensible"
    }
}