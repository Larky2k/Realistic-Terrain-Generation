package rtg.world.gen.surface.atg;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import rtg.api.biome.BiomeConfig;
import rtg.util.CellNoise;
import rtg.util.CliffCalculator;
import rtg.util.OpenSimplexNoise;
import rtg.world.gen.surface.SurfaceBase;

import java.util.Random;

public class SurfaceATGGravelBeach extends SurfaceBase
{
	private Block cliffBlock1;
	private Block cliffBlock2;
	private byte sandMetadata;
	private int cliffType;
	
	public SurfaceATGGravelBeach(BiomeConfig config, Block top, Block filler, Block cliff1, Block cliff2, byte metadata, int cliff)
	{
		super(config, top, (byte)0, filler, (byte)0);
		
		cliffBlock1 = cliff1;
		cliffBlock2 = cliff2;
		sandMetadata = metadata;
		cliffType = cliff;
	}
	
	@Override
	public void paintTerrain(ChunkPrimer primer, int i, int j, int x, int y, int depth, World world, Random rand, OpenSimplexNoise simplex, CellNoise cell, float[] noise, float river, BiomeGenBase[] base)
	{
		float c = CliffCalculator.calc(x, y, noise);
		boolean cliff = c > 1.3f ? true : false;
		boolean dirt = false;

		for(int k = 255; k > -1; k--)
		{
			Block b = primer.getBlockState((y * 16 + x) * 256 + k).getBlock();
            if(b == Blocks.air)
            {
            	depth = -1;
            }
            else if(b == Blocks.stone)
            {
            	depth++;

            	if(cliff)
            	{
            		if(cliffType == 1)
            		{
            			if (depth < 6)
	            		{
                			primer.setBlockState((y * 16 + x) * 256 + k, cliffBlock1.getStateFromMeta(14));
	            		}
            		}
            		else
            		{
	            		if(depth > -1 && depth < 2)
	            		{
	            			primer.setBlockState((y * 16 + x) * 256 + k, rand.nextInt(3) == 0 ? cliffBlock2.getDefaultState() : cliffBlock1.getDefaultState());
	            		}
	            		else if (depth < 10)
	            		{
	            			primer.setBlockState((y * 16 + x) * 256 + k, cliffBlock1.getDefaultState());
	            		}
            		}
            	}
            	else if(depth < 6)
            	{
	        		if(depth == 0 && k > 61)
	        		{
	        			if(simplex.noise2(i / 12f, j / 12f) > -0.3f + ((k - 61f) / 15f))
	        			{
	        				dirt = true;
		        			primer.setBlockState((y * 16 + x) * 256 + k, topBlock);
	        			}
	        			else
	        			{
		        			primer.setBlockState((y * 16 + x) * 256 + k, Blocks.sand.getStateFromMeta(sandMetadata));
	        			}
	        		}
	        		else if(depth < 4)
	        		{
	        			if(dirt)
	        			{
	        				primer.setBlockState((y * 16 + x) * 256 + k, fillerBlock);
	        			}
	        			else
	        			{
	        				primer.setBlockState((y * 16 + x) * 256 + k, Blocks.sand.getStateFromMeta(sandMetadata));
	        			}
	        		}
	        		else if(!dirt)
	        		{
	        			primer.setBlockState((y * 16 + x) * 256 + k, Blocks.sandstone.getDefaultState());
	        		}
            	}
            }
		}
	}
}
