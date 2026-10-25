# Lit It Up — Fabric port

## Target
- Minecraft Java Edition 1.21.11
- Fabric Loader
- Repository: `Nightandir/Lit-It-Up-Fabric-Port`
- The original mod JAR is retained as a reference only; the original mod is not modified.

## Source artifact inspected
- `lititup-1.21-7.4.jar` (104,344 bytes)
- Its archive contains `META-INF/mods.toml` and Forge-specific data paths (`data/lititup/forge/...`), plus classes under `com/eruannie_9/lititup/`.
- This is a Forge mod, not a Fabric mod. Renaming the JAR or changing metadata alone will not port it.

## Feature scope to preserve
- Manual ignition for supported furnace-like blocks.
- Ignition using flint and steel and the mod's early-game Sparkling Flint.
- Switchgrass growth stages and Switchgrass Fiber progression.
- Environmental ignition from configured hot/lit blocks, with rain disabling that route.
- Fire Aspect and optional ignition-item configuration where practical.
- Existing recipes, translations, models, textures, and advancement progression should be reviewed for compatibility and licensing before reuse.

## Important compatibility note
The published mod documentation indicates that later Lit It Up versions use Bookling Gear for in-game configuration and that some special interactions depend on optional integrations. Those integrations need Fabric-compatible replacements or explicit feature fallbacks; Forge dependencies cannot simply be carried over.

## Current status
- [x] Located and verified the uploaded source JAR in this repository.
- [x] Identified it as Forge-based from archive contents.
- [x] Recorded the target and feature scope.
- [ ] Create the Fabric/Loom project for Minecraft 1.21.11.
- [ ] Reimplement the furnace ignition logic for Fabric.
- [ ] Port Switchgrass, fiber, recipes, loot tables, and world generation.
- [ ] Replace or omit Forge-only configuration and integrations.
- [ ] Build and fix compile errors.
- [ ] Test client and dedicated-server startup, recipes, ignition, rain behavior, and multiplayer synchronization.

A successful build is not the same as in-game verification. No working Fabric JAR is claimed until those checks pass.
