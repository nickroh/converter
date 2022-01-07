import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import java.time.Year;

import javax.imageio.ImageIO;
import java.util.*;

class main{
    public static void main(String[] args) throws IOException {
      
      while(true){

         convert_blackwhite my_converter = new convert_blackwhite();
         edge_extraction my_edge = new edge_extraction();
         input my_input = new input();

         BufferedImage img;

         Scanner sc = new Scanner(System.in);
         
         int option;

         System.out.println("Press 1 for gray scale converting ");
         System.out.println("Press 2 for edge extraction");
         linespace();

         option = sc.nextInt();

         if(option == 1){
            img = my_input.get_input();
        
            my_converter.using_bufferedimage(img);
            
            save_img(img);
         }if(option == 2){
            img = my_input.get_input();

            my_edge.

         }else{
            System.out.println("No option chosen");
            linespace();
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
   private static void save_img(BufferedImage img){
      File f = null;
      try{
         f = new File("/Users/Patron/Desktop/dev/image/converter/output.jpg");
         ImageIO.write(img, "jpg", f);
       }catch(IOException e){
         System.out.println(e);
       }
  }
  private static void linespace(){
     System.out.println();
  }
} 
