package screen_change;

import javax.swing.ImageIcon;

public class Fish_Cat extends Animal{
	private static final long serialVersionUID = 1L;

	@Override
	protected void prepareImageAndScoreAndVoice() {
		// TODO 自動生成されたメソッド・スタブ
		super.image = new ImageIcon(getClass().getClassLoader().getResource("./images/cat_fish_run1.png")).getImage();
		super.score = 10;
		super.voiceKey = "にゃー";
	}

}
