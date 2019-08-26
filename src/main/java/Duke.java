import java.util.ArrayList;
import java.util.Scanner;
public class Duke {

    private static void print_output(Task CurrentTask, int no_of_tasks) // Used to print the output repeatedly!
    {
        String user_output_dash = "_______________________________";
        System.out.println(user_output_dash);
        System.out.println("Got it. I've added this task:");
        System.out.println(CurrentTask.toString());
        System.out.println("Now you have " + no_of_tasks + " tasks in the list.");
        System.out.println(user_output_dash);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String greeting = "_______________________________\n"
                        + "Hello! I'm Duke\n"
                        + "What can I do for you?\n"
                        + "_______________________________\n";

        System.out.println(greeting);

        ArrayList<Task> listOfTasks = new ArrayList<Task>();

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
                if (listIndex < listOfTasks.size()) {
                    Task currentTask = listOfTasks.get(listIndex); // object instance
                    currentTask.markAsDone();
                    System.out.println(user_output_dash);
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println(currentTask.toString());
                    System.out.println(user_output_dash);
                }
                else
                {
                    System.out.println(user_output_dash);
                    System.out.println("Sorry the task does not exist!");
                    System.out.println(user_output_dash);
                }
            }
            else if (user_input.contains("todo"))
            {
                String todo_name = user_input.replace("todo ","");
                Todo TodoTask = new Todo(todo_name);
                listOfTasks.add(TodoTask);
                print_output(TodoTask, listOfTasks.size());
            }
            else if (user_input.contains("deadline"))
            {
                user_input = user_input.replace("deadline","");
                String[] parts = user_input.split("/by");
                String deadline_name = parts[0];
                String deadline_date = parts[1];
                Deadline DeadlineTask = new Deadline(deadline_name,deadline_date);
                listOfTasks.add(DeadlineTask);
                print_output(DeadlineTask,listOfTasks.size());
            }
            else if (user_input.contains("event"))
            {
                user_input = user_input.replace("event","");
                String[] parts = user_input.split("/at");
                String event_name = parts[0];
                String event_dateandtime = parts[1];
                Event EventTask = new Event(event_name,event_dateandtime);
                listOfTasks.add(EventTask);
                print_output(EventTask,listOfTasks.size());

            }
        }while (!user_input.equals("bye"));

        String goodbye = "_______________________________\n"
                       + "Bye. Hope to see you again soon!\n"
                       + "_______________________________\n";
        System.out.println(goodbye);
    }
}
