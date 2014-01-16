package java8;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Listener {

	public static void main(String[] args) {
		JButton button = new JButton();
		
		ActionListener listener = e -> System.out.println("Button gedrückt");
		button.addActionListener(listener);
		
		button.doClick();
		
	}

}
