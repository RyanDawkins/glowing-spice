package com.ryanddawkins.glowing_spice.test;

import com.ryanddawkins.glowing_spice.VideoPlayer;

public class Test_VideoPlayer
{
	
	public static void main(String[] args)
	{
		if(args.length > 0)
		{
			VideoPlayer player = new VideoPlayer().playFile(args[0]);
		}
	}

}