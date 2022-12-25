package screen_change;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	// フィールド
	ScreenMode screenMode = ScreenMode.TITLE;
	// 定数
	final int WIDTH = 800;// フレームの幅
	final int HEIGHT = 600;// フレームの高さ
	// レイアウト(紙芝居のような設定用)
	CardLayout layout = new CardLayout();
	// コンポーネント
	TitlePanel titlePanel;
	GamePanel gamePanel;

	// コンストラクタ
	MainWindow() {
		// ウインドウ左上のアイコンとタイトル
		this.setTitle("タイトルを設定");
		ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("./images/nikukyu_shirokuro.png"));
		this.setIconImage(icon.getImage());

		// いつもの
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);// 画面サイズの変更を禁止
		this.getContentPane().setBackground(Color.green);// 背景の色
		this.setLayout(layout);// レイアウトを"紙芝居"のように設定
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));// サイズ設定
		this.pack();// 自動サイズ調整(これがないと変なサイズになる)
		this.setLocationRelativeTo(null);// 起動時のスクリーンの位置を中央に(packより後に記載)
	}

	// コンストラクタが呼ばれた後メインメソッドから最初に手動で呼び出す
	public void preparePanels() {
		// パネルの準備
		titlePanel = new TitlePanel();
		this.add(titlePanel, "タイトル画面");
		gamePanel = new GamePanel();
		this.add(gamePanel, "ゲーム画面");
		this.pack();
	}

	// preparePanels()が呼ばれた後メインメソッドからさらに手動で呼び出す
	public void prepareComponents() {
		titlePanel.prepareComponents();
		gamePanel.prepareComponents();
	}

	// スクリーンモードを切り替える
	// メインメソッドから最後に手動で呼び出す
	public void setFontScreenAndFocus(ScreenMode s) {
		screenMode = s;
		// 表示される画面の設定
		switch (screenMode) {
		case TITLE:
			layout.show(this.getContentPane(), "タイトル画面");
			titlePanel.requestFocus();
			break;
		case GAME:
			layout.show(this.getContentPane(), "ゲーム画面");
			gamePanel.requestFocus();
			break;
		}
	}
}
