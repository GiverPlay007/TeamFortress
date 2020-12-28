package me.giverplay.teamfortress.graphics;

import static me.giverplay.teamfortress.game.Game.WIDTH;
import static me.giverplay.teamfortress.game.Game.HEIGHT;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import java.awt.image.BufferedImage;
import me.giverplay.teamfortress.entity.EntityWeapon;
import me.giverplay.teamfortress.entity.entities.PlayerEntity;
import me.giverplay.teamfortress.game.Game;

public class UI
{
	private Game game;
	
	private int width = 140;
	private int height = 75;
	
	public UI()
	{
		game = Game.getGame();
	}
	
	public void render(Graphics g)
	{
		g.setColor(new Color(0, 0, 0, 192));
		g.fillRect(WIDTH - width - 10, 10, width, height);
		
		PlayerEntity player = game.getPlayer();
		EntityWeapon weapon = player.getEquippedWeapon();
		
		if(weapon != null)
		{
			BufferedImage sprite = weapon.getSprite();
			g.drawImage(sprite, WIDTH - width - 8, 12, sprite.getWidth() * 2, sprite.getHeight() * 2, null);
			
			g.setColor(Color.WHITE);
			g.drawRect(WIDTH - width - 10, 10, width, 12 + sprite.getHeight() * 2);
			g.drawRect(WIDTH - width - 10, 22 + sprite.getHeight() * 2, width, height - 12 - sprite.getHeight() * 2);
			
			String txt = weapon.getAmmo() + "/" + player.getAmmo(weapon.getAmmoType());
			int x = (WIDTH - 10) + ((width - g.getFontMetrics().stringWidth(txt)) / 2);
			g.setFont(new Font("arial", Font.BOLD, 14));
			g.drawString(txt, x, height + 8 - 10);
		}
	}
}
