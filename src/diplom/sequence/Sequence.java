package diplom.sequence;

public interface Sequence extends Iterable<Double>{
    double getElement(int index);
    void add(double element);
    int getLength();
    int getMinIndex();
}
