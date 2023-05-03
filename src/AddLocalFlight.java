

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class AddLocalFlight extends JFrame {

	private JPanel contentPane;
	private JTextField flightID;
	private JTextField flightTime;
	private JTextField landTime;
	private JTextField departCity;
	private JTextField landCity;
	private JTextField economySeats;
	private JTextField businessSeats;
	private JTextField distance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddLocalFlight frame = new AddLocalFlight();
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
	public AddLocalFlight() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 359);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Flight");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 414, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Flight ID");
		lblNewLabel_1.setBounds(20, 36, 101, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Time");
		lblNewLabel_2.setBounds(20, 65, 101, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Date");
		lblNewLabel_3.setBounds(20, 90, 101, 14);
		contentPane.add(lblNewLabel_3);
		
		flightID = new JTextField();
		flightID.setBounds(131, 33, 86, 20);
		contentPane.add(flightID);
		flightID.setColumns(10);
		
		flightTime = new JTextField();
		flightTime.setBounds(131, 62, 86, 20);
		contentPane.add(flightTime);
		flightTime.setColumns(10);
		
		landTime = new JTextField();
		landTime.setBounds(131, 90, 86, 20);
		contentPane.add(landTime);
		landTime.setColumns(10);
		
		departCity = new JTextField();
		departCity.setBounds(131, 121, 86, 20);
		contentPane.add(departCity);
		departCity.setColumns(10);
		
		landCity = new JTextField();
		landCity.setBounds(131, 152, 86, 20);
		contentPane.add(landCity);
		landCity.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Departure City");
		lblNewLabel_4.setBounds(20, 124, 94, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Landing City");
		lblNewLabel_5.setBounds(20, 155, 94, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel("Economy Seats");
		lblNewLabel_7.setBounds(20, 187, 101, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Business Seats");
		lblNewLabel_8.setBounds(20, 217, 101, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_6 = new JLabel("Time Duration");
		lblNewLabel_6.setBounds(20, 242, 101, 14);
		contentPane.add(lblNewLabel_6);
		
		distance = new JTextField();
		distance.setBounds(131, 239, 86, 20);
		contentPane.add(distance);
		distance.setColumns(10);
		
		economySeats = new JTextField();
		economySeats.setBounds(131, 183, 86, 20);
		contentPane.add(economySeats);
		economySeats.setColumns(10);
		
		businessSeats = new JTextField();
		businessSeats.setBounds(131, 214, 86, 20);
		contentPane.add(businessSeats);
		businessSeats.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (flightID.getText().equals("") || flightTime.getText().equals("") || landTime.getText().equals("") || departCity.getText().equals("") || 
						landCity.getText().equals("") || economySeats.getText().equals("") || businessSeats.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Fields cannot be empty");
				}
				else if(economySeats.getText().matches("^\\d+(\\.\\d+)?")==false)
				{
					JOptionPane.showMessageDialog(null, "Please enter integer input for Economy Seats.");
				}
				else if(businessSeats.getText().matches("^\\d+(\\.\\d+)?")==false)
				{
					JOptionPane.showMessageDialog(null, "Please enter integer input for Business Seats.");
				}
				else if(distance.getText().matches("^\\d+(\\.\\d+)?")==false)
				{
					JOptionPane.showMessageDialog(null, "Please enter integer input for Time Duration.");
				}
				else if (Integer.parseInt(economySeats.getText())>50)
				{
					JOptionPane.showMessageDialog(null, "Economy seats cannot be greater than '50'");
				}
				else if (Integer.parseInt(businessSeats.getText())>10)
				{
					JOptionPane.showMessageDialog(null, "Business seats cannot be greater than '10'");
				}
				
				Flight obj=new Flight(flightID.getText(),flightTime.getText(),landTime.getText(),departCity.getText(),landCity.getText()
						,economySeats.getText(),businessSeats.getText(),distance.getText());
				LocalFlightSchedule.flightList.add(obj);
				JOptionPane.showMessageDialog(null, "Added Successfully");
			}
		});
		btnNewButton.setBounds(244, 179, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocalFlightSchedule obj1=new LocalFlightSchedule();
				obj1.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(244, 213, 89, 23);
		contentPane.add(btnNewButton_1);
		
		
		
		
		
		
	}
}
