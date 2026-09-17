package dmntdneko.dmntddeko.common.util;

public class DmntdUtil {
    public static long getCoordinateRandom(int x, int y, int z) {
        long hash = (long)(x * 73856093) ^ (long)z * 19115207L ^ (long)y;
        hash = hash * hash * 83492791L + hash * 13L;
        return hash;
    }
}