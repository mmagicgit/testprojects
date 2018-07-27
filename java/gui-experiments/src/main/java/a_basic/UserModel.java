package a_basic;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

public class UserModel {

	private final List<User> users = Lists.newArrayList();

	public List<User> getUsers() {
		return Collections.unmodifiableList(users);
	}
	
	public void exchangeData(List<User> newUsers) {
		users.clear();
		users.addAll(newUsers);
	}
	
}
