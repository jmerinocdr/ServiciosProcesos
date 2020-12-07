package EjemploClientePasarImagenStream;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
 
public class Cliente
{
    public static void main(String[] args)
    {
        int port=2050;
        try
        {
            Socket clientSocket = new Socket("localhost",port);
 
            OutputStream outputStream = clientSocket.getOutputStream();
 
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
 
            BufferedImage image = ImageIO.read(new File("D:\\coche.png"));
            ImageIO.write(image, "jpg", byteArrayOutputStream);
 
            byte[] size = ByteBuffer.allocate(4).putInt(byteArrayOutputStream.size()).array();
            System.out.println(byteArrayOutputStream.size());
            outputStream.write(byteArrayOutputStream.toByteArray());
            Thread.sleep(2000);
 
            outputStream.close();
            clientSocket.close();
        }
        catch (UnknownHostException e){
            System.out.println(e);
        }
        catch (IOException e) {
            System.out.println(e);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}