package a_basic;



public class UserPresenter {

	private UserModel model;
	private UserView view;
	private UserDao userDao;

	public UserPresenter(UserModel model, UserView view, UserDao userDao) {
		this.model = model;
		this.view = view;
		this.userDao = userDao;
	}

	public void refresh() {
		model.exchangeData(userDao.findAll());
		view.showUsers(model.getUsers());
	}
	
}
