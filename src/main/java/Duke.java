import java.io.*;
//import java.nio.file.attribute.FileStoreAttributeView;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    private static String filePath = "D:/DukeDatabase/ArrayList";

    private static void print_output(Task CurrentTask, int no_of_tasks) // Used to print the output repeatedly!
    {
        String user_output_dash = "_______________________________";
        System.out.println(user_output_dash);
        System.out.println("Got it. I've added this task:");
        System.out.println(CurrentTask.toString());
        System.out.println("Now you have " + no_of_tasks + " tasks in the list.");
        System.out.println(user_output_dash);
    }

    public static void main(String[] args) throws IOException{

        File Database = new File(filePath);

        Scanner scanner = new Scanner(System.in);
        String greeting = "_______________________________\n"
                        + "Hello! I'm Duke\n"
                        + "What can I do for you?\n"
                        + "_______________________________\n";

        System.out.println(greeting);

        ArrayList<Task> listOfTasks = loadFile(Database); //new ArrayList<Task>();

        String user_output_dash = "_______________________________"; // just a definition

        int iterate; int counter;
        String user_input; //declared outside to be used by the do-while loop

        do
        {
            user_input = scanner.nextLine();

            if(user_input.contains("list"))
            {
                System.out.println(user_output_dash + "\n" + "Here are the tasks in your list:");
                iterate = 0;
                counter = 0;
                while(counter < listOfTasks.size()) // this prints out all the different tasks you have
                {
                    Task currentTask = listOfTasks.get(iterate);
                    System.out.println((counter+=1) + "." + currentTask.toString());
                    iterate++;
                }
                System.out.println(user_output_dash);
            }
            else if (user_input.matches("done \\d+")) {
                int listIndex = Integer.parseInt(user_input.replaceAll("[^0-9]", ""));
                listIndex -= 1;
                if (listIndex < listOfTasks.size() && listIndex >= 0) {
                    Task currentTask = listOfTasks.get(listIndex); // object instance
                    currentTask.markAsDone();
                    System.out.println(user_output_dash);
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println(currentTask.toString());
                    System.out.println(user_output_dash);
                    saveFile(listOfTasks,Database);
                }
                else
                {
                    System.out.println(user_output_dash);
                    System.out.println("☹ OOPS!!! Sorry the task does not exist!");
                    System.out.println(user_output_dash);
                }
            }
            else if (user_input.matches("todo.*"))
            {
                String todo_name = user_input.replace("todo","");
                todo_name.replace(" ", "");
                try {
                    Todo TodoTask = new Todo(todo_name);
                    listOfTasks.add(TodoTask);
                    print_output(TodoTask, listOfTasks.size());
                    saveFile(listOfTasks,Database);
                }
                catch (DukeException e) {
                    System.out.println(e);
                }
            }
            else if (user_input.matches("deadline.*"))
            {
                if(user_input.matches("deadline.*/by.*")) {
                    user_input = user_input.replace("deadline", "");
                    String[] parts = user_input.split("/by");
                    String deadline_name = parts[0];
                    String deadline_date;

                    if (parts.length < 2) { deadline_date = ""; }
                    else { deadline_date = parts[1]; }

                    try {
                        Deadline DeadlineTask = new Deadline(deadline_name, deadline_date);
                        listOfTasks.add(DeadlineTask);
                        print_output(DeadlineTask, listOfTasks.size());
                        saveFile(listOfTasks,Database);
                    } catch (DukeException e) {
                        System.out.println(e);
                    }
                    catch (ParseException e){
                        System.out.println("☹ OOPS!!! The deadline should be of the format <dd/MM/yyyy HHmm>");
                        //e.printStackTrace();
                    }
                }
                else{
                    System.out.println("☹ OOPS!!! The deadline is not given in the proper format of (deadline <description> /by <dd/MM/yyyy HHmm>)");
                }
            }
            else if (user_input.matches("event.*"))
            {
                if (user_input.matches("event.*/at.*")) {
                    user_input = user_input.replace("event", "");
                    String[] parts = user_input.split("/at");
                    String event_name = parts[0];
                    String event_dateandtime;

                    if (parts.length < 2) { event_dateandtime = ""; }
                    else { event_dateandtime = parts[1]; }

                    try {
                        Event EventTask = new Event(event_name, event_dateandtime);
                        listOfTasks.add(EventTask);
                        print_output(EventTask, listOfTasks.size());
                        saveFile(listOfTasks,Database);
                    } catch (DukeException e) {
                        System.out.println(e);
                    } catch (ParseException e) {
                        System.out.println("☹ OOPS!!! The event's should be of the format <dd/MM/yyyy HHmm-HHmm>");
                    }
                    }
                else{
                    System.out.println(("☹ OOPS!!! The event is not given in the proper format (event <description> /at <dd/MM/yyyy HHmm-HHmm>)"));
                }

            }
            else if (user_input.contains("duke-manual"))
            {
                System.out.println("Hi, this is Duke!");
                System.out.println("I am able to let you add tasks of three types! todo, event and deadline");
                System.out.println("1. To enter a todo task, key in todo<space>your task description eg. todo borrow books");
                System.out.println("2. To enter a deadline, key in deadline<space>your deadline description<space>/by<space>the date eg. return books/by Sunday");
                System.out.println("3. To enter a event, key in event<space>your event description<space>/at<space>the day or date and the time eg. Project meeting /at 2-4pm Sunday");
                System.out.println("4. To list out all your tasks simply enter list");
                System.out.println("5. To mark a task as complete just enter done<space>the index of the task as listed");
                System.out.println("6. To exit, enter bye");
            }
            else if(!user_input.matches("bye"))
            {
                System.out.println(" ☹ OOPS!!! I'm sorry, but I don't know what that means. If you would like to know how to use Duke, Enter duke-manual");
            }

        }while (!user_input.equals("bye"));

        String goodbye = "_______________________________\n"
                       + "Bye. Hope to see you again soon!\n"
                       + "_______________________________\n";
        System.out.println(goodbye);
    }

    private static void saveFile(ArrayList<Task> listOfTasks, File database) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(database);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(listOfTasks);
            objectOutputStream.close(); //always close
            fileOutputStream.close(); //always close
        } catch (IOException e) {
            System.out.println("☹ OOPS!!! Error writing task list to file!!!");
        }
    }

    private static ArrayList<Task> loadFile(File Database) throws IOException {
        ArrayList<Task> listOfTasks = new ArrayList<Task>();
        try {
            FileInputStream fileInputStream = new FileInputStream(Database);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            listOfTasks = (ArrayList<Task>) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
        } catch (FileNotFoundException e) {
            Database = new File(filePath);
            Database.createNewFile();
        } catch (IOException e) {
            e.getMessage();
        } catch (ClassNotFoundException e) {
            System.out.println("☹ OOPS!!! The project folder for Duke is missing the 'Task' class type");
        }
        return listOfTasks;
    }
}
