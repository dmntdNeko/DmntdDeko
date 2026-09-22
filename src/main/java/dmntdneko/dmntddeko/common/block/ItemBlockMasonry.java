package dmntdneko.dmntddeko.common.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemBlockMasonry extends ItemBlockWithMetadata {
    public ItemBlockMasonry(Block block) {
        super(block, block);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        int meta = stack.getItemDamage();
        if (meta < 0 || meta >= BlockMixedBricks.TYPES.length) meta = 0;

        return super.getUnlocalizedName() + "_" + BlockMixedBricks.TYPES[meta];
    }
}
