package me.roundaround.axolotlbuckets.client;

import me.roundaround.axolotlbuckets.client.render.item.property.BabyProperty;
import me.roundaround.axolotlbuckets.generated.Constants;
import me.roundaround.trove.resource.BuiltinResourcePack;
import net.minecraft.network.chat.Component;

public final class AxolotlBucketsClient {
  public static final String RESOURCE_PACK_ID = "axolotl-buckets-small";

  private AxolotlBucketsClient() {}

  public static void initClient() {
    BabyProperty.register();

    BuiltinResourcePack.register(
        Constants.MOD_ID,
        RESOURCE_PACK_ID,
        Component.translatable("axolotlbuckets.resource.smaller"));
  }
}
