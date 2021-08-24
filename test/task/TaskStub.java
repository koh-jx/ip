package task;
import task.Task;

import java.time.LocalDate;

public class TaskStub extends Task {

    public TaskStub(String input, boolean done) {
        super(input, done);
    }

    public boolean toggleDone() {
        done = !done;
        return done;
    }

    @Override
    public String toString() {
        String checkBox = done
                ? "[X] "
                : "[ ] ";
        return checkBox + description;
    }

    public String saveString() {
        String checkBox = done
                ? "[X] "
                : "[ ] ";
        return checkBox + description;
    }
    public boolean isDate(LocalDate date) {
        return false;
    }
}