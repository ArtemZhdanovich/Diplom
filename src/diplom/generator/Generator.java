package diplom.generator;

import java.util.function.BiFunction;

public interface Generator {
    Generator createGenerator(String polynomial);
    Generator createGenerator(String polynomial, int offset);
    double[] getNextArray(int count);
}
