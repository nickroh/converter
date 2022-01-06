import java.util.*;
import java.util.concurrent.Future;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.nio.channels.spi.SelectorProvider;
import java.net.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class input {

    public BufferedImage get_input() {
        BufferedImage return_img= null;
        Scanner scanner = new Scanner(System.in);

        char user_input;

        System.out.println("Uploading image using url? Y/N");
        user_input = scanner.next().charAt(0);

        String trash = scanner.nextLine();

        if(user_input=='Y' || user_input=='y'){
            System.out.println("URL: ");
            String url_string = scanner.nextLine();
            
            try {
                URL url = new URL(url_string);
                try {
                    return_img = using_URL(url);
                    
                } catch (Exception e) {
                    //TODO: handle exception
                    System.out.println("Not valid URL err");
                }
            } catch (Exception e) {
                //TODO: handle exception
                System.out.println("Malformed URL Exception err");

            }
        }if(user_input == 'N'||user_input=='n'){
            System.out.println("Path: ");
            String path_string = scanner.nextLine();
            
            System.out.println("before try path ");
            try {
                
                return_img=using_file_path(path_string);
            } catch (Exception e) {
                //TODO: handle exception
                System.out.println("Not valid path err");

            }
        }


        return return_img;
    }

    private BufferedImage using_URL(URL url) throws IOException, InterruptedException, ExecutionException{
        
        System.out.println("URL entry ");
        System.out.println();
        System.out.println();

        System.out.println("Getting image from -- "+url);
        
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<BufferedImage> future = executor.submit(()->{
            BufferedImage img = ImageIO.read(url);
            return img;
        });
        
        return future.get();  
    }
    private BufferedImage using_file_path(String path)throws IOException{
        
        System.out.println("Path entry");

        BufferedImage img;
        File file = new File(path);

        img = ImageIO.read(file);

        return img;
    }
}
