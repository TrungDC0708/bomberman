package com.izzist.game.ultility;

public class Vector2D {
    public float x;
    public float y;

    public static float worldX;
    public static float worldY;

    public Vector2D() {
        x = 0;
        y = 0;
    }

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D(Vector2D pos) {
        new Vector2D(pos.x, pos.y);
    }


    public void addX(float a) {
        this.x += a;
    }

    public void addY(float a) {
        this.y += a;
    }

    public void setVector(Vector2D vector2D) {
        this.x = vector2D.x;
        this.y = vector2D.y;
    }

    public void setVector(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public static void setWorldXY(float x, float y) {
        worldX = x;
        worldY = y;
    }

    public Vector2D getWorldXY() {
        return new Vector2D(x - worldX, y - worldY);
    }

    @Override
    public String toString() {
        return x + " , " + y;
    }
}