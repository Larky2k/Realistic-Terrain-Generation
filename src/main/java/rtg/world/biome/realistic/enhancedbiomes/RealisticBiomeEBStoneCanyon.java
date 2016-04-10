package rtg.world.biome.realistic.enhancedbiomes;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import rtg.api.biome.BiomeConfig;
import rtg.api.biome.enhancedbiomes.config.BiomeConfigEBStoneCanyon;
import rtg.world.biome.deco.DecoEBTree;
import rtg.world.biome.deco.DecoEBTree.TreeType;
import rtg.world.biome.deco.DecoFallenTree;
import rtg.world.biome.deco.DecoFallenTree.LogCondition;
import rtg.world.biome.deco.DecoGrass;
import rtg.world.biome.deco.DecoShrub;
import rtg.world.biome.deco.DecoTree.TreeCondition;
import rtg.world.gen.surface.enhancedbiomes.SurfaceEBStoneCanyon;
import rtg.world.gen.terrain.enhancedbiomes.TerrainEBStoneCanyon;
import enhancedbiomes.api.EBAPI;
import enhancedbiomes.blocks.EnhancedBiomesBlocks;

public class RealisticBiomeEBStoneCanyon extends RealisticBiomeEBBase
{
    public static Block[] ebDominantStoneBlock = new Block[]{
        EBAPI.ebStonify(EnhancedBiomesBlocks.stoneEB, Blocks.stone),
        EBAPI.ebStonify(EnhancedBiomesBlocks.stoneEB, Blocks.stone)
    };
    
    public static byte[] ebDominantStoneMeta = new byte[]{
        EBAPI.ebStonify(EBAPI.BASALT, (byte)0),
        EBAPI.ebStonify(EBAPI.GABBRO, (byte)0)
    };
    
    public static Block[] ebDominantCobblestoneBlock = new Block[]{
        EBAPI.ebStonify(EnhancedBiomesBlocks.stoneCobbleEB, Blocks.cobblestone),
        EBAPI.ebStonify(EnhancedBiomesBlocks.stoneCobbleEB, Blocks.cobblestone)
    };
    
    public static byte[] ebDominantCobblestoneMeta = new byte[]{
        EBAPI.ebStonify(EBAPI.BASALT, (byte)0),
        EBAPI.ebStonify(EBAPI.GABBRO, (byte)0)
    };
    
    private static Block ebTopBlock =EBAPI.ebStonify(EnhancedBiomesBlocks.stoneEB, Blocks.stone);
    private static byte ebTopByte = EBAPI.ebStonify(EBAPI.GABBRO, (byte)0);
    private static Block ebFillBlock = EBAPI.ebStonify(EnhancedBiomesBlocks.stoneEB, Blocks.stone);
    private static byte ebFillByte = EBAPI.ebStonify(EBAPI.BASALT, (byte)0);
    private static Block ebMixTopBlock = EBAPI.ebGrassify(Blocks.dirt, Blocks.dirt);
    private static byte ebMixTopByte = EBAPI.ebGrassify(EBAPI.ALFISOL, (byte)0);
    private static Block ebMixFillBlock = EBAPI.ebStonify(EnhancedBiomesBlocks.stoneEB, Blocks.stone);
    private static byte ebMixFillByte = EBAPI.ebStonify(EBAPI.GABBRO, (byte)0);
    private static Block ebCliff1Block = EBAPI.ebStonify(EnhancedBiomesBlocks.stoneEB, Blocks.stone);
    private static byte ebCliff1Byte = EBAPI.ebStonify(EBAPI.BASALT, (byte)0);
    private static Block ebCliff2Block = EBAPI.ebStonify(EnhancedBiomesBlocks.stoneCobbleEB, Blocks.stone);
    private static byte ebCliff2Byte = EBAPI.ebStonify(EBAPI.BASALT, (byte)0);
    
	public RealisticBiomeEBStoneCanyon(BiomeGenBase ebBiome, BiomeConfig config)
	{
		super(config, 
			ebBiome, BiomeGenBase.river,
			new TerrainEBStoneCanyon(false, 35f, 60),
			new SurfaceEBStoneCanyon(config,
                ebTopBlock, //Block top 
                ebTopByte, //byte topByte
                ebFillBlock, //Block filler, 
                ebFillByte, //byte fillerByte
                ebMixTopBlock, //Block mixTop, 
                ebMixTopByte, //byte mixTopByte, 
                ebMixFillBlock, //Block mixFill, 
                ebMixFillByte, //byte mixFillByte, 
                ebCliff1Block, //Block cliff1, 
                ebCliff1Byte, //byte cliff1Byte, 
                ebCliff2Block, //Block cliff2, 
                ebCliff2Byte, //byte cliff2Byte, 
                80f, //float mixWidth, 
                -0.15f, //float mixHeight, 
                10f, //float smallWidth, 
                0.5f //float smallStrength
            )
		);
        
        DecoEBTree ebTrees = new DecoEBTree();
		ebTrees.treeType = TreeType.BIRCH;
		ebTrees.strengthFactorForLoops = 3f;
		ebTrees.distribution.noiseDivisor = 80f;
		ebTrees.distribution.noiseFactor = 60f;
		ebTrees.distribution.noiseAddend = -15f;
		ebTrees.treeCondition = TreeCondition.NOISE_GREATER_AND_RANDOM_CHANCE;
		ebTrees.treeConditionNoise = 5f;
		ebTrees.treeConditionChance = 4;
		ebTrees.maxY = 120;
		this.addDeco(ebTrees);
        
        DecoFallenTree decoFallenTree = new DecoFallenTree();
        decoFallenTree.logCondition = LogCondition.X_DIVIDED_BY_STRENGTH;
        decoFallenTree.logConditionNoise = 16f;
        decoFallenTree.logConditionChance = 8;
        decoFallenTree.maxY = 100;
        decoFallenTree.logBlock = Blocks.log;
        decoFallenTree.logMeta = (byte)2;
        decoFallenTree.leavesBlock = Blocks.leaves;
        decoFallenTree.leavesMeta = (byte)-1;
        decoFallenTree.minSize = 3;
        decoFallenTree.maxSize = 5;        
		this.addDeco(decoFallenTree, this.config._boolean(BiomeConfigEBStoneCanyon.decorationLogsId));
        
        DecoShrub decoShrub = new DecoShrub();
        decoShrub.maxY = 110;
        decoShrub.chance = 5;
        decoShrub.strengthFactor = 2f;
		this.addDeco(decoShrub);
        
		DecoGrass decoGrass = new DecoGrass();
		decoGrass.maxY = 128;
		decoGrass.chance = 1;
		decoGrass.strengthFactor = 12f;
        this.addDeco(decoGrass);
    }
}
