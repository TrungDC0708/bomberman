package com.izzist.game.entity.Bomb;

import com.izzist.game.entity.Entity;
import com.izzist.game.graphics.Animation;
import com.izzist.game.graphics.Sprite;
import com.izzist.game.states.PlayState;
import com.izzist.game.ultility.Vector2D;

import java.awt.*;

public class Bomb extends Entity {
    private int explodeTime = 150;
    private boolean isExploded = false;

    public Bomb(Vector2D position, int size) {
        super(position, size);
        this.sprite = new Sprite("font/BombGreen_16_16.png", 16, 16);
        animation = new Animation();
        setAnimation2(sprite.getSpriteArray2(0),30);
        int xt=(int)(position.x+16)/32;
        int yt = (int)(position.y+16)/32;
        this.position.x = xt*32;
        this.position.y = yt*32;
    }

    public void setIsExploded(boolean exploded) {
        this.isExploded = exploded;
    }

    public boolean getIsExploded() {
        return isExploded;
    }

    @Override
    public void render(Graphics2D g2D) {
            g2D.drawImage(animation.getImage(), (int) (position.x), (int) (position.y), size, size, null);

    }

    @Override
    public void update() {
        animation.update();
        if (explodeTime > 0) {
            isExploded = false;
            explodeTime--;
        } else if (explodeTime == 0) {
            isExploded = true;
            explodeTime = 150;
        }
    }

    public void animate(){
    }

    public void setPosition(int x, int y) {
        position.x = x;
        position.y = y;
    }

    public int getExplodeTime() {
        return explodeTime;
    }

    public void setExplodeTime(int explodeTime) {
        this.explodeTime = explodeTime;
    }

}