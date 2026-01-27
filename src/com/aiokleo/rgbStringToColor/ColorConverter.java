package com.aiokleo.rgbStringToColor;

import java.awt.Color;

import java.util.ArrayList;
import java.util.List;

public class ColorConverter {

    // Converts Int -> 6-digit hex String
    public static String dec2hex(int dec) {
        return String.format("%06X", dec);
    }

    // Converts any hex String to Int
    public static int hex2dec(String hex) {
        return Integer.parseInt(hex, 16);
    }

    // Convert Hue, Saturation, Value -> Red, Green, Blue
    // ([Any]%360, [0,1], [0,1]) -> ([0,255], [0,255], [0,255])
    public static List<Double> hsv2rgb(List<Double> hsv) {
        float[] hsb = new float[]{hsv.get(0).floatValue(), hsv.get(1).floatValue(), hsv.get(2).floatValue()};
        int colorCode = Color.HSBtoRGB(hsb[0], hsb[1], hsb[2]);

        List<Double> rgbaBuffer = new ArrayList<>(3);

        rgbaBuffer.add((double) ((colorCode & 0x00ff0000) >> 16)); // r
        rgbaBuffer.add((double) ((colorCode & 0x0000ff00) >> 8));  // g
        rgbaBuffer.add((double) (colorCode & 0x000000ff));           // b

        return rgbaBuffer;
    }

    // Convert Red, Green, Blue -> Hue, Saturation, Value
    // ([0,255], [0,255], [0,255]) -> ([0,1], [0,1], [0,1])
    public static List<Double> rgb2hsv(List<Double> rgb) {
        Color color = new Color(rgb.get(0).intValue(), rgb.get(1).intValue(), rgb.get(2).intValue());
        float[] hsb = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
        List<Double> hsbList = new ArrayList<>(3);
        hsbList.add((double) hsb[0]);
        hsbList.add((double) hsb[1]);
        hsbList.add((double) hsb[2]);
        return hsbList;
    }

    // Converts hex String to Hue, Saturation, Value ([Any]%360, [0,1], [0,1])
    public static List<Double> hex2hsv(String hex) {
        List<Double> rgb = new ArrayList<>(3);
        rgb.add((double) hex2dec(hex.substring(0, 2)));
        rgb.add((double) hex2dec(hex.substring(2, 4)));
        rgb.add((double) hex2dec(hex.substring(4, 6)));
        return rgb2hsv(rgb);
    }

    // Converts Hue, Saturation, Value ([Any]%360, [0,1], [0,1]) to hex String
    public static String hsv2hex(List<Double> hsv) {
        List<Double> rgb = hsv2rgb(hsv);

        String rhex = String.format("%02X", rgb.get(0).intValue());
        String ghex = String.format("%02X", rgb.get(1).intValue());
        String bhex = String.format("%02X", rgb.get(2).intValue());

        return rhex + ghex + bhex;
    }

    public static String rgb2hex(List<Double> rgb) {
        return hsv2hex(rgb2hsv(rgb));
    }

    public static List<Double> hex2rgb(String hex) {
        return hsv2rgb(hex2hsv(hex));
    }

    public static int rgb2dec(List<Double> rgb) {
        return hex2dec(rgb2hex(rgb));
    }

    public static int hsv2dec(List<Double> hsv) {
        return hex2dec(hsv2hex(hsv));
    }

    public static List<Double> dec2rgb(int dec) {
        return hex2rgb(dec2hex(dec));
    }

    public static List<Double> dec2hsv(int dec) {
        return hex2hsv(dec2hex(dec));
    }

    public static void main(String[] args) {
        // Test the conversion functions here
    }
}
