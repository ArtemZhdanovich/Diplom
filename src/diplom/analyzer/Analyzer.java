package diplom.analyzer;

import diplom.generator.Generator;
import diplom.sequence.Sequence;
import diplom.sequence.impl.SequenceCreator;

import java.util.HashMap;
import java.util.Map;

public class Analyzer {

    private static Map<Double, Boolean> testCriteria = new HashMap<>();

    public static Sequence analyze(Sequence[] sequences, double deviation) {
        Sequence result = new SequenceCreator();

        double maxVal = 0.5000+deviation;
        double minVal = 0.5000-deviation;
        for (Sequence sequence:sequences) {
            int pos = 0;
            for (int i = 0; i<sequence.getLength(); i++) {
                if(sequence.getElement(i)>maxVal | sequence.getElement(i)<minVal)
                    pos = i;
            }
            result.add(pos+1<sequence.getLength()?pos+2:0);
        }
        return result;
    }

    public static String findMin(Sequence sequence, Generator generator) {
        return generator.getState(sequence.getMinIndex());
    }

    public static void frequencyTest(Sequence result) {

    }
}
