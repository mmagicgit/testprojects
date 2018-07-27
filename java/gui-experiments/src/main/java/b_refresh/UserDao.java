package b_refresh;

import java.util.Collections;
import java.util.List;

import org.joda.time.LocalDate;

import com.google.common.collect.Lists;

public class UserDao {

	public List<User> findAll() {
		User user1 = new User("hans", 31, new LocalDate(1982, 11, 30));
		User user2 = new User("maria", 5, new LocalDate(2009, 1, 19));
		List<User> result = Lists.newArrayList(user1, user2);
		Collections.shuffle(result);
		return result;
	}
	
}
