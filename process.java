import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import java.time.Year;

import javax.imageio.ImageIO;
import java.util.*;

class process{
    public static void main(String[] args) throws IOException {
      
      while(true){

         convert_blackwhite my_converter = new convert_blackwhite();
         input my_input = new input();

         BufferedImage img;
         
         img = my_input.get_input();
        
         my_converter.using_bufferedimage(img);
         File f = null;
         try{
            f = new File("/Users/Patron/Desktop/dev/image/converter/output.jpg");
            ImageIO.write(img, "jpg", f);
          }catch(IOException e){
            System.out.println(e);
          }
         quit_program();
      }
      
   }

   private static void quit_program(){  // why must be static --> need to figure out 
      Scanner scanner = new Scanner(System.in);

      System.out.println("Quit? Y/N");
      char quit = scanner.next().charAt(0);

      if(quit == 'Y'|| quit=='y'){
         System.exit(0);
      }

   }
} 
