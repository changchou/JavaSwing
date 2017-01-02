package TestJFileChooser;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class JFileChooserFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFileChooser jFileChooser;
	private JTextArea label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFileChooserFrame frame = new JFileChooserFrame();
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
	public JFileChooserFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		// 文件选择
		jFileChooser = new JFileChooser();
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.NORTH);

		JButton btnOpenFile = new JButton("OpenFile");
		panel_2.add(btnOpenFile);
		btnOpenFile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 设定扩展名过滤
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Allowed File", "mp4", "exe");
				jFileChooser.setFileFilter(filter);

				int value = jFileChooser.showOpenDialog(getParent());
				if (value == JFileChooser.APPROVE_OPTION) {
					File file = jFileChooser.getSelectedFile();
					System.out.println(file.getAbsolutePath());
					label.setText(file.getAbsolutePath());
				}
			}
		});

		JButton btnOpenDir = new JButton("OpenDir");
		panel_2.add(btnOpenDir);

		label = new JTextArea();
		label.setLineWrap(true);
		panel.add(label, BorderLayout.CENTER);

		btnOpenDir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 文件和文件夹都可以选择
				jFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				// 设置选择多项
				jFileChooser.setMultiSelectionEnabled(true);
				int value = jFileChooser.showOpenDialog(getParent());
				if (value == JFileChooser.APPROVE_OPTION) {
					// File file = jFileChooser.getSelectedFile();
					// System.out.println(file.getAbsolutePath());

					// 选择多个文件
					File file[] = jFileChooser.getSelectedFiles();
					for (File f : file) {
						System.out.println(f.getAbsolutePath());
						label.setText(f.getAbsolutePath());
					}

				}
			}
		});

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);

		JButton btnSavefile = new JButton("SaveFile");
		btnSavefile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int value = jFileChooser.showSaveDialog(getParent());
				if (value == JFileChooser.APPROVE_OPTION) {
					File file = jFileChooser.getSelectedFile();
					if (!file.exists()) {
						try {
							file.createNewFile();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					System.out.println(jFileChooser.getSelectedFile().getAbsolutePath());
				}
			}
		});
		panel_1.add(btnSavefile);
	}

}
