/*
League of Legends Ping Tool NA by Stevecabbage/Stevecaboose

This is a simple tool that uses commands in Windows Command Prompt to
quickly get the min, max and average of the users ping over the interval
of 4 seconds. Each packet is 32 bytes and is sent each second. You do not
need to close the program and reopen it to check your ping again. This is
a great tool that can be easily mapped to a key on your keyboard to quickly
check your ping before you commit to a ranked game. At this time, it only checks
the North American server. If this program hits off, I may add options for other
servers. If you have any suggestions or constructive criticism please send me a message.
Thanks and enjoy :)


*/

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import java.awt.Font;


public class MainFrame {

	private JFrame frame;
	JLabel lblMain;
	JProgressBar progressBar;
	private JButton buttonExit;
	JButton btnShowMessage;
	private JLabel lblNewLabel;
	private JLabel lblPleaseAllow;
	private JLabel lblDone;
	private JLabel lblResults;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("LoL Ping Tool NA by Stevecabbage");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblDone = new JLabel("");
		lblDone.setHorizontalAlignment(SwingConstants.CENTER);
		lblDone.setBounds(180, 236, 73, 25);
		lblDone.setFont(new Font("Times New Roman", Font.BOLD, 12));
		frame.getContentPane().add(lblDone);
		
		
		btnShowMessage = new JButton("Check Ping");
		btnShowMessage.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
		
			
		
				try {
					Process p = Runtime.getRuntime().exec("ping 104.160.131.1");
					BufferedReader inputStream = new BufferedReader(
							new InputStreamReader(p.getInputStream()));

					String s = "";
					int n = 25;
					// reading output stream of the command
					while ((s = inputStream.readLine()) != null) {
						progressBar.setValue(n);
						n += 25;
						System.out.println(s);
						
						lblMain.setText(s);
						
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			
				lblDone.setText("DONE");
				
			
				
			}
		});
		btnShowMessage.setForeground(Color.BLACK);
		btnShowMessage.setBounds(73, 177, 129, 39);
		frame.getContentPane().add(btnShowMessage);
		
		lblMain = new JLabel("");
		lblMain.setHorizontalAlignment(SwingConstants.CENTER);
		lblMain.setBounds(10, 43, 414, 52);
		frame.getContentPane().add(lblMain);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(10, 221, 414, 14);
		frame.getContentPane().add(progressBar);
		
		buttonExit = new JButton("Exit");
		buttonExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.dispose();
			}
		});
		buttonExit.setForeground(Color.BLACK);
		buttonExit.setBounds(260, 177, 129, 39);
		frame.getContentPane().add(buttonExit);
		
		lblNewLabel = new JLabel("League of Lengends ping tester by Stevecabbage");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 106, 256, 33);
		frame.getContentPane().add(lblNewLabel);
		
		lblPleaseAllow = new JLabel("Please allow 4 or more seconds for results to be displayed");
		lblPleaseAllow.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblPleaseAllow.setBounds(10, 139, 379, 25);
		frame.getContentPane().add(lblPleaseAllow);
		
		lblResults = new JLabel("Results:");
		lblResults.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblResults.setHorizontalAlignment(SwingConstants.CENTER);
		lblResults.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(lblResults);
		
		
		
	}
}