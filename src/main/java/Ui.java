import java.util.Scanner;

public class Ui {

    private static String userOutputDash = "_______________________________"; // just a definition
    private static String userInput;
    private static Scanner scanner = new Scanner(System.in);

    public static void printLogo() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println(logo);
    }

    public static void printDash(){
        System.out.println(userOutputDash);
    }

    public static void printGreeting() {
        String greeting = "_______________________________\n"
                + "Hello! I'm Duke\n"
                + "What can I do for you?\n"
                + "_______________________________\n";
        System.out.println(greeting);
    }

    public static void printGoodbye() {
        String goodbye = "_______________________________\n"
                + "Bye. Hope to see you again soon!\n"
                + "_______________________________\n";
        System.out.println(goodbye);
    }

    // Used to print the output repeatedly!
    public static void printOutput(String userOutput) {
        System.out.println(userOutputDash);
        System.out.println(userOutput);
        System.out.println(userOutputDash);
    }

    public static String readInput() {
        if (scanner.hasNextLine()) {
            userInput = scanner.nextLine();
        } else {
            userInput = "bye";
        }
        return userInput;
    }

    public static void printMessage(String message){
        System.out.println(message);
    }

    public static void printManual() {
        System.out.println(userOutputDash);
        System.out.println("Hi, this is Duke!");
        System.out.println("I am able to let you add tasks of three types! todo, event and deadline");
        System.out.println("1. To add a todo task, key in todo<space>your task description eg. todo borrow books");
        System.out.println("2. To add a deadline, key in deadline<space>your deadline description<space>/by<space>the date eg. return books/by dd/MM/yyyy HHmm");
        System.out.println("3. To add a event, key in event<space>your event description<space>/at<space>the day or date and the time eg. Project meeting /at dd/MM/yyyy HHmm-HHmm");
        System.out.println("4. To list out all your tasks simply enter list");
        System.out.println("5. To mark a task as complete just enter done<space>the index of the task as listed");
        System.out.println("6. To find a task from the task list enter find<space>any word in the task");
        System.out.println("7. To delete a task just enter delete<space>the index of the task as listed");
        System.out.println("8. To exit, enter bye");
    }

    public static void printUnknownInput() {
        System.out.println(" ☹ OOPS!!! I'm sorry, but I don't know what that means. If you would like to know how to use Duke, Enter duke-manual");
    }
}

