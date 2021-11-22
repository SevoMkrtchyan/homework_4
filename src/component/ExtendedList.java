package component;

import java.util.ArrayList;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ExtendedList<T> extends ArrayList<T> {

    public ExtendedList() {
        super();
    }

    public ExtendedList(int capacity) {
        super(capacity);
    }

    public ExtendedList<T> map(Function<T, T> mapper) {
        final Object[] elementData = super.toArray();
        ExtendedList<T> newList = new ExtendedList<>();
        for (Object element : elementData) {
            newList.add(mapper.apply((T) element));
        }
        return newList;
    }

    public ExtendedList<T> fill(int capacity, Supplier<T> supplier) {
        final ExtendedList<T> newArray = new ExtendedList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            T apply = supplier.get();
            outer:
            while (newArray.contains(apply)) {
                apply = supplier.get();
                continue outer;
            }
            newArray.add(apply);
        }
        return newArray;
    }

    public boolean forAll(Predicate<T> predicate) {
        final Object[] elementData = super.toArray();
        boolean flag = true;
        for (Object element : elementData) {
            boolean test = predicate.test((T) element);
            while (!test) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public ExtendedList<ExtendedList<T>> partition(Predicate<T> predicate) {
        final ExtendedList<T> evenNumbers = new ExtendedList<>();
        final ExtendedList<T> oddNumbers = new ExtendedList<>();
        final Object[] numbers = super.toArray();
        for (Object number : numbers) {
            if (predicate.test((T) number)) {
                evenNumbers.add((T) number);
            } else {
                oddNumbers.add((T) number);
            }
        }
        ExtendedList<ExtendedList<T>> result = new ExtendedList<>();
        result.add(evenNumbers);
        result.add(oddNumbers);
        return result;
    }

    public T reduce(Integer element, BinaryOperator<T> binaryOperator) {
        final Object[] elementsData = super.toArray();
        T sum = (T) element;
        for (Object datum : elementsData) {
            sum = binaryOperator.apply(sum, (T) datum);
        }
        return sum;
    }

}
