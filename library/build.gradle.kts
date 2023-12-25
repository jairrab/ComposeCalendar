import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("plugins.android-compose-library")
}

android {
    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = freeCompilerArgs + "-Xexplicit-api=strict"
        }
    }

    namespace = "com.boguszpawlowski.composecalendar"
}

private val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

dependencies {
    accompanist(libs)
    coroutines(libs)
    material(libs)

    testImplementation(Kotest.Assertions)
    testImplementation(Kotest.RunnerJunit5)
    testImplementation(Kotlin.Reflect)
}

object Kotest {
    const val Version = "5.4.1"
    const val RunnerJunit5 = "io.kotest:kotest-runner-junit5-jvm:$Version"
    const val Assertions = "io.kotest:kotest-assertions-core-jvm:$Version"
}

object Kotlin {
    const val Version = "1.7.21"
    const val Reflect = "org.jetbrains.kotlin:kotlin-reflect:$Version"
}
