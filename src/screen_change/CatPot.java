package screen_change;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CatPot extends JLabel {
	private static final long serialVersionUID = 1L;
	// フィールド
	ImageIcon image;

	// コンストラクタ
	public CatPot() {
		image = new ImageIcon(getClass().getClassLoader().getResource("./images/shopping_reji_kago_red1.png"));
		this.setBounds(325, 375, 150, 150);
		this.setIcon(image);
		this.setText("DROP HERE↓");
		this.setHorizontalTextPosition(CENTER);
		this.setVerticalTextPosition(TOP);
	}
}
