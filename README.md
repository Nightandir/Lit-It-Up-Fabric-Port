# Lit It Up — Fabric Port

An independent Fabric reimplementation targeting **Minecraft 1.21.11**. The original Forge JAR is kept in this repository as a reference artifact; it is not modified.

## Status

This repository now contains the initial Fabric Loom project scaffold. **It is not yet a playable port**: the furnace ignition hooks, Switchgrass content, recipes, and environmental ignition logic remain to be implemented and tested.

See [`PORTING_STATUS.md`](PORTING_STATUS.md) for the feature checklist and findings from inspecting the original JAR.

## Build

Requires JDK 21 and Gradle. From the repository root:

```sh
gradle build
```

The project uses Fabric Loom, Minecraft 1.21.11, Yarn mappings, Fabric Loader, and Fabric API. The produced mod should not be installed into a real game profile until the implementation and client/server tests are complete.
