package dmntdneko.dmntddeko.common.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dmntdneko.dmntddeko.DmntdDeko;
import dmntdneko.dmntddeko.common.util.DmntdUtil;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

import java.util.List;

public class BlockMasonry extends Block {
    public enum MasonryType {
        // A - Andesite, C - Clay Bricks, D - Diorite, G - Granite, M - Mud Bricks, P - Prismarine, R- Dark Prismarine, S - deepSlate
        // Pending: blackstone,
        riprap("riprap", 1, 1),
        mixed_bricks_ADG("mixed_bricks_ADG", 2, 3),
        mixed_bricks_ADS("mixed_bricks_ADS", 2, 3),
        mixed_bricks_CMPRS("mixed_bricks_CMPRS", 2, 3),
        mixed_bricks_CS("mixed_bricks_CS", 2, 3),
        mixed_bricks_DS("mixed_bricks_DS", 2, 3),
        mixed_bricks_DG("mixed_bricks_DG", 2, 3),
        mixed_bricks_PS("mixed_bricks_PS", 2, 3);


        public final String name;
        public final int sets;    // Vertical variations
        public final int counts;  // Lateral/Horizontal variations

        MasonryType(String name, int sets, int counts) {
            this.name = name;
            this.sets = sets;
            this.counts = counts;
        }
    }

    public static final MasonryType[] TYPES = MasonryType.values();

    @SideOnly(Side.CLIENT)
    private IIcon[][][] icons;

    public BlockMasonry(Material material) {
        super(material);
        this.setBlockName("dmntddeko.masonry");
        this.setHardness(2.0F);
        this.setResistance(10.0F);
        this.setCreativeTab(DmntdDeko.modTabBlocks);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        icons = new IIcon[TYPES.length][][];

        for (int meta = 0; meta < TYPES.length; meta++) {
            MasonryType type = TYPES[meta];
            icons[meta] = new IIcon[type.sets][];

            for (int i = 0; i < type.sets; i++) {
                icons[meta][i] = new IIcon[type.counts];

                for (int j = 0; j < type.counts; j++) {
                    String textureName = "dmntddeko:masonry/masonry_" + type.name;

                    if (type.sets > 1) textureName += "_" + i;
                    if (type.counts > 1) textureName += "_" + j;

                    icons[meta][i][j] = iconRegister.registerIcon(textureName);
                }
            }
        }
    }

    @Override
    public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side) {
        int meta = world.getBlockMetadata(x, y, z);
        if (meta < 0 || meta >= TYPES.length) meta = 0;

        MasonryType type = TYPES[meta];

        if (type.counts <= 1 && type.sets <= 1) {
            return icons[meta][0][0];
        }

        int variantVert = Math.abs(y) % type.sets;

        long hash = DmntdUtil.getCoordinateRandom(x, y, z);
        int variantLat = (int) (Math.abs(hash) % type.counts);

        return icons[meta][variantVert][variantLat];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        if (meta < 0 || meta >= TYPES.length) meta = 0;
        return icons[meta][0][0];
    }

    @Override
    public int damageDropped(int meta) {
        return meta;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tabs, List list) {
        for (int i = 0; i < TYPES.length; ++i) {
            list.add(new ItemStack(item, 1, i));
        }
    }
}
