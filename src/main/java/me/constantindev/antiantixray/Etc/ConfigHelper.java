package me.constantindev.antiantixray.Etc;

import net.minecraft.client.Minecraft;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_G;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_V;

@SuppressWarnings("ResultOfMethodCallIgnored")
public class ConfigHelper {

    public static int getScanKBFromFile() throws IOException {
        int kc = GLFW_KEY_G;
        File f = new File(Minecraft.getInstance().gameDirectory.getAbsolutePath() + "/.aaxconfig");
        if (!f.exists()) {
            f.mkdir();
        }
        if (!f.isDirectory()) {
            f.delete();
            f.mkdir();
        }
        File sf = new File(f.getAbsolutePath() + "/scankb.bin");
        if (!sf.exists()) {
            sf.createNewFile();
            FileWriter fw = new FileWriter(sf);
            fw.write(kc + "\n");
            fw.flush();
            fw.close();
        }
        StringBuilder data = new StringBuilder();
        Scanner s = new Scanner(sf);
        while (s.hasNext()) {
            data.append(s.nextLine());
        }
        s.close();
        try {
            kc = Integer.parseInt(data.toString());
        } catch (Exception exc) {
            sf.delete();
            System.out.println(data);
        }
        return kc;
    }

    public static int getRemoveKBFromFile() throws IOException {
        int kc = GLFW_KEY_V;
        File f = new File(Minecraft.getInstance().gameDirectory.getAbsolutePath() + "/.aaxconfig");
        if (!f.exists()) {
            f.mkdir();
        }
        if (!f.isDirectory()) {
            f.delete();
            f.mkdir();
        }
        File sf = new File(f.getAbsolutePath() + "/rmkb.bin");
        if (!sf.exists()) {
            sf.createNewFile();
            FileWriter fw = new FileWriter(sf);
            fw.write(kc + "\n");
            fw.flush();
            fw.close();
        }
        StringBuilder data = new StringBuilder();
        Scanner s = new Scanner(sf);
        while (s.hasNext()) {
            data.append(s.nextLine());
        }
        s.close();
        try {
            kc = Integer.parseInt(data.toString());
        } catch (Exception exc) {
            sf.delete();
            System.out.println(data);
        }
        return kc;
    }

    public static void setScanKBToFile(int kb) throws IOException {

        File f = new File(Minecraft.getInstance().gameDirectory.getAbsolutePath() + "/.aaxconfig");
        if (!f.exists()) {
            f.mkdir();
        }
        if (!f.isDirectory()) {
            f.delete();
            f.mkdir();
        }
        File sf = new File(f.getAbsolutePath() + "/scankb.bin");
        if (sf.exists()) sf.delete();
        sf.createNewFile();
        FileWriter fw = new FileWriter(sf);
        fw.write(kb + "\n");
        fw.flush();
        fw.close();
    }

    public static void setRemoveKBToFile(int kb) throws IOException {
        File f = new File(Minecraft.getInstance().gameDirectory.getAbsolutePath() + "/.aaxconfig");
        if (!f.exists()) {
            f.mkdir();
        }
        if (!f.isDirectory()) {
            f.delete();
            f.mkdir();
        }
        File sf = new File(f.getAbsolutePath() + "/rmkb.bin");
        if (sf.exists()) sf.delete();
        sf.createNewFile();
        FileWriter fw = new FileWriter(sf);
        fw.write(kb + "\n");
        fw.flush();
        fw.close();
    }

    public static int getMenuKBFromFile() throws IOException {
        int kc = org.lwjgl.glfw.GLFW.GLFW_KEY_O;
        File f = new File(Minecraft.getInstance().gameDirectory.getAbsolutePath() + "/.aaxconfig");
        if (!f.exists()) f.mkdir();
        if (!f.isDirectory()) { f.delete(); f.mkdir(); }
        File sf = new File(f.getAbsolutePath() + "/menukb.bin");
        if (!sf.exists()) {
            sf.createNewFile();
            FileWriter fw = new FileWriter(sf);
            fw.write(kc + "\n");
            fw.flush();
            fw.close();
        }
        StringBuilder data = new StringBuilder();
        Scanner s = new Scanner(sf);
        while (s.hasNext()) data.append(s.nextLine());
        s.close();
        try { kc = Integer.parseInt(data.toString()); } 
        catch (Exception exc) { sf.delete(); }
        return kc;
    }

    public static void setMenuKBToFile(int kb) throws IOException {
        File f = new File(Minecraft.getInstance().gameDirectory.getAbsolutePath() + "/.aaxconfig");
        if (!f.exists()) f.mkdir();
        if (!f.isDirectory()) { f.delete(); f.mkdir(); }
        File sf = new File(f.getAbsolutePath() + "/menukb.bin");
        if (sf.exists()) sf.delete();
        sf.createNewFile();
        FileWriter fw = new FileWriter(sf);
        fw.write(kb + "\n");
        fw.flush();
        fw.close();
    }

