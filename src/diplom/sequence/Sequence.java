package diplom.sequence;

import java.util.ArrayList;

public interface Sequence extends Iterable<Double>{
    ArrayList<Double> returnSequence();
    double getElement(int index);
    void add(double element);
    int getLength();
    int getMinIndex();
}
