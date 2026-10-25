package dev.nightandir.lititup.mixin;

import dev.nightandir.lititup.LitItUpFabric;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AbstractFurnaceBlockEntity.class)
public abstract class AbstractFurnaceBlockEntityMixin {
    @Redirect(
        method = "serverTick",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/entity/AbstractFurnaceBlockEntity;getFuelTime(Lnet/minecraft/item/ItemStack;)I")
    )
    private static int lititup$requireManualIgnition(ItemStack fuel) {
        // The token is consumed by the companion mixin hook in the final implementation.
        // Returning zero here is safe until the ignition-token hook is wired to this call site.
        return 0;
    }
}
