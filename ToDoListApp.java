import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private ArrayList<String> tasks;

    public ToDoList() {
        tasks = new ArrayList<>();
    }

    // Method to add a task
    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    // Method to delete a task
    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            String removedTask = tasks.remove(index);
            System.out.println("Task removed: " + removedTask);
        } else {
            System.out.println("Invalid index. Task not removed.");
        }
    }

    // Method to display the list of tasks
    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the to-do list.");
        } else {
            System.out.println("To-Do List:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    // Method to mark a task as complete
    public void markComplete(int index) {
        if (index >= 0 && index < tasks.size()) {
            String completedTask = tasks.get(index);
            tasks.set(index, "[Completed] " + completedTask);
            System.out.println("Task marked as complete: " + completedTask);
        } else {
            System.out.println("Invalid index. Task not marked as complete.");
        }
    }

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Display Tasks");
            System.out.println("4. Mark Task as Complete");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter task to add: ");
                    scanner.nextLine(); // Consume the newline character
                    String newTask = scanner.nextLine();
                    toDoList.addTask(newTask);
                    break;
                case 2:
                    System.out.print("Enter index to delete: ");
                    int deleteIndex = scanner.nextInt();
                    toDoList.deleteTask(deleteIndex - 1);
                    break;
                case 3:
                    toDoList.displayTasks();
                    break;
                case 4:
                    System.out.print("Enter index to mark as complete: ");
                    int completeIndex = scanner.nextInt();
                    toDoList.markComplete(completeIndex - 1);
                    break;
                case 5:
                    System.out.println("Exiting the application. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

   
}
