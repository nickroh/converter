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

    // BufferedImage extract_edge_SobelVertical(BufferedImage img);

    // BufferedImage extract_edge_ScharrVertical(BufferedImage img);

    // BufferedImage extract_edge_Horizontal(BufferedImage img);

    // BufferedImage extract_edge_SobelHorizontal(BufferedImage img);

    // BufferedImage extract_edge_ScharrHorizontal(BufferedImage img);

    BufferedImage extract_edge_Laplacian(BufferedImage img);

    BufferedImage extract_canny_edge(BufferedImage img);
}

public class edge_extraction implements edge{

    public edge_extraction(){
        System.out.println("Constructor for edge detector generated");

        filterMap.put(HORIZONTAL_FILTER, FILTER_HORIZONTAL);
        filterMap.put(VERTICAL_FILTER, FILTER_VERTICAL);
        filterMap.put(SOBEL_FILTER_HORIZONTAL, FILTER_SOBEL_H);
        filterMap.put(SOBEL_FILTER_VERTICAL, FILTER_SOBEL_V);
        filterMap.put(SCHARR_FILTER_HORIZONTAL, FILTER_SCHARR_H);
        filterMap.put(SCHARR_FILTER_VETICAL, FILTER_SCHARR_V);
        filterMap.put(LAPLACIAN_FILTER, FILTER_LAPLACIAN);
    }

    private final HashMap<String, double[][]> filterMap= new HashMap<>();

    public static final String HORIZONTAL_FILTER = "Horizontal Filter";
    public static final String VERTICAL_FILTER = "Vertical Filter";
    public static final String SOBEL_FILTER_VERTICAL = "Sobel Vertical Filter";
    public static final String SOBEL_FILTER_HORIZONTAL = "Sobel Horizontal Filter";
    public static final String SCHARR_FILTER_VETICAL = "Scharr Vertical Filter";
    public static final String SCHARR_FILTER_HORIZONTAL = "Scharr Horizontal Filter";
    public static final String LAPLACIAN_FILTER = "Laplacian Filter";

    private static final double[][] FILTER_VERTICAL = {{1, 0, -1}, {1, 0, -1}, {1, 0, -1}};
    private static final double[][] FILTER_HORIZONTAL = {{1, 1, 1}, {0, 0, 0}, {-1, -1, -1}};
    private static final double[][] FILTER_SOBEL_V = {{1, 0, -1}, {2, 0, -2}, {1, 0, -1}};
    private static final double[][] FILTER_SOBEL_H = {{1, 2, 1}, {0, 0, 0}, {-1, -2, -1}};
    private static final double[][] FILTER_SCHARR_V = {{3, 0, -3}, {10, 0, -10}, {3, 0, -3}};
    private static final double[][] FILTER_SCHARR_H = {{3, 10, 3}, {0, 0, 0}, {-3, -10, -3}};
    private static final double[][] FILTER_LAPLACIAN = {{0, 1, 0}, {1, -4, 1}, {0, 1, 0}};

    convert_blackwhite my_grayscale= new convert_blackwhite();


    public BufferedImage extract_edge(BufferedImage img){



        return img;
    }
}
