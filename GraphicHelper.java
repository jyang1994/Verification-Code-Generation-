package com.kaishengit.web.kit;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

public class GraphicHelper {
	/**
	 * @param width 图片宽度
	 * @param height 图片高度
	 * @param imgType 图片类型（不是MEMI类型）
	 * @param out 图片输出流
	 * @return
	 */
	public static String create(int width,int height,String imgType,OutputStream out){
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		BufferedImage image = new BufferedImage(width, height,  BufferedImage.TYPE_INT_RGB);
		Graphics graphics = image.getGraphics();
		graphics.setColor(Color.getColor("F8F8F8"));
		graphics.fillRect(0, 0, width, height);
		Color[] colors = new Color[] {Color.BLUE,Color.RED,Color.pink,Color.green,Color.black,Color.ORANGE};
		for(int i = 0; i < 10; i++){
			 graphics.setColor(colors[random.nextInt(colors.length)]);  
		       final int x = random.nextInt(width);  
		       final int y = random.nextInt(height);  
		       final int w = random.nextInt(10);  
		       final int h = random.nextInt(10);  
		       final int signA = random.nextBoolean() ? 1 : -1;  
		       final int signB = random.nextBoolean() ? 1 : -1;  
		       graphics.drawLine(x, y, x + w * signA, y + h * signB);  
		}
		graphics.setFont(new Font("Comic Sans MS", Font.BOLD, 20));  
		   for (int i = 0; i < 4; i++) {  
		       final int temp = random.nextInt(20) + 67;  
		       String s = String.valueOf((char) temp);  
		       sb.append(s);  
		       graphics.setColor(colors[random.nextInt(colors.length)]);  
		       graphics.drawString(s, i * (width / 4), height - (height / 3));  
		   }  
		   graphics.dispose();  
		   try {  
		       ImageIO.write(image, imgType, out);  
		   } catch (IOException e) {  
		       e.printStackTrace();  
		   }  
		   return sb.toString();  
		   }  
		
			
}
/*
	调用方法，与前端传过来的进行验证
		String code = req.getSession().getAttribute("code").toString();
		if(code!=null && code.equalsIgnoreCase(codenum)){
			//验证通过
		}
*/