package TestJOptionPane;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class JOptionPaneFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JOptionPaneFrame frame = new JOptionPaneFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JOptionPaneFrame() {

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				// super.windowClosing(e);
				int value = JOptionPane.showConfirmDialog(JOptionPaneFrame.this, "你确认退出吗？", "请确认",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (value == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnshowconfirmdialog = new JButton("显示确认框（showConfirmDialog）");
		btnshowconfirmdialog.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// int value =
				// JOptionPane.showConfirmDialog(JOptionPaneFrame.this,
				// "你确认吗？");
				// System.out.println(value);
				// if (value == JOptionPane.YES_OPTION) {
				//
				// }

				int value = JOptionPane.showConfirmDialog(JOptionPaneFrame.this, "你确认退出吗？", "请确认",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				System.out.println(value);
				if (value == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});

		JButton btnshowMessageDialog = new JButton("显示消息框（showMessageDialog）");
		btnshowMessageDialog.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(JOptionPaneFrame.this, "Null Pointer Exception", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		});

		JButton btnshowInputDialog = new JButton("显示输入框（showInputDialog）");
		btnshowInputDialog.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// String in = JOptionPane.showInputDialog("Input", "abc");
				// String in =
				// JOptionPane.showInputDialog(JOptionPaneFrame.this,"请输入密码",
				// "输入密码",JOptionPane.INFORMATION_MESSAGE);
				String in = (String) JOptionPane.showInputDialog(JOptionPaneFrame.this, "请输入密码", "输入密码",
						JOptionPane.INFORMATION_MESSAGE, null, new String[] { "aaa", "bbb", "ccc", "abc" }, "abc");
				JOptionPane.showMessageDialog(JOptionPaneFrame.this, in);
			}
		});

		JButton btnshowOptionDialog = new JButton("显示多项选择框（showOptionDialog）");
		btnshowOptionDialog.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int value = JOptionPane.showOptionDialog(JOptionPaneFrame.this, "选择合适你的计划", "选择计划",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
						new String[] { "A", "B", "C", "D" }, "A");
				if (value != JOptionPane.CLOSED_OPTION) {
					switch (value) {
					case 0:
						System.out.println("你选择了计划 A");
						break;
					case 1:
						System.out.println("你选择了计划 B");
						break;
					case 2:
						System.out.println("你选择了计划 C");
						break;
					case 3:
						System.out.println("你选择了计划 D");
						break;

					default:
						break;
					}
				}

			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(278)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnshowInputDialog, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnshowMessageDialog, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnshowconfirmdialog, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnshowOptionDialog, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 248,
								GroupLayout.PREFERRED_SIZE))
				.addGap(330)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(5).addComponent(btnshowconfirmdialog)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnshowMessageDialog)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnshowInputDialog)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnshowOptionDialog)
						.addContainerGap(437, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}
}
