package com.ryanddawkins.glowing_spice.test;

import com.ryanddawkins.glowing_spice.Glowing_Assert;
import com.ryanddawkins.glowing_spice.MovieList;

public class Test_MovieList extends Glowing_Assert
{
	public static void main(String[] args)
	{
		MovieList movieList = MovieList.create("/media/ryan/Passport/Videos");
	}
}