import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDoListGUI extends JFrame {
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;

    public ToDoListGUI() {
        setTitle("To-Do List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);

        JButton addButton = new JButton("Add Task");
        JButton deleteButton = new JButton("Delete Task");
        JButton completeButton = new JButton("Mark as Complete");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newTask = JOptionPane.showInputDialog("Enter task to add:");
                if (newTask != null && !newTask.trim().isEmpty()) {
                    taskListModel.addElement(newTask);
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    taskListModel.remove(selectedIndex);
                } else {
                    JOptionPane.showMessageDialog(null, "Select a task to delete.");
                }
            }
        });

        completeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    String selectedTask = taskListModel.get(selectedIndex);
                    taskListModel.setElementAt("[Completed] " + selectedTask, selectedIndex);
                } else {
                    JOptionPane.showMessageDialog(null, "Select a task to mark as complete.");
                }
            }
        });

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(completeButton);

        JScrollPane scrollPane = new JScrollPane(taskList);

       // getContentPane().setLayout(new BorderLayout());
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ToDoListGUI toDoListGUI = new ToDoListGUI();
                toDoListGUI.setVisible(true);
            }
        });
    }
}
