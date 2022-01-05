package converter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.Math;
//import java.io.File;
//import java.io.IOException;

interface blackwhite {
   
    BufferedImage using_bufferedimage(BufferedImage img);

}


public class convert_blackwhite implements blackwhite{

    public BufferedImage using_bufferedimage(BufferedImage img){    
        //get image width and height
        int width = img.getWidth();
        int height = img.getHeight();
    
        //convert to grayscale
        for(int y = 0; y < height; y++){
          for(int x = 0; x < width; x++){
            int p = img.getRGB(x,y);
    
            int a = (p>>24)&0xff;
            int r = (p>>16)&0xff;
            int g = (p>>8)&0xff;
            int b = p&0xff;
    
            //calculate average
            int avg = (r+g+b)/3;
    
            //replace RGB value with avg
            p = (a<<24) | (avg<<16) | (avg<<8) | avg;
    
            img.setRGB(x, y, p);
          }
        }
        return img;   
    }

}


// public Image using_greyfilter(Image){

//     ImageFilter filter = new GrayFilter(true, 50);  
//     ImageProducer producer = new FilteredImageSource(colorImage.getSource(), filter);  
//     Image mage = Toolkit.getDefaultToolkit().createImage(producer); 

//     return mage
// }

// public static void makeGray(BufferedImage img)
// {
    
// }

// ImageIO.write(image, "png", new File("output.png"));
// }

// ImageFilter filter = new GrayFilter(true, 50);  
// ImageProducer producer = new FilteredImageSource(colorImage.getSource(), filter);  
// Image mage = Toolkit.getDefaultToolkit().createImage(producer);  


// BufferedImage image = ImageIO.read(new File("input.png"));

// for(int y = 0; y < image.getHeight(); y++) {
//    for(int x = 0; x < image.getWidth(); x++) {
//        Color colour = new Color(image.getRGB(x, y));
// //       Choose one from below
// //       int Y = (int) (0.299 * colour.getRed() + 0.587 * colour.getGreen() + 0.114 * colour.getBlue());
//        int Y = (int) (0.2126 * colour.getRed() + 0.7152 * colour.getGreen() + 0.0722 * colour.getBlue());
//        image.setRGB(x, y, new Color(Y, Y, Y).getRGB());
//    }