package interview.picture;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 * @author WuPing
 * @version 2016年11月28日 上午11:15:54
 */

public class DecorationUtil {
    public static void getAfterCombine(int messageNum,
	    BufferedImage bufferedImage) {
	int pictureWidth = bufferedImage.getWidth();
	int pictureHeight = bufferedImage.getHeight();

	Graphics2D graphics2D = bufferedImage.createGraphics();

	BufferedImage messageImage = getMessageCircle(messageNum, pictureWidth,
		pictureHeight);

	int diameter;
	// 消息圆圈直径为宽或者高的 1/3
	if (pictureWidth < pictureHeight) {
	    diameter = pictureWidth / 3;
	} else {
	    diameter = pictureHeight / 3;
	}
	int hideSize = diameter / 20; // 右边和上边隐藏的像素

	graphics2D.drawImage(messageImage, null,
		(pictureWidth + hideSize - diameter), -hideSize);
    }

    // 圆框的bufferedImage, 需要传入显示的消息数, 原图片宽高
    public static BufferedImage getMessageCircle(int messageNum,
	    int pictureWidth, int pictureHeight) {
	String numberStr;

	if (messageNum > 99) {
	    numberStr = "99+";
	} else if (messageNum < 0) {
	    numberStr = "0";
	} else {
	    numberStr = String.valueOf(messageNum);
	}

	int diameter;
	// 消息圆圈直径为宽或者高的 1/3
	if (pictureWidth < pictureHeight) {
	    diameter = pictureWidth / 3;
	} else {
	    diameter = pictureHeight / 3;
	}

	// 这样构造的bufferedImage背景是黑色的
	BufferedImage bufferedImage = new BufferedImage(diameter, diameter,
		BufferedImage.TYPE_3BYTE_BGR);

	Graphics2D g2d = bufferedImage.createGraphics();

	// 背景透明的bufferedImage
	bufferedImage = g2d.getDeviceConfiguration().createCompatibleImage(
		diameter, diameter, Transparency.TRANSLUCENT);

	g2d.dispose();// 释放

	// 下面开始画消息框
	Graphics2D graphics2D = bufferedImage.createGraphics();

	// 先画红色圆圈
	graphics2D.setPaint(Color.RED);
	Ellipse2D ellipse = new Ellipse2D.Double(0, 0, diameter, diameter);
	graphics2D.fill(ellipse);

	// 画消息, 消息要画在正中间
	int fontSize = diameter / 2; // 字体大小为直径 2/6
	Font font = new Font("SansSerif", Font.PLAIN, fontSize);
	graphics2D.setFont(font);

	// 获取包含字符串 numberStr 的矩形, 通过它来获取字符串占的宽高
	FontRenderContext context = graphics2D.getFontRenderContext();
	Rectangle2D bounds = font.getStringBounds(numberStr, context);

	double x = (diameter - bounds.getWidth()) / 2;
	double y = (diameter - bounds.getHeight()) / 2;
	double acsent = -bounds.getY(); // 上坡度;

	double baseY = y + acsent;

	// 画消息
	graphics2D.setPaint(Color.WHITE);
	graphics2D.drawString(numberStr, (int) x, (int) baseY);

	graphics2D.dispose();

	return bufferedImage;
    }
}
