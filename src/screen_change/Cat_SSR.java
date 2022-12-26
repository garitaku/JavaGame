package screen_change;

import javax.swing.ImageIcon;

public class Cat_SSR extends Animal{
	private static final long serialVersionUID = 1L;
	
	//コンストラクタのオーバーライド
	Cat_SSR(){
		super();
		super.xVelocity=0;
		super.yVelocity=0;
	}
	
	@Override
	protected void prepareImageAndScoreAndVoice() {
		// TODO 自動生成されたメソッド・スタブ
		super.image = new ImageIcon(getClass().getClassLoader().getResource("./images/sleep_animal_cat1.png")).getImage();
		super.score = 100;
		super.voiceKey = "すや";
		super.escapeTime=150;
	}
}
