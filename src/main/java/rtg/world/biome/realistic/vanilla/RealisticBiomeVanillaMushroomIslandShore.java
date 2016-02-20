package rtg.world.biome.realistic.vanilla;

import rtg.api.biome.BiomeConfig;
import rtg.world.gen.surface.vanilla.SurfaceVanillaMushroomIslandShore;
import rtg.world.gen.terrain.vanilla.TerrainVanillaMushroomIslandShore;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

public class RealisticBiomeVanillaMushroomIslandShore extends RealisticBiomeVanillaBase
{	
	public static Block topBlock = BiomeGenBase.mushroomIslandShore.topBlock.getBlock();
	public static Block fillerBlock = BiomeGenBase.mushroomIslandShore.fillerBlock.getBlock();
	
	public RealisticBiomeVanillaMushroomIslandShore(BiomeConfig config)
	{
		super(config, 
			BiomeGenBase.mushroomIslandShore,
			BiomeGenBase.river,
			new TerrainVanillaMushroomIslandShore(),
			new SurfaceVanillaMushroomIslandShore(config, topBlock, fillerBlock, 67, topBlock, 0f)
		);
	}	
}
