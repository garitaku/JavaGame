package screen_change;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	// レイアウト
	BorderLayout layout = new BorderLayout();

	// コンポーネント
	MenuBar menuBar;
	FieldPanel fieldPanel;

	// リスナー
	MyKeyListener myKeyListener;

	// コンストラクタ
	GamePanel() {
		// パネルサイズと貼り付け位置の設定は不要(CardLayoutが勝手に画面サイズに合わせてくれる)
		this.setLayout(layout);// レイアウトの設定
		this.setBackground(Color.yellow);// 背景の色
		// パネル生成と設置
		fieldPanel = new FieldPanel();
		menuBar = new MenuBar();
		this.add(fieldPanel, BorderLayout.CENTER);
		this.add(menuBar, BorderLayout.NORTH);
		// その他の追加設定をここに追加
	}

	public void prepareComponents() {
		// 以降コンポーネントに関する命令
		menuBar.prepareComponents();
		fieldPanel.prepareComponents();
		// リスナーを設置
		myKeyListener = new MyKeyListener(this);
	}

	private class MyKeyListener implements KeyListener {

		JPanel panel;

		MyKeyListener(GamePanel p) {
			super();
			panel = p;
			panel.addKeyListener(this);
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO 自動生成されたメソッド・スタブ

		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO 自動生成されたメソッド・スタブ
			if (e.getKeyCode() == KeyEvent.VK_H) {
//				System.out.println("hが押されました");
				Main.mainWindow.setFontScreenAndFocus(ScreenMode.TITLE);
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO 自動生成されたメソッド・スタブ

		}

	}
}
