package diplom.sequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SequenceCreator implements Sequence{
    ArrayList<Double> sequence;

    public SequenceCreator(double[] array) {
        sequence = new ArrayList<>();
        for (double val:array)
            sequence.add(val);
    }

    @Override
    public Iterator<Double> iterator() {
        return sequence.iterator();
    }

    @Override
    public ArrayList<Double> returnSequence() {
        return sequence;
    }
}
