package interview.picture;

import interview.picture.DecorationUtil;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年11月28日 上午11:11:14
 */

public class DecoratePicture {
    public static final String OUTPUT_DIRECTORY = "D://Pictures/Result";

    public static void main(String[] args) {
        @SuppressWarnings("resource")
	Scanner input = new Scanner(System.in);

        //如果输出文件夹不存在, 创建它
        File dir = new File(DecoratePicture.OUTPUT_DIRECTORY);
        if(!dir.exists()) {
            System.out.println("not exist");
            dir.mkdir();
        }

        boolean isQuit = false;
        while(!isQuit) {
            String inputPath;
            String messageNum;

            System.out.println("请输入文件路径如(D://Pictures/Test/test.jpg, 开头盘符后必须接 // 否则生成文件文件名不规范)");
            inputPath = input.nextLine();
            System.out.println("请输入消息数: ");
            messageNum = input.nextLine();

            File file = new File(inputPath);
            try {
                BufferedImage sourceImage = ImageIO.read(file);
                DecorationUtil.getAfterCombine(Integer.valueOf(messageNum), sourceImage);

                String outputPath = DecoratePicture.OUTPUT_DIRECTORY + getFileName(inputPath);//输出文件路径
                
                OutputStream output = new FileOutputStream(outputPath);

                String format = getFileName(inputPath).split("\\.")[1];  //获取文件格式名, 比如  jpg
                
                ImageIO.write(sourceImage, format, output);

                output.close();

                System.out.println("quit 退出, 任意字符继续");
                String action = input.nextLine();

                if(action.equals("quit")) {
                    isQuit = true;
                }
            } catch (IOException e) {
                System.out.println("文件不存在");
            } catch (NumberFormatException e) {
                System.out.println("输入的不是数字");
            } catch (Exception e) {
                System.out.println("未知异常");
            }
        }
    }

    //获取传入文件的文件名
    public static String getFileName(String path) {
        String temp = path.substring(4); //去掉前面盘符, 如: D://

        //分割获取最后一个,就是文件名
        String[] splitTemp = temp.split("/");
        String fileName = splitTemp[splitTemp.length-1];

        return fileName;
    }
}
