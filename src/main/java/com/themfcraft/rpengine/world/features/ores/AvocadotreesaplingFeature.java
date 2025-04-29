package com.themfcraft.rpengine.world.features.ores;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.feature.template.IRuleTestType;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.ISeedReader;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.block.BlockState;

import java.util.Random;

import com.themfcraft.rpengine.init.RpEngineModBlocks;

import com.mojang.serialization.Codec;

@Mod.EventBusSubscriber
public class AvocadotreesaplingFeature {
	private static Feature<OreFeatureConfig> feature = null;
	private static ConfiguredFeature<?, ?> configuredFeature = null;
	private static IRuleTestType<AvocadotreesaplingFeatureRuleTest> CUSTOM_MATCH = null;

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	private static class AvocadotreesaplingFeatureRuleTest extends RuleTest {
		static final AvocadotreesaplingFeatureRuleTest INSTANCE = new AvocadotreesaplingFeatureRuleTest();
		static final Codec<AvocadotreesaplingFeatureRuleTest> codec = Codec.unit(() -> INSTANCE);

		public boolean test(BlockState blockAt, Random random) {
			boolean blockCriteria = false;
			if (BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:overworld_carver_replaceables")).contains(blockAt.getBlock()))
				blockCriteria = true;
			return blockCriteria;
		}

		protected IRuleTestType<?> getType() {
			return CUSTOM_MATCH;
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	private static class AvocadotreesaplingFeatureRegisterHandler {
		@SubscribeEvent
		public static void registerFeature(RegistryEvent.Register<Feature<?>> event) {
			CUSTOM_MATCH = Registry.register(Registry.RULE_TEST, new ResourceLocation("rp_engine:avocadotreesapling_match"), () -> AvocadotreesaplingFeatureRuleTest.codec);
			feature = new OreFeature(OreFeatureConfig.CODEC) {
				@Override
				public boolean generate(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, OreFeatureConfig config) {

					return super.generate(world, generator, rand, pos, config);
				}
			};

			configuredFeature = feature.withConfiguration(new OreFeatureConfig(AvocadotreesaplingFeatureRuleTest.INSTANCE, RpEngineModBlocks.AVOCADOTREESAPLING.get().getDefaultState(), 16))
					.withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 64))).square().func_242731_b(10);

			event.getRegistry().register(feature.setRegistryName("avocadotreesapling_ores"));
			Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation("rp_engine:avocadotreesapling_ores"), configuredFeature);
		}
	}

	@SubscribeEvent
	public static void addFeatureToBiomes(BiomeLoadingEvent event) {
		event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> configuredFeature);
	}
}
