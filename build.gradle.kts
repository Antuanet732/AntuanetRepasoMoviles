// CORRECTO: En el archivo build.gradle.kts de la raíz del proyecto

// En: C:/Users/antua/AndroidStudioProjects/MyApplication/build.gradle.kts
// Este archivo DEFINE los plugins para todo el proyecto.
plugins {
    id("com.android.application") version "8.4.1" apply false
    id("org.jetbrains.kotlin.android") version "2.0.0" apply false
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.0" apply false
    // Esta línea es correcta y debe permanecer aquí.
    id("org.jetbrains.kotlin.kapt") version "2.0.0" apply false
}

