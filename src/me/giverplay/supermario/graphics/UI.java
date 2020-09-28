package me.giverplay.supermario.graphics;

import static me.giverplay.supermario.Game.WIDTH;
import static me.giverplay.supermario.Game.HEIGHT;
import static me.giverplay.supermario.Game.SCALE;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import me.giverplay.supermario.Game;
import me.giverplay.supermario.entity.Entity;

public class UI
{
	private Game game;
	
	public UI()
	{
		game = Game.getGame();
	}
	
	public void render(Graphics g)
	{
		g.setColor(Color.YELLOW);
		g.setFont(FontUtils.getFont(16, Font.PLAIN));
		
		String txt = game.getCoins()  + "/" + game.getMaxCoins();
		int loc = WIDTH * SCALE - FontUtils.stringWidth(g, txt);
		
		g.drawString(txt, loc - 4, 22);
		g.drawImage(Entity.SPRITE_COINS, loc - 32, 4, 24, 24, null);
		
		g.setColor(Color.RED);
		String txt2 = game.getEnemyCount() + "/" + game.getMaxEnemies();
		int loc2 = WIDTH * SCALE - FontUtils.stringWidth(g, txt2);
		
		g.drawString(txt2, loc2 - 4, 50);
		g.drawImage(Entity.SPRITE_ENEMY[4], loc2 - 32, 28, 24, 24, null);
		
		int max = game.getPlayer().getMaxLife();
		int cur = game.getPlayer().getLife();
		int coe = 24;
		
		for(int i = 0; i < max; i++)
		{
			g.drawImage(i < cur ? Entity.SPRITE_LIFE_FULL : Entity.SPRITE_LIFE_NON_FULL, i * (coe + 5) + 5, HEIGHT * SCALE - coe -5, coe, coe, null);
		}
	}
}
