# Ornithorynque Mod (Platypus Mod) for Minecraft (WIP)

An early‑stage Forge mod adding **platypuses (ornithorynques)** and **snails** to Minecraft, plus new items, eggs, buckets, foods, and a slime‑ball farming mechanic.

> *This mod is a Work In Progress — expect bugs and missing features!*

---

## 📦 Features

* 🦆 **Platypus Entity**

  * Wild platypuses spawn in swamps and mangrove biomes.
  * Baby platypuses grow up over time.
  * Platypus animations, and movement behavior.

* 🥚 **Platypus Eggs & Buckets**

  * Platypuses randomly drop eggs.
  * Platypus eggs act like chicken eggs.
  * `platypus_in_bucket` item: capture adult platypus in a bucket, carry & release.

* 🐌 **Snails**

  * New snail mobs crawling on leaves and grass.
  * Snails drop snail mucus when killed.

* 🍽️ **Foods & Recipes**

  * Snails are used to craft  slime balls and feed/temp platypuses.

* ⚙️ **Creative Mode Tab**

  * A dedicated creative tab containing all mod items & blocks.

* 🔧 **Mod Events & Data**

  * Custom event handlers for entity registration, spawn rules, and drops.
  * JSON recipes, loot tables, and data files under `src/main/resources/data/platypusmod/`.

---

## 🚀 Getting Started (For Modders)

This project follows the **Minecraft Forge** MDK installation methodology and patching against un‑renamed (SRG) MCP code.

### Prerequisites

* Java JDK 8 or above
* Gradle Wrapper (included)
* IntelliJ IDEA or Eclipse

### Setup Process

1. **Clone the Repository**

   ```bash
   git clone https://github.com/yourusername/ornithorynque_mod.git
   cd ornithorynque_mod
   ```

2. **Import as a Gradle Project**

   **Eclipse**:

   ```bash
   ./gradlew genEclipseRuns
   ```

   * In Eclipse: **File → Import → Existing Gradle Project → Select Folder**

   **IntelliJ IDEA**:

   * **File → Open** the `build.gradle` file.
   * Wait for Gradle sync.

   ```bash
   ./gradlew genIntellijRuns
   ```

3. **Refresh Dependencies** (if needed)

   ```bash
   ./gradlew --refresh-dependencies
   ```

4. **Clean & Rebuild**

   ```bash
   ./gradlew clean build
   ```

### Mapping Names

By default, this MDK uses **Mojang mappings** (SRG names). To switch to community mappings (MCP or Yarn), update `mappings` in `build.gradle` accordingly.

---

## 🏗️ Project Structure

```
ornithorynque_mod/
├── build.gradle           # Gradle build script
├── settings.gradle
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── net/xerneas02/platypusmod/
│   │   │       ├── PlatypusMod.java        # @Mod entrypoint
│   │   │       ├── ModBlocks.java           # Custom block registration
│   │   │       ├── ModItems.java            # Item & bucket registration
│   │   │       ├── ModEntity.java           # EntityType registration
│   │   │       ├── ModCreativeModeTab.java  # Creative tab setup
│   │   │       ├── ModEvents.java           # Event handlers (registration, spawns)
│   │   │       ├── entity/
│   │   │       │   ├── PlatypusEntity.java
│   │   │       │   └── SnailEntity.java
│   │   │       └── item/
│   │   │           └── PlatypusEggItem.java
│   │   └── resources/
│   │       ├── assets/platypusmod/
│   │       │   ├── blockstates/
│   │       │   ├── models/
│   │       │   │   ├── block/
│   │       │   │   └── item/
│   │       │   ├── textures/
│   │       │   │   ├── entity/
│   │       │   │   │   ├── platypus.png
│   │       │   │   │   └── snail.png
│   │       │   │   └── item/
│   │       └── data/platypusmod/
│   │           ├── recipes/
│   │           ├── loot_tables/
│   │           └── tags/
└── LICENSE.txt
```

---

## 🛠️ Development Tips

* **Run Client**: `./gradlew genIntellijRuns runClient` or via your IDE run configs.
* **Run Data Generation**: `./gradlew runData` to auto‑generate JSONs.
* **Debug Logging**: Adjust log levels in `resources/log4j2.xml`.

---

## 📜 License

This mod is released under the **MIT License**. See [LICENSE](LICENSE) for details.

---
