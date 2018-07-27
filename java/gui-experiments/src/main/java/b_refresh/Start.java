package b_refresh;

import javax.swing.JFrame;

public class Start {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Hallo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(320, 120);
		frame.setVisible(true);
		
		UserDao userDao = new UserDao();
		UserModel model = new UserModel();
		UserView view = new UserView();
		UserPresenter presenter = new UserPresenter(model, view, userDao);
		
		frame.add(view.getComponent());
		presenter.refresh();
	}

}
