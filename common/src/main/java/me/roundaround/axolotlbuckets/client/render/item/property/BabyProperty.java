package me.roundaround.axolotlbuckets.client.render.item.property;

import com.mojang.serialization.MapCodec;
import me.roundaround.axolotlbuckets.generated.Constants;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.properties.conditional.ConditionalItemModelProperties;
import net.minecraft.client.renderer.item.properties.conditional.ConditionalItemModelProperty;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;

public record BabyProperty() implements ConditionalItemModelProperty {
  private static final String NBT_AGE = "Age";

  public static final MapCodec<BabyProperty> MAP_CODEC = MapCodec.unit(new BabyProperty());

  @Override
  public boolean get(
      ItemStack stack,
      ClientLevel level,
      LivingEntity owner,
      int seed,
      ItemDisplayContext displayContext
  ) {
    CompoundTag nbt =
        stack.getOrDefault(DataComponents.BUCKET_ENTITY_DATA, CustomData.EMPTY).copyTag();
    return nbt.getIntOr(NBT_AGE, 0) < 0;
  }

  @Override
  public MapCodec<BabyProperty> type() {
    return MAP_CODEC;
  }

  public static void register() {
    ConditionalItemModelProperties.ID_MAPPER.put(
        Identifier.fromNamespaceAndPath(Constants.MOD_ID, "baby"), MAP_CODEC);
  }
}
