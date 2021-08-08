package website.skylorbeck.minecraft.moonbasegamma;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AirBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Registrar {
    public static String MOD_ID = "moonbasegamma";
    public static Block spaceblock;
    public static Item spaceblockitem;

    public static void Register(){
        spaceblock = Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "spaceblock"), new AirBlock(FabricBlockSettings.copy(Blocks.WATER).dropsNothing().noCollision()){});
        spaceblockitem = Registry.register(Registry.ITEM,new Identifier(MOD_ID, "spaceblockitem"), new BlockItem(spaceblock,new FabricItemSettings().group(ItemGroup.MISC)));

    }
}
