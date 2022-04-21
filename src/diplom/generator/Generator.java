package diplom.generator;

import java.util.function.BiFunction;

public interface Generator {
    double[] getNextArray(int count);
    void offset(int offset);
    int getLength();
    String getState(int offset);
}
