import java.util.Scanner;

public class Actions {
    public static void showMenu() {

        System.out.println("""
                What would you like to do?
                1. Add task to board
                2. Remove task from board
                3. Add person to board
                4. Remove person from board
                5. Connect person to task
                6. Disconnect person from task
                7. Print board
                8. Exit""");

    }

    public static void showMiniMenu(){
        System.out.println("""
                1.Show menu
                2.Exit""");
    }
    public static void askToShowMenu(String input){
        if(input.equals("1")){
            showMenu();
        }else if(input.equals("2")){
            System.exit(1);
        }else{
            System.out.println("Enter 1 or 2");
            showMiniMenu();
            askToShowMenu(getUserInput());
        }
    }

    public static String getUserInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static void analyzeInput(String input, Board board) {
        if (!"12345678".contains(input)) {
            System.out.println("Select a number from 1-7");
            showMenu();
        } else if (input.equals("1")) {
            addTaskToBoard(board);
        } else if (input.equals("2")) {
            removeTaskFromBoard(board);
        } else if (input.equals("3")) {
            addPersonToBoard(board);
        } else if (input.equals("4")) {
            removePersonFromBoard(board);
        } else if (input.equals("5")) {
            connectPersonToTask(board);
        } else if (input.equals("6")) {
            disconnectPersonFromTask(board);
        } else if (input.equals("7")) {
            printBoard(board);
        } else if (input.equals("8")) {
            System.exit(1);
        }
    }

    public static void addTaskToBoard(Board board) {
        System.out.println("Enter task name");
        board.addTaskToBoard(getUserInput());
    }

    public static void addPersonToBoard(Board board) {
        System.out.println("Enter person name");
        board.addAssigneeToBoard(getUserInput());
    }

    public static void removeTaskFromBoard(Board board) {
        System.out.println("Enter the name of the task to be removed");
        board.removeTaskFromBoard(getUserInput());
    }

    public static void removePersonFromBoard(Board board) {
        System.out.println("Enter the name of the person to be removed");
        board.removeAssigneeFromBoard(getUserInput());
    }

    public static void connectPersonToTask(Board board) {
        System.out.println("Enter task name");
        String task_name = getUserInput();
        System.out.println("Enter person name");
        String person_name = getUserInput();
        board.connectAssigneeToTask(task_name, person_name);
    }

    public static void disconnectPersonFromTask(Board board) {
        System.out.println("Enter task name");
        String task_name = getUserInput();
        System.out.println("Enter person name");
        String person_name = getUserInput();
        board.disconnectAssigneeFromTask(task_name, person_name);
    }

    public static void printBoard(Board board) {
        board.printBoard();
    }

}
