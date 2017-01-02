package TestSwingPaint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class MyPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// BufferedImage image = null;
	//
	// public MyPanel() {
	// super();
	// try {
	// image = ImageIO.read(getClass().getResource("image.jpg"));
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

	@Override
	public void paint(Graphics arg0) {
		// TODO Auto-generated method stub
		super.paint(arg0);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		// super为默认绘制
		// super.paintComponent(arg0);
		// g.setColor(new Color(220, 220, 0));
		// g.drawRect(0, 0, 100, 100);
		// g.fillRect(0, 0, 100, 100);
		// g.fillRoundRect(0, 0, 100, 100, 10, 10);
		// g.drawOval(10, 10, 200, 200);
		// g.fillOval(10, 10, 200, 200);
		// g.setColor(new Color(0, 220, 220));
		// g.setFont(new Font("Arial", Font.PLAIN, 20));
		// g.drawString("Hello Swing", 90, 110);
		// g.fillArc(0, 0, 200, 200, 0, 180);
		// 绘制多边形
		// g.fillPolygon(new int[]{1,105,205,305,405}, new
		// int[]{10,20,300,400,500}, 5);

		// 绘制图片
		// if (image != null) {
		// g.drawImage(image, 20, 20, null);
		//// g.drawImage(image, 20, 20, 150, 200, null);
		// }

		// Java2D
		Graphics2D g2d = (Graphics2D) g;
		// 抗锯齿
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		// g2d.setStroke(new BasicStroke(6, BasicStroke.CAP_ROUND,
		// BasicStroke.JOIN_ROUND));
		// g2d.drawLine(130, 30, 260, 70);
		// g2d.drawPolygon(new int[] { 10, 105, 205, 305, 405 }, new int[] { 10,
		// 20, 300, 400, 500 }, 5);
		// //设置绘图的边界
		// g2d.setClip(0, 0, 500, 500);

		// 使用绘图API自定义组件

		g2d.setColor(new Color(255, 255, 255, 150));
		g2d.fillRoundRect(3, 3, getWidth() - 7, getHeight() - 7, 20, 20);

		g2d.setClip(0, 0, getWidth(), 30);
		g2d.setColor(Color.WHITE);
		g2d.fillRoundRect(1, 3, getWidth() - 2, 40, 20, 20);
		g2d.setClip(null);

		g2d.setColor(Color.DARK_GRAY);
		g2d.setStroke(new BasicStroke(6));
		g2d.drawRoundRect(3, 3, getWidth() - 7, getHeight() - 7, 20, 20);
		
		g2d.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		g2d.setColor(Color.DARK_GRAY);
		g2d.drawString("Swing Custom UI", 15, 24);
	}

	@Override
	protected void paintBorder(Graphics arg0) {
		// TODO Auto-generated method stub
		super.paintBorder(arg0);
	}

	@Override
	protected void paintChildren(Graphics arg0) {
		// TODO Auto-generated method stub
		super.paintChildren(arg0);
	}

}
