import java.io.*;
import javax.sound.sampled.*;

//	plays sound clips 
public class Sound {
	public static void play(String filename){
		try{
		Clip clip = AudioSystem.getClip();
		clip.open(AudioSystem.getAudioInputStream(new File(filename)));
		clip.start();
		
		}
		catch (Exception e){
			e.printStackTrace(System.out);
		}
	}
}
