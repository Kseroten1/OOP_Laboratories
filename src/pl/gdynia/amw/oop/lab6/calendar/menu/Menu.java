package pl.gdynia.amw.oop.lab6.calendar.menu;

import pl.gdynia.amw.oop.lab6.calendar.dataproviding.ConditionalDataProvider;

import java.io.IOException;
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

    public static Menu withMessage(String promptMessage) {
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
        this.addOption(new MenuOption(text, (ignored) -> {
            try {
                function.invoke();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
        return this;
    }

    public int show() {
        System.out.printf("%n%n[?] %s%n", promptMessage);
        this.menuOptions.forEach((optionId, option) -> System.out.printf("[%d] %s%n", optionId, option.getText()));

        final var decision = ConditionalDataProvider.get( "Your decision: ",
                () -> Integer.parseInt(scanner.useDelimiter("\n").next()),
                test -> test < lastMenuKey && test > 0,
                String.format("Provide correct decision! <1,%d>%n", lastMenuKey - 1)
            );

        menuOptions.get(decision).invokeAction(decision);
        return decision;
    }
}
