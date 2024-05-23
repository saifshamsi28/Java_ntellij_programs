package SaifJavaPrograms;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageConverter {
    public static void main(String[] args) {
        try {
            File file = new File("C://Users//saifs//Desktop//IMG20230610160013.jpg");
            BufferedImage image = ImageIO.read(file);
           ImageIO.write(image,"png", new File("C://Users//saifs//Desktop//ConvertedSaif.png"));
           ImageIO.write(image,"bmp", new File("C://Users//saifs//Desktop//ConvertedSaif.bmp"));
           ImageIO.write(image,"gif", new File("C://Users//saifs//Desktop//ConvertedSaif.gif"));
           ImageIO.write(image,"jpg", new File("C://Users//saifs//Desktop//ConvertedSaif.jpg"));
            System.out.println("Image converted successfully");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
