import java.util.Scanner;
public class Duke {
    public static void print_output(String n) //Used to print the output repeatedly!
    {
        String user_output_dash = "_______________________________";
        System.out.println(user_output_dash);
        System.out.println(n);
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

        String n = user_input.nextLine();
        print_output(n);

        while(!n.equals("bye"))
        {
            n = user_input.nextLine();
            print_output(n);
        }

        print_output(n);

        String goodbye = "_______________________________\n"
                       + "Bye. Hope to see you again soon!\n"
                       + "_______________________________\n";

        System.out.println(goodbye);
    }
}
