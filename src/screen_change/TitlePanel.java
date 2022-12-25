package screen_change;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class TitlePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	// コンポーネント
	JLabel title;
	JLabel start;
	JLabel exit;
	JLabel select;
	JLabel message;
	MyKeyListener myKeyListener;
	Menu CheckMenu = Menu.START;
	Border border = BorderFactory.createLineBorder(Color.black, 2);

	// 列挙型
	public enum Menu {
		START, EXIT,
	}

	// コンストラクタ
	TitlePanel() {
		// パネルサイズと貼り付け位置の設定は不要(CardLayoutが勝手に画面サイズに合わせてくれる)
		this.setLayout(null);// レイアウトの設定
		this.setBackground(Color.cyan);// 背景の色
		// その他の追加設定をここに追加
	}

	// コンストラクタが呼ばれた後手動で呼び出す
	public void prepareComponents() {
		// 以降コンポーネントに関する命令
		
		// タイトルロゴ
		title = new JLabel();
		ImageIcon titleLogo = new ImageIcon(getClass().getClassLoader().getResource("./images/86617.png"));// 600*300のタイトル画像
		title.setIcon(titleLogo);// タイトル画像をセット
		title.setBounds(90, 0, 600, 350);// 位置とサイズを指定
		
		//タイトル画像下部のテキスト
//		title.setHorizontalAlignment(SwingConstants.CENTER);//
//		title.setVerticalAlignment(SwingConstants.BOTTOM);
//		title.setText("Created by【石原 拓也】");
//		title.setHorizontalTextPosition(JLabel.CENTER);
//		title.setVerticalTextPosition(SwingConstants.BOTTOM);
//		title.setBorder(border);// 縁取り

		// 選択肢(スタート)
		start = new JLabel();
		start.setText("START");
		start.setFont(new Font("MV boli", Font.BOLD, 40));
		start.setHorizontalAlignment(SwingConstants.CENTER);//
		start.setVerticalAlignment(SwingConstants.BOTTOM);
		start.setBounds(330, 400, 150, 40);

		// 選択肢(スタート)
		exit = new JLabel();
		exit.setText("EXIT");
		exit.setFont(new Font("MV boli", Font.BOLD, 40));
		exit.setHorizontalAlignment(SwingConstants.CENTER);//
		exit.setVerticalAlignment(SwingConstants.BOTTOM);
		exit.setBounds(350, 450, 110, 40);

		// 選択アイコン
		select = new JLabel();
		ImageIcon icon02 = new ImageIcon(getClass().getClassLoader().getResource("./images/nikukyu_shirokuro.png"));
		select.setIcon(icon02);
		select.setOpaque(false);
		select.setBounds(280, 400, 40, 40);

		// 説明
		message = new JLabel();
		message.setHorizontalAlignment(SwingConstants.CENTER);
		message.setText("選択：⬆︎ ⬇	決定：SPACE︎");
		message.setHorizontalTextPosition(JLabel.CENTER);
		message.setVerticalTextPosition(JLabel.CENTER);
		message.setBounds(249, 517, 200, 30);

		// 配置
		this.setLayout(null);
		this.add(title);
		this.add(start);
		this.add(exit);
		this.add(select);
		this.add(message);

		myKeyListener = new MyKeyListener(this);
	}

	private class MyKeyListener implements KeyListener {
		TitlePanel panel;

		MyKeyListener(TitlePanel p) {
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
			switch (e.getKeyCode()) {
			case KeyEvent.VK_DOWN:
				if (CheckMenu == Menu.START) {
					select.setLocation(select.getX(), select.getY() + 50);
					CheckMenu = Menu.EXIT;
				}
				break;
			case KeyEvent.VK_UP:
				if (CheckMenu == Menu.EXIT) {
					select.setLocation(select.getX(), select.getY() - 50);
					CheckMenu = Menu.START;
				}
				break;

			case KeyEvent.VK_SPACE:
				if (CheckMenu == Menu.START) {
					// リスナーが画面切り替えメソッドを呼ぶ
					Main.mainWindow.setFontScreenAndFocus(ScreenMode.GAME);
				} else if (CheckMenu == Menu.EXIT) {
					System.exit(0);
				}
				break;
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO 自動生成されたメソッド・スタブ
		}
	}
}
