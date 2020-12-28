package me.giverplay.teamfortress.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Listeners implements KeyListener
{
	private Game game;
	
	public Listeners(Game game)
	{
		this.game = game;
		this.game.addKeyListener(this);
	}
	
	@Override
	public void keyPressed(KeyEvent event)
	{
	
	}
	
	@Override
	public void keyReleased(KeyEvent event)
	{
	
	}

	@Override
	public void keyTyped(KeyEvent arg0)
	{
	
	}
}
