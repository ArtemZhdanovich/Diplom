package diplom.graphics;

import diplom.graphics.charts.XYChart;
import diplom.sequence.Sequence;

import javax.swing.*;

public record GraphicsCreator(String title) {
    void initChart(XYChart chart) {
        chart.setAlwaysOnTop(true);
        chart.pack();
        chart.setSize(1600, 800);
        chart.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        chart.setVisible(true);
    }
    public void createChart(Sequence sequence) {
        SwingUtilities.invokeLater(() -> {
            XYChart chart = new XYChart("Function", sequence, title);
            this.initChart(chart);
        });
    }
    public void createChart(Sequence sequence, double deviation) {
        SwingUtilities.invokeLater(() -> {
            XYChart chart = new XYChart("Function", sequence, deviation, title);
            initChart(chart);
        });
    }
}
