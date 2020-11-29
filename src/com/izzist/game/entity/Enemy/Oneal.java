package com.izzist.game.entity.Enemy;

import com.izzist.game.graphics.Animation;
import com.izzist.game.graphics.Sprite;
import com.izzist.game.ultility.Vector2D;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Oneal extends Enemy{
    public Oneal(Vector2D position, int size) {
        super(position,size);
        this.xOffSet = 4;
        this.yOffSet = 0;
        dead_animation.setFrames(Sprite.oneal_dead);
        dead_animation.setDelay(20);
        setAnimation(RIGHT, Sprite.oneal_right, 10);
        rectangle = new Rectangle2D.Float( position.x + xOffSet,
                position.y + yOffSet, 24, 32);
        speed = 0.5f;
    }

    public void animate() {
        if (random == 0) {
            if (currentAnimation != UP) {
                setAnimation(UP, Sprite.oneal_right, 10);
            }
        } else if (random == 1) {
            if (currentAnimation != DOWN) {
                setAnimation(DOWN, Sprite.oneal_left, 10);
            }
        } else if (random == 2) {
            if (currentAnimation != LEFT) {
                setAnimation(LEFT, Sprite.oneal_left, 10);
            }
        } else if (random == 3) {
            if (currentAnimation != RIGHT) {
                setAnimation(RIGHT, Sprite.oneal_right, 10);
            }
        }
    }

    @Override
    public void render(Graphics2D g2D) {
        g2D.drawRect((int)rectangle.getX(),(int)rectangle.getY(),(int)rectangle.getWidth(),(int)rectangle.getHeight());
        if (isAlive) {
            g2D.drawImage(animation.getImage(), (int) (position.x), (int) (position.y), size, size, null);
        } else {
            g2D.drawImage(dead_animation.getImage(), (int) (position.x), (int) (position.y), size, size, null);
        }
    }

    @Override
    public void update() {
        if (isAlive) {
            animation.update();
            move2();
            animate();
            randomDirection();
            moveCondition();
            updateRect();
        } else {
            rectangle = new Rectangle();
            dead_animation.update();
        }

        if (flameCollision()) {
            isAlive = false;
        }
    }

}
