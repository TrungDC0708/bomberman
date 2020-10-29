package com.izzist.game.graphics;

import com.izzist.game.ultility.Vector2D;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Sprite {
    private BufferedImage spriteSheet = null;
    private BufferedImage[][] spriteArray;
    private final int TILE_SIZE = 32;
    private int width;
    private int height;

    private int spriteWidth;
    private int spriteHeight;

    public Sprite(String path) {
        width = TILE_SIZE;
        height = TILE_SIZE;

        spriteSheet = loadSprite(path);
        spriteWidth = spriteSheet.getWidth() / width;
        spriteHeight = spriteSheet.getHeight() / height;
        loadSpriteArray();
    }

    public Sprite(String path, int w, int h) {
        this.width = w;
        this.height = h;
        spriteSheet = loadSprite(path);
        spriteWidth = spriteSheet.getWidth() / width;
        spriteHeight = spriteSheet.getHeight() / height;
        loadSpriteArray();
    }


    public void setSize(int width, int height) {
        setWidth(width);
        setHeight(height);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
        spriteWidth = spriteSheet.getWidth() / width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
        spriteHeight = spriteSheet.getHeight() / height;
    }

    private BufferedImage loadSprite(String path) {
        BufferedImage sprite = null;
        try {
            sprite = ImageIO.read(getClass().getClassLoader().getResourceAsStream(path));
        } catch (Exception e) {
            System.out.println("could not load file" + path);

        }
        return sprite;
    }

    public void loadSpriteArray() {
        spriteArray = new BufferedImage[spriteWidth][spriteHeight];

        for (int i = 0; i < spriteWidth; i++) {
            for (int j = 0; j < spriteHeight; j++) {
                spriteArray[i][j] = getSprite(i, j);
            }
        }
    }

    public BufferedImage getSpriteSheet() {
        return spriteSheet;
    }

    public BufferedImage getSprite(int x, int y) {
        return spriteSheet.getSubimage(x * width, y * height, width, height);
    }

    public BufferedImage[] getSpriteArray(int i) {
        return spriteArray[i];
    }

    public BufferedImage[][] getSpriteArray2(int i) {
        return spriteArray;
    }

    public static void drawArray(Graphics2D g2D, ArrayList<BufferedImage> image, Vector2D vector2D,
                                 int width, int height, int xOffset, int yOffset) {
        float x = vector2D.getX();
        float y = vector2D.getY();

        for (int i = 0; i < image.size(); i++) {
            if (image.get(i) != null) {
                g2D.drawImage(image.get(i), (int) x, (int) y, width, height, null);
            }

            x += xOffset;
            y += yOffset;
        }
    }

    public static void drawArray(Graphics2D g2D, Font f, String word, Vector2D vector2D,
                                 int width, int height, int xOffset, int yOffset) {
        float x = vector2D.getX();
        float y = vector2D.getY();

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != 32) {
                g2D.drawImage(f.getFont(word.charAt(i)), (int) x, (int) y, width, height, null);
            }
        }

        x += xOffset;
        y += yOffset;
    }

}
