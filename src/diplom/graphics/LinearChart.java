package diplom.graphics;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

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
