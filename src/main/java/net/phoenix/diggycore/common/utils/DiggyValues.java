package net.phoenix.diggycore.common.utils;

public class DiggyValues {

    public static int SECOND = 20; // contrary to gtvalues one this one is a int not a long.

    public static int clamp(int value, int min, int max) {
        return Math.max(min, Math.min(max, value)); // clamp number
    }
}
