package me.giverplay.supermario.sound;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound
{
	public static Clips theme = load("/theme.wav");
	public static Clips ak_shoot = load("/ak_shoot.wav");
	public static Clips rpg_shoot = load("/rpg_shoot.wav");
	public static Clips rev_shoot = load("/revolver_shoot.wav");
	public static Clips shot_shoot = load("/shotgun_shoot.wav");
	public static Clips heal = load("/heal.wav");
	public static Clips explosion = load("/explosion.wav");
	public static Clips ammo = load("/ammo.wav");
	
	public static void init()
	{
		// Apenas corrigir o lag
	}
	
	public static class Clips
	{
		public Clip clips;
		
		public Clips(byte[] buffer) throws IllegalArgumentException, LineUnavailableException, IOException, UnsupportedAudioFileException
		{
			if(buffer == null)
			{
				throw new IllegalArgumentException("Buffer não pode ser nulo");
			}
			
			clips = AudioSystem.getClip();
			clips.open(AudioSystem.getAudioInputStream(new ByteArrayInputStream(buffer)));
		}
		
		public void play() throws IllegalStateException
		{
			if(clips == null)
			{
				throw new IllegalStateException("Clip é nulo");
			}
			
			clips.stop();
			clips.setFramePosition(0);
			clips.start();
		}
		
		public void loop() throws IllegalStateException
		{
			if(clips == null)
			{
				throw new IllegalStateException("Lista de clips est� vazia");
			}
			
			clips.loop(300);
		}
	}
	
	private static Clips load(String name)
	{
		try(ByteArrayOutputStream baos = new ByteArrayOutputStream();
				DataInputStream dis = new DataInputStream(Sound.class.getResourceAsStream(name)))
		{
			byte[] buffer = new byte[1024];
			
			int read = 0;
			
			while((read = dis.read(buffer)) >= 0)
			{
				baos.write(buffer, 0, read);
			}
			
			dis.close();
			
			byte[] data = baos.toByteArray();
			
			return new Clips(data);
		}
		catch(Exception e)
		{
			System.out.println("Erro ao carregar clip de áudio.");
			e.printStackTrace();
		}
		
		return null;
	}
}
