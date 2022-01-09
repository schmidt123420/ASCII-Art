import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class ASCII_Art {

    public static void main(String[] args) {
        //Create scanner object and image and file objects
        Scanner in = new Scanner(System.in);
        BufferedImage userImage = null;

        //Ask user for image file to read
        System.out.println("Enter image file: ");
        String fileName = in.nextLine();

        //Try to read and store the image
        try {
            userImage = ImageIO.read(new File("test_images/" + fileName)); //location of picture is in test_images folder
        } catch (IOException e) {
            System.out.println("Ruh roh, error: " + e);
        }

        //Find and store width and height of image
        int imageWidth = userImage.getWidth();
        int imageHeight = userImage.getHeight();

        //Create array to hold the colors of each pixel
        int[] pixelColors = new int[imageHeight * imageWidth * 3]; //multiply by 3 to hold red, green, and blue values for each pixel
        int arrayIndex = 0;

        //Loop through the picture and check the color of each pixel
        for (int y = 0; y < imageHeight; y++) {
            for (int x = 0; x < imageWidth; x++) {
                int pixelColor = userImage.getRGB(x, y);

                //Calculating the red, green, and blue values using shifting

                //playing around with stackoverflow code to see what it means/does
                int redValue = (pixelColor & 0x00ff0000) >> 16;
                int greenValue = (pixelColor & 0x0000ff00) >> 8;
                int blueValue = pixelColor & 0x000000ff;

                //Store color values in array
                pixelColors[arrayIndex] = redValue;
                arrayIndex++;
                pixelColors[arrayIndex] = greenValue;
                arrayIndex++;
                pixelColors[arrayIndex] = blueValue;
                arrayIndex++;
            }
        }

        //Close input stream
        in.close();
    }

}
