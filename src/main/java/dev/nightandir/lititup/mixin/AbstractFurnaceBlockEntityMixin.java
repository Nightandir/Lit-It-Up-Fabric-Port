package dev.nightandir.lititup.mixin;

import dev.nightandir.lititup.IgnitionTracked;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AbstractFurnaceBlockEntity.class)
public abstract class AbstractFurnaceBlockEntityMixin implements IgnitionTracked {
    @Unique private boolean lititup$ignitionToken;

    @Override
    public boolean lititup$consumeIgnitionToken() {
        boolean value = lititup$ignitionToken;
        lititup$ignitionToken = false;
        return value;
    }

    @Override
    public void lititup$setIgnitionToken(boolean value) {
        lititup$ignitionToken = value;
    }

    @Invoker("getFuelTime")
    private static int lititup$getFuelTime(ItemStack fuel) { throw new AssertionError(); }

    @Redirect(
        method = "serverTick",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/entity/AbstractFurnaceBlockEntity;getFuelTime(Lnet/minecraft/item/ItemStack;)I")
    )
    private static int lititup$requireManualIgnition(ItemStack fuel, World world, BlockPos pos, BlockState state, AbstractFurnaceBlockEntity furnace) {
        if (!((IgnitionTracked) furnace).lititup$consumeIgnitionToken()) return 0;
        return lititup$getFuelTime(fuel);
    }
}
