plugins {
    id("maven-publish")
    alias(libs.plugins.quilt.loom)
}

project.version = "0.3.0+1.21.1"
project.group = "io.github.ennuil"

loom {
    mods {
        register("ennuis_bigger_gambiarra") {
            sourceSet(sourceSets["main"])
        }
    }

    mixin {
        useLegacyMixinAp = false
    }
}

repositories {
    maven(uri("https://maven.terraformersmc.com/releases/"))
    exclusiveContent {
        forRepository {
            maven(uri("https://api.modrinth.com/maven"))
        }
        filter {
            includeGroup("maven.modrinth")
        }
    }
}

dependencies {
    minecraft(libs.minecraft)
    mappings(variantOf(libs.quilt.mappings) { classifier("intermediary-v2") })
    modImplementation(libs.quilt.loader)

    modImplementation(libs.fabric.api)

    modCompileOnly(libs.ennuis.bigger.inventories)
    modLocalRuntime(libs.ennuis.bigger.inventories)

    modCompileOnly(libs.emi)
    modLocalRuntime(libs.emi)
}

tasks.processResources {
    inputs.property("version", version)

    filesMatching("fabric.mod.json") {
        expand("version" to version)
    }
}

tasks.withType<JavaCompile> {
    options.release = 21
}

java {
    // Loom will automatically attach sourcesJar to a RemapSourcesJar task and to the "build" task if it is present.
    // If you remove this line, sources will not be generated.
    withSourcesJar()

    // If this mod is going to be a library, then it should also generate Javadocs in order to aid with development.
    // Uncomment this line to generate them.
    // withJavadocJar()
}

// If you plan to use a different file for the license, don't forget to change the file name here!
tasks.jar {
    from("LICENSE.md") {
        rename { "${it}_${base.archivesName.get()}" }
    }
}

// Configure the maven publication
publishing {
    publications {
        register<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }

    // See https://docs.gradle.org/current/userguide/publishing_maven.html for information on how to set up publishing.
    repositories {
        // Add repositories to publish to here.
        // Notice: This block does NOT have the same function as the block in the top level.
        // The repositories here will be used for publishing your artifact, not for
        // retrieving dependencies.
    }
}

