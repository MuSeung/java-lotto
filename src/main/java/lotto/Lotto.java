package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (isWrongSize(numbers)) {
            throw new IllegalArgumentException();
        }
        if (isDuplicate(numbers)) {
            throw new IllegalArgumentException();
        }
        if (isOutOfBound(numbers)) {
            throw new IllegalArgumentException();
        }
    }
    private boolean isWrongSize(List<Integer> numbers) {
        return numbers.size() != 6;
    }
    private boolean isDuplicate(List<Integer> numbers) {
        Set<Integer> numbersSet = new HashSet<>(numbers);
        return numbers.size() != numbersSet.size();
    }
    private boolean isOutOfBound(List<Integer> numbers) {
        boolean hasWrongBoundaryNumber = false;
        for (int number : numbers) {
            hasWrongBoundaryNumber |= number < LottoState.START.number();
            hasWrongBoundaryNumber |= number > LottoState.END.number();
        }
        return hasWrongBoundaryNumber;
    }
}
