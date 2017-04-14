package com.mygdx.stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.Constants;

/*
 * 这个Stage负责菜单画面
 */
public class StartStage extends Stage{
		Texture texture;
		TextureRegion startRegion;
		Image startImage;
		Image newGameBtn;
		TextureRegion newGameRegion;
		
		static int HEIGHT = 600;
		
		static int WIDTH = 800;
		
		
		public StartStage()
		{
			super(); //估计是用于初始化Stage的监听器等
			init();
		}
		
		public void init()
		{
			texture = new Texture(Gdx.files.internal("assets/startstage.jpg"));
			startImage = new Image(texture);
			startImage.setSize(WIDTH, HEIGHT);
			this.addActor(startImage);
			
			startImage.addListener(new InputListener()
					{
							@Override
							public boolean touchDown(InputEvent event, float x, float y, 
																			int pointer, int button)
							{
								Constants.Stageflag = Constants.GameStage;//这里如果是Constants.GameStage，那么一次之后就会消失。如果是1则不会.
								System.out.println("Click Listening");
								return true;
							}
					});

		}
		
		/*
		 * 这个测试函数不知道怎么写，读取不到图片.
		 */
		public static void main(String[] args)
		{
			Texture texture2;
			texture2 = new Texture(Gdx.files.internal("startstage.jpg"));
			SpriteBatch batch = null;
			batch.begin();
			batch.draw(texture2,WIDTH,HEIGHT);
			batch.end();
			
		}
		
		

}
