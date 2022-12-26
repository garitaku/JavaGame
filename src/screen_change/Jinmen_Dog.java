package screen_change;

import javax.swing.ImageIcon;

public class Jinmen_Dog extends Animal {
	private static final long serialVersionUID = 1L;

	@Override
	protected void prepareImageAndScoreAndVoice() {
		// TODO 自動生成されたメソッド・スタブ
		super.image = new ImageIcon(getClass().getClassLoader().getResource("./images/youkai_jinmenken1.png"))
				.getImage();
		super.score = -20;
		super.voiceKey = "にゃー";
		super.escapeTime = 800;
	}
}
