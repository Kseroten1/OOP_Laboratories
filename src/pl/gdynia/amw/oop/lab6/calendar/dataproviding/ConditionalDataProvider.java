package pl.gdynia.amw.oop.lab6.calendar.dataproviding;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class ConditionalDataProvider<T> implements DataProvider<T> {
    private final String incorrectInput;
    private final Predicate<T> isValueCorrect;
    private final Supplier<T> valueSupplier;
    private final String prompt;

    public ConditionalDataProvider(String prompt, Supplier<T> valueSupplier, Predicate<T> isValueCorrect, String incorrectInput) {
        this.prompt = prompt;
        this.incorrectInput = incorrectInput;
        this.isValueCorrect = isValueCorrect;
        this.valueSupplier = valueSupplier;
    }

    @Override
    public T provide() {
        T input = null;
        while (input == null) {
            System.out.println(prompt);
            try {
                var tester = valueSupplier.get();
                if (isValueCorrect.test(tester)) {
                    input = tester;
                } else {
                    System.out.println(incorrectInput);
                }
            } catch (Exception ignored) {
                System.out.println(incorrectInput);
            }
        }
        return input;
    }
}
