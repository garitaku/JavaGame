package screen_change;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.event.*;
import javax.swing.*;
import javax.swing.Timer;

public class FieldPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	ArrayList<Animal> animals = new ArrayList<Animal>();
	Animal animal01;
	Animal animal02;
	Animal animal03;

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
		}
	}

	public void vitalizeCat(Animal animal) {
		AnimalActionListener animalActionListener = new AnimalActionListener(animal);
		animal.timer = new Timer(10, animalActionListener);
		this.add(animal);
		animal.timer.start();
	}

	private class AnimalActionListener implements ActionListener {
		// 貼り付け先を保持
		private Animal animal;

		public AnimalActionListener(Animal animal) {
			this.animal = animal;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自動生成されたメソッド・スタブ

		}

	}

}
