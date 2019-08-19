import java.util.ArrayList;
import java.util.Scanner;
public class Duke {
    public static void print_output(String n) //Used to print the output repeatedly!
    {
        String user_output_dash = "_______________________________";
        System.out.println(user_output_dash);
        System.out.println("Task added:" + " " + n);
        System.out.println(user_output_dash);
    }

    public static void main(String[] args) {

        Scanner user_input = new Scanner(System.in);
        String greeting = "_______________________________\n"
                        + "Hello! I'm Duke\n"
                        + "What can I do for you?\n"
                        + "_______________________________\n";

        System.out.println(greeting);

        ArrayList<Task> listOfTasks = new ArrayList<Task>();

        String user_output_dash = "_______________________________"; // just a definition
        String n = "not_bye";
        int iterate; int counter;

        while(!n.equals("bye"))
        {
            n = user_input.nextLine();

            if(n.equals("list"))
            {
                System.out.println(user_output_dash + "\n" + "Here are the tasks in your list:");
                iterate = 0;
                counter = 0;
                System.out.println(user_output_dash);
                while(counter < listOfTasks.size())
                {
                    System.out.println((counter+=1) + "." + "[" + listOfTasks.get(iterate).getStatusIcon() + "]" + " " + listOfTasks.get(iterate).description);
                    iterate++;
                }
                System.out.println(user_output_dash);
            }
            else if (n.matches("done \\d+")) {
                int listIndex = Integer.parseInt(n.replaceAll("[^0-9]", ""));
                listIndex -= 1;
                if (listIndex < listOfTasks.size()) {
                    Task currentTask = listOfTasks.get(listIndex); // object instance
                    currentTask.markAsDone();
                    System.out.println(user_output_dash);
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("[" + listOfTasks.get(listIndex).getStatusIcon() + "]" + " " + listOfTasks.get(listIndex).description);
                    System.out.println(user_output_dash);
                }
                else
                {
                    System.out.println(user_output_dash);
                    System.out.println("Sorry the task does not exist!");
                    System.out.println(user_output_dash);
                }
            }
            else if (!n.equals("bye"))
            {
                Task task = new Task(n);
                listOfTasks.add(task);
                print_output(n);
            }
        }
        String goodbye = "_______________________________\n"
                       + "Bye. Hope to see you again soon!\n"
                       + "_______________________________\n";
        System.out.println(goodbye);
    }
}
