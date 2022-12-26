package screen_change;

import javax.swing.ImageIcon;

public class Cat_Normal extends Animal {
	private static final long serialVersionUID = 1L;

	@Override
	protected void prepareImageAndScoreAndVoice() {
		// TODO 自動生成されたメソッド・スタブ
		super.image = new ImageIcon(getClass().getClassLoader().getResource("./images/run_cat_smile1.png")).getImage();
		super.score = 5;
		super.voiceKey = "にゃー";
	}

}
