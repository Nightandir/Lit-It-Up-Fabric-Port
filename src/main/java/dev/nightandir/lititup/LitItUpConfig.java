package dev.nightandir.lititup;

import net.minecraft.util.Identifier;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/** Runtime defaults for the first Fabric port iteration. */
public final class LitItUpConfig {
    private LitItUpConfig() {}

    /** Block IDs that may ignite a furnace from below when not raining. */
    public static final Set<Identifier> HOT_BLOCKS = ConcurrentHashMap.newKeySet();

    static {
        HOT_BLOCKS.add(Identifier.ofVanilla("lava"));
        HOT_BLOCKS.add(Identifier.ofVanilla("fire"));
        HOT_BLOCKS.add(Identifier.ofVanilla("soul_fire"));
        HOT_BLOCKS.add(Identifier.ofVanilla("magma_block"));
        HOT_BLOCKS.add(Identifier.ofVanilla("campfire"));
        HOT_BLOCKS.add(Identifier.ofVanilla("soul_campfire"));
    }
}
