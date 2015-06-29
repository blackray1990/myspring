package com.hjs.study.spring.util;

import java.io.*;
import java.util.Date;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import com.sun.image.codec.jpeg.*;
/**
 * 图片缩放处理
 * @author
 */
public class ImageUtil {
	private Image img;
	private int width;
	private int height;

	public static void main(String[] args) throws Exception {
		System.out.println("开始：" + new Date());
		ImageUtil imgCom = new ImageUtil("C:\\gaoqing.jpg");
		imgCom.resizeFix(200, 200);
		imgCom.resize(300,300,"forceimg-smooth.jpg");
		System.out.println("结束：" + new Date());
	}
	/**
	 * 构造函数
	 */
	public ImageUtil(String fileName) throws IOException {
		File file = new File(fileName);// 读入文件
		img = ImageIO.read(file);      // 构造Image对象
		width = img.getWidth(null);    // 得到源图宽
		height = img.getHeight(null);  // 得到源图长
	}
	/**
	 * 按照宽度还是高度进行缩放(按比例)
	 * @param w int 最大宽度
	 * @param h int 最大高度
	 */
	public void resizeFix(int w, int h) throws IOException {
		if ((width / height) > (w / h)) {
			resizeByWidth(w);
		} else {
			resizeByHeight(h);
		}
	}
	/**
	 * 以宽度为基准，等比例放缩图片(按比例)
	 * @param w int 新宽度
	 */
	public void resizeByWidth(int w) throws IOException {
		int h = (int) (height * w / width);
		resize(w, h,null);
	}
	/**
	 * 以高度为基准，等比例缩放图片(按比例)
	 * @param h int 新高度
	 */
	public void resizeByHeight(int h) throws IOException {
		int w = (int) (width * h / height);
		resize(w, h,null);
	}
	/**
	 * 压缩图片到固定的大小
	 * @param w int 新宽度
	 * @param h int 新高度
	 */
	public void resize(int w, int h,String filename) throws IOException {
		if(filename==null){
			filename = "default-smooth.jpg";
		}
		// SCALE_SMOOTH 的缩略算法   生成的图片平滑度较高，但速度稍慢
		// SCALE_FAST 算法速度较快，但平滑度稍差
		BufferedImage image = new BufferedImage(w, h,BufferedImage.SCALE_SMOOTH );
		image.getGraphics().drawImage(img, 0, 0, w, h, null); // 绘制缩小后的图
		File destFile = new File("C:\\"+filename);
		FileOutputStream out = new FileOutputStream(destFile); // 输出到文件流
		// 可以正常实现bmp、png、gif转jpg
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		encoder.encode(image); // JPEG编码
		out.close();
	}
	
}