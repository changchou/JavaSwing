package TestSwingPaint;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.JComponent;
import javax.swing.LookAndFeel;
import javax.swing.plaf.basic.BasicButtonUI;

import sun.swing.SwingUtilities2;

public class MyButtonUI extends BasicButtonUI{

	@Override
	protected void installDefaults(AbstractButton b) {
		// TODO Auto-generated method stub
		super.installDefaults(b);
		//背景强制透明
		LookAndFeel.installProperty(b, "opaque", Boolean.FALSE);
	}
	
	@Override
	public void paint(Graphics g, JComponent c) {
		// TODO Auto-generated method stub
		//改变背景颜色、大小、图形  需要设置btnMin.setBorder(null);
		g.setColor(Color.YELLOW);
		g.fillOval((c.getWidth()-c.getHeight())/2, 0, c.getHeight(), c.getHeight());
		super.paint(g, c);
	}
	
	@Override
	protected void paintText(Graphics g, JComponent c, Rectangle textRect, String text) {
		// TODO Auto-generated method stub
		AbstractButton b = (AbstractButton) c;
        ButtonModel model = b.getModel();
        FontMetrics fm = SwingUtilities2.getFontMetrics(c, g);
        int mnemonicIndex = b.getDisplayedMnemonicIndex();

        /* Draw the Text */
        if(model.isEnabled()) {
            /*** paint the text normally */
//            g.setColor(b.getForeground());
        	//按钮字体颜色
            g.setColor(Color.MAGENTA);
            SwingUtilities2.drawStringUnderlineCharAt(c, g,text, mnemonicIndex,
                                          textRect.x + getTextShiftOffset(),
                                          textRect.y + fm.getAscent() + getTextShiftOffset());
        }
        else {
            /*** paint the text disabled ***/
            g.setColor(b.getBackground().brighter());
            SwingUtilities2.drawStringUnderlineCharAt(c, g,text, mnemonicIndex,
                                          textRect.x, textRect.y + fm.getAscent());
            g.setColor(b.getBackground().darker());
            SwingUtilities2.drawStringUnderlineCharAt(c, g,text, mnemonicIndex,
                                          textRect.x - 1, textRect.y + fm.getAscent() - 1);
        }
	}
	
	@Override
	protected void paintButtonPressed(Graphics g, AbstractButton b) {
		// TODO Auto-generated method stub
//		super.paintButtonPressed(g, b);
		g.setColor(Color.ORANGE);
		g.fillOval((b.getWidth()-b.getHeight())/2, 0, b.getHeight(), b.getHeight());
	}
}
