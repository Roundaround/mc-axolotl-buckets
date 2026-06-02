package me.roundaround.axolotlbuckets.forge;

import me.roundaround.axolotlbuckets.client.AxolotlBucketsClient;
import me.roundaround.trove.forge.TroveForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("axolotlbuckets")
public final class AxolotlBucketsForgeMod {
  public AxolotlBucketsForgeMod(FMLJavaModLoadingContext context) {
    TroveForge.bootstrap(context);

    FMLClientSetupEvent.getBus(context.getModBusGroup())
        .addListener(event -> AxolotlBucketsClient.initClient());
  }
}
