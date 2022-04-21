package diplom;

import diplom.analyzer.Analyzer;
import diplom.generator.Generator;
import diplom.generator.lfsr.LFSRGenerator;
import diplom.graphics.GraphicsCreator;
import diplom.sequence.Sequence;
import diplom.sequence.impl.SequenceCreator;
import org.apache.commons.math3.*;
import org.apache.commons.math3.special.Erf;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter poly: ");
        String polynomial = scanner.nextLine();
        System.out.println("Enter deviation");
        double deviation = scanner.nextDouble();
        int generationLength = (int)Math.pow(2, polynomial.length())-1;

        Sequence[] sequences = new Sequence[(int) generationLength];
        for (int i = 0; i<generationLength; i++) {
            Generator generator = new LFSRGenerator(polynomial);
            generator.offset(i);
            sequences[i] = new SequenceCreator(generator.getNextArray(generationLength));
        }

        Sequence result = Analyzer.analyze(sequences, deviation);
        GraphicsCreator graphicsCreator = new GraphicsCreator(result, "Result");
        graphicsCreator.createChart(result);

        GraphicsCreator graphicsCreator1 = new GraphicsCreator(sequences[result.getMinIndex()], deviation, new LFSRGenerator(polynomial).getState(result.getMinIndex()));
        graphicsCreator1.createChart(sequences[result.getMinIndex()], deviation);
    }
}
