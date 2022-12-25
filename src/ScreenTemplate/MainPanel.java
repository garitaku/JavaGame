//package ScreenTemplate;
//
//import java.awt.Color;
//
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//
//public class MainPanel extends JPanel {
//	private static final long serialVersionUID = 1L;
//	// 定数フィールド
//	Color backgroundColor = Color.green;
//
//	// コンポーネント
//	JLabel mainLabel;
//
//	// コンストラクタ
//	MainPanel() {
//		// パネルサイズと貼り付け位置の設定は不要(CardLayoutが勝手に画面サイズに合わせてくれる)
//		this.setLayout(null);// レイアウトの設定
//		this.setBackground(backgroundColor);// 背景の色
//		// その他の追加設定をここに追加
//	}
//
//	// コンストラクタが呼ばれた後手動で呼び出す
//	public void prepareComponents() {
//		// 以降コンポーネントに関する命令
//		mainLabel = new JLabel();// ラベル生成
//		mainLabel.setText("メイン画面");// ラベルに文字を記入
//		mainLabel.setBounds(100, 200, 100, 30);// 位置とサイズを指定
//		this.add(mainLabel);// ラベルをこのパネルに貼る
//	}
//}
