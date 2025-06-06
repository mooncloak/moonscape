import gradle.kotlin.dsl.accessors._9d6accdeac6876c73060866945fb6d8c.java
import gradle.kotlin.dsl.accessors._9d6accdeac6876c73060866945fb6d8c.kotlin
import org.gradle.api.JavaVersion
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.assign
import org.gradle.kotlin.dsl.kotlin
import org.gradle.kotlin.dsl.named
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.targets.js.npm.tasks.KotlinNpmInstallTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompilationTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.gradle.tasks.KotlinTest

plugins {
    kotlin("multiplatform")
}

kotlin {
    applyDefaultHierarchyTemplate()

    js {
        browser {
            testTask {
                enabled = false
            }
        }

        nodejs {
            testTask {
                enabled = false
            }
        }
    }

    @OptIn(org.jetbrains.kotlin.gradle.ExperimentalWasmDsl::class)
    wasmJs {
        browser {
            testTask {
                enabled = false
            }
        }

        nodejs {
            testTask {
                enabled = false
            }
        }
    }

    macosX64()
    macosArm64()

    // TODO: Re-enable when supported by Compose UI module: linuxArm64()
    // TODO: Re-enable when supported by Compose UI module: linuxX64()

    // TODO: Re-enable when supported by Compose UI module: mingwX64()

    iosArm64()
    iosX64()
    iosSimulatorArm64()

    // TODO: Re-enable when supported by Compose UI module: tvosArm64()
    // TODO: Re-enable when supported by Compose UI module: tvosX64()
    // TODO: Re-enable when supported by Compose UI module: tvosSimulatorArm64()

    // TODO: Re-enable when supported by Compose UI module: watchosArm32()
    // TODO: Re-enable when supported by Compose UI module: watchosArm64()
    // TODO: Re-enable when supported by Compose UI module: watchosX64()
    // TODO: Re-enable when supported by Compose UI module: watchosSimulatorArm64()

    androidTarget {
        publishAllLibraryVariants()
    }

    jvm()

    explicitApi()

    // Ensure xml test reports are generated
    tasks.named("jvmTest", Test::class).configure {
        reports.junitXml.required.set(true)
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks.withType<KotlinCompile>().configureEach {
    compilerOptions.jvmTarget = JvmTarget.JVM_11
}

tasks.withType<KotlinTest> {
    if (targetName == "tvosSimulatorArm64" || targetName == "watchosSimulatorArm64") {
        enabled = false
    }
}

// Don't run npm install scripts, protects against
// https://blog.jetbrains.com/kotlin/2021/10/important-ua-parser-js-exploit-and-kotlin-js/ etc.
tasks.withType<KotlinNpmInstallTask> {
    args += "--ignore-scripts"
}

tasks.withType<KotlinCompilationTask<*>>().configureEach {
    compilerOptions {
        freeCompilerArgs.add("-Xexpect-actual-classes")
    }
}
