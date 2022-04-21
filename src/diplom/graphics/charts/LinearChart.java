package diplom.graphics.charts;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;

import java.awt.*;

public class LinearChart  extends JFrame {
    private static final long serialVersionUID = 1L;

    public LinearChart(String title, DefaultCategoryDataset dataset){
        super(title);
        // Create chart
        JFreeChart chart = ChartFactory.createLineChart(
                "Function", // Chart title
                "Stage", // X-Axis Label
                "Created number", // Y-Axis Label
                dataset
        );


        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }
}
