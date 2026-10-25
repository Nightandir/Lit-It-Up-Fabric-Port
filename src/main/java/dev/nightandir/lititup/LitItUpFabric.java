package dev.nightandir.lititup;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class LitItUpFabric implements ModInitializer {
    public static final String MOD_ID = "lititup_fabric";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Lit It Up Fabric port initializing for Minecraft 1.21.11");
        // Feature registrations and furnace ignition hooks are added in the porting steps.
    }
}
