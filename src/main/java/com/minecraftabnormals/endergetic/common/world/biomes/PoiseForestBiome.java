package com.minecraftabnormals.endergetic.common.world.biomes;

import com.minecraftabnormals.endergetic.common.world.features.EEFeatures;
import com.minecraftabnormals.endergetic.common.world.surfacebuilders.EESurfaceBuilders;
import com.minecraftabnormals.endergetic.core.registry.EEEntities;

import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.MoodSoundAmbience;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.EndGatewayConfig;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.NoiseDependant;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.BiomeDictionary.Type;

public class PoiseForestBiome extends EndergeticBiome {

	public PoiseForestBiome() {
		super((new Builder()).surfaceBuilder(new ConfiguredSurfaceBuilder<>(SurfaceBuilder.DEFAULT, SurfaceBuilder.END_STONE_CONFIG)).precipitation(RainType.NONE).category(Category.THEEND).depth(0.1F).scale(0.2F).temperature(0.5F).downfall(0.5F).func_235097_a_((new BiomeAmbience.Builder()).setWaterColor(4159204).setWaterFogColor(329011).setFogColor(10518688).setMoodSound(MoodSoundAmbience.field_235027_b_).build()).parent((String)null), () -> new ConfiguredSurfaceBuilder<>(EESurfaceBuilders.POISE_SURFACE_BUILDER.get(), SurfaceBuilder.END_STONE_CONFIG));
	}
	
	@Override
	public void addSpawnsAndFeatures() {
		this.addFeature(Decoration.SURFACE_STRUCTURES, EEFeatures.POISE_DOME.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(3, 0.02F, 1))));
		this.addFeature(Decoration.SURFACE_STRUCTURES, EEFeatures.POISE_TREE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(2, 0.05F, 1))));
		this.addFeature(Decoration.SURFACE_STRUCTURES, EEFeatures.ENDERGETIC_GATEWAY.get().withConfiguration(EndGatewayConfig.func_214702_a(ServerWorld.field_241108_a_, true)).withPlacement(Placement.END_GATEWAY.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
		
		this.addFeature(Decoration.VEGETAL_DECORATION, EEFeatures.POISE_CLUSTER.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOISE_HEIGHTMAP_32.configure(new NoiseDependant(-0.8D, 4, 22))));
		this.addFeature(Decoration.VEGETAL_DECORATION, EEFeatures.PUFFBUG_HIVE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOISE_HEIGHTMAP_32.configure(new NoiseDependant(-0.8D, 9, 25))));
		this.addFeature(Decoration.VEGETAL_DECORATION, EEFeatures.BOLLOOM_BUD.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOISE_HEIGHTMAP_32.configure(new NoiseDependant(-0.9D, 90, 90))));
		this.addFeature(Decoration.VEGETAL_DECORATION, EEFeatures.POISE_TALLGRASS.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOISE_HEIGHTMAP_32.configure(new NoiseDependant(-0.8D, 0, 7))));
		this.addFeature(Decoration.VEGETAL_DECORATION, EEFeatures.POISE_GRASS.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOISE_HEIGHTMAP_DOUBLE.configure(new NoiseDependant(-0.8D, 5, 10))));
		
		this.addCreatureSpawn(EEEntities.BOOFLO_ADOLESCENT.get(), 5, 1, 2);
		this.addCreatureSpawn(EEEntities.BOOFLO.get(), 15, 1, 3);
		this.addCreatureSpawn(EEEntities.PUFF_BUG.get(), 10, 2, 4);
	}
	
	@Override
	public float getSpawningChance() {
		return 1.0F;
	}
	
	@Override
	public int getWeight() {
		return 6;
	}
	
	@Override
	public Type[] getBiomeTypes() {
		return new Type[] {
			Type.MAGICAL, 
			Type.FOREST, 
			Type.END
		};
	}
	
}