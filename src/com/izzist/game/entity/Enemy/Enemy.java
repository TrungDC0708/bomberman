package com.izzist.game.entity.Enemy;

import com.izzist.game.entity.Character;
import com.izzist.game.graphics.Sprite;
import com.izzist.game.ultility.Vector2D;

import java.awt.*;

public abstract class Enemy extends Character {
    public Enemy(Vector2D position, int size) {
        super(position, size);
    }

    public Enemy(Sprite sprite, Vector2D position, int size) {
        super(sprite, position, size);
    }

}