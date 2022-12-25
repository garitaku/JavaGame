package screen_change;


public class Main {
	static MainWindow mainWindow;

	public static void main(String[] args) {
		mainWindow = new MainWindow();// ウインドウのみ生成
		mainWindow.preparePanels();// ペインに直接貼るパネルのみ生成
		mainWindow.prepareComponents();// その他のコンポーネントを生成
		mainWindow.setFontScreenAndFocus(ScreenMode.TITLE);
		// 起動後最初に表示すべき画面を手前に持ってきてそれに注目させる
		mainWindow.setVisible(true);
	}
}
