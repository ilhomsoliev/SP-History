
plugins {
}


buildscript {
    repositories {
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
        google()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.9.0")

    }
}