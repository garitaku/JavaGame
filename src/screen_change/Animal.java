package screen_change;

import javax.swing.JLabel;
import javax.swing.Timer;

import java.awt.*;

public abstract class Animal extends JLabel {
	private static final long serialVersionUID = 1L;
	Image image;// 100×100の画像を指定
	int score;// 捕獲時の得点
	String voiceKey;// 捕獲時の鳴き声のkey
	Timer timer = null;// その個体の動きの制御用
	int escapeTime = 500;// 時間経過で消える用

	// 座標と速度
	int x;// 座標
	int y;
	int xVelocity;// 速度
	int yVelocity;

	public Animal() {
		x = new java.util.Random().nextInt(680);
		y = new java.util.Random().nextInt(300);
		// 真縦or真横には動かないように速度を設定
		do {
			xVelocity = -5 + new java.util.Random().nextInt(10);
			yVelocity = -5 + new java.util.Random().nextInt(10);
		} while (xVelocity == 0 || yVelocity == 0);
		this.prepareImageAndScoreAndVoice();
		this.setBounds(x, y, image.getWidth(null), image.getHeight(null));
	}

	// 設定(子クラスで必ず設定)
	protected abstract void prepareImageAndScoreAndVoice();

	// 画像の描画（反転の処理を含む)
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2D = (Graphics2D) g;
		if (xVelocity >= 0) {// （多分）右方向に進んでいるとき
			g2D.drawImage(image, 0, 0, image.getWidth(null), image.getHeight(null), null);
		} else {
			g2D.drawImage(image, image.getWidth(null), 0, -image.getWidth(null), image.getHeight(null), null);
		}
	}

}
