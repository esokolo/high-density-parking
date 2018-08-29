
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.awt.event.ActionEvent;
import java.util.TimerTask;


@SuppressWarnings("serial")
public class Parking_Gui extends JFrame {

	private JPanel contentPane;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Parking_Gui frame = new Parking_Gui();
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
	public Parking_Gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1078, 746);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);	
// Second Panel for the Tiles Moving----------------------------------------------------------------------------------------- 
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.menu);
		panel_1.setBounds(598, 33, 450, 641);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblxThingsHere = new JLabel("8X8 THINGS HERE");
		lblxThingsHere.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblxThingsHere.setBounds(132, 301, 252, 16);
		panel_1.add(lblxThingsHere);
//=====Welcome Panel=================================================================================================		
		
		final JPanel panel = new JPanel();
		panel.setBackground(SystemColor.menu);
		panel.setBounds(26, 33, 427, 641);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel1 = new JLabel("Welcome to High-Density");
		lblNewLabel1.setBounds(58, 23, 254, 42);
		lblNewLabel1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel.add(lblNewLabel1);
		
		JLabel lblParking = new JLabel("Parking");
		lblParking.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblParking.setBounds(153, 78, 87, 25);
		panel.add(lblParking);
//=========Retrieval==============================================================================================
		
		final JPanel Dpanel = new JPanel();
		Dpanel.setBackground(SystemColor.menu);
		Dpanel.setBounds(26, 33, 427, 641);
		Dpanel.setLayout(null);
		
		JButton btnNewButton = new JButton("Retrieve");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				contentPane.remove(panel);
				contentPane.add(Dpanel);
				contentPane.revalidate();
				contentPane.repaint();
				
				JLabel lblNewLabel = new JLabel("High-Density Parking System");
				lblNewLabel.setBounds(58, 23, 350, 50);
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
				Dpanel.add(lblNewLabel);
				
				JLabel lblReceipt = new JLabel ("Please swipe your card");
				Dpanel.add(lblReceipt);
				lblReceipt.setFont(new Font("Tahoma", Font.PLAIN, 20));
				lblReceipt.setBounds(90, 150, 254, 25);
				
				final JTextField retrieve= new JTextField();
				retrieve.setBounds(90, 200, 256, 25);
				Dpanel.add(retrieve);
				
				JButton btndretrieve = new JButton ("Submit");
				btndretrieve.setBackground(Color.WHITE);
				btndretrieve.setFont(new Font("Tahoma", Font.PLAIN, 16));
				btndretrieve.setBounds(90, 230, 109, 50);
				Dpanel.add(btndretrieve);
