package TestSwingWork;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.swing.JProgressBar;
import javax.swing.JButton;

public class SwingWorkFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea textArea;
	private JProgressBar progressBar;
	private int value = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingWorkFrame frame = new SwingWorkFrame();
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
	public SwingWorkFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//SwingWorker用法
		JToggleButton btnRun = new JToggleButton("Run");
		btnRun.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				webRead();
			}

		});
		contentPane.add(btnRun, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		
		//Timer用法
		JButton btnPro = new JButton("Progress");
		btnPro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Timer timer = new Timer(1000, new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						value += 10;
						progressBar.setValue(value);
						if (value == 100) {
							value = 0;
						}
					}
				});
				timer.setRepeats(true);
				timer.start();
			}
		});
		scrollPane.setColumnHeaderView(btnPro);
		
		progressBar = new JProgressBar();
		contentPane.add(progressBar, BorderLayout.SOUTH);
	}

	private void webRead() {
		// TODO Auto-generated method stub
		new SwingWorker<StringBuilder, String>() {

			@Override
			protected StringBuilder doInBackground() throws Exception {
				// TODO Auto-generated method stub
				URL url = new URL("http://www.apache.org");
				URLConnection connection = url.openConnection();
				BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
				String line;
				StringBuilder builder = new StringBuilder();
				while ((line = reader.readLine()) != null) {
//					publish(line);
					builder.append(line).append("\n");
				}
				reader.close();
				return builder;
			}
			
			@Override
			protected void process(List<String> chunks) {
				// TODO Auto-generated method stub
//				for (String string : chunks) {
//					textArea.append(string);
//					textArea.append("\n");
//				}
				super.process(chunks);
			}
			
			@Override
			protected void done() {
				// TODO Auto-generated method stub
				try {
					textArea.setText(get().toString());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				super.done();
			}
		}.execute();
	}

}
