package diplom.generator.lfsr;

import diplom.generator.Generator;

public class LFSRGenerator implements Generator {
    private final String initialState;
    private final StringBuilder polynomial;
    private double sum;
    private int count;
    private final int length;

    public LFSRGenerator(String polynomial) {
        initialState = polynomial;
        this.polynomial = new StringBuilder(polynomial);
        sum = 0.0000;
        count = 0;
        length = polynomial.length();
    }

    private void nextBytePolynomial() {
        nextByte(polynomial);
    }

    private void nextBytePolynomial(StringBuilder polynomial) {
        nextByte(polynomial);
    }

    private void nextByte(StringBuilder polynomial) {
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
        nextByte(polynomial);

        return sum/count;
    }

    @Override
    public double[] getNextArray(int count) {
        double[] array = new double[count];
        for (int i = 0; i<count; i++)
            array[i] = getNextDouble();

        return array;
    }

    @Override
    public double[] getBitArray(int count) {
        double[] array = new double[count];
        for (int i = 0; i<count; i++) {
            array[i] = getDouble();
            nextByte(polynomial);
        }
        return array;
    }

    @Override
    public void offset(int offset) {
        while (offset>0) {
            nextByte(polynomial);
            offset--;
        }
    }

    @Override
    public String getState(int offset) {
        StringBuilder result = new StringBuilder(initialState);
        while (offset>0) {
            nextBytePolynomial(result);
            offset--;
        }
        return result.toString();
    }
}
