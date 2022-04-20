package diplom.generator.lfsr;

import diplom.generator.Generator;

public class LFSRGenerator implements Generator {
    private StringBuilder polynomial;
    private double sum;
    private int count;
    private final int length;

    private LFSRGenerator(String polynomial) {
        this.polynomial = new StringBuilder(polynomial);
        sum = 0.0000;
        count = 0;
        length = polynomial.length();
    }

    private LFSRGenerator(String polynomial, int offset) {
        this.polynomial = new StringBuilder(polynomial);
        for (int i = 0; i<offset; i++)
            nextBytePolynomial();

        sum = 0;
        count = 0;
        length = polynomial.length();
    }

    private void nextBytePolynomial() {
        int newByte = Character.getNumericValue(polynomial.charAt(length-1));
        int[] arr = TabsTable.getArray(polynomial.length());
        for (int a:arr) {
            newByte ^= Character.getNumericValue(polynomial.charAt(a-1));
        }

        polynomial.deleteCharAt(length-1);
        polynomial.insert(0,newByte);
    }

    private double getDouble() {
        return Character.getNumericValue(polynomial.charAt(0));
    }

    private double getNextDouble() {
        sum += getDouble();
        count++;
        nextBytePolynomial();

        return sum/count;
    }

    @Override
    public Generator createGenerator(String polynomial) {
        return new LFSRGenerator(polynomial);
    }

    @Override
    public Generator createGenerator(String polynomial, int offset) {
        return new LFSRGenerator(polynomial, offset);
    }

    @Override
    public double[] getNextArray(int count) {
        double[] array = new double[count];
        for (int i = 0; i<count; i++)
            array[i] = getNextDouble();

        return array;
    }
}
