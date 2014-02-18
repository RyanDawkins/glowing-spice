package com.ryanddawkins.glowing_spice;

/**
 * Now playing is an class designed to store the data
 * for the currently playing file.
 *
 * @author Ryan Dawkins
 * @since 0.3
 * @package com.ryanddawkins.glowing_spice
 */

public class NowPlaying extends MediaFile<NowPlaying>
{

	protected NowPlaying getThis(){ return this; }

	public NowPlaying(String fileName)
	{
		super(fileName);
	}

}