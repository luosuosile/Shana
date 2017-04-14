package com.mygdx.collision;

public class Collision {
	
	//Åö×²·½ÏòÅĞ¶Ï
	
	public static boolean collisionLeft(float x,float x2)
	{
		if( ( ( x - x2 ) > -50)  &&  ( (x - x2)   < 0))
		{
			return true;
		}
		return false;
	}
	
	public static  boolean collisionRight(float x, float x2)
	{
		if( ((x - x2) < 50  )&&((x-x2) > 0))
		{
			return true;
		}
		return false;
	}
	
	

}