//========Third Panel for Retrieval====================================================================================			
				btndretrieve.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						final JPanel Fpanel = new JPanel();
						Fpanel.setBackground(SystemColor.menu);
						Fpanel.setBounds(26, 33, 427, 641);
						Fpanel.setLayout(null);
						
						contentPane.remove(Dpanel);
						contentPane.add(Fpanel);
						contentPane.revalidate();
						contentPane.repaint();

						String CCard = retrieve.getText();

						String ccNumber = "";
						String custName = "";
						

						String raw = "{%B<acct_no>^<cust_name>^<*>?}";
						raw = CCard;
						int head = raw.indexOf("%B");
						int middle = raw.indexOf("^");
						int tail = raw.lastIndexOf("^");

						// 2. extract acct_no
						ccNumber = raw.substring(head+2, middle); 
						//Testing
						System.out.println("Credit Card Number = " +ccNumber);

						// 3. extract cust_name
						custName = raw.substring(middle+1, tail);
						//Testing
						System.out.println("Customer Name = " +custName);
						//System.out.println(Card1);

						JLabel lblFinal = new JLabel("Would you like your receipt ?");
						lblFinal.setBounds(85, 23, 350, 50);
						lblFinal.setFont(new Font("Tahoma", Font.PLAIN, 22));
						Fpanel.add(lblFinal);

						JButton btnyes = new JButton ("YES");
						
						 btnyes.setBackground(Color.WHITE);
						 btnyes.setFont(new Font("Tahoma", Font.PLAIN, 16));
						 btnyes.setBounds(90, 230, 109, 50);
						 Fpanel.add(btnyes);
						
						btnyes.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
						final JPanel Receiptpanel = new JPanel();
						Receiptpanel.setBackground(SystemColor.menu);
						Receiptpanel.setBounds(26, 33, 427, 641);
						Receiptpanel.setLayout(null);
							
						JLabel lblFinalReceipt = new JLabel("Your Total is : ");
						lblFinalReceipt.setBounds(58, 238, 350, 50);
						lblFinalReceipt.setFont(new Font("Tahoma", Font.PLAIN, 22));
						Receiptpanel.add(lblFinalReceipt);
						
					    retrieve.setText("");
						
							contentPane.remove(Fpanel);
						    contentPane.add(Receiptpanel);
							contentPane.revalidate();
							contentPane.repaint();
						

							Timer timer = new Timer ();
							timer.schedule(new TimerTask(){

								@Override
								public void run()
								{
									contentPane.remove(Receiptpanel);
								    contentPane.add(panel);
									contentPane.revalidate();
									contentPane.repaint();
									
								}}, 3000,1);
							}});

						JButton btnNo = new JButton ("NO");
						
						btnNo.setBackground(Color.WHITE);
						btnNo.setFont(new Font("Tahoma", Font.PLAIN, 16));
						btnNo.setBounds(254, 230, 109, 50);
						Fpanel.add(btnNo);
						
						btnNo.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								final JPanel nopanel = new JPanel();
								nopanel.setBackground(SystemColor.menu);
								nopanel.setBounds(26, 33, 427, 641);
								nopanel.setLayout(null);
								JLabel lblFinalnoReceipt = new JLabel("Good bye");
								lblFinalnoReceipt.setBounds(85, 238, 350, 50);
								lblFinalnoReceipt.setFont(new Font("Tahoma", Font.PLAIN, 50));
								nopanel.add(lblFinalnoReceipt);
								
								retrieve.setText("");
								contentPane.remove(Fpanel);
								contentPane.add(nopanel);
								contentPane.revalidate();
								contentPane.repaint();
								
								Timer timer = new Timer ();
								timer.schedule(new TimerTask(){

									@Override
									public void run()
									{
										contentPane.remove(nopanel);
									    contentPane.add(panel);
										contentPane.revalidate();
										contentPane.repaint();	
									}}, 3000,1);	
							}});			 
					}}); 	
			}
		});

		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(58, 531, 109, 50);
		panel.add(btnNewButton);

//======Drop off=================================================================================================
	
		final JPanel Rpanel = new JPanel ();
		Rpanel.setBackground(SystemColor.menu);
		Rpanel.setBounds(26, 33, 427, 641);
		Rpanel.setLayout(null);

		JButton btnNewButton_1 = new JButton("DropOff");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				contentPane.remove(panel);
				contentPane.add(Rpanel);
				contentPane.revalidate();
				contentPane.repaint();
				
				JLabel lblNewLabel2 = new JLabel(" High-Density Parking System ");
				lblNewLabel2.setBounds(58, 23, 350, 50);
				lblNewLabel2.setFont(new Font("Tahoma", Font.PLAIN, 22));
				Rpanel.add(lblNewLabel2);
				
				
				JLabel lblReceipt1 = new JLabel ("Please swipe your card");
				Rpanel.add(lblReceipt1);
				lblReceipt1.setFont(new Font("Tahoma", Font.PLAIN, 20));
				lblReceipt1.setBounds(90, 150, 254, 25);
				
				
				final JTextField dropoff = new JTextField();
				dropoff.setBounds(90, 200, 256, 25);
				Rpanel.add(dropoff);
				
				JButton btndropoff = new JButton ("Submit");
				btndropoff.setBackground(Color.WHITE);
				btndropoff.setFont(new Font("Tahoma", Font.PLAIN, 16));
				btndropoff.setBounds(90, 230, 109, 50);
				Rpanel.add(btndropoff);
				
				
				 btndropoff.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						String Card1 = dropoff.getText();
						String ccNumber = "";
						String custName = "";
						
						String raw = "{%B<acct_no>^<cust_name>^<*>?}";
						raw = Card1;
						int head = raw.indexOf("%B");
						int middle = raw.indexOf("^");
						int tail = raw.lastIndexOf("^");

						// 2. extract acct_no
						ccNumber = raw.substring(head+2, middle); 
						
						// 3. extract cust_name
						custName = raw.substring(middle+1, tail);
						//Testing
						
						
						final JPanel Timepanel = new JPanel ();
						Timepanel.setBackground(SystemColor.menu);
						Timepanel.setBounds(26, 33, 427, 641);
						Timepanel.setLayout(null);
						
						dropoff.setText("");
						contentPane.remove(Rpanel);
						contentPane.add(Timepanel);
						contentPane.revalidate();
						contentPane.repaint();
						
						
						JLabel timelbl = new JLabel(" Please Choose your Time ");
						timelbl.setBounds(58, 23, 350, 50);
						timelbl.setFont(new Font("Tahoma", Font.PLAIN, 22));
						Timepanel.add(timelbl);
						
