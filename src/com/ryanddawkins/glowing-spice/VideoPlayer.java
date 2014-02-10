package com.ryanddawkins.glowing_spice;

import javax.swing.JFrame;
import java.awt.Toolkit;

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

    public static void main(String[] args)
    {
	VideoPlayer v = new VideoPlayer();
    }

    private final EmbeddedMediaPlayerComponent mediaPlayerComponent;

    public VideoPlayer()
    {
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	Toolkit tk = Toolkit.getDefaultToolkit();
	int xsize = ((int) tk.getScreenSize().getWidth());
	int ysize = ((int) tk.getScreenSize().getHeight());
	this.setSize(xsize, ysize);
	
	mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
	this.setContentPane(this.mediaPlayerComponent);

	this.setVisible(true);

    }
}
