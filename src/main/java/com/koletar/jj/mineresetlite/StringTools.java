package com.koletar.jj.mineresetlite;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.List;


/**
 * @author jjkoletar
 */
public class StringTools {
    /**
     * Build a spaced argument out of an array of args that don't contain spaces, due to the command delimiter.
     * @param args String array of args
     * @param start Number of elements to skip over/index to begin at
     * @param stop Number of elements at the <b>end of the array</b> to ignore, <u>not</u> a stopping index.
     * @return Reconstructed spaced argument
     */
    public static String buildSpacedArgument(String[] args, int start, int stop) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < args.length - stop; i++) {
            sb.append(args[i]);
            sb.append(" ");
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static String buildSpacedArgument(String[] args, int stop) {
        return buildSpacedArgument(args, 0, stop);
    }

    public static String buildSpacedArgument(String[] args) {
        return buildSpacedArgument(args, 0);
    }

    public static String buildList(Object[] items, String prefix, String suffix) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < items.length; i++) {
            sb.append(prefix);
            sb.append(Phrases.findName(items[i]));
            if (i < items.length - 1) {
                sb.append(suffix);
            }
        }
        return sb.toString();
    }

    public static String buildList(List<?> items, String prefix, String suffix) {
        return buildList(items.toArray(), prefix, suffix);
    }

    public static String locTo(Location location) {
        return location.getWorld().getName() + "," + location.getBlockX() + "," + location.getBlockY() + "," + location.getBlockZ() + "," + location.getYaw() + "," + location.getPitch();
    }

    public static Location locFrom(String s) {
        if (s == null) {
            return null;
        }
        String[] str = s.split(",");
        World world = Bukkit.getWorld(str[0]);
        int x = Integer.parseInt(str[1]);
        int y = Integer.parseInt(str[2]);
        int z = Integer.parseInt(str[3]);
        float yaw = Float.parseFloat(str[4]);
        float pitch = Float.parseFloat(str[5]);
        return new Location(world, x, y, z, yaw, pitch);
    }
}
