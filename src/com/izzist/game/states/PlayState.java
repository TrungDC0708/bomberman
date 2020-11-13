package com.izzist.game.states;

import com.izzist.game.entity.Player;
import com.izzist.game.map.MapLoader;
import com.izzist.game.ultility.KeyHandler;
import com.izzist.game.ultility.Vector2D;


import java.awt.Graphics2D;

public class PlayState extends GameState {
    private Player player;
    private MapLoader m;

    public PlayState(GameStateManager gameStateManager) {
        super((gameStateManager));
        player = new Player(new Vector2D(32, 32), 32);
        m = new MapLoader();
        m.readMap();

    }

    @Override
    public void update() {
        player.update();

    }

    @Override
    public void input(KeyHandler key) {
        player.input(key);
    }

    @Override
    public void render(Graphics2D g2D) {
        m.render(g2D);
        player.render(g2D);

    }
}
