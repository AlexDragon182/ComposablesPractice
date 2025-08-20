// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript{
    dependencies{
        classpath (libs.hilt.android.gradle.plugin)

    }
    repositories {
        mavenCentral()
        maven {
            url = uri("https://gitlab.com/api/v4/projects/4128550/packages/maven")
        }
        google()
        gradlePluginPortal()
        jcenter()
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    //NAVEGACION CON TIPO SEGURO
    alias(libs.plugins.kotlin.parcelize) apply false
}