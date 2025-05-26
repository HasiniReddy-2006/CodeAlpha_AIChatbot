import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class Chatbot extends JFrame {
    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;
    private HashMap<String, String> responses;

    public Chatbot() {
        setTitle("AI Chatbot");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        add(new JScrollPane(chatArea), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputField = new JTextField();
        sendButton = new JButton("Send");
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        add(inputPanel, BorderLayout.SOUTH);

        responses = new HashMap<>();
        responses.put("hi", "Hello! How can I assist you?");
        responses.put("how are you", "I'm just a bot, but I'm functioning well!");
        responses.put("what is your name", "I am your Java AI Chatbot.");
        responses.put("bye", "Goodbye! Have a great day.");
        responses.put("thanks", "You're welcome!");

        sendButton.addActionListener(e -> sendMessage());
        inputField.addActionListener(e -> sendMessage());
    }

    private void sendMessage() {
        String input = inputField.getText().toLowerCase().trim();
        chatArea.append("You: " + input + "\n");
        inputField.setText("");

        String reply = responses.getOrDefault(input, "Sorry, I don't understand that.");
        chatArea.append("Bot: " + reply + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Chatbot().setVisible(true));
    }
}
