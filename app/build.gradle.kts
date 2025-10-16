// En: app/build.gradle.kts

plugins {
    // Se aplican los plugins usando sus alias del catálogo de versiones.
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.kotlin.compose.compiler) // Plugin del compilador de Compose para Kotlin 2.0+
}

android {
    namespace = "com.c_antuanet.AppUEREPASO1162003"
    compileSdk = 34 // Última versión estable

    defaultConfig {
        applicationId = "com.c_antuanet.AppUEREPASO1162003"
        minSdk = 26 // Base recomendada para alcanzar la mayoría de dispositivos
        targetSdk = 34 // Debe coincidir con compileSdk
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        // Habilita Jetpack Compose en el proyecto
        compose = true
    }
    // Este bloque ya no es necesario para la versión del compilador, se puede omitir.
    composeOptions {
        // kotlinCompilerExtensionVersion se gestiona ahora por el plugin de compose
    }
    packaging {
        // Evita conflictos de archivos duplicados en las dependencias
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Dependencias principales (usando el catálogo de versiones `libs`)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    // ---- Dependencias de Jetpack Compose ----
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)

    // ---- Dependencias Adicionales ----
    implementation("androidx.navigation:navigation-compose:2.7.7")
    implementation("io.coil-kt:coil-compose:2.6.0")

    // Room Database
    val roomVersion = "2.6.1"
    implementation("androidx.room:room-runtime:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")
    kapt("androidx.room:room-compiler:$roomVersion") // 'kapt' ahora es reconocido gracias al plugin

    // ---- Dependencias de Pruebas (Testing) ----
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)

    // ---- Dependencias de Depuración (Debug) ----
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}
