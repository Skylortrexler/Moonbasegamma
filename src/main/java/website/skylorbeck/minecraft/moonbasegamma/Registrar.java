package website.skylorbeck.minecraft.moonbasegamma;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Registrar {
    public static String MOD_ID = "moonbasegamma";
    public static FlowableFluid stillspace;
    public static FlowableFluid flowingspace;
    public static Block spacefluidblock;
    public static Item spacebucket;

    public static void Register(){
        stillspace = Registry.register(Registry.FLUID, new Identifier(MOD_ID, "stillspace"), new spacefluid.Still());
        flowingspace = Registry.register(Registry.FLUID, new Identifier(MOD_ID, "flowingspace"), new spacefluid.Flowing());
        spacefluidblock = Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "space"), new FluidBlock(stillspace, FabricBlockSettings.copy(Blocks.WATER)){});
        spacebucket = Registry.register(Registry.ITEM, new Identifier(MOD_ID, "spacebucket"), new BucketItem(stillspace, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1).group(ItemGroup.MISC)));
    }
}
