package rtg.api.config;

import net.minecraft.init.Blocks;

import rtg.api.config.property.ConfigPropertyBlockstate;
import rtg.api.config.property.ConfigPropertyBoolean;
import rtg.api.config.property.ConfigPropertyFloat;
import rtg.api.config.property.ConfigPropertyInt;


public class DecoConfig extends Config {

    /*
     * GLOBAL CONFIGS
     */

    public final ConfigPropertyBoolean ALLOW;
    public final ConfigPropertyBoolean CHECK_RIVER;
    public final ConfigPropertyFloat MIN_RIVER;
    public final ConfigPropertyFloat MAX_RIVER;

    /*
     * OPTIONAL CONFIGS
     */

    public final ConfigPropertyInt MIN_Y;
    public final ConfigPropertyInt MAX_Y;
    public final ConfigPropertyInt LOOPS;
    public final ConfigPropertyInt CHANCE;
    public final ConfigPropertyInt EQUALS_ZERO_CHANCE;
    public final ConfigPropertyInt NOT_EQUALS_ZERO_CHANCE;
    public final ConfigPropertyFloat STRENGTH_FACTOR;
    public final ConfigPropertyBoolean CHECK_WATER;
    public final ConfigPropertyBlockstate BOULDER_BLOCK;

    public DecoConfig() {

        /*
         * GLOBAL CONFIGS
         */

        /**
         * If false, the deco won't get generated during chunk decoration.
         * Currently, the only deco that uses allow=false is the DecoBaseBiomeDecorations deco, and it only gets
         * set to false when we need to generate ores in biomes that don't let the base biome handle decoration at all.
         */
        ALLOW = new ConfigPropertyBoolean(
            "Allow",
            "",
            "Set to FALSE to prevent this deco from generating in this biome.",
            true
        );
        this.addProperty(ALLOW);

        CHECK_RIVER = new ConfigPropertyBoolean(
            "Check River",
            "",
            "Set to TRUE to have this deco check the river.",
            false
        );
        this.addProperty(CHECK_RIVER);

        MIN_RIVER = new ConfigPropertyFloat("Min River", "", "Minimum river value required to generate.", -2f, -2f, 2f);
        this.addProperty(MIN_RIVER);

        MAX_RIVER = new ConfigPropertyFloat("Min River", "", "Maximum river value required to generate.", -2f, -2f, 2f);
        this.addProperty(MAX_RIVER);

        /*
         * OPTIONAL CONFIGS
         *
         * These properties get 'added' by the individual decos when relevant, so don't 'add' them here.
         */

        MIN_Y = new ConfigPropertyInt("Min Y", "", "", 1, 1, 255);
        MAX_Y = new ConfigPropertyInt("Max Y", "", "", 255, 1, 255);
        LOOPS = new ConfigPropertyInt("Loops", "", "", 1, -1, Integer.MAX_VALUE);
        CHANCE = new ConfigPropertyInt("Chance", "", "", 1, 1, Integer.MAX_VALUE);
        EQUALS_ZERO_CHANCE = new ConfigPropertyInt("Equals Zero Chance", "", "", 1, 1, Integer.MAX_VALUE);
        NOT_EQUALS_ZERO_CHANCE = new ConfigPropertyInt("Not Equals Zero Chance", "", "", 1, 1, Integer.MAX_VALUE);
        STRENGTH_FACTOR = new ConfigPropertyFloat("Strength Factor", "", "", 2f, 0f, Float.MAX_VALUE);
        CHECK_WATER = new ConfigPropertyBoolean("Check Water", "", "", true);
        BOULDER_BLOCK = new ConfigPropertyBlockstate("Boulder Block", "", "", Blocks.COBBLESTONE.getDefaultState());
    }
}
