package me.roundaround.axolotlbuckets.neoforge;

import me.roundaround.axolotlbuckets.client.AxolotlBucketsClient;
import me.roundaround.trove.neoforge.TroveNeoForge;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@Mod("axolotlbuckets")
public final class AxolotlBucketsNeoForgeMod {
  public AxolotlBucketsNeoForgeMod(IEventBus modBus, ModContainer container) {
    TroveNeoForge.bootstrap(modBus, container);

    modBus.addListener(FMLClientSetupEvent.class, event -> AxolotlBucketsClient.initClient());
  }
}
