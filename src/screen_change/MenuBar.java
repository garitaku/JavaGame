package screen_change;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuBar extends JPanel {
	private static final long serialVersionUID = 1L;

	// コンポーネント
	JButton homeButton;
	JLabel homeLabel;
	HomeButtonListener homeButtonListener;

	public MenuBar() {
		// パネルサイズと貼り付け位置の設定は不要(BorderLayoutが勝手にサイズを合わせてくれる)
		this.setPreferredSize(new Dimension(100, 40));// 幅は自動調整されるが必要な命令
		this.setBackground(Color.red);
		this.setLayout(null);
	}

	public void prepareComponents() {
		// ホームボタン
		homeButton = new JButton();
		homeButton.setBounds(5, 5, 80, 30);
		homeButton.setText("HOME");
		homeButton.setFocusable(false);
		homeButtonListener = new HomeButtonListener();
		homeButton.addActionListener(homeButtonListener);

		// ラベル
		homeLabel = new JLabel("Click this Button or press 'h' to home");
		homeLabel.setBounds(100, 5, 250, 30);
		homeLabel.setBorder(BorderFactory.createEtchedBorder(3, Color.BLACK, Color.WHITE));

		// 設置
		this.add(homeButton);
		this.add(homeLabel);
	}

	private class HomeButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自動生成されたメソッド・スタブ
			Main.mainWindow.setFontScreenAndFocus(ScreenMode.TITLE);
		}

	}
}
