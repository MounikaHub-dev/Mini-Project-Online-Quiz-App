package com.task6;

import javax.swing.*;
import java.awt.*;

public class TodoApp {

    public static void main(String[] args) {

        JFrame frame = new JFrame("To-Do List App");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); 

    
        JPanel panel = new JPanel(new BorderLayout());

       
        JTextField taskField = new JTextField();
        panel.add(taskField, BorderLayout.NORTH);

        
        DefaultListModel<String> taskListModel = new DefaultListModel<>();
        JList<String> taskList = new JList<>(taskListModel);
        panel.add(new JScrollPane(taskList), BorderLayout.CENTER);

       
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Task");
        JButton deleteButton = new JButton("Delete Task");

       
        addButton.addActionListener(e -> {
            String task = taskField.getText().trim();
            if (!task.isEmpty()) {
                taskListModel.addElement(task); 
                taskField.setText(""); 
            } else {
                JOptionPane.showMessageDialog(frame, "Enter a task!");
            }
        });

     
        deleteButton.addActionListener(e -> {
            int index = taskList.getSelectedIndex();
            if (index != -1) {
                taskListModel.remove(index); // Remove selected
            } else {
                JOptionPane.showMessageDialog(frame, "Select a task to delete!");
            }
        });

     
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

      
        frame.add(panel);

      
        frame.setVisible(true);
    }
}
