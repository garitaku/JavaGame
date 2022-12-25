package screen_change;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FieldPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	JLabel gameLabel;

	// コンストラクタ
	public FieldPanel() {
		// サイズは自動化される
		this.setBackground(Color.ORANGE);
		this.setLayout(null);
	}

	// コンストラクタが呼ばれた後手動で呼び出す
	public void prepareComponents() {
		// コンポーネント
		gameLabel = new JLabel();
		gameLabel.setText("ゲーム画面");
		gameLabel.setBounds(0, 0, 100, 30);
		gameLabel.setBorder(BorderFactory.createLineBorder(Color.black, 3));//縁取り
		this.add(gameLabel);
	}
}
