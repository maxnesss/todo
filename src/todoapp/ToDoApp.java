package todoapp;

import java.util.ArrayList;
import java.util.List;

public class ToDoApp {
    public static List<Task> listOfTasks = new ArrayList<>();
    public static FileHandler fileHandler = new FileHandler();

    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();
        listOfTasks = fileHandler.loadFile();
        if (args.length == 0){
            menu();
        } else {
        switch (args[0]) {
            case "" -> menu();
            case "-l" -> listTasks();
            case "-a" ->{ try {addTask(args[1]);} catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Unable to add: no task provided");}}
            case "-r" -> {try {removeTask(Integer.parseInt(args[1]));} catch (ArrayIndexOutOfBoundsException e){System.out.println("Unable to check: o index provided");}
            catch (IndexOutOfBoundsException outE){
                System.out.println("Unable to check: index out of bound");
            }}
            case "-c" -> {try {checkTask(Integer.parseInt(args[1]));} catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Unable to check: no index provided");}
                catch (IndexOutOfBoundsException outE){
                    System.out.println("Unable to check: index out of bound");
                }
            catch (NumberFormatException numE){
                System.out.println("Unable to check: index is not a number");
            } }
            default -> System.out.println("Unsupported argument");
        }
    }}
    // lists tasks
    public static void listTasks(){
        if (listOfTasks.isEmpty()){
            System.out.println("No todos for today! :)");
        }

        int lineNumber = 1;
        for (Task task : listOfTasks) {
            System.out.println(lineNumber + " - " +task.getName());
            lineNumber++;
        }
    }
    // add task
    public static void addTask(String nameOfTask){
        listOfTasks.add(new Task("[ ] " + nameOfTask));
        fileHandler.saveFile(listOfTasks);
    }
    // removes task
    public static void removeTask(int taskNo){
        listOfTasks.remove(taskNo-1);
        fileHandler.saveFile(listOfTasks);
    }
    // check tasks
    public static void checkTask(int taskNo){

        listOfTasks.get(taskNo-1).setCompleted(true);//wrong task nmb
        fileHandler.saveFile(listOfTasks);
    }
    // menu
    public static void menu(){
        System.out.println("""
                Command Line Todo application
                =============================

                Command line arguments:
                    -l   Lists all the tasks
                    -a   Adds a new task
                    -r   Removes an task
                    -c   Completes an task""");
    }
}
