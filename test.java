import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class test {
    public static void main(String args[])throws IOException{
      double[][] arr = new double[2][2];
      
      for(int i=0;i<2;i++){
        for(int j=0;j<2;j++){
          System.out.printf("%f ",arr[j][i]);
        }
        System.out.println();
      }
    }
}
