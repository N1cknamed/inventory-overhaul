package net.nick.inventoryoverheaul.mixin;

import net.minecraft.entity.player.PlayerInventory;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerInventory.class)
public abstract class PlayerInventoryMixin {
    @Shadow
    @Final
    @Mutable
    public static int MAIN_SIZE;
    @Shadow
    @Final
    @Mutable
    public static int OFF_HAND_SLOT;

    @Inject(method = "<clinit>",
            at = @At("TAIL"))
    private static void injectPlayerInventoryClinit(CallbackInfo ci) { //TODO: update method names
        MAIN_SIZE = 72;
        OFF_HAND_SLOT = 76;
    }

    @ModifyConstant(method = "getOccupiedSlotWithRoomForStack",
            constant = @Constant(intValue = 40))
    private int modifyGetOccupiedSlotWithRoomForStack(int original) {
        return 76;
    }
}

