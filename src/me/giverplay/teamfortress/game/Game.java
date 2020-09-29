package me.giverplay.teamfortress.game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import me.giverplay.teamfortress.entity.Entity;
import me.giverplay.teamfortress.entity.entities.Player;
import me.giverplay.teamfortress.graphics.FontUtils;
import me.giverplay.teamfortress.graphics.Spritesheet;
import me.giverplay.teamfortress.graphics.UI;
import me.giverplay.teamfortress.world.World;

public class Game extends Canvas
{
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 320;
	public static final int HEIGHT = 240;
	public static final int SCALE = 2;
	
	private List<Entity> entities;
	
	private static Game game;
	
	private GameTask task;
	private Camera camera;
	private State state;
	private World world;
	private Player player;
	private UI ui;
	
	private BufferedImage image;
	private JFrame frame;
	
	private boolean isRunning = false;
	private boolean showMessage = true;
	
	private int messageFrames = 0;
	private int maxMessageFrames = 30;
	
	public static Game getGame()
	{
		return game;
	}
	
	public static void main(String[] args)
	{
		Spritesheet.init();
		Sound.init();
		
		new Game();
	}
	
	public Game()
	{
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		
		game = this;
		setupFrame();
		setupAssets();
		
		new Listeners(this);
		state = State.START;
		
		start();
	}
	
	
	private void setupFrame()
	{
		frame = new JFrame("Game 04 - Super Mario Clone");
		frame.add(this);
		frame.setResizable(false);
		frame.setUndecorated(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private void setupAssets()
	{
		ui = new UI();
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_BGR);
		camera = new Camera(0, 0);
		entities = new ArrayList<>();
	}
	
	public void startGame()
	{
		state = State.LOADING;
		entities.clear();
		
		player = new Player(0, 0);
		world = new World();
		
		entities.add(player);
		state = State.NORMAL;
	}
	
	private void start()
	{
		startGame();
		isRunning = true;
		task = new GameTask(this);
	}
	
	public void tick()
	{
		if(state.doGameTick())
		{
			for(int i = 0; i < entities.size(); i++) entities.get(i).tick();
		}
		
		if(state.doMenuTick())
		{
		
		}
	}
	
	public boolean isRunning()
	{
		return isRunning;
	}
	
	public void render()
	{
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null)
		{
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = image.getGraphics();
		
		g.setColor(new Color(110, 200, 255));
		g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
		
		world.render(g);
		
		entities.sort(Entity.sortDepth);
		
		for(Entity entity : entities) entity.render(g);
		
		g.dispose();
		g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
		
		renderSmooth(g);
		
		if(state == State.GAME_OVER || state == State.VICTORY)
		{
			Graphics2D g2 = (Graphics2D) g;
			
			g2.setColor(new Color(0, 0, 0, 100));
			g2.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
			
			String txt = state == State.GAME_OVER ? "Game Over" : "Você Venceu!";
			g.setColor(Color.WHITE);
			g.setFont(FontUtils.getFont(32, Font.BOLD));
			g.drawString(txt, (WIDTH * SCALE - g.getFontMetrics(g.getFont()).stringWidth(txt)) / 2, HEIGHT * SCALE / 2);
			
			messageFrames++;
			
			if(messageFrames > maxMessageFrames)
			{
				messageFrames = 0;
				showMessage = !showMessage;
			}
			
			if(showMessage)
			{
				g.setFont(FontUtils.getFont(24, Font.BOLD));
				g.drawString("> Aperte ENTER para reiniciar <", (WIDTH * SCALE - g.getFontMetrics(g.getFont()).stringWidth("> Aperte ENTER para reiniciar <")) / 2, HEIGHT * SCALE / 2 + 28);
			}
		}
		
		bs.show();
	}
	
	public void renderSmooth(Graphics g)
	{
		ui.render(g);
		
		g.setColor(new Color(100, 100, 100));
		g.setFont(FontUtils.getFont(18, Font.PLAIN));
		
		// FPS
		g.setColor(Color.WHITE);
		g.setFont(FontUtils.getFont(11, Font.PLAIN));
		g.drawString("TICKS: " + task.getTpsAvg(), 2, 12);
		g.drawString("FPS: " + task.getFpsAvg(), 2, 24);
	}
	
	
	public Player getPlayer()
	{
		return this.player;
	}
	
	public World getWorld()
	{
		return this.world;
	}
	
	public List<Entity> getEntities()
	{
		return this.entities;
	}
	
	public Camera getCamera()
	{
		return this.camera;
	}
	
	public State getState()
	{
		return state;
	}
}
