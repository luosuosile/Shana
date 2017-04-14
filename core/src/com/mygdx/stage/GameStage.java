package com.mygdx.stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.actor.Shana;
import com.mygdx.actor.Shana2;
import com.mygdx.collision.Collision;
import com.mygdx.game.Constants;
import com.mygdx.sound.BackgroundSound;

public class GameStage extends Stage{
	
	public Texture texture;
	Image background;
	Shana shana;
	Shana2 shana2;
	private BitmapFont font1;
	
	private static int P1X1 = 100;
	private static int P2X2 = 300;
	private static int P1Y1 = 190;
	private static int P2Y2 = 190;
	
	public GameStage()
	{
		this.init();
		BackgroundSound sound = new BackgroundSound();
	}
	
	public void init()
	{
		texture = new Texture(Gdx.files.internal("assets/gamestage.jpg"));
		background = new Image(texture);
		shana = new Shana(P1X1 , P1Y1);
		shana2 = new Shana2(P2X2,P2Y2); 
		this.addActor(background);
		this.addActor(shana2);
		this.addActor(shana);
		this.addListener(new InputListener()
		{
			@Override
			public boolean keyDown(InputEvent event , int keycode)
			{
				//P2×óÒÆ¶¯
				if(event.getKeyCode() == Input.Keys.LEFT)
				{
					shana2.STATE =shana2.LEFT_STATE;
					shana2.setisFacingRight(false);
				}
				//P1×óÒÆ¶¯
				if(event.getKeyCode() == Input.Keys.A)
				{
					shana.STATE =shana.LEFT_STATE;
					shana.setisFacingRight(false);
				}
				//P2ÓÒÒÆ¶¯
				else if(event.getKeyCode() == Input.Keys.RIGHT)
				{
					shana2.STATE = shana2.RIGHT_STATE;
					shana2.setisFacingRight(true);
				}
				//P1ÓÒÒÆ¶¯
				else if(event.getKeyCode() == Input.Keys.D)
				{
					shana.STATE = shana.RIGHT_STATE;
					shana.setisFacingRight(true);
				}
				//P2ÆÕÍ¨¹¥»÷
				else if(event.getKeyCode() == Input.Keys.NUMPAD_4)
				{
					shana.LEFTHURT=Collision.collisionLeft(shana.getX(),shana2.getX());
					shana.RIGHTHURT=Collision.collisionRight(shana.getX(), shana.getY());
					shana2.CLICK_NUMBER += 1;
					if(shana2.getisFacingRight())
					{
						if(shana2.CLICK_NUMBER == 1)
						shana2.STATE = shana2.RIGHT_ATKA_STATE;
						
						else if(shana2.CLICK_NUMBER ==2)
							shana2.STATE = shana2.RIGHT_ATKB_STATE;
						
						else if(shana2.CLICK_NUMBER ==3)
						{
							shana2.STATE = shana2.RIGHT_ATKC_STATE;
							shana2.CLICK_NUMBER = 0;
						}
						
						
						if(shana.LEFTHURT)
						{
							shana.HP -=10;
							shana.STATE = shana.HURT_STATE;
							shana.LEFTHURT = false;
						}
						else if(shana.RIGHTHURT)
						{
							shana.HP -=10;
							shana.STATE = shana.HURT_STATE;
							shana.RIGHTHURT = false;
						}
					}
					else
					{
						if(shana2.CLICK_NUMBER == 1)
						shana2.STATE = shana2.LEFT_ATKA_STATE;
						
						else if(shana2.CLICK_NUMBER ==2)
							shana2.STATE = shana2.LEFT_ATKB_STATE;
						
						else if(shana2.CLICK_NUMBER ==3)
						{
							shana2.STATE = shana2.LEFT_ATKC_STATE;
							shana2.CLICK_NUMBER = 0;
						}
						
						if(shana.LEFTHURT)
						{
							shana.HP -=10;
							shana.STATE = shana.HURT_STATE;
							shana.LEFTHURT = false;
						}
						else if(shana.RIGHTHURT)
						{
							shana.HP -=10;
							shana.STATE = shana.HURT_STATE;
							shana.RIGHTHURT = false;
						}
					}
					System.out.println(shana.LEFTHURT);
					System.out.println(shana.RIGHTHURT);
				}
				//P1ÆÕÍ¨¹¥»÷
				else if(event.getKeyCode() == Input.Keys.J)
				{
					shana2.LEFTHURT=Collision.collisionLeft(shana.getX(),shana2.getX());
					shana2.RIGHTHURT=Collision.collisionRight(shana.getX(), shana.getY());
					shana.CLICK_NUMBER += 1;
					if(shana.getisFacingRight())
					{
						if(shana.CLICK_NUMBER == 1)
						shana.STATE = shana.RIGHT_ATKA_STATE;
						
						else if(shana.CLICK_NUMBER ==2)
							shana.STATE = shana.RIGHT_ATKB_STATE;
						
						else if(shana.CLICK_NUMBER ==3)
						{
							shana.STATE = shana.RIGHT_ATKC_STATE;
							shana.CLICK_NUMBER = 0;
						}
						
						
						if(shana2.LEFTHURT)
						{
							shana2.HP -=10;
							shana2.STATE = shana2.HURT_STATE;
							shana2.LEFTHURT = false;
						}
						else if(shana2.RIGHTHURT)
						{
							shana2.HP -=10;
							shana2.STATE = shana2.HURT_STATE;
							shana2.RIGHTHURT = false;
						}
					}
					else
					{
						if(shana.CLICK_NUMBER == 1)
						shana.STATE = shana.LEFT_ATKA_STATE;
						
						else if(shana.CLICK_NUMBER ==2)
							shana.STATE = shana.LEFT_ATKB_STATE;
						
						else if(shana.CLICK_NUMBER ==3)
						{
							shana.STATE = shana.LEFT_ATKC_STATE;
							shana.CLICK_NUMBER = 0;
						}
						
						if(shana2.LEFTHURT)
						{
							shana2.HP -=10;
							shana2.STATE = shana2.HURT_STATE;
							shana2.LEFTHURT = false;
						}
						else if(shana2.RIGHTHURT)
						{
							shana2.HP -=10;
							shana2.STATE = shana2.HURT_STATE;
							shana2.RIGHTHURT = false;
						}
					}
				}
				//P2ÌØÊâ¹¥»÷
				else if(event.getKeyCode() == Input.Keys.NUMPAD_5)
				{
					shana.LEFTHURT=Collision.collisionLeft(shana.getX(),shana2.getX());
					shana.RIGHTHURT=Collision.collisionRight(shana.getX(), shana.getY());
					if(shana2.getisFacingRight())
					{
						shana2.STATE = shana2.RIGHT_SATK_STATE;
					}
					else
					{
						shana2.STATE = shana2.LEFT_SATK_STATE;
					}
					if(shana.LEFTHURT)
					{
						shana.HP -=30;
						shana.STATE = shana.HURT_STATE;
						shana.LEFTHURT = false;
					}
					else if(shana.RIGHTHURT)
					{
						shana.HP -=30;
						shana.STATE = shana.HURT_STATE;
						shana.RIGHTHURT = false;
					}
				}
				
				//P1ÌØÊâ¹¥»÷
				else if(event.getKeyCode() == Input.Keys.I)
				{
					shana2.LEFTHURT=Collision.collisionLeft(shana.getX(),shana2.getX());
					shana2.RIGHTHURT=Collision.collisionRight(shana.getX(), shana.getY());
					if(shana.getisFacingRight())
					{
						shana.STATE = shana.RIGHT_SATK_STATE;
					}
					else
					{
						shana.STATE = shana.LEFT_SATK_STATE;
					}
					
					if(shana2.LEFTHURT)
					{
						shana2.HP -=30;
						shana2.STATE = shana2.HURT_STATE;
						shana2.LEFTHURT = false;
					}
					else if(shana2.RIGHTHURT)
					{
						shana2.HP -=30;
						shana2.STATE = shana2.HURT_STATE;
						shana2.RIGHTHURT = false;
					}
					
				}
			
				return true;
			}
			
			@Override
			public boolean keyUp(InputEvent event , int keycode)
			{
				if(shana.STATE != shana.HURT_STATE)
				shana.STATE = shana.STAY_STATE;
				if(shana2.STATE != shana2.HURT_STATE)
				shana2.STATE = shana.STAY_STATE;
				return true;
			}
			
			
			
			
			
			
		});
		
		
	}
}
