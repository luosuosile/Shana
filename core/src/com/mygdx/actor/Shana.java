package com.mygdx.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Shana extends Actor {
	
	public static int HP = 100;
	public static int ATK_DAMAGE = 10;
	public static int STK_DAMAGE = 30;
	public static int STRIKING_DISTENCE = 50;
	public static boolean LEFTHURT;
	public static boolean RIGHTHURT;
	private static float FRAME_DURATION_ATK2  = 1.0f / 14.0f;
	private static float FRAME_DURATION_ATK3  = 1.0f / 14.0f;
	private static float FRAME_DURATION_SATK1 = 1.0f / 11.0f;
	private static float FRAME_DURATION_HURT = 1.0f /8.0f;
	private static float FRAME_DURATION_LOSE = 1.0f / 4.5f;
	private static float FRAME_DURATION_LOSEKEEP  = 1.0f / 8.0f;
	private static float FRAME_DURATION_JUMP_UP  = 1.0f / 15.0f;
	private static float FRAME_DURATION_JUMP_DOWN = 1.0f / 7.0f;
	private static float FRAME_DURATION_JUMP_DOWN_KEEP =  1.0f/7.0f;
	private static float FRAME_DURATION_JUMP_DOWN_END = 1.0f /17.0f;
	private static float FRAME_DURATION_WIN = 1.0f /4.5f;
	private static float FRAME_DURATION_WINKEEP = 1.0f / 8.0f ;
	public static int STATE = 3;
	public  static int RIGHT_STATE = 1;
	public  static int LEFT_STATE = 2;
	public static int STAY_STATE = 3;
	public static int RIGHT_ATKA_STATE = 4;
	public static int RIGHT_ATKB_STATE = 5;
	public static int RIGHT_ATKC_STATE =6;
	public static int RIGHT_SATK_STATE = 7;
	public static int LEFT_ATKA_STATE = 8;
	public static int LEFT_ATKB_STATE = 9;
	public static int LEFT_ATKC_STATE = 10;
	public static int LEFT_SATK_STATE = 11;
	public static int UP_STATE =12;
	public static int DOWN_STATE =13;
	public static int HURT_STATE = 14;
	private static float  FRAME_DURATION_STAND = 1.0f / 8.0f;
	private static float FRAME_DURATION_RUN = 1.0f / 15.0f;
	private static float FRAME_DURATION_ATK1 = 1.0f / 14.0f;
	
	public static int CLICK_NUMBER = 0;
	
	
	public  static  boolean isFacingRight;
	private TextureAtlas heroAtlas;
	private Animation animationStandingRight;
	private Animation animationWalkingRight;
	private Animation animationAttaRight ;
	
	private String CurrentAction = "Standing";
	private static float statetime;
	
	public static float x;
	public static float y;
	TextureRegion currentFrame;
	private Animation animationAttbRight;
	private Animation animationAttcRight;
	private Animation animationSatkaRight;
	private Animation animationHurtRight;
	private Animation animationLoseRight;
	private Animation animationLoseKeepRight;
	private Animation animationJumpingUpLeft;
	private Animation animationJumpingDownLeft;
	private Animation animationJumpingDownKeepLeft;
	private Animation animationJumpingDownEndLeft;
	private Animation animationStandingLeft;
	private Animation animationWalkingLeft;
	private Animation animationAttaLeft;
	private Animation animationAttbLeft;
	private Animation animationAttcLeft;
	private Animation animationSatkaLeft;
	private Animation animationHurtLeft;
	private Animation animationLoseLeft;
	private Animation animationLoseKeepLeft;
	private Animation animationWin;
	private Animation animationWinKeep;
	

	public Shana(int x,int y)
	{
		this.x = x;
		this.y = y;
		this.init();
	}
	
	public void init()
	{
		isFacingRight = true;
		
		this.setCurrentAction("Standing");
		
		heroAtlas = new TextureAtlas(Gdx.files
				.internal("assets/hero/heroShana.pack"));
		
		//右边站立
		TextureRegion[] frameStandingRight = new TextureRegion[6];
        frameStandingRight[0] = heroAtlas.findRegion("StandingRight1");
        frameStandingRight[1] = heroAtlas.findRegion("StandingRight2");
        frameStandingRight[2] = heroAtlas.findRegion("StandingRight3");
        frameStandingRight[3] = heroAtlas.findRegion("StandingRight4");
        frameStandingRight[4] = heroAtlas.findRegion("StandingRight5");
        frameStandingRight[5] = heroAtlas.findRegion("StandingRight6");
        animationStandingRight = new Animation(FRAME_DURATION_STAND, frameStandingRight);
		
		//右边跑步
        TextureRegion[] frameWalkingRight = new TextureRegion[8];
        frameWalkingRight[0] = heroAtlas.findRegion("RunningRight1");
        frameWalkingRight[1] = heroAtlas.findRegion("RunningRight2");
        frameWalkingRight[2] = heroAtlas.findRegion("RunningRight3");
        frameWalkingRight[3] = heroAtlas.findRegion("RunningRight4");
        frameWalkingRight[4] = heroAtlas.findRegion("RunningRight5");
        frameWalkingRight[5] = heroAtlas.findRegion("RunningRight6");
        frameWalkingRight[6] = heroAtlas.findRegion("RunningRight7");
        frameWalkingRight[7] = heroAtlas.findRegion("RunningRight8");
        animationWalkingRight = new Animation(FRAME_DURATION_RUN, frameWalkingRight);
        
      //右邊普通攻擊(A模式)
        TextureRegion[] frameAtkaRight = new TextureRegion[8];
        frameAtkaRight[0] = heroAtlas.findRegion("RightATTA1");
        frameAtkaRight[1] = heroAtlas.findRegion("RightATTA2");
        frameAtkaRight[2] = heroAtlas.findRegion("RightATTA3");
        frameAtkaRight[3] = heroAtlas.findRegion("RightATTA4");
        frameAtkaRight[4] = heroAtlas.findRegion("RightATTA5");
        frameAtkaRight[5] = heroAtlas.findRegion("RightATTA6");
        frameAtkaRight[6] = heroAtlas.findRegion("RightATTA7");
        frameAtkaRight[7] = heroAtlas.findRegion("RightATTA8");
        animationAttaRight = new Animation(FRAME_DURATION_ATK1, frameAtkaRight);
        
      //右邊普通攻擊(B模式)
        TextureRegion[] frameAtkbRight = new TextureRegion[8];
        frameAtkbRight[0] = heroAtlas.findRegion("RightATTB1");
        frameAtkbRight[1] = heroAtlas.findRegion("RightATTB2");
        frameAtkbRight[2] = heroAtlas.findRegion("RightATTB3");
        frameAtkbRight[3] = heroAtlas.findRegion("RightATTB4");
        frameAtkbRight[4] = heroAtlas.findRegion("RightATTB5");
        frameAtkbRight[5] = heroAtlas.findRegion("RightATTB6");
        frameAtkbRight[6] = heroAtlas.findRegion("RightATTB7");
        frameAtkbRight[7] = heroAtlas.findRegion("RightATTB8");
		animationAttbRight = new Animation(FRAME_DURATION_ATK2, frameAtkbRight);
        
      //右邊普通攻擊(C模式)
        TextureRegion[] frameAtkcRight = new TextureRegion[7];
        frameAtkcRight[0] = heroAtlas.findRegion("RightATTC1");
        frameAtkcRight[1] = heroAtlas.findRegion("RightATTC2");
        frameAtkcRight[2] = heroAtlas.findRegion("RightATTC3");
        frameAtkcRight[3] = heroAtlas.findRegion("RightATTC4");
        frameAtkcRight[4] = heroAtlas.findRegion("RightATTC5");
        frameAtkcRight[5] = heroAtlas.findRegion("RightATTC6");
        frameAtkcRight[6] = heroAtlas.findRegion("RightATTC7");
        animationAttcRight = new Animation(FRAME_DURATION_ATK3, frameAtkcRight);

        //右邊特殊技能1
        TextureRegion[] frameSatkaRight = new TextureRegion[11];
        frameSatkaRight[0] = heroAtlas.findRegion("SatkRight01");
        frameSatkaRight[1] = heroAtlas.findRegion("SatkRight02");
        frameSatkaRight[2] = heroAtlas.findRegion("SatkRight03");
        frameSatkaRight[3] = heroAtlas.findRegion("SatkRight04");
        frameSatkaRight[4] = heroAtlas.findRegion("SatkRight05");
        frameSatkaRight[5] = heroAtlas.findRegion("SatkRight06");
        frameSatkaRight[6] = heroAtlas.findRegion("SatkRight07");
        frameSatkaRight[7] = heroAtlas.findRegion("SatkRight08");
        frameSatkaRight[8] = heroAtlas.findRegion("SatkRight09");
        frameSatkaRight[9] = heroAtlas.findRegion("SatkRight10");
        frameSatkaRight[10] = heroAtlas.findRegion("SatkRight11");
        animationSatkaRight = new Animation(FRAME_DURATION_SATK1, frameSatkaRight);
        
        //右邊受傷
        TextureRegion[] frameHurtRight = new TextureRegion[3];
        frameHurtRight[0] = heroAtlas.findRegion("HurtRight");
        frameHurtRight[1] = heroAtlas.findRegion("HurtRight");
        frameHurtRight[2] = heroAtlas.findRegion("HurtRight");
        animationHurtRight = new Animation(FRAME_DURATION_HURT, frameHurtRight);
        
        //右邊死亡
        TextureRegion[] frameLoseRight = new TextureRegion[3];
        frameLoseRight[0] = heroAtlas.findRegion("LoseRight1");
        frameLoseRight[1] = heroAtlas.findRegion("LoseRight2");
        frameLoseRight[2] = heroAtlas.findRegion("LoseRight3");
        animationLoseRight = new Animation(FRAME_DURATION_LOSE, frameLoseRight);
        

        //右邊死亡持續姿勢
        TextureRegion[] frameLoseKeepRight = new TextureRegion[3];
        frameLoseKeepRight[0] = heroAtlas.findRegion("LoseRight3");
        frameLoseKeepRight[1] = heroAtlas.findRegion("LoseRight3");
        frameLoseKeepRight[2] = heroAtlas.findRegion("LoseRight3");
        animationLoseKeepRight = new Animation(FRAME_DURATION_LOSEKEEP, frameLoseKeepRight);
        
        
        //左邊跳躍
      TextureRegion[] frameJumpingUpLeft = new TextureRegion[5];
      frameJumpingUpLeft[0] = heroAtlas.findRegion("JumpingLeft1");
      frameJumpingUpLeft[1] = heroAtlas.findRegion("JumpingLeft2");
      frameJumpingUpLeft[2] = heroAtlas.findRegion("JumpingLeft3");
      frameJumpingUpLeft[3] = heroAtlas.findRegion("JumpingLeft4");
      frameJumpingUpLeft[4] = heroAtlas.findRegion("JumpingLeft5");
      animationJumpingUpLeft = new Animation(FRAME_DURATION_JUMP_UP, frameJumpingUpLeft);
      
      TextureRegion[] frameJumpingDownLeft = new TextureRegion[3];
      frameJumpingDownLeft[0] = heroAtlas.findRegion("JumpingLeft6");
      frameJumpingDownLeft[1] = heroAtlas.findRegion("JumpingLeft7");
      frameJumpingDownLeft[2] = heroAtlas.findRegion("JumpingLeft8");
      animationJumpingDownLeft = new Animation(FRAME_DURATION_JUMP_DOWN, frameJumpingDownLeft);

      TextureRegion[] frameJumpingDownKeepLeft = new TextureRegion[2];
      frameJumpingDownKeepLeft[0] = heroAtlas.findRegion("JumpingLeft7");
      frameJumpingDownKeepLeft[1] = heroAtlas.findRegion("JumpingLeft8");
      animationJumpingDownKeepLeft = new Animation(FRAME_DURATION_JUMP_DOWN_KEEP, frameJumpingDownKeepLeft);

      TextureRegion[] frameJumpingDownEndLeft = new TextureRegion[4];
      frameJumpingDownEndLeft[0] = heroAtlas.findRegion("JumpingLeft9");
      frameJumpingDownEndLeft[1] = heroAtlas.findRegion("JumpingLeft10");
      frameJumpingDownEndLeft[2] = heroAtlas.findRegion("JumpingLeft10");
      frameJumpingDownEndLeft[3] = heroAtlas.findRegion("JumpingLeft10");
      animationJumpingDownEndLeft = new Animation(FRAME_DURATION_JUMP_DOWN_END, frameJumpingDownEndLeft);
      
    //左邊站立
      TextureRegion[] frameStandingLeft = new TextureRegion[6];
      frameStandingLeft[0] = heroAtlas.findRegion("StandingLeft1");
      frameStandingLeft[1] = heroAtlas.findRegion("StandingLeft2");
      frameStandingLeft[2] = heroAtlas.findRegion("StandingLeft3");
      frameStandingLeft[3] = heroAtlas.findRegion("StandingLeft4");
      frameStandingLeft[4] = heroAtlas.findRegion("StandingLeft5");
      frameStandingLeft[5] = heroAtlas.findRegion("StandingLeft6");
      animationStandingLeft = new Animation(FRAME_DURATION_STAND, frameStandingLeft);

      //左邊跑步
      TextureRegion[] frameWalkingLeft = new TextureRegion[8];
      frameWalkingLeft[0] = heroAtlas.findRegion("RunningLeft1");
      frameWalkingLeft[1] = heroAtlas.findRegion("RunningLeft2");
      frameWalkingLeft[2] = heroAtlas.findRegion("RunningLeft3");
      frameWalkingLeft[3] = heroAtlas.findRegion("RunningLeft4");
      frameWalkingLeft[4] = heroAtlas.findRegion("RunningLeft5");
      frameWalkingLeft[5] = heroAtlas.findRegion("RunningLeft6");
      frameWalkingLeft[6] = heroAtlas.findRegion("RunningLeft7");
      frameWalkingLeft[7] = heroAtlas.findRegion("RunningLeft8");
      animationWalkingLeft = new Animation(FRAME_DURATION_RUN, frameWalkingLeft);

      //左邊普通攻擊(A模式)
      TextureRegion[] frameAtkaLeft = new TextureRegion[8];
      frameAtkaLeft[0] = heroAtlas.findRegion("LeftATTA1");
      frameAtkaLeft[1] = heroAtlas.findRegion("LeftATTA2");
      frameAtkaLeft[2] = heroAtlas.findRegion("LeftATTA3");
      frameAtkaLeft[3] = heroAtlas.findRegion("LeftATTA4");
      frameAtkaLeft[4] = heroAtlas.findRegion("LeftATTA5");
      frameAtkaLeft[5] = heroAtlas.findRegion("LeftATTA6");
      frameAtkaLeft[6] = heroAtlas.findRegion("LeftATTA7");
      frameAtkaLeft[7] = heroAtlas.findRegion("LeftATTA8");
      animationAttaLeft = new Animation(FRAME_DURATION_ATK1, frameAtkaLeft);

      //左邊普通攻擊(B模式)
      TextureRegion[] frameAtkbLeft = new TextureRegion[8];
      frameAtkbLeft[0] = heroAtlas.findRegion("LeftATTB1");
      frameAtkbLeft[1] = heroAtlas.findRegion("LeftATTB2");
      frameAtkbLeft[2] = heroAtlas.findRegion("LeftATTB3");
      frameAtkbLeft[3] = heroAtlas.findRegion("LeftATTB4");
      frameAtkbLeft[4] = heroAtlas.findRegion("LeftATTB5");
      frameAtkbLeft[5] = heroAtlas.findRegion("LeftATTB6");
      frameAtkbLeft[6] = heroAtlas.findRegion("LeftATTB7");
      frameAtkbLeft[7] = heroAtlas.findRegion("LeftATTB8");
      animationAttbLeft = new Animation(FRAME_DURATION_ATK2, frameAtkbLeft);

      //左邊普通攻擊(C模式)
      TextureRegion[] frameAtkcLeft = new TextureRegion[7];
      frameAtkcLeft[0] = heroAtlas.findRegion("LeftATTC1");
      frameAtkcLeft[1] = heroAtlas.findRegion("LeftATTC2");
      frameAtkcLeft[2] = heroAtlas.findRegion("LeftATTC3");
      frameAtkcLeft[3] = heroAtlas.findRegion("LeftATTC4");
      frameAtkcLeft[4] = heroAtlas.findRegion("LeftATTC5");
      frameAtkcLeft[5] = heroAtlas.findRegion("LeftATTC6");
      frameAtkcLeft[6] = heroAtlas.findRegion("LeftATTC7");
      animationAttcLeft = new Animation(FRAME_DURATION_ATK3, frameAtkcLeft);

      //左邊特殊技能1
      TextureRegion[] frameSatkaLeft = new TextureRegion[11];
      frameSatkaLeft[0] = heroAtlas.findRegion("SatkLeft01");
      frameSatkaLeft[1] = heroAtlas.findRegion("SatkLeft02");
      frameSatkaLeft[2] = heroAtlas.findRegion("SatkLeft03");
      frameSatkaLeft[3] = heroAtlas.findRegion("SatkLeft04");
      frameSatkaLeft[4] = heroAtlas.findRegion("SatkLeft05");
      frameSatkaLeft[5] = heroAtlas.findRegion("SatkLeft06");
      frameSatkaLeft[6] = heroAtlas.findRegion("SatkLeft07");
      frameSatkaLeft[7] = heroAtlas.findRegion("SatkLeft08");
      frameSatkaLeft[8] = heroAtlas.findRegion("SatkLeft09");
      frameSatkaLeft[9] = heroAtlas.findRegion("SatkLeft10");
      frameSatkaLeft[10] = heroAtlas.findRegion("SatkLeft11");
      animationSatkaLeft = new Animation(FRAME_DURATION_SATK1, frameSatkaLeft);

      //左邊受傷
      TextureRegion[] frameHurtLeft = new TextureRegion[3];
      frameHurtLeft[0] = heroAtlas.findRegion("HurtLeft");
      frameHurtLeft[1] = heroAtlas.findRegion("HurtLeft");
      frameHurtLeft[2] = heroAtlas.findRegion("HurtLeft");
      animationHurtLeft = new Animation(FRAME_DURATION_HURT, frameHurtLeft);

      //左邊死亡
      TextureRegion[] frameLoseLeft = new TextureRegion[3];
      frameLoseLeft[0] = heroAtlas.findRegion("LoseLeft1");
      frameLoseLeft[1] = heroAtlas.findRegion("LoseLeft2");
      frameLoseLeft[2] = heroAtlas.findRegion("LoseLeft3");
      animationLoseLeft = new Animation(FRAME_DURATION_LOSE, frameLoseLeft);

      //左邊死亡持續姿勢
      TextureRegion[] frameLoseKeepLeft = new TextureRegion[3];
      frameLoseKeepLeft[0] = heroAtlas.findRegion("LoseLeft3");
      frameLoseKeepLeft[1] = heroAtlas.findRegion("LoseLeft3");
      frameLoseKeepLeft[2] = heroAtlas.findRegion("LoseLeft3");
      animationLoseKeepLeft = new Animation(FRAME_DURATION_LOSEKEEP, frameLoseKeepLeft);




      //勝利
      TextureRegion[] frameWin = new TextureRegion[8];
      frameWin[0] = heroAtlas.findRegion("Win1");
      frameWin[1] = heroAtlas.findRegion("Win2");
      frameWin[2] = heroAtlas.findRegion("Win3");
      frameWin[3] = heroAtlas.findRegion("Win4");
      frameWin[4] = heroAtlas.findRegion("Win5");
      frameWin[5] = heroAtlas.findRegion("Win6");
      frameWin[6] = heroAtlas.findRegion("Win7");
      frameWin[7] = heroAtlas.findRegion("Win8");
      animationWin = new Animation(FRAME_DURATION_WIN, frameWin);

      //勝利持續姿勢
      TextureRegion[] frameWinKeep = new TextureRegion[3];
      frameWinKeep[0] = heroAtlas.findRegion("WinKeep1");
      frameWinKeep[1] = heroAtlas.findRegion("WinKeep2");
      frameWinKeep[2] = heroAtlas.findRegion("WinKeep3");
      animationWinKeep = new Animation(FRAME_DURATION_WINKEEP, frameWinKeep);
	}

	public boolean getisFacingRight() {
		return isFacingRight;
	}

	public void setisFacingRight(boolean isFacingRight) {
		this.isFacingRight = isFacingRight;
	}

	public TextureAtlas getHeroAtlas() {
		return heroAtlas;
	}

	public void setHeroAtlas(TextureAtlas heroAtlas) {
		this.heroAtlas = heroAtlas;
	}

	public Animation getAnimationStandingRight() {
		return animationStandingRight;
	}

	public void setAnimationStandingRight(Animation animationStandingRight) {
		this.animationStandingRight = animationStandingRight;
	}

	public float getFRAME_DURATION_STAND() {
		return FRAME_DURATION_STAND;
	}

	public void setFRAME_DURATION_STAND(float fRAME_DURATION_STAND) {
		FRAME_DURATION_STAND = fRAME_DURATION_STAND;
	}

	public Animation getAnimationWalkingRight() {
		return animationWalkingRight;
	}

	public void setAnimationWalkingRight(Animation animationWalkingRight) {
		this.animationWalkingRight = animationWalkingRight;
	}

	public float getFRAME_DURATION_RUN() {
		return FRAME_DURATION_RUN;
	}

	public void setFRAME_DURATION_RUN(float fRAME_DURATION_RUN) {
		FRAME_DURATION_RUN = fRAME_DURATION_RUN;
	}

	public float getFRAME_DURATION_ATK1() {
		return FRAME_DURATION_ATK1;
	}

	public void setFRAME_DURATION_ATK1(float fRAME_DURATION_ATK1) {
		FRAME_DURATION_ATK1 = fRAME_DURATION_ATK1;
	}

	public Animation getAnimationAttaRight() {
		return animationAttaRight;
	}

	public void setAnimationAttaRight(Animation animationAttaRight) {
		this.animationAttaRight = animationAttaRight;
	}

	public String getCurrentAction() {
		return CurrentAction;
	}

	public void setCurrentAction(String currentAction) {
		CurrentAction = currentAction;
	}
	
	public void update()
	{
		if(STATE == LEFT_STATE) 
		{
			this.x -=1.5f;
			if(x<20)
				this.x = 20;
		}
		else if(STATE == RIGHT_STATE)
		{
			this.x +=1.5f;
			if(x>400)
				this.x = 400;
		}
		else if(STATE == UP_STATE)
		{
			this.y +=2.0f;
			if(y>800)
				this.y =800;
		}
		else if(STATE ==DOWN_STATE)
		{
			this.y -=2.0f;
			if(y<20)
				this.y =20;
		}
		this.y = y;
		this.x = x;
	}
	
	public void aniCheck()
	{
		if(STATE == LEFT_STATE)
		{
			currentFrame = animationWalkingLeft.getKeyFrame(statetime, true);
			
		}
		else if(STATE == RIGHT_STATE)
		{
			currentFrame = animationWalkingRight.getKeyFrame(statetime,true);
			
		}
		else if(STATE == STAY_STATE)
		{
			if(isFacingRight)
			currentFrame = animationStandingRight .getKeyFrame(statetime , true);
			else
				currentFrame = animationStandingLeft.getKeyFrame(statetime, true);
		}
		
		else if(STATE == RIGHT_ATKA_STATE)
		{
			currentFrame = animationAttaRight.getKeyFrame(statetime, true);
		}
		else if(STATE == RIGHT_ATKB_STATE)
		{
			currentFrame = animationAttbRight.getKeyFrame(statetime, true);
		}
		else if(STATE == RIGHT_ATKC_STATE)
		{
			currentFrame = animationAttcRight.getKeyFrame(statetime, true);
		}
		else if(STATE == LEFT_ATKA_STATE)
		{
			currentFrame = animationAttaLeft.getKeyFrame(statetime, true);
		}
		else if(STATE == LEFT_ATKB_STATE)
		{
			currentFrame = animationAttbLeft.getKeyFrame(statetime, true);
		}
		else if(STATE == LEFT_ATKC_STATE)
		{
			currentFrame = animationAttcLeft.getKeyFrame(statetime, true);
		}
		else if(STATE == LEFT_SATK_STATE)
		{
			currentFrame = animationSatkaLeft.getKeyFrame(statetime, true);
		}
		else if(STATE == RIGHT_SATK_STATE)
		{
			currentFrame = animationSatkaRight.getKeyFrame(statetime, true);
		}
		else if(STATE == UP_STATE)
		{
			if(isFacingRight)
			{
				currentFrame = animationWalkingRight.getKeyFrame(statetime,true);
			}
			else
			{
				currentFrame = animationWalkingLeft.getKeyFrame(statetime, true);
			}
		}
		else if(STATE == DOWN_STATE)
		{
			if(isFacingRight)
			{
				currentFrame = animationWalkingRight.getKeyFrame(statetime,true);
			}
			else
			{
				currentFrame = animationWalkingLeft.getKeyFrame(statetime, true);
			}
		}
		
		else if(STATE == HURT_STATE)
		{
			if(LEFTHURT)
			{
				currentFrame = animationHurtLeft.getKeyFrame(statetime, true);
			}
			else
			{
				currentFrame = animationHurtRight.getKeyFrame(statetime, true);
			}
		}
	
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
			statetime+=Gdx.graphics.getDeltaTime();
			this.update();
			this.aniCheck();
			
			batch.draw(currentFrame, x, y);//这里给了位置
	}

	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);
	}

	public  float getX() {
		return x;
	}

	public  void setX(float x) {
		this.x = x;
	}

	public  float getY() {
		return y;
	}

	public  void setY(float y) {
		this.y = y;
	}
	
	
	
	
	

}
