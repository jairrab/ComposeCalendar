import config.coroutines
import config.material

plugins {
    id("compose-library")
}

android {
    namespace = "com.boguszpawlowski.composecalendar"
}

kotlin {
    compilerOptions {
        freeCompilerArgs.add("-Xexplicit-api=strict")
    }
}

private val libs2 = extensions.getByType<VersionCatalogsExtension>().named("libs")

dependencies {
    coroutines(libs2)
    material(libs2)
    implementation("dev.chrisbanes.snapper:snapper:0.3.0")

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
