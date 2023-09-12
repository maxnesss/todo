package todoapp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    // ---Loads list of tasks from file---
    // returns list of tasks
    public List<Task> loadFile() {
        Path filePath = Paths.get("assets/text.txt");
        List<String> lines = new ArrayList<>();
        List<Task> listOfTasks = new ArrayList<>();
        //writes to file
        try {
            lines = Files.readAllLines(filePath);
        } catch (IOException exeption) {
            System.out.println("Couldn't read our tasks file");
        }
        for (String line : lines) {
            listOfTasks.add(new Task(line));
        }
        for (Task task: listOfTasks
             ) {
            if (task.getName().charAt(1) == 'X'){
                task.setCompleted(true);
            }
        }
        return listOfTasks;
    }

    // ---Saves list of tasks to file---
    public void saveFile(List<Task> listOfTasks){
        Path filePath = Paths.get("assets/text.txt");

        List<String> lines = new ArrayList<>();

        for (Task task:listOfTasks) {
            if (task.isCompleted()){
                lines.add("[X] "+ task.getName().substring(4));//know
            } else {
                lines.add(task.getName());
            }
        }
        try {
            // writes to file
            Files.write(filePath,lines);
        } catch (IOException exception){
            System.out.println("couldn't write to file");
        }
    }
    }


