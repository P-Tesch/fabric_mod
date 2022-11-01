package com.tesch.typemoon.items;

import com.tesch.typemoon.TypeMoonDamageSource;

import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class FragarachItem extends SwordItem {

  public FragarachItem() {
      super(ToolMaterials.IRON, 1, 1.0F, new Settings().maxCount(1).group(TypeMoonItemGroups.TYPE_MOON_ITEM_GROUP));
  }

  @Override
  public boolean damage(DamageSource source) {
      DamageSource.thorns(source.getAttacker());
      return true;
    }

  @Override
  public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
      user.playSound(SoundEvents.BLOCK_WOOL_BREAK, 1.0F, 1.0F);
      return TypedActionResult.success(user.getStackInHand(hand));
    }
  
  public static void onDamageReceived(DamageSource source, float amount, PlayerEntity defender) {
    Entity attacker = source.getAttacker();

    if (defender.getMainHandStack().getItem() instanceof FragarachItem || defender.getOffHandStack().getItem() instanceof FragarachItem) {
      attacker.damage((new TypeMoonDamageSource("fragarach")), amount);
      if (!attacker.isAlive()) {
        defender.heal(amount);
      }
    }
  }
}
