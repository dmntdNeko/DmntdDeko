package dmntdneko.dmntddeko.common.init;

import cpw.mods.fml.common.registry.GameRegistry;
import dmntdneko.dmntddeko.common.block.BlockMasonry;
import dmntdneko.dmntddeko.common.block.ItemBlockMasonry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class DmntdDekoBlocks {
    public static Block blockMasonry;

    public static void init() {
        blockMasonry = new BlockMasonry(Material.rock);

        GameRegistry.registerBlock(blockMasonry, ItemBlockMasonry.class, "masonry");
    }

}
