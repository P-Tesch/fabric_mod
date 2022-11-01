package com.tesch.typemoon.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.tesch.typemoon.TypeMoonMod;
import com.tesch.typemoon.items.FragarachItem;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;

@Mixin(PlayerEntity.class)
public class OnDamageReceivedMixin {

    @Inject(at = @At("HEAD"), method = "applyDamage")
    public void applyDamage(DamageSource source, float amount, CallbackInfo info) {
        TypeMoonMod.LOGGER.info("Mixin");
        FragarachItem.onDamageReceived(source, amount, ((PlayerEntity)(Object)this));
    }
}
