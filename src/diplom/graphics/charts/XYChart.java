package diplom.graphics.charts;

import diplom.sequence.Sequence;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;

public class XYChart extends ApplicationFrame {
    private static final long serialVersionUID = 1L;

    public XYChart(final String title, Sequence sequence)
    {
        super(title);

        XYDataset dataset    = createDataset(sequence);
        JFreeChart chart      = createChart(dataset, true);
        ChartPanel chartPanel = new ChartPanel(chart);

        chartPanel.setPreferredSize(new java.awt.Dimension(560, 480));
        setContentPane(chartPanel);
    }

    public XYChart(final String title, Sequence sequence, double deviation)
    {
        super(title);

        XYDataset dataset    = createDataset(sequence, deviation);
        JFreeChart chart      = createChart(dataset, false);
        ChartPanel chartPanel = new ChartPanel(chart);

        chartPanel.setPreferredSize(new java.awt.Dimension(560, 480));
        setContentPane(chartPanel);
    }

    private JFreeChart createChart(XYDataset dataset, boolean points) {
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Линейный график 2",
                null,                        // x axis label
                null,                        // y axis label
                dataset,                     // data
                PlotOrientation.VERTICAL,
                true,                        // include legend
                false,                       // tooltips
                false                        // urls
        );

        final XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesShapesVisible(0, false);
        renderer.setSeriesShapesVisible(1, false);
        renderer.setSeriesShapesVisible(2, false);
        renderer.setSeriesShapesVisible(3, false);

        renderer.setSeriesStroke       (0, new BasicStroke(2.5f));
        renderer.setSeriesStroke       (1, new BasicStroke(1.5f));
        renderer.setSeriesStroke       (2, new BasicStroke(1.5f));
        renderer.setSeriesStroke       (3, new BasicStroke(1.5f));

        renderer.setSeriesPaint(1, Color.BLUE);
        renderer.setSeriesPaint(2, Color.BLUE);
        renderer.setSeriesPaint(3, Color.GREEN);
        if (points) {
            renderer.setSeriesShapesVisible(1, true);
        }
        plot.setRenderer(renderer);

        return chart;
    }

    private XYDataset createDataset(Sequence sequence) {
        final XYSeries series = new XYSeries("График точек входа в интервал");
        final XYSeries minPoint = new XYSeries("Min point");
        minPoint.add(sequence.getMinIndex()+1, sequence.getElement(sequence.getMinIndex()));

        for (int i = 1; i<sequence.getLength()+1; i++) {
            series.add(i, sequence.getElement(i-1));
        }

        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        dataset.addSeries(minPoint);

        return dataset;
    }

    private XYDataset createDataset(Sequence sequence, double deviation) {
        final XYSeries result = new XYSeries("Result");
        final XYSeries upInterval = new XYSeries("Max interval border");
        final XYSeries downInterval = new XYSeries("Min interval border");
        final XYSeries middle = new XYSeries("Middle");
        for (int i = 1; i<sequence.getLength()+1; i++) {
            upInterval.add(i, 0.5000+deviation);
            downInterval.add(i, 0.5000-deviation);
            middle.add(i, 0.5000);
            result.add(i, sequence.getElement(i-1));
        }

        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(result);
        dataset.addSeries(upInterval);
        dataset.addSeries(downInterval);
        dataset.addSeries(middle);

        return dataset;
    }

}
