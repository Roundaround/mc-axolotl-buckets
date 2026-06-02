package me.roundaround.axolotlbuckets.client;

import me.roundaround.allay.api.Entrypoint;
import net.fabricmc.api.ClientModInitializer;

@Entrypoint(Entrypoint.CLIENT)
public class AxolotlBucketsClientMod implements ClientModInitializer {
  @Override
  public void onInitializeClient() {
    AxolotlBucketsClient.initClient();
  }
}