// 30 minutes chosen================================================================================================================						
						
						JButton Thirty_mins = new JButton("30 Mins");
						Thirty_mins.setBackground(Color.WHITE);
						Thirty_mins.setFont(new Font("Tahoma", Font.PLAIN, 16));
						Thirty_mins.setBounds(50, 230, 130, 50);
						Timepanel.add(Thirty_mins);
						
						Thirty_mins.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
						int _30_min = 30;
						dropoff.setText("");
						Timer timer = new Timer ();
						timer.schedule(new TimerTask(){

							@Override
							public void run() {
								contentPane.remove(Timepanel);
							    contentPane.add(panel);
								contentPane.revalidate();
								contentPane.repaint();
								
							}
								
								
								
						}, 3000,1);	
							}});
						
						
// one hour chosen =================================================================================================================						
						
						JButton one_hour = new JButton("1 Hrs");
						one_hour.setBackground(Color.WHITE);
						one_hour.setFont(new Font("Tahoma", Font.PLAIN, 16));
						one_hour.setBounds(200, 230, 130, 50);
						Timepanel.add(one_hour);

						one_hour.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
						int _1_hr = 60;
						dropoff.setText("");
						Timer timer = new Timer ();
						timer.schedule(new TimerTask(){

							@Override
							public void run() {
								contentPane.remove(Timepanel);
							    contentPane.add(panel);
								contentPane.revalidate();
								contentPane.repaint();
								
							}
								
								
								
						}
								
								, 3000,1);					
							}});
// 2 hour chosen ==================================================================================================================					
				
						JButton two_hour = new JButton("2 Hrs");
						two_hour.setBackground(Color.WHITE);
						two_hour.setFont(new Font("Tahoma", Font.PLAIN, 16));
						two_hour.setBounds(50, 290, 130, 50);
						Timepanel.add(two_hour);
						
						two_hour.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
						int _2_hr = 120;
						dropoff.setText("");
						Timer timer = new Timer ();
						timer.schedule(new TimerTask(){

							@Override
							public void run() {
								contentPane.remove(Timepanel);
							    contentPane.add(panel);
								contentPane.revalidate();
								contentPane.repaint();
								
							}
								
								
								
						}
								
								, 3000,1);
							}});			
//  3 hour chosen ====================================================================================================================						
				
						JButton three_hour = new JButton("3 Hrs");
						three_hour.setBackground(Color.WHITE);
						three_hour.setFont(new Font("Tahoma", Font.PLAIN, 16));
						three_hour.setBounds(200, 290, 130, 50);
						Timepanel.add(three_hour);

						three_hour.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
						int _3_hr = 180;
						dropoff.setText("");
						Timer timer = new Timer ();
						timer.schedule(new TimerTask(){

							@Override
							public void run() {
								contentPane.remove(Timepanel);
							    contentPane.add(panel);
								contentPane.revalidate();
								contentPane.repaint();
								
							}
								
								
								
						}
								
								, 3000,1);	
							}});	
// 4 hour chosen=====================================================================================================================
						JButton four_hour = new JButton("4 Hrs");
						four_hour.setBackground(Color.WHITE);
						four_hour.setFont(new Font("Tahoma", Font.PLAIN, 16));
						four_hour.setBounds(125, 350, 130, 50);
						Timepanel.add(four_hour);
				
						four_hour.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
						int _4_hr = 240;
						dropoff.setText("");
						Timer timer = new Timer ();
						timer.schedule(new TimerTask(){

							@Override
							public void run() {
								contentPane.remove(Timepanel);
							    contentPane.add(panel);
								contentPane.revalidate();
								contentPane.repaint();
								
							}		
						}
								
								, 3000,1);							
							}});	
					}});

			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1.setBounds(281, 530, 109, 50);
		panel.add(btnNewButton_1);
	
	}
	

}// end Class