package TestUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class MyFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JRadioButton r1;
	private JRadioButton r2;
	private JRadioButton r3;
	private JCheckBox c1;
	private JCheckBox c2;
	private JCheckBox c3;
	private JLabel l2;
	private JPanel panel_2;
	private JLabel label;
	private JButton btnNewButton;
	private JList<String> list;
	private JPanel panel_3;
	private JComboBox<String> comboBox;
	private JLabel label_1;
	private JPanel panel_4;
	private JProgressBar progressBar;
	private JPanel panel_5;
	private JLabel label_2;
	private JPanel panel_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		//界面样式  如果还有其他窗口不需要这个样式 将窗口实例放在前面即可
//		try {
//			UIManager.setLookAndFeel(new MetalLookAndFeel());
//		} catch (UnsupportedLookAndFeelException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
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
		
		setTitle("TestFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		ButtonGroup group = new ButtonGroup();

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "\u9009\u62E9\u98981", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(
				new TitledBorder(null, "\u9009\u62E9\u98982", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u5217\u8868\u63A7\u4EF6 JList",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "\u4E0B\u62C9\u83DC\u5355 JComboBox", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));

		panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "\u8FDB\u5EA6\u6761\u63A7\u4EF6 JProgressBar", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		
		panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "\u6570\u5B57\u8C03\u8282\u63A7\u4EF6 JSpinner", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		panel_6 = new JPanel();
		panel_6.setBackground(new Color(51, 255, 153));
		panel_6.setBorder(new TitledBorder(null, "\u5E03\u5C40", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(162, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
							.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(panel_1, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
							.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
		);
		
		JPanel panel_8 = new JPanel();
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(204, 204, 102));
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 602, GroupLayout.PREFERRED_SIZE)
				.addComponent(panel_8, GroupLayout.PREFERRED_SIZE, 602, GroupLayout.PREFERRED_SIZE)
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
				.addComponent(panel_8, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
		);
		panel_6.setLayout(gl_panel_6);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		
		//数字调节控件
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(60, 0, 100, 5));
		panel_5.add(spinner, BorderLayout.NORTH);
		
		label_2 = new JLabel(" ");
		panel_5.add(label_2, BorderLayout.CENTER);
		
		JButton btnNewButton_2 = new JButton("get");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				label_2.setText(spinner.getValue().toString());
			}
		});
		panel_5.add(btnNewButton_2, BorderLayout.SOUTH);
		panel_4.setLayout(new BorderLayout(0, 0));

		// 进度条
		progressBar = new JProgressBar();
		panel_4.add(progressBar, BorderLayout.SOUTH);

		JButton btnNewButton_1 = new JButton("Run");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new SwingWorker<String, Integer>() {

					@Override
					protected String doInBackground() throws Exception {
						// TODO Auto-generated method stub
						for (int i = 0; i <= 10; i++) {
							Thread.sleep(1000);
							publish(i * 10);
						}
						return null;
					}

					@Override
					protected void process(List<Integer> chunks) {
						// TODO Auto-generated method stub
//						super.process(chunks);
						for (Integer integer : chunks) {
							progressBar.setValue(integer);
						}
					}
				}.execute();
			}
		});
		panel_4.add(btnNewButton_1, BorderLayout.NORTH);
		panel_3.setLayout(new BorderLayout(0, 0));

		// 下拉菜单
		comboBox = new JComboBox<String>();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				label_1.setText(comboBox.getSelectedItem().toString());
			}
		});
		comboBox.setModel(
				new DefaultComboBoxModel<String>(new String[] { "Java", "Android", "JavaSwing", "PHP", "Html5" }));
		panel_3.add(comboBox, BorderLayout.NORTH);

		label_1 = new JLabel(" ");
		panel_3.add(label_1, BorderLayout.CENTER);

		JButton btnGet_2 = new JButton("get");
		btnGet_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				label_1.setText(comboBox.getSelectedItem().toString());
			}
		});
		panel_3.add(btnGet_2, BorderLayout.SOUTH);
		panel_2.setLayout(new BorderLayout(0, 0));

		// 列表控件
		list = new JList<String>();
		list.setModel(new AbstractListModel<String>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			String[] values = new String[] { "Java", "Swift", "C#", "Python", "Ruby" };

			public int getSize() {
				return values.length;
			}

			public String getElementAt(int index) {
				return values[index];
			}
		});
		panel_2.add(list, BorderLayout.NORTH);

		label = new JLabel(" ");
		panel_2.add(label, BorderLayout.CENTER);

		btnNewButton = new JButton("get");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// label.setText(list.getSelectedValue());

				@SuppressWarnings("deprecation")
				Object[] o = list.getSelectedValues();
				StringBuilder builder = new StringBuilder("You selected ");
				for (int i = 0; i < o.length; i++) {
					builder.append(o[i] + " ");
				}
				label.setText(builder.toString());
			}
		});
		panel_2.add(btnNewButton, BorderLayout.SOUTH);

		// 复选控件
		c1 = new JCheckBox("Java");

		c2 = new JCheckBox("Swift");

		c3 = new JCheckBox("C#");

		JButton btnGet_1 = new JButton("get");
		btnGet_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				StringBuilder builder = new StringBuilder("You selected ");
				if (c1.isSelected()) {
					builder.append(c1.getText() + " ");
				}
				if (c2.isSelected()) {
					builder.append(c2.getText() + " ");
				}
				if (c3.isSelected()) {
					builder.append(c3.getText() + " ");
				}
				l2.setText(builder.toString());
			}
		});

		l2 = new JLabel(" ");

		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup().addContainerGap().addComponent(l2,
										GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
								.addGroup(gl_panel_1.createSequentialGroup().addContainerGap().addComponent(c1))
								.addGroup(gl_panel_1.createSequentialGroup().addContainerGap().addComponent(c2))
								.addGroup(gl_panel_1.createSequentialGroup().addContainerGap().addComponent(c3))
								.addGroup(gl_panel_1.createSequentialGroup().addGap(54).addComponent(btnGet_1)))
						.addContainerGap()));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap().addComponent(c1)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(c2)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(c3).addGap(21).addComponent(btnGet_1)
						.addGap(28).addComponent(l2).addContainerGap(77, Short.MAX_VALUE)));
		panel_1.setLayout(gl_panel_1);

		// 单选控件
		r1 = new JRadioButton("option1");
		group.add(r1);

		r2 = new JRadioButton("option2");
		group.add(r2);

		r3 = new JRadioButton("option3");
		group.add(r3);

		JButton btnGet = new JButton("get");
		btnGet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (r1.isSelected()) {
					btnGet.setText("1");
				} else if (r2.isSelected()) {
					btnGet.setText("2");
				} else if (r3.isSelected()) {
					btnGet.setText("3");
				}
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addContainerGap()
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(r1)
												.addComponent(r2).addComponent(r3)))
								.addGroup(gl_panel.createSequentialGroup().addGap(54).addComponent(btnGet)))
						.addContainerGap(71, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(r1)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(r2)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(r3).addGap(18).addComponent(btnGet)
						.addContainerGap(108, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
