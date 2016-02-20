package rtg.world.biome.realistic.biomesoplenty;

import biomesoplenty.api.content.BOPCBiomes;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
import rtg.api.biome.BiomeConfig;
import rtg.world.gen.surface.biomesoplenty.SurfaceBOPTundra;
import rtg.world.gen.terrain.biomesoplenty.TerrainBOPTundra;

public class RealisticBiomeBOPTundra extends RealisticBiomeBOPBase
{	
	public static BiomeGenBase bopBiome = BOPCBiomes.tundra;
	
	public static Block topBlock = bopBiome.topBlock.getBlock();
	public static Block fillerBlock = bopBiome.fillerBlock.getBlock();
	
	public RealisticBiomeBOPTundra(BiomeConfig config)
	{
		super(config, 
			bopBiome, BiomeGenBase.river,
			new TerrainBOPTundra(),
			new SurfaceBOPTundra(config, topBlock, fillerBlock)
		);
	}
}
