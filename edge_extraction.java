import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.Math;
import java.util.HashMap;

interface edge{

    void choose_option();

    BufferedImage extract_edge_vertical(BufferedImage img);

    BufferedImage extract_edge_SobelVertical(BufferedImage img);

    BufferedImage extract_edge_ScharrVertical(BufferedImage img);

    BufferedImage extract_edge_Horizontal(BufferedImage img);

    BufferedImage extract_edge_SobelHorizontal(BufferedImage img);

    BufferedImage extract_edge_ScharrHorizontal(BufferedImage img);
}

public class edge_extraction {

    private static final double[][] FILTER_VERTICAL = {{1, 0, -1}, {1, 0, -1}, {1, 0, -1}};
    private static final double[][] FILTER_HORIZONTAL = {{1, 1, 1}, {0, 0, 0}, {-1, -1, -1}};
    private static final double[][] FILTER_SOBEL_V = {{1, 0, -1}, {2, 0, -2}, {1, 0, -1}};
    private static final double[][] FILTER_SOBEL_H = {{1, 2, 1}, {0, 0, 0}, {-1, -2, -1}};
    private static final double[][] FILTER_SCHARR_V = {{3, 0, -3}, {10, 0, -10}, {3, 0, -3}};
    private static final double[][] FILTER_SCHARR_H = {{3, 10, 3}, {0, 0, 0}, {-3, -10, -3}};

    public BufferedImage extract_edge(BufferedImage img){



        return img;
    }
}
