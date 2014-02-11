package com.ryanddawkins.glowing_spice;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import com.sun.jna.Native;

/**
 * Movie player class to integrate with VLC player
 *
 * @author Ryan Dawkins
 * @package com.ryanddawkins.glowing_spice
 * @since 0.1
 * @extends javax.swing.JFrame
 */
public class VideoPlayer extends JFrame
{

	private String playingFile;
    private final EmbeddedMediaPlayerComponent mediaPlayerComponent;

    /**
     * Constructor that creates the JFrame
     */
    public VideoPlayer()
    {
        // Sets fullscreen
		// Toolkit tk = Toolkit.getDefaultToolkit();
		// int xsize = ((int) tk.getScreenSize().getWidth());
		// int ysize = ((int) tk.getScreenSize().getHeight());
		// this.setSize(xsize, ysize);
        this.setExtendedState(MAXIMIZED_BOTH);
        setUndecorated(true);
		
        // Grabs mediaComponent to call functions on
		this.mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
		this.setContentPane(this.mediaPlayerComponent);

        // This is so we can implement our own windowAdapter
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                setVisible(false);
                pause();
            }
        });

		this.setVisible(false);
    }

    /**
     * Chainable method to play the given file by string name
     *
     * @param String path filepath to video file
     * @return VideoPlayer this
     */
    public VideoPlayer playFile(String path)
    {
    	this.mediaPlayerComponent.getMediaPlayer().playMedia(path);
    	this.playingFile = path;
    	return this;	
    }

    /**
     * Method to pause the movie by using the mediaPlayer object
     *
     * @return VideoPlayer this
     */
    public VideoPlayer pause()
    {
        this.mediaPlayerComponent.getMediaPlayer().pause();
        return this;
    }

}
