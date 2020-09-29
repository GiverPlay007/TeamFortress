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
import me.giverplay.teamfortress.entity.EntityHuman;
import me.giverplay.teamfortress.entity.EntityHumanType;
import me.giverplay.teamfortress.entity.entities.Enemy;
import me.giverplay.teamfortress.entity.entities.Player;
import me.giverplay.teamfortress.graphics.FontUtils;
import me.giverplay.teamfortress.graphics.Spritesheet;
import me.giverplay.teamfortress.graphics.UI;
import me.giverplay.teamfortress.world.World;

public class Game extends Canvas
{
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
	
	private List<Entity> entities;
	
	private static Game game;
	
	private GameTask task;
	private Camera camera;
	private State state;
	private World world;
	private Player player;
	private UI ui;
	
	private JFrame frame;
	
	private volatile boolean isRunning = false;
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
		//Sound.init();
		
		new Game();
	}
	
	public Game()
	{
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
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
		camera = new Camera(0, 0);
		entities = new ArrayList<>();
	}
	
	public void startGame()
	{
		state = State.LOADING;
		entities.clear();
		
		player = new Player(50, 50);
		world = new World();
		
		entities.add(player);
		state = State.NORMAL;
	}
	
	private void start()
	{
		startGame();
		isRunning = true;
		
		try
    {
		Thread.sleep(100);
    }catch(InterruptedException interruptedException){}
		
		task = new GameTask(this);
		
		teste();
	}
	
	void teste()
  {
    entities.add(new Enemy(100, 100, EntityHumanType.MINEIRO_BLUE));
    entities.add(new Enemy(140, 100, EntityHumanType.MINEIRO_PINK));
    
    entities.add(new Enemy(180, 100, EntityHumanType.FUZILEIRO_BLUE));
    entities.add(new Enemy(220, 100, EntityHumanType.FUZILEIRO_PINK));
    
    entities.add(new Enemy(100, 140, EntityHumanType.CARECA_BLUE));
    entities.add(new Enemy(140, 140, EntityHumanType.CARECA_PINK));
    
    entities.add(new Enemy(180, 140, EntityHumanType.SOLDADO_BLUE));
    entities.add(new Enemy(220, 140, EntityHumanType.SOLDADO_PINK));
    
    entities.add(new Enemy(140, 180, EntityHumanType.TERRORISTA_BLUE));
    entities.add(new Enemy(180, 180, EntityHumanType.TERRORISTA_PINK));
    state = State.NORMAL;
  }
	
	public void tick()
	{
		if(state.doGameTick())
		{
			for(int i = 0; i < entities.size(); i++)
			{
				entities.get(i).tick();
			}
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
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(new Color(110, 200, 255));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		world.render(g);
		
		entities.sort(Entity.sortDepth);
		
		for(Entity entity : entities) entity.render(g);
		
		renderSmooth(g);
		
		if(state == State.GAME_OVER || state == State.VICTORY)
		{
			Graphics2D g2 = (Graphics2D) g;
			
			g2.setColor(new Color(0, 0, 0, 100));
			g2.fillRect(0, 0, WIDTH, HEIGHT);
			
			String txt = state == State.GAME_OVER ? "Game Over" : "Você Venceu!";
			g.setColor(Color.WHITE);
			g.setFont(FontUtils.getFont(32, Font.BOLD));
			g.drawString(txt, (WIDTH - g.getFontMetrics(g.getFont()).stringWidth(txt)) / 2, HEIGHT / 2);
			
			messageFrames++;
			
			if(messageFrames > maxMessageFrames)
			{
				messageFrames = 0;
				showMessage = !showMessage;
			}
			
			if(showMessage)
			{
				g.setFont(FontUtils.getFont(24, Font.BOLD));
				g.drawString("> Aperte ENTER para reiniciar <", (WIDTH - g.getFontMetrics(g.getFont()).stringWidth("> Aperte ENTER para reiniciar <")) / 2, HEIGHT / 2 + 28);
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
