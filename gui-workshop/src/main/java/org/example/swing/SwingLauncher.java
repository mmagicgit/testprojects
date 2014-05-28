package org.example.swing;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class SwingLauncher {

    public static void main(String[] args) {
        new SwingLauncher().start(args);
    }

    private void start(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(createContent());
            }
        });
    }

    private JPanel createContent() {
        JLabel label = new JLabel("hello world");
        final JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(160, 25));
        final JButton button = new JButton("press me");

        listenToButtonPressAndRespond(textField, button);
        listenToTextInputAndUpdateButtonText(textField, button);

        final JPanel panel = new JPanel();
        panel.add(label);
        panel.add(button);
        panel.add(textField);
        return panel;
    }

    private void listenToButtonPressAndRespond(final JTextField textField, JButton button) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("Ouch, not so hard...");
            }
        });
    }

    private void listenToTextInputAndUpdateButtonText(final JTextField textField, final JButton button) {
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.setText(textField.getText());
            }
        });
    }

    private void createAndShowGUI(JComponent display) {
        JFrame frame = new JFrame("application name");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(display);
        frame.pack();
        frame.setVisible(true);
    }

}
