package com.neotasker.view;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CustomImage {
    public static final String linuxpath = "src/main/java/com/neotasker/view/icons/";
    // public static final String windowspath = "src\\main\\java\\com\\neotasker\\view\\icons\\";
    public static final String windowspath = "/";

    public static Image createImage(String filename) {
        String platform = System.getProperty("os.name");
        String path;
        if (platform.toLowerCase().startsWith("win")) {
            path = windowspath;
        } else {
            path = linuxpath;
        }
        System.out.format("Platform: %s\n", platform);
        System.out.format("Path: '%s'\n", path);
        try {
            return ImageIO.read(new File(linuxpath + filename));
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
