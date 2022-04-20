package diplom;

import diplom.generator.Generator;
import diplom.generator.lfsr.LFSRGenerator;
import diplom.graphics.GraphicsCreator;
import diplom.sequence.Sequence;
import diplom.sequence.SequenceCreator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter poly: ");
        String polynomial = scanner.nextLine();
        System.out.println("Enter deviation");
        double deviation = scanner.nextDouble();

        Generator generator = new LFSRGenerator(polynomial);
        Sequence sequence = new SequenceCreator(generator.getNextArray((int) (Math.pow(2, polynomial.length())-1)));
        GraphicsCreator graphicsCreator = new GraphicsCreator(sequence, deviation);
        graphicsCreator.createChart();
    }
}
