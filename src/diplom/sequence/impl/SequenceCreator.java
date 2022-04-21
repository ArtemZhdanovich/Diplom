package diplom.sequence.impl;

import diplom.generator.Generator;
import diplom.sequence.Sequence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class SequenceCreator implements Sequence {
    ArrayList<Double> sequence;

    public SequenceCreator() {
        sequence = new ArrayList<>();
    }
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

    @Override
    public double getElement(int index) {
        return sequence.get(index);
    }

    @Override
    public void add(double element) {
        sequence.add(element);
    }

    @Override
    public int getLength() {
        return sequence.size();
    }

    @Override
    public int getMinIndex() {
        int minValue = Collections.min(sequence).intValue();
        return sequence.indexOf((double) minValue);
    }
}
