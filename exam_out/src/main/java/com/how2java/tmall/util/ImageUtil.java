package com.how2java.tmall.util;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;
import java.awt.image.DirectColorModel;
import java.awt.image.PixelGrabber;
import java.awt.image.Raster;
import java.awt.image.RenderedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageUtil {

	public static BufferedImage change2jpg(File f) {
		try {
			Image image=Toolkit.getDefaultToolkit().createImage(f.getAbsolutePath());
			PixelGrabber pGrabber =new PixelGrabber(image, 0, 0, -1, -1, true);
			pGrabber.grabPixels();
			int width=pGrabber.getWidth();
			int height=pGrabber.getHeight();
			final int[] RGB_MASKS= {0xFF0000,0xFF00,0xFF};
			final ColorModel RGB_OPAQUE=new DirectColorModel(32, RGB_MASKS[0], RGB_MASKS[1], RGB_MASKS[2]);
			DataBuffer buffer =new DataBufferInt((int[])pGrabber.getPixels(), pGrabber.getWidth()*pGrabber.getHeight());
			WritableRaster raster =Raster.createPackedRaster(buffer, width, height, width, RGB_MASKS, null);
			BufferedImage bufferedImage=new BufferedImage(RGB_OPAQUE, raster, false, null);
			return bufferedImage ;
		}catch (InterruptedException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void resizeImage(File srcFile,int width,int height,File destFile) {
		try {
			if(!destFile.getParentFile().exists())
				destFile.getParentFile().mkdirs();
			Image image =ImageIO.read(srcFile);
			image=resizeImage(image, width, height);
			ImageIO.write((RenderedImage) image, "jpg", destFile);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Image resizeImage(Image srcImage,int width,int height) {
		try {
			BufferedImage bufferedImage=null;
			bufferedImage =new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
			bufferedImage.getGraphics().drawImage(srcImage.getScaledInstance(width, height, Image.SCALE_SMOOTH),0, 0, null);
			return bufferedImage;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
