package TestSwingJMenuBar;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

public class MyFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPopupMenu popupMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame frame = new MyFrame();
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
	public MyFrame() {
		setTitle("菜单栏的使用");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mnFile.add(mntmOpen);
		
		JMenuItem mntmClose = new JMenuItem("Close");
		mntmClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnFile.add(mntmClose);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmUndo = new JMenuItem("Undo");
		mntmUndo.setIcon(new ImageIcon(MyFrame.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
		mnEdit.add(mntmUndo);
		
		JMenu mnStyle = new JMenu("Style");
		mnEdit.add(mnStyle);
		
		JMenuItem mntmRed = new JMenuItem("Red");
		mnStyle.add(mntmRed);
		
		JMenuItem mntmBlue = new JMenuItem("Blue");
		mnStyle.add(mntmBlue);
		
		mnEdit.addSeparator();
		
		JCheckBoxMenuItem chckbxmntmA = new JCheckBoxMenuItem("a");
		mnEdit.add(chckbxmntmA);
		
		JCheckBoxMenuItem chckbxmntmB = new JCheckBoxMenuItem("b");
		mnEdit.add(chckbxmntmB);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 3) {
					popupMenu.show(MyFrame.this, e.getX(), e.getY());
				}
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		/************************************************/
		popupMenu = new JPopupMenu();
		JMenuItem item1 = new JMenuItem("A");
		popupMenu.add(item1);
		JMenuItem item2 = new JMenuItem("B");
		popupMenu.add(item2);
		popupMenu.addSeparator();
		
		JMenu m = new JMenu("Open");
		JMenuItem item3 = new JMenuItem("1");
		m.add(item3);
		JMenuItem item4 = new JMenuItem("2");
		m.add(item4);
		popupMenu.add(m);
	}

}
