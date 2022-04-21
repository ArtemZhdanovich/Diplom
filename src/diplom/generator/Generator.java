package diplom.generator;

public interface Generator {
    double[] getNextArray(int count);
    void offset(int offset);
    String getState(int offset);
}
