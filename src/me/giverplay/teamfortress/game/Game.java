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

import me.giverplay.teamfortress.entity.EntityHuman;
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
	
	private List<EntityHuman> entities;
	
	private static Game game;
	private static int FPS = 0;
	
	private Camera camera;
	private World world;
	private Player player;
	private UI ui;
	
	private BufferedImage image;
	private Thread thread;
	private JFrame frame;
	
	private boolean isRunning = false;
	private boolean showGameOver = true;
	private boolean morreu = false;
	
	private int gameOverFrames = 0;
	private int maxGameOverFrames = 30;
	private int coins = 0;
	private int maxCoins = 0;
	private int enemyC = 0;
	private int maxEnemyC = 0;
	
	public static Game getGame()
	{
		return game;
	}
	
	public Game()
	{
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		
		game = this;
		setupFrame();
		setupAssets();
		
		new Listeners(this);
	}
	
	public static void main(String[] args)
	{
		Spritesheet.init();
		Sound.init();
		
		new Game();
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
		coins = 0;
		maxCoins = 0;
		enemyC = 0;
		maxEnemyC = 0;
		
		entities = new ArrayList<>();
		
		camera = new Camera(0, 0);
		player = new Player(1, 1);
		world = new World("/World.png");
		
		ui = new UI();
		
		entities.add(player);
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_BGR);
		
		morreu = false;
	}
	
	public synchronized void start()
	{
		isRunning = true;
		new GameTask(this);
	}
	
	public synchronized void stop()
	{
		isRunning = false;
		
		try
		{
			thread.join();
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	public synchronized void tick()
	{
		if(!morreu)
		{
			for(int i = 0; i < entities.size(); i++) entities.get(i).tick();
		}
	}
	
	public boolean isRunning()
	{
		return isRunning;
	}
	
	public synchronized void render()
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
		
		entities.sort(EntityHuman.sortDepth);
		
		for(int i = 0; i < entities.size(); i++) entities.get(i).render(g);
		
		g.dispose();
		g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
		
		renderSmooth(g);
		
		if(1 == 2)
		{
			Graphics2D g2 = (Graphics2D) g;
			
			g2.setColor(new Color(0, 0, 0, 100));
			g2.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
			
			String txt = morreu ? "Game Over" : "Você Venceu!";
			g.setColor(Color.WHITE);
			g.setFont(FontUtils.getFont(32, Font.BOLD));
			g.drawString(txt, (WIDTH * SCALE - g.getFontMetrics(g.getFont()).stringWidth(txt)) / 2, HEIGHT * SCALE / 2);
			
			gameOverFrames++;
			
			if(gameOverFrames > maxGameOverFrames)
			{
				gameOverFrames = 0;
				showGameOver = !showGameOver;
			}
			
			if(showGameOver)
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
		g.drawString("FPS: " + FPS, 2, 12);
	}
	
	
	public Player getPlayer()
	{
		return this.player;
	}
	
	public World getWorld()
	{
		return this.world;
	}
	
	public List<EntityHuman> getEntities()
	{
		return this.entities;
	}
	
	public void matar()
	{
		this.morreu = true;
	}
	
	public Camera getCamera()
	{
		return this.camera;
	}
	
	public void addCoin()
	{
		this.coins++;
	}
	
	public void addMaxCoin()
	{
		this.maxCoins++;
	}
	
	public int getCoins()
	{
		return this.coins;
	}
	
	public int getMaxCoins()
	{
		return this.maxCoins;
	}
	
	public int getMaxEnemies()
	{
		return this.maxEnemyC;
	}
	
	public int getEnemyCount()
	{
		return this.enemyC;
	}
	
	public void addEnemyCount()
	{
		this.enemyC++;
	}
	
	public void addMaxEnemyCount()
	{
		this.maxEnemyC++;
	}
}
