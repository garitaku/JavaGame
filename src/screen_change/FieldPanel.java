package screen_change;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.event.*;
import javax.swing.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class FieldPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	ArrayList<Animal> animals = new ArrayList<Animal>();
	Animal animal01;
	Animal animal02;
	Animal animal03;
	JLayeredPane layeredPane;
	JLabel catPot;

	// コンストラクタ
	public FieldPanel() {
		// サイズは自動化される
		this.setBackground(Color.ORANGE);
		this.setLayout(null);
	}

	// コンストラクタが呼ばれた後手動で呼び出す
	public void prepareComponents() {
		// コンポーネント
		animals.add(animal01);
		animals.add(animal02);
		animals.add(animal03);
		// レイヤードペインを追加
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, this.getWidth(), this.getHeight());
		this.add(layeredPane);

		// ランダムに猫を生成する(レア猫とコモン猫を生成)
		for (int i = 0; i < animals.size(); i++) {
			int rnd = new Random().nextInt(100);
			if (rnd < 30) {// 30%
				animals.set(i, new Cat_Normal());
			} else if (rnd < 50) {// 20%
				animals.set(i, new Fish_Cat());
			} else if (rnd < 70) {// 20%
				animals.set(i, new Normal_Dog());
			} else if (rnd < 85) {// 15%
				animals.set(i, new Jinmen_Dog());
			} else if (rnd < 95) {// 10%
				animals.set(i, new Soujiki_Cat());
			} else {// 5%
				animals.set(i, new Cat_SSR());
			}
			this.add(animals.get(i));
			vitalizeCat(animals.get(i));
		}
		// 猫鍋を設置
		catPot = new CatPot();
		this.add(catPot);
		this.layeredPane.add(catPot, JLayeredPane.DEFAULT_LAYER);
	}

	public void vitalizeCat(Animal animal) {
		AnimalActionListener animalActionListener = new AnimalActionListener(animal);
		animal.timer = new Timer(10, animalActionListener);
		this.add(animal);
		animal.timer.start();
		this.layeredPane.add(animal, JLayeredPane.DRAG_LAYER);
	}

	public void generateAnimal() {
		int rnd = new Random().nextInt(100);
		if (rnd < 30) {// 30%
			animals.add(new Cat_Normal());
		} else if (rnd < 50) {// 20%
			animals.add(new Fish_Cat());
		} else if (rnd < 70) {// 20%
			animals.add(new Normal_Dog());
		} else if (rnd < 85) {// 15%
			animals.add(new Jinmen_Dog());
		} else if (rnd < 95) {// 10%
			animals.add(new Soujiki_Cat());
		} else {// 5%
			animals.add(new Cat_SSR());
		}
		this.add(animals.get(animals.size() - 1));
		vitalizeCat(animals.get(animals.size() - 1));
	}

	private class AnimalActionListener implements ActionListener, MouseListener, MouseMotionListener {
		// 貼り付け先を保持
		private Animal animal;
		private int dx;
		private int dy;

		public AnimalActionListener(Animal animal) {
			this.animal = animal;
			animal.addMouseListener(this);
			animal.addMouseMotionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自動生成されたメソッド・スタブ

			if (animal.x > Main.mainWindow.gamePanel.fieldPanel.getWidth() - animal.getWidth() || animal.x < 0) {
				animal.xVelocity = animal.xVelocity * (-1);
			}
			animal.x = animal.x + animal.xVelocity;
			if (animal.y > Main.mainWindow.gamePanel.fieldPanel.getHeight() - animal.getHeight() || animal.y < 0) {
				animal.yVelocity = animal.yVelocity * (-1);
			}
			animal.y = animal.y + animal.yVelocity;
			animal.setLocation(animal.x, animal.y);
			animal.repaint();
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO 自動生成されたメソッド・スタブ

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO 自動生成されたメソッド・スタブ
			// 押さえたところからラベルの左上の差を取っておく
			dx = e.getXOnScreen() - animal.getX();
			dy = e.getYOnScreen() - animal.getY();
			animal.timer.stop();
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO 自動生成されたメソッド・スタブ
			int x = e.getXOnScreen();
			int y = e.getYOnScreen();
			int px = (int) catPot.getLocationOnScreen().getX();
			int py = (int) catPot.getLocationOnScreen().getY();
			int ph = catPot.getHeight();
			int pw = catPot.getWidth();

			if ((px < x) && (x < px + pw) && (py < y) && y < (py + ph)) {
				System.out.println("にゃー");
				animal.setVisible(false);
				generateAnimal();

			}else {
				animal.timer.start();
			}

//			System.out.println("X座標：" + x + ",Y座標：" + y);
//			System.out.println("PX座標：" + px + ",PY座標：" + py);
//			System.out.println("PW座標：" + pw + ",PH座標：" + ph);

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO 自動生成されたメソッド・スタブ

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO 自動生成されたメソッド・スタブ

		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO 自動生成されたメソッド・スタブ
			// マウスの座標からラベルの左上の座標を取得
			int x = e.getXOnScreen() - dx;
			int y = e.getYOnScreen() - dy;
			if (x < Main.mainWindow.gamePanel.fieldPanel.getWidth() - animal.getWidth() - 5 && x > 5) {
				animal.x = x;
			}
			if (y < Main.mainWindow.gamePanel.fieldPanel.getHeight() - animal.getHeight() - 5 && y > 5) {
				animal.y = y;
			}
			animal.setLocation(animal.x, animal.y);
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO 自動生成されたメソッド・スタブ

		}

	}

}