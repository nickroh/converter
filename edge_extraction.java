import java.awt.image.BufferedImage;
import java.lang.Math;
import java.util.HashMap;
import java.util.Scanner;

interface edge{

    // void choose_option();
    BufferedImage extract_edge(BufferedImage img);
    

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

        BufferedImage new_img = img;

        new_img=convolution(img);

        return new_img;
    }

    private BufferedImage convolution(BufferedImage img){

        System.out.println("Choose filter option ");

        System.out.println("1: LAPLACIAN_FILTER");
        System.out.println("2: HORIZONTAL_FILTER");
        System.out.println("3: SOBEL_FILTER_HORIZONTAL");
        System.out.println("4: SOBEL_FILTER_VERTICAL");
        System.out.println("5: VERTICAL_FILTER");
        System.out.println("6: SCHARR_FILTER_HORIZONTAL");
        System.out.println("7: SCHARR_FILTER_VETICAL");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        
        String selected_filter;

        if(option == 1){
            selected_filter = LAPLACIAN_FILTER;
        }if(option == 2){
            selected_filter = HORIZONTAL_FILTER;
        }if(option == 3){
            selected_filter = SOBEL_FILTER_HORIZONTAL;
        }if(option == 4){
            selected_filter = SOBEL_FILTER_VERTICAL;
        }if(option == 5){
            selected_filter = VERTICAL_FILTER;
        }if(option == 6){
            selected_filter = SCHARR_FILTER_HORIZONTAL;
        }if(option == 7){
            selected_filter = SCHARR_FILTER_VETICAL;
        }else{
            selected_filter = "Laplacian Filter";
        }
            
        

        int height = img.getHeight();
        int width = img.getWidth();

        BufferedImage return_image = img;

        double[][] convolution = new double[width+2][height+2];
        double[][] convolutioned = new double[width][height];
        for(int j=1;j<height+1;j++){
            for(int i=1;i<width+1;i++){
                convolution[i][j]=img.getRGB(i-1, j-1)&0xff;  
            }
        }

        for(int j=1;j<height+1;j++){
            for(int i=1;i<width+1;i++){
                convolutioned[i-1][j-1]= calculate_convolution(filterMap.get(selected_filter), convolution,i,j);
            } 
        }

        for(int j=0;j<height;j++){
            for(int i=0;i<width;i++){
                return_image.setRGB(i, j, (255<<24|(int)convolutioned[i][j]<<16)|((int)convolutioned[i][j]<<8)|((int)convolutioned[i][j]));
            }
        }

        return return_image;
    }

    private double calculate_convolution(double[][] filter, double[][] convolution, int x, int y){
        
        double value=0;
        
        for(int j=0;j<3;j++){
            for(int i=0;i<3;i++){
                value += filter[i][j]*convolution[x-1+i][y-1+j];
            }
        }
        value = fixOutOfRangeRGBValues(value);

        if(Math.abs(value)>230){
            value =255;
        }
        if(value < 100){
            value = 0;
        }
        return value;
    }

    private int fixOutOfRangeRGBValues(double value) {
        // if(Math.random()>0.99){
        //     System.out.println(value);
        // }
        value = 1.3*value;
        if (value < 0.0) {
            value = -value;
        }
        if (value > 255) {
            return 255;
        }
        
        return reverse_blackwhite((int)value);

        
    }
    
    private int reverse_blackwhite(int value){
        return 255-value;
    }

}
