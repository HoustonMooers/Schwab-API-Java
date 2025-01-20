package com.hm.schwab.oauth;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class ResponsePopup {

    public static String getResponse(String url) {
        // Create the frame
        JFrame frame = new JFrame("URL Popup Example");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(800, 150);
        frame.setLayout(new BorderLayout());

        // Create the clickable URL
        JLabel urlLabel = new JLabel("<html><a href=''>" + url + "</a></html>");
        urlLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        urlLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    Desktop.getDesktop().browse(new URI(url));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        // Create the label
        JLabel label = new JLabel("Paste response URL here: ");

        // Create the text field
        JTextField textField = new JTextField(40);

        // Create the submit button
        JButton submitButton = new JButton("Submit");

        // Create a panel to hold the components
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(urlLabel);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        inputPanel.add(label);
        inputPanel.add(textField);
        inputPanel.add(submitButton);

        panel.add(inputPanel);

        // Create a JOptionPane to block the execution
        JOptionPane optionPane = new JOptionPane(panel, JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);

        // Add action listener to the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String responseUrl = textField.getText();
                if (!responseUrl.isBlank()) {
                    optionPane.setValue(responseUrl);
                    frame.dispose();
                }
            }
        });

        // Create a dialog to display the JOptionPane
        JDialog dialog = optionPane.createDialog(frame, "URL Popup Example");
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);

        // Wait for the user to submit the response URL
        String responseUrl = (String) optionPane.getValue();
        return responseUrl;
    }
}