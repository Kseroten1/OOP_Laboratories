package pl.gdynia.amw.oop.lab6.calendar.menu;

public class MenuOption {
    private final String text;
    private final MenuOptionAction action;

    public MenuOption(String text, MenuOptionAction action) {
        this.text = text;
        this.action = action;
    }

    public void invokeAction(Integer chosenMenuKey) {
        action.invokeAction(chosenMenuKey);
    }

    public String getText() {
        return text;
    }
}
