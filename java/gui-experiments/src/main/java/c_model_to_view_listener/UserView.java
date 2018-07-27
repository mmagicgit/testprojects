package c_model_to_view_listener;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.google.common.collect.Lists;

public class UserView {

	private JPanel mainPanel = new JPanel(new BorderLayout());
	private JButton refreshButton = new JButton("Refresh");
	private JPanel userPanel = new JPanel(new GridLayout(0, 3));
	private List<SingleUserView> userView = Lists.newArrayList(new SingleUserView(), new SingleUserView());

	public UserView() {
		mainPanel.add(refreshButton, BorderLayout.NORTH);
		mainPanel.add(userPanel, BorderLayout.CENTER);
	}
	
	public JComponent getComponent() {
		return mainPanel;
	}

	public void showUsers(List<User> users) {
		userView.get(0).setUser(users.get(0));
		userView.get(1).setUser(users.get(1));
	}

	public void addActionListener(ActionListener listener) {
		refreshButton.addActionListener(listener);
	}
	
	private class SingleUserView {

		private JLabel name = new JLabel("", SwingConstants.CENTER);
		private JLabel age = new JLabel("", SwingConstants.CENTER);
		private JLabel birthday = new JLabel("", SwingConstants.CENTER);

		private SingleUserView() {
			userPanel.add(name);
			userPanel.add(age);
			userPanel.add(birthday);
		}
		
		private void setUser(User user) {
			name.setText(user.name);
			age.setText(String.valueOf(user.age));
			birthday.setText(user.birthday.toString());
		}

	}

}
