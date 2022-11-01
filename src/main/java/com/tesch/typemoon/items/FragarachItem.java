package com.tesch.typemoon.items;

import com.tesch.typemoon.TypeMoonDamageSource;

import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class FragarachItem extends SwordItem {

  public FragarachItem() {
      super(ToolMaterials.IRON, 1, 1.0F, new Settings().maxCount(1).group(TypeMoonItemGroups.TYPE_MOON_ITEM_GROUP));
  }

  @Override
  public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
    ItemStack stack = user.getStackInHand(hand);
    NbtCompound nbt = new NbtCompound();

    nbt.putBoolean("activated", !stack.getNbt().getBoolean("activated"));
    stack.setNbt(nbt);

    user.playSound(stack.getNbt().getBoolean("activated") ? SoundEvents.BLOCK_NOTE_BLOCK_PLING : SoundEvents.BLOCK_NOTE_BLOCK_BASS, 1.0F, 1.0F);

    return TypedActionResult.success(user.getStackInHand(hand));
  }
  
  public static void onDamageReceived(DamageSource source, float amount, PlayerEntity defender) {
    Entity attacker = source.getAttacker();
    if (attacker == null) return;

    ItemStack mainHandItem = defender.getMainHandStack();
    ItemStack offHandItem = defender.getOffHandStack();

    if ((mainHandItem.getItem() instanceof FragarachItem && mainHandItem.getNbt().getBoolean("activated")) 
      || (offHandItem.getItem() instanceof FragarachItem && offHandItem.getNbt().getBoolean("activated"))
      ) {

      attacker.damage((new TypeMoonDamageSource("fragarach")), amount);
      if (!attacker.isAlive()) {
        defender.heal(amount);
      }

      if (mainHandItem.getItem() instanceof FragarachItem) {
        mainHandItem.use(defender.getWorld(), defender, Hand.MAIN_HAND);
        defender.getItemCooldownManager().set(mainHandItem.getItem(), 20 * 30);
      }
      else {
        offHandItem.use(defender.getWorld(), defender, Hand.OFF_HAND);
        defender.getItemCooldownManager().set(offHandItem.getItem(), 20 * 30);
      }
    }
  }
}
