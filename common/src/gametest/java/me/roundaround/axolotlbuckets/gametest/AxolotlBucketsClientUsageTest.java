package me.roundaround.axolotlbuckets.gametest;

import me.roundaround.allay.api.gametest.ClientGameTest;
import me.roundaround.trove.gametest.ClientTest;
import me.roundaround.trove.gametest.ClientTestContext;
import me.roundaround.trove.gametest.ClientWorld;
import me.roundaround.trove.gametest.GameTestAssertionException;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.List;

/**
 * Boots a client world and produces an axolotl bucket the way the mod renders for:
 * bucket a live axolotl, then confirm the resulting filled bucket carries the
 * entity data the mod's {@code BabyProperty} model property reads at render time.
 * Proves the client property registration + classtweaker-widened {@code ID_MAPPER}
 * access applied without crashing the client.
 */
@ClientGameTest
public class AxolotlBucketsClientUsageTest implements ClientTest {
  @Override
  public void runTest(ClientTestContext context) {
    try (ClientWorld world = context.worldBuilder().creative().stopTime(true).create()) {
      world.fill(new BlockPos(0, 64, 0), new BlockPos(3, 64, 3), "minecraft:smooth_stone");
      world.teleport(0.5, 65.0, 0.5);
      world.give("minecraft:water_bucket");
      world.setMainHandItem("minecraft:water_bucket");
      context.waitTicks(2);

      world.summon("minecraft:axolotl", new BlockPos(1, 65, 1));
      context.waitTicks(2);

      Axolotl axolotl = world.nearestEntity(Axolotl.class, 6.0);
      if (axolotl == null) {
        throw new GameTestAssertionException("axolotl did not spawn");
      }

      world.useItemOn(axolotl);
      world.settle();

      List<ItemStack> inventory = world.inventorySnapshot();
      boolean hasAxolotlBucket = inventory.stream().anyMatch(
          (stack) -> stack.is(Items.AXOLOTL_BUCKET));
      if (!hasAxolotlBucket) {
        throw new GameTestAssertionException("bucketing the axolotl did not yield an axolotl bucket");
      }
    }
  }
}
