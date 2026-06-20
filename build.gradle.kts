plugins {
  id("me.roundaround.allay")
}

allay {
  displayName.set("Axolotl Buckets")
  description.set("Show the color and age of axolotls when in buckets.")
  authors.set(listOf("Roundaround"))
  license.set("MIT")
  homepage.set("https://modrinth.com/mod/axolotl-buckets")
  repository.set("https://github.com/Roundaround/mc-axolotl-buckets")
  issues.set("https://github.com/Roundaround/mc-axolotl-buckets/issues")
  logoFile.set("assets/axolotlbuckets/banner.png")

  gametest {
    // Acknowledge the Minecraft EULA for the throwaway worlds the headless
    // server game test spins up.
    eula.set(true)
  }

  modrinth {
    projectId.set("axolotl-buckets")
  }

  release {
    versionType.set("release")
    sourcesJar.set(true)
  }
}
