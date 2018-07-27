package c_model_to_view_listener;

import java.util.Collections;
import java.util.List;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.google.common.collect.Lists;

public class UserModel {

	private final List<User> users = Lists.newArrayList();
	private ChangeListener listener;

	public List<User> getUsers() {
		return Collections.unmodifiableList(users);
	}
	
	public void exchangeData(List<User> newUsers) {
		users.clear();
		users.addAll(newUsers);
		listener.stateChanged(new ChangeEvent(this));
	}
	
	public void addChangeListsner(ChangeListener listener) {
		this.listener = listener;
	}
	
}
