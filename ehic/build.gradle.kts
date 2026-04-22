import at.asitplus.gradle.Logger
import at.asitplus.gradle.kotest
import at.asitplus.gradle.serialization
import at.asitplus.gradle.setupDokka

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.asitplus.gradle.conventions)
    id("org.jetbrains.dokka")
    id("signing")
    alias(libs.plugins.testballoon)
}

/* required for maven publication */
val artifactVersion: String by extra
group = "at.asitplus.wallet"
version = artifactVersion

kotlin {
    jvm()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        commonMain {
            dependencies {
                api(serialization("json"))
                api(libs.vck)
            }
        }
        commonTest {
            dependencies {
                implementation(libs.testballoon)
                implementation(kotest("assertions-core"))
            }
        }
    }
}
val javadocJar = setupDokka(baseUrl = "https://github.com/a-sit-plus/ehic/tree/main/")

publishing {
    publications {
        withType<MavenPublication> {
            if (this.name != "relocation") artifact(javadocJar)
            pom {
                name.set("European Health Identity Credential")
                description.set("Use data representing EHIC as a SD-JWT credential, using VC-K")
                url.set("https://github.com/a-sit-plus/ehic/")
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set("nodh")
                        name.set("Christian Kollmann")
                        email.set("christian.kollmann@a-sit.at")
                    }
                }
                scm {
                    connection.set("scm:git:git@github.com:a-sit-plus/ehic.git")
                    developerConnection.set("scm:git:git@github.com:a-sit-plus/ehic.git")
                    url.set("https://github.com/a-sit-plus/ehic/")
                }
            }
        }
    }
    repositories {
        mavenLocal {
            signing.isRequired = false
        }
    }
}

signing {
    val signingKeyId: String? by project
    val signingKey: String? by project
    val signingPassword: String? by project
    useInMemoryPgpKeys(signingKeyId, signingKey, signingPassword)
    sign(publishing.publications)
}
