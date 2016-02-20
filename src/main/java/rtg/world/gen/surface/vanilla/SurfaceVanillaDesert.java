package rtg.world.gen.surface.vanilla;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import rtg.api.biome.BiomeConfig;
import rtg.util.CellNoise;
import rtg.util.OpenSimplexNoise;
import rtg.world.gen.surface.SurfaceBase;

import java.util.Random;

public class SurfaceVanillaDesert extends SurfaceBase
{
	public SurfaceVanillaDesert(BiomeConfig config, Block top, Block fill) 
	{
	    super(config, top, (byte)0, fill, (byte)0);
	}
	
	@Override
	public void paintTerrain(ChunkPrimer primer, int i, int j, int x, int y, int depth, World world, Random rand, OpenSimplexNoise simplex, CellNoise cell, float[] noise, float river, BiomeGenBase[] base)
	{
		boolean water = false;
		boolean riverPaint = false;
		boolean grass = false;
		
		if(river > 0.05f && river + (simplex.noise2(i / 10f, j / 10f) * 0.1f) > 0.86f)
		{
			riverPaint = true;
			
			if(simplex.noise2(i / 12f, j / 12f) > 0.25f)
			{
				grass = true;
			}
		}
		
		Block b;
		for(int k = 255; k > -1; k--)
		{
			b = primer.getBlockState((y * 16 + x) * 256 + k).getBlock();
            if(b == Blocks.air)
            {
            	depth = -1;
            }
            else if(b == Blocks.stone)
            {
            	depth++;

            	if(riverPaint)
            	{
            		if(grass && depth < 4)
            		{
    	        		primer.setBlockState((y * 16 + x) * 256 + k, Blocks.grass.getDefaultState());
            		}
            		else if(depth == 0)
            		{
    	        		primer.setBlockState((y * 16 + x) * 256 + k, rand.nextInt(2) == 0 ? Blocks.sand.getDefaultState() : Blocks.sandstone.getDefaultState());
            		}
            	}
        		else if(depth > -1 && depth < 9)
        		{
        			primer.setBlockState((y * 16 + x) * 256 + k, Blocks.sand.getDefaultState());
            		if(depth == 0 && k > 61 && k < 254);
        		}
            }

            
		}
	}
}
