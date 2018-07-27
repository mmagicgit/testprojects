package c_model_to_view_listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



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
	}
	
	private void initializeListeners() {
		view.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});
		model.addChangeListsner(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				view.showUsers(model.getUsers());
			}
		});
		
	}
}
