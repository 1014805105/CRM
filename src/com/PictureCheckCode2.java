package com;

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PictureCheckCode2 extends HttpServlet {
	private String ctmp = "";
	public String getCtmp(){
		
		return ctmp;
		
	}
	public PictureCheckCode2() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}

	public void init() throws ServletException {
		super.init();
	}
	
	public Color getRandColor(int s, int e) {
		//Random random = new Random();
		if (s > 255) s = 255;
		if (e > 255) e = 255;
		int r = 233;//s + random.nextInt(e - s);ֵ
		int g =  233;//s + random.nextInt(e - s);		ֵ
		int b =  233;//s + random.nextInt(e - s);	
		return new Color(r, g, b);
	}

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "No-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");
		int width = 86;
		int height = 22;
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		Graphics2D g2d = (Graphics2D) g;
		Random random = new Random();
		Font mFont = new Font("宋体", Font.BOLD, 17);
		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, width, height);
		g.setFont(mFont);
		//g.setColor(getRandColor(180, 200));
		
		for (int i = 0; i < 100; i++) {
			int x = random.nextInt(width - 1);
			int y = random.nextInt(height - 1);
			int x1 = random.nextInt(6) + 1;
			int y1 = random.nextInt(12) + 1;
			BasicStroke bs = new BasicStroke(2f, BasicStroke.CAP_BUTT,
					BasicStroke.JOIN_BEVEL);
			Line2D line = new Line2D.Double(x, y, x + x1, y + y1);
			g2d.setStroke(bs);
			g2d.draw(line);
		}
		String sRand = "";
		
		
		int itmp = 0;
		for (int i = 0; i < 4; i++) {
			
			switch (random.nextInt(4)) {
			case 1:
				itmp = random.nextInt(26) + 65;
				ctmp = String.valueOf((char) itmp);
				break;
			case 2: 
				String[] rBase = { "0", "1", "2", "3", "4", "5", "6", "7", "8",
						"9", "a", "b", "c", "d", "e", "f" };
				
				int r1 = random.nextInt(3) + 11;	
				String str_r1 = rBase[r1];
				
				int r2;
				if (r1 == 13) {
					r2 = random.nextInt(7);			
				} else {
					r2 = random.nextInt(16);		
				}
				String str_r2 = rBase[r2];
				// ��ɵ�1λ��λ��
				int r3 = random.nextInt(6) + 10;	
				String str_r3 = rBase[r3];
				// ��ɵ�2λ��λ��
				int r4;
				if (r3 == 10) {
					r4 = random.nextInt(15) + 1;	
				} else if (r3 == 15) {
					r4 = random.nextInt(15);		
				} else {
					r4 = random.nextInt(16);		
				}
				String str_r4 = rBase[r4];
				System.out.println(str_r1 + str_r2 + str_r3 + str_r4);
				
				byte[] bytes = new byte[2];
				
				String str_r12 = str_r1 + str_r2;
				int tempLow = Integer.parseInt(str_r12, 16);
				bytes[0] = (byte) tempLow;
				
				String str_r34 = str_r3 + str_r4;
				int tempHigh = Integer.parseInt(str_r34, 16);
				bytes[1] = (byte) tempHigh;
				
				ctmp = new String(bytes);
				break;
			default:
				itmp = random.nextInt(10) + 48; 
				ctmp = String.valueOf((char) itmp);
				break;
			}
			sRand += ctmp;
			HttpSession se=request.getSession();
			se.setAttribute("sRand", sRand);
			Color color = new Color(20 + random.nextInt(110), 20 + random
					.nextInt(110), 20 + random.nextInt(110));
			g.setColor(color);
		
			Graphics2D g2d_word = (Graphics2D) g;
			AffineTransform trans = new AffineTransform();
			trans.rotate(random.nextInt(45) * 3.14 / 180, 15 * i + 8, 7);
			float scaleSize = random.nextFloat() +0.8f;
			if (scaleSize > 1f)	scaleSize = 1f;
			trans.scale(scaleSize, scaleSize);
			g2d_word.setTransform(trans);
			g.drawString(ctmp, 15 * i + 18, 14);

		}
		HttpSession session = request.getSession(true);
		session.setAttribute("randCheckCode", sRand);
		g.dispose();
		ImageIO.write(image, "JPEG", response.getOutputStream());
	}

}
