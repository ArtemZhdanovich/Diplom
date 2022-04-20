package diplom.graphics;

import diplom.sequence.Sequence;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;

public class GraphicsCreator {
    private final DefaultCategoryDataset dataset;

    public GraphicsCreator(Sequence sequence) {
        dataset = createDataset(sequence);
    }

    public GraphicsCreator(Sequence sequence, double deviation) {
        dataset = createDataset(sequence, deviation);
    }

    public void createChart() {
        SwingUtilities.invokeLater(() -> {
            LinearChart chart = new LinearChart("hello", dataset);
            chart.setAlwaysOnTop(true);
            chart.pack();
            chart.setSize(1600, 800);
            chart.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            chart.setVisible(true);
        });
    }

    private DefaultCategoryDataset createDataset(Sequence sequence) {
        String center = "";
        String valueTitle = "Sequence 1";
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        Integer i = 0;
        for (double value:sequence) {
            dataset.addValue(value, valueTitle, ++i);
            dataset.addValue(0.5, center, i);
        }

        return dataset;
    }

    private DefaultCategoryDataset createDataset(Sequence sequence, double deviation) {
        String center = "";
        String maxDeviation = "Max interval range";
        String minDeviation = "Min interval range";
        String valueTitle = "Sequence 1";
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        Integer i = 0;
        for (double value:sequence) {
            dataset.addValue(0.5000+deviation, maxDeviation, ++i);
            dataset.addValue(0.5000-deviation, minDeviation, i);
            dataset.addValue(value, valueTitle, i);
            dataset.addValue(0.5, center, i);
        }

        return dataset;
    }
}
