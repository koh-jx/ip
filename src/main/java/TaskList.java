import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Matcher;

public class TaskList {
    private final ArrayList<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }
    public TaskList(ArrayList<Task> tasks) { this.tasks = tasks; }

    /**
     * Prints the number of tasks in the list
     */
    public void printSize() {
        System.out.println( Ui.OUTPUT_DISPLAY +
                (tasks.size() == 1
                    ? "There is 1 task in your list"
                    : "There are " + tasks.size() + " tasks in your list"));
    }

    /**
     * Adds a task into the task list
     *
     * @param input A matcher object with the groups of information
     *              required to create a task with the corresponding
     *              task type
     * @param type The TaskType of task to add
     */
    public void add(Matcher input, TaskType type) {
        Optional.ofNullable(
                TaskType.getTask(input, type))
                    .map(task -> {
                        System.out.println(Ui.OUTPUT_SPACES + task);
                        tasks.add(task);
                        return null;
                    });
        this.printSize();
        this.saveList();
    }


    /**
     * Marks the task as complete (or incomplete if it is already complete)
     *
     * @param index Index of the task displayed by the list command
     *              Actual index is (index - 1)
     */
    public void toggleDone(int index) {
        try {
            boolean result = tasks.get(index - 1).toggleDone();
            System.out.println(result
                    ? Ui.OUTPUT_DISPLAY + "sugoi! Duke-san marked this task as done!"
                    : Ui.OUTPUT_DISPLAY + "Duke-san marked this task as not done!");
            System.out.println(Ui.OUTPUT_SPACES + tasks.get(index - 1));
            saveList();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("There's no task at index " + index + "!!");
        }
    }

    /**
     * Deletes a task from the task list
     *
     * @param index Index of the task displayed by the list command
     *              Actual index is (index - 1)
     */
    public void delete(int index) {
        try {
            Task removed = tasks.remove(index - 1);
            System.out.println(Ui.OUTPUT_DISPLAY + "Noted. Duke-san removed this task:");
            System.out.println(Ui.OUTPUT_SPACES + removed);
            this.printSize();
            saveList();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("There's no task at index " + index + "!!");
        }
    }

    /**
     * Displays the list of tasks
     */
    public void displayList() {
        if (tasks.size() == 0) {
            System.out.println(Ui.OUTPUT_DISPLAY + "There is nothing to display! :angery:");
        } else {
            System.out.println(Ui.OUTPUT_DISPLAY + "Displaying List:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(Ui.OUTPUT_SPACES + (i + 1) + "." + tasks.get(i));
            }
        }
    }

    private static String FILE_LOCATION = "C:\\Users\\kohjx\\projects\\ip\\data\\TaskList.txt";
    private void saveList() {
        try {
            FileWriter writer = new FileWriter(TaskList.FILE_LOCATION, false);
            for (Task task : tasks) {
                writer.write(task.saveString());
                writer.write("\r\n");
            }
            writer.close();
            System.out.println(Ui.OUTPUT_DISPLAY + "Duke-san saved your list UwU");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TaskList loadList() {
        try {
            FileReader reader = new FileReader(TaskList.FILE_LOCATION);
            File file = new File(TaskList.FILE_LOCATION);
            Scanner text = new Scanner(file);

            ArrayList<Task> loaded = new ArrayList<>();
            while(text.hasNextLine()) {
                String task = text.nextLine();
                loaded.add(Task.StringToTask(task));
            }

            System.out.println("List loaded!");
            return new TaskList(loaded);

        } catch (IOException e) {
            return new TaskList();
        }
//        catch (//Errors in text file) {}
    }
}
