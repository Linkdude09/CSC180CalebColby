package edu.neumont.ccolby.service;

import org.springframework.stereotype.Service;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImageService {


    public String createImage(String filePath, byte[] image, String imageName) {

        Path imagePath = Paths.get(filePath);
        String returnVal = imageName;

        try{
            if(!Files.exists(imagePath)){
                Files.createDirectories(imagePath);
            }

            Path IPath = imagePath.resolve(imageName);
            Files.write(IPath, image);
        }catch(IOException ioe){
            System.out.println(ioe);
            returnVal = "image can't be saved";
        }
        return returnVal;
    }

    public byte[] readImage(String FilePath){
        Path imagePath = Paths.get(FilePath);

        try {
            if (Files.exists(imagePath)) {
                return Files.readAllBytes(imagePath);
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
            return null;
        }
        return null;
    }

    public boolean deleteImage(String FilePath){
        Path imagePath = Paths.get(FilePath);
        try{
            if(Files.exists(imagePath)) {
                Files.delete(imagePath);
                return true;
            }
            return false;
        }catch(IOException ioe){
            ioe.printStackTrace();
            return false;
        }
    }

    public byte[] greyscaleImage(String FilePath){
        try {

            File input = new File(FilePath);
            BufferedImage image = ImageIO.read(input);

            BufferedImage result = new BufferedImage(
                    image.getWidth(),
                    image.getHeight(),
                    BufferedImage.TYPE_INT_RGB);

            Graphics2D graphic = result.createGraphics();
            graphic.drawImage(image, 0, 0, Color.WHITE, null);

            for (int i = 0; i < result.getHeight(); i++) {
                for (int j = 0; j < result.getWidth(); j++) {
                    Color c = new Color(result.getRGB(j, i));
                    int red = (int) (c.getRed() * 0.299);
                    int green = (int) (c.getGreen() * 0.587);
                    int blue = (int) (c.getBlue() * 0.114);
                    Color newColor = new Color(
                            red + green + blue,
                            red + green + blue,
                            red + green + blue);
                    result.setRGB(j, i, newColor.getRGB());
                }
            }
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(result, "png", baos);
            return baos.toByteArray();

        }  catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }


    public byte[] rotateImage(String FilePath){
        return null;
    }
}
