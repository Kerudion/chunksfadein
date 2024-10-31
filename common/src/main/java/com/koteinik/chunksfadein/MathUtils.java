package com.koteinik.chunksfadein;

import java.math.BigDecimal;
import java.math.RoundingMode;

import net.minecraft.world.phys.Vec3;

public class MathUtils {
    public static double clamp(double value, double min, double max) {
        return value < min ? min : value > max ? max : value;
    }

    public static float clamp(float value, float min, float max) {
        return value < min ? min : value > max ? max : value;
    }

    public static int clamp(int value, int min, int max) {
        return value < min ? min : value > max ? max : value;
    }

    public static float pow(float in, int times) {
        for (int i = -1; i < times; i++)
            in *= in;

        return in;
    }

    public static float abs(float in) {
        return in >= 0f ? in : -in;
    }

    public static Vec3 abs(Vec3 in) {
        return new Vec3(Math.abs(in.x), Math.abs(in.y), Math.abs(in.z));
    }

    public static int floor(float x) {
        final float f = x % 1f;
        if (x < 0f && f != 0f)
            x--;

        return f >= 0.5f ? (int) (x - 0.5f) : (int) x;
    }

    public static boolean chunkInRange(int aX, int aZ, int bX, int bZ, int radius) {
        return chunkInRange(aX, 0, aZ, bX, 0, bZ, radius);
    }

    public static boolean chunkInRange(int aX, int aY, int aZ, int bX, int bY, int bZ, int radius) {
        if (Math.abs(aX - bX) > radius)
            return false;
        if (Math.abs(aY - bY) > radius)
            return false;
        if (Math.abs(aZ - bZ) > radius)
            return false;

        return true;
    }

    public static float sqrt(float f) {
        return (float) Math.sqrt((double) f);
    }

    public static double round(double value) {
        return (double) Math.round(value);
    }

    public static double round(double value, int places) {
        if (places < 0)
            throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static float lerp(float a, float b, float factor) {
        return a + (b - a) * factor;
    }
}
