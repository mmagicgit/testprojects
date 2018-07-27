package b_refresh;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class UserPresenter {

	private UserModel model;
	private UserView view;
	private UserDao userDao;

	public UserPresenter(UserModel model, UserView view, UserDao userDao) {
		this.model = model;
		this.view = view;
		this.userDao = userDao;
		initializeListeners();
	}

	public void refresh() {
		model.exchangeData(userDao.findAll());
		view.showUsers(model.getUsers());
	}
	
	private void initializeListeners() {
		view.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});
		
	}
}
