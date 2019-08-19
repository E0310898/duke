import java.util.ArrayList;
import java.util.Scanner;
public class Duke {
    public static void print_output(String n) //Used to print the output repeatedly!
    {
        String user_output_dash = "_______________________________";
        System.out.println(user_output_dash);
        System.out.println("added:" + " " + n);
        System.out.println(user_output_dash);
    }
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        //System.out.println("Hello from\n" + logo);

        Scanner user_input = new Scanner(System.in);
        String greeting = "_______________________________\n"
                        + "Hello! I'm Duke\n"
                        + "What can I do for you?\n"
                        + "_______________________________\n";

        System.out.println(greeting);
        ArrayList<String> listOfTasks = new ArrayList<String>();
        String user_output_dash = "_______________________________";
        String n = "not_bye";
        int iterate = 0;
        int loc_changer = 0;
        int counter = 0;
        while(!n.equals("bye"))
        {
            n = user_input.nextLine();
            if(n.equals("list"))
            {
                iterate = 0;
                counter = 0;
                System.out.println(user_output_dash);
                while(counter < listOfTasks.size())
                {
                    System.out.println((counter+=1) + "." + " " + listOfTasks.get(iterate));
                    iterate++;
                }
                System.out.println(user_output_dash);
            }
            else if (!n.equals("bye"))
            {
                listOfTasks.add(loc_changer,n);
                loc_changer++;
                print_output(n);
            }
        }

        String goodbye = "_______________________________\n"
                       + "Bye. Hope to see you again soon!\n"
                       + "_______________________________\n";

        System.out.println(goodbye);
    }
}
