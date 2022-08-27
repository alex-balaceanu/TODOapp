public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Actions.showMenu();
        while (true) {
            Actions.analyzeInput(Actions.getUserInput(), board);
            Actions.showMiniMenu();
            Actions.askToShowMenu(Actions.getUserInput());
        }
    }
}
