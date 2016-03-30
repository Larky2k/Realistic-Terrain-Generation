package rtg.world.biome.realistic.biomesoplenty;

import biomesoplenty.api.biome.BOPBiomes;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.BiomeGenBase;
import rtg.api.biome.BiomeConfig;
import rtg.world.gen.surface.biomesoplenty.SurfaceBOPTemperateRainforest;
import rtg.world.gen.terrain.biomesoplenty.TerrainBOPTemperateRainforest;

public class RealisticBiomeBOPTemperateRainforest extends RealisticBiomeBOPBase {
    public static BiomeGenBase bopBiome = BOPBiomes.temperate_rainforest.get();

    public static IBlockState topBlock = bopBiome.topBlock;
    public static IBlockState fillerBlock = bopBiome.fillerBlock;

    public RealisticBiomeBOPTemperateRainforest() {
        super(
                bopBiome, Biomes.river,
                new TerrainBOPTemperateRainforest(),
                new SurfaceBOPTemperateRainforest(config, topBlock, fillerBlock, false, null, 0.45f)
        );
    }
}
