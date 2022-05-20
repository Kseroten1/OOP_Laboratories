package pl.gdynia.amw.oop.lab6.calendar.dataproviding;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class ConditionalDataProvider<T> implements DataProvider<T> {
    private final String incorrectInput;
    private final Predicate<T> isValueCorrect;
    private final Supplier<T> valueSupplier;
    private final String prompt;

    private ConditionalDataProvider(String prompt, Supplier<T> valueSupplier, Predicate<T> isValueCorrect, String incorrectInput) {
        this.prompt = prompt;
        this.incorrectInput = incorrectInput;
        this.isValueCorrect = isValueCorrect;
        this.valueSupplier = valueSupplier;
    }

    public static <T> T get(String prompt, Supplier<T> valueSupplier, Predicate<T> isValueCorrect, String incorrectInput) {
        final var provider = new ConditionalDataProvider<>(prompt, valueSupplier, isValueCorrect, incorrectInput);
        return provider.provide();
    }

    @Override
    public T provide() {
        T input = null;
        while (input == null) {
            System.out.printf("[?] %s", prompt);
            try {
                var tester = valueSupplier.get();
                if (isValueCorrect.test(tester)) {
                    input = tester;
                } else {
                    System.out.printf("[!] %s%n", incorrectInput);
                }
            } catch (Exception ignored) /*jawna weryfikacja wyjatkow + obsluga ich*/{
                System.out.printf("[!] %s%n", incorrectInput);
            }
        }
        return input;
    }
}
