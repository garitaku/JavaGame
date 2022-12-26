package screen_change;

import javax.swing.ImageIcon;

public class Soujiki_Cat extends Animal{
	private static final long serialVersionUID = 1L;

	@Override
	protected void prepareImageAndScoreAndVoice() {
		// TODO 自動生成されたメソッド・スタブ
		super.image = new ImageIcon(getClass().getClassLoader().getResource("./images/pet_robot_soujiki_cat1.png")).getImage();
		super.score = 150;
		super.voiceKey = "にゃー";
		super.escapeTime=100;
	}
}