    public static int getRadiusFromFile() throws IOException {
        int rad = 16;
        File f = new File(Minecraft.getInstance().gameDirectory.getAbsolutePath() + "/.aaxconfig");
        if (!f.exists()) {
            f.mkdir();
        }
        if (!f.isDirectory()) {
            f.delete();
            f.mkdir();
        }
        File sf = new File(f.getAbsolutePath() + "/radius.bin");
        if (!sf.exists()) {
            sf.createNewFile();
            FileWriter fw = new FileWriter(sf);
            fw.write(rad + "\n");
            fw.flush();
            fw.close();
        }
        StringBuilder data = new StringBuilder();
        Scanner s = new Scanner(sf);
        while (s.hasNext()) {
            data.append(s.nextLine());
        }
        s.close();
        try {
            rad = Integer.parseInt(data.toString());
        } catch (Exception exc) {
            sf.delete();
            System.out.println(data);
        }
        return rad;
    }

    public static void setRadiusToFile(int rad) throws IOException {
        File f = new File(Minecraft.getInstance().gameDirectory.getAbsolutePath() + "/.aaxconfig");
        if (!f.exists()) {
            f.mkdir();
        }
        if (!f.isDirectory()) {
            f.delete();
            f.mkdir();
        }
        File sf = new File(f.getAbsolutePath() + "/radius.bin");
        if (sf.exists()) sf.delete();
        sf.createNewFile();
        FileWriter fw = new FileWriter(sf);
        fw.write(rad + "\n");
        fw.flush();
        fw.close();
    }

    public static long getDelayFromFile() throws IOException {
        long delay = 10;
        File f = new File(Minecraft.getInstance().gameDirectory.getAbsolutePath() + "/.aaxconfig");
        if (!f.exists()) f.mkdir();
        File sf = new File(f.getAbsolutePath() + "/delay.bin");
        if (!sf.exists()) {
            sf.createNewFile();
            FileWriter fw = new FileWriter(sf);
            fw.write(delay + "\n");
            fw.close();
        } else {
            Scanner s = new Scanner(sf);
            if (s.hasNext()) delay = Long.parseLong(s.nextLine().trim());
            s.close();
        }
        return delay;
    }

    public static void setDelayToFile(long delay) throws IOException {
        File f = new File(Minecraft.getInstance().gameDirectory.getAbsolutePath() + "/.aaxconfig");
        if (!f.exists()) f.mkdir();
        File sf = new File(f.getAbsolutePath() + "/delay.bin");
        if (sf.exists()) sf.delete();
        sf.createNewFile();
        FileWriter fw = new FileWriter(sf);
        fw.write(delay + "\n");
        fw.close();
    }

    public static boolean getBooleanFromFile(String filename, boolean def) throws IOException {
        boolean val = def;
        File f = new File(Minecraft.getInstance().gameDirectory.getAbsolutePath() + "/.aaxconfig");
        if (!f.exists()) f.mkdir();
        File sf = new File(f.getAbsolutePath() + "/" + filename);
        if (!sf.exists()) {
            sf.createNewFile();
            FileWriter fw = new FileWriter(sf);
            fw.write(val + "\n");
            fw.close();
        } else {
            Scanner s = new Scanner(sf);
            if (s.hasNext()) val = Boolean.parseBoolean(s.nextLine().trim());
            s.close();
        }
        return val;
    }

    public static int getIntFromFile(String filename, int def) throws IOException {
        int val = def;
        File f = new File(Minecraft.getInstance().gameDirectory.getAbsolutePath() + "/.aaxconfig");
        if (!f.exists()) f.mkdir();
        File sf = new File(f.getAbsolutePath() + "/" + filename);
        if (!sf.exists()) {
            sf.createNewFile();
            FileWriter fw = new FileWriter(sf);
            fw.write(val + "\n");
            fw.close();
        } else {
            Scanner s = new Scanner(sf);
            if (s.hasNext()) val = Integer.parseInt(s.nextLine().trim());
            s.close();
        }
        return val;
    }

    public static void setIntToFile(String filename, int val) throws IOException {
        File f = new File(Minecraft.getInstance().gameDirectory.getAbsolutePath() + "/.aaxconfig");
        if (!f.exists()) f.mkdir();
        File sf = new File(f.getAbsolutePath() + "/" + filename);
        if (sf.exists()) sf.delete();
        sf.createNewFile();
        FileWriter fw = new FileWriter(sf);
        fw.write(val + "\n");
        fw.close();
    }

    public static void setBooleanToFile(String filename, boolean val) throws IOException {
        File f = new File(Minecraft.getInstance().gameDirectory.getAbsolutePath() + "/.aaxconfig");
        if (!f.exists()) f.mkdir();
        File sf = new File(f.getAbsolutePath() + "/" + filename);
        if (sf.exists()) sf.delete();
        sf.createNewFile();
        FileWriter fw = new FileWriter(sf);
        fw.write(val + "\n");
        fw.close();
    }
}




