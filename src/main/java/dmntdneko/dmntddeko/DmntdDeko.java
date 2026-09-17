package dmntdneko.dmntddeko;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import dmntdneko.dmntddeko.common.init.DmntdDekoBlocks;
import dmntdneko.dmntddeko.common.misc.TabDmntdDeko;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.item.Item;
import org.apache.logging.log4j.core.web.Log4jServletFilter;

@Mod(modid = DmntdDeko.MODID, version = DmntdDeko.VERSION)
public class DmntdDeko
{
    public static final String MODID = "dmntddeko";
    public static final String VERSION = "1.0";

    public static final TabDmntdDeko modTabBlocks =new TabDmntdDeko(CreativeTabs.getNextID(), "TabDekoBlocks");

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        DmntdDekoBlocks.init();

        modTabBlocks.setTabIconItem(Item.getItemFromBlock(DmntdDekoBlocks.blockMasonry));
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		// some example code
        System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
    }
}
