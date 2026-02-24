import com.android.build.api.dsl.LibraryExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import plugins.coroutines
import plugins.material

plugins {
    id("com.bluecoins.plugins.compose-library")
}

extensions.configure<LibraryExtension> {
    namespace = "com.boguszpawlowski.composecalendar"
}

tasks.withType<KotlinCompile>().configureEach {
    compilerOptions {
        freeCompilerArgs.addAll(
            listOf(
                "-Xexplicit-api=strict",
            ),
        )
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
