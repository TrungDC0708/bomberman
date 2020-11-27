package com.izzist.game.managers;

import com.izzist.game.entity.Enemy.Enemy;

import java.awt.*;
import java.util.ArrayList;

public class EnemyManager {
    public static ArrayList<Enemy> enemies=new ArrayList<>();

    public EnemyManager() {

    }

    public static Enemy getEnemy(int x, int y) {
        Enemy temp = null;
        for (Enemy e : enemies) {
            if ((int)e.getPosition().x/32 == x && (int)e.getPosition().y/32 == y) {
                temp = e;
            }
        }
        return temp;
    }

    public void render(Graphics2D g2D){
        for (Enemy e : enemies) {
            e.render(g2D);
        }
    }

    public void update(){
        for (Enemy e : enemies) {
            e.update();
        }
        removeEnemies();
    }

    public void removeEnemies() {
        for (int i = enemies.size() - 1; i >= 0; i--) {
            if (!enemies.get(i).getIsAlive() && enemies.get(i).getDead_animation().playOnce()) {
                enemies.remove(i);
            }
        }
    }
}
