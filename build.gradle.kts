plugins {
	id("maven-publish")
	alias(libs.plugins.fabric.loom)
}

project.version = "0.5.0+1.21.1"
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
	maven("https://maven.parchmentmc.org")
	maven("https://maven.terraformersmc.com/releases/")
	maven("https://maven.blamejared.com/")
	maven("https://maven.wispforest.io/releases")
	exclusiveContent {
		forRepository {
			maven("https://api.modrinth.com/maven")
		}
		filter {
			includeGroup("maven.modrinth")
		}
	}
}

dependencies {
	minecraft(libs.minecraft)
	mappings(loom.layered {
		officialMojangMappings()
		parchment(libs.parchment)
	})
	modImplementation(libs.fabric.loader)

	modImplementation(libs.fabric.api)

	modCompileOnly(libs.ennuis.bigger.inventories)
	modLocalRuntime(libs.ennuis.bigger.inventories)

	// JEI on runtime is fine because EMI will eat it
	modCompileOnly(libs.jei)
	//modLocalRuntime(libs.jei)

	modCompileOnly(libs.emi)
	modLocalRuntime(libs.emi)

	modCompileOnly(libs.accessories)
	modLocalRuntime(libs.accessories)

	modCompileOnly(libs.owo.lib)
}

tasks.named<ProcessResources>("processResources").configure {
	val version = project.version
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
tasks.named<Jar>("jar").configure {
	val name = project.name
	inputs.files("LICENSE.md")
	inputs.property("name", name)

	from("LICENSE.md") {
		rename { "LICENSE_${name}.md" }
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

