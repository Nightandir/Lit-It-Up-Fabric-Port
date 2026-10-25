package dev.nightandir.lititup;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class FurnaceIgnition {
    private FurnaceIgnition() {}

    public static void register() {
        UseBlockCallback.EVENT.register(FurnaceIgnition::onUseBlock);
    }

    private static ActionResult onUseBlock(PlayerEntity player, World world, Hand hand, BlockHitResult hit) {
        if (world.isClient()) return ActionResult.PASS;
        BlockPos pos = hit.getBlockPos();
        BlockState state = world.getBlockState(pos);
        if (!(state.getBlock() instanceof AbstractFurnaceBlock) ||
            !(world.getBlockEntity(pos) instanceof AbstractFurnaceBlockEntity furnace)) {
            return ActionResult.PASS;
        }

        ItemStack held = player.getStackInHand(hand);
        if (!held.isOf(Items.FLINT_AND_STEEL) || state.get(AbstractFurnaceBlock.LIT)) return ActionResult.PASS;

        ((IgnitionTracked) furnace).lititup$setIgnitionToken(true);
        held.damage(1, (ServerWorld) world, player, item -> {});
        player.swingHand(hand);
        return ActionResult.SUCCESS;
    }
}