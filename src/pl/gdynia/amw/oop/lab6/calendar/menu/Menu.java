package pl.gdynia.amw.oop.lab6.calendar.menu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);
    private final Map<Integer, MenuOption> menuOptions = new HashMap<>();
    private Integer lastMenuKey = 1;
    private final String promptMessage;

    public Menu(String promptMessage) {
        this.promptMessage = promptMessage;
    }

    public static Menu withMessage(String promptMessage){
        return new Menu(promptMessage);
    }

    public void addOption(MenuOption option) {
        menuOptions.put(lastMenuKey++, option);
    }

    public Menu addOption(String text, MenuOptionAction action) {
        this.addOption(new MenuOption(text, action));
        return this;
    }

    public Menu addOption(String text, MenuOptionActionParameterless function) {
        this.addOption(new MenuOption(text, (ignored) -> function.invoke()));
        return this;
    }

    public int show() {
        System.out.println(promptMessage);
        this.menuOptions.forEach((optionId, option) -> System.out.printf("[%d] %s%n", optionId, option.getText()));
        System.out.print("Your decision: ");
        try {
            int decision = Integer.parseInt(scanner.next());
            if (decision >= lastMenuKey || decision < 1) throw new ArrayIndexOutOfBoundsException();
            menuOptions.get(decision).invokeAction(decision);
            return decision;
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException ignored) {
            System.out.printf("Provide correct decision! <1,%d>%n", lastMenuKey - 1);
            this.show();
        }
        return -1;
    }
}
