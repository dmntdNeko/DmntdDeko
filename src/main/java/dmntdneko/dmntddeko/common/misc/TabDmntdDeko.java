package dmntdneko.dmntddeko.common.misc;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TabDmntdDeko extends CreativeTabs {
    private Item tabIcon;
    private ItemStack iconStack;

    public TabDmntdDeko(String label) {super(label);}

    public TabDmntdDeko(int index, String label) {super(index, label);}

    public TabDmntdDeko setTabIconItem(Item item) {
        this.tabIcon = item;
        return this;
    }

    public TabDmntdDeko setTabIconStack(ItemStack stack) {
        this.iconStack = stack;
        return this;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem() {
        if (this.iconStack != null) {
            return this.iconStack.getItem();
        }
        return this.tabIcon;
    }

    @Override
    public ItemStack getIconItemStack() {
        if (this.iconStack != null) {
            return this.iconStack;
        }
        return super.getIconItemStack();
    }
}
