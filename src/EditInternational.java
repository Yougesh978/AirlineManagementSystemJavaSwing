
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class EditInternational extends JFrame {

	private JPanel contentPane;
	private JTextField flightID;
	private JTextField flightTime;
	private JTextField flightDate;
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
					EditLocalFlight frame = new EditLocalFlight();
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
	public EditInternational() {
		setBackground(Color.PINK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 381);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Flight");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(56, 11, 414, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Flight ID");
		lblNewLabel_1.setBounds(10, 36, 113, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Time");
		lblNewLabel_2.setBounds(10, 61, 113, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Flight Date");
		lblNewLabel_3.setBounds(10, 86, 113, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Deaprture City");
		lblNewLabel_4.setBounds(10, 111, 113, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Landing City");
		lblNewLabel_5.setBounds(10, 136, 113, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Economy Seats");
		lblNewLabel_6.setBounds(10, 161, 113, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Business Seats");
		lblNewLabel_7.setBounds(10, 186, 113, 14);
		contentPane.add(lblNewLabel_7);
		
		flightID = new JTextField();
		flightID.setBounds(133, 33, 86, 20);
		contentPane.add(flightID);
		flightID.setColumns(10);
		
		flightTime = new JTextField();
		flightTime.setBounds(133, 58, 86, 20);
		contentPane.add(flightTime);
		flightTime.setColumns(10);
		
		flightDate = new JTextField();
		flightDate.setBounds(133, 83, 86, 20);
		contentPane.add(flightDate);
		flightDate.setColumns(10);
		
		departCity = new JTextField();
		departCity.setBounds(133, 108, 86, 20);
		contentPane.add(departCity);
		departCity.setColumns(10);
		
		landCity = new JTextField();
		landCity.setBounds(133, 133, 86, 20);
		contentPane.add(landCity);
		landCity.setColumns(10);
		
		economySeats = new JTextField();
		economySeats.setBounds(133, 158, 86, 20);
		contentPane.add(economySeats);
		economySeats.setColumns(10);
		
		businessSeats = new JTextField();
		businessSeats.setBounds(133, 183, 86, 20);
		contentPane.add(businessSeats);
		businessSeats.setColumns(10);
		
		JButton btnNewButton = new JButton("Done");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row= InternationalFlightSchedule.table.getSelectedRow();
				
				InternationalFlightSchedule.table.setValueAt(flightID.getText(), row , 0);
				InternationalFlightSchedule.table.setValueAt(flightTime.getText(), row , 1);
				InternationalFlightSchedule.table.setValueAt(flightDate.getText(), row , 2);
				InternationalFlightSchedule.table.setValueAt(departCity.getText(), row , 3);
				InternationalFlightSchedule.table.setValueAt(landCity.getText(), row , 4);
				InternationalFlightSchedule.table.setValueAt(economySeats.getText(), row , 5);
				InternationalFlightSchedule.table.setValueAt(businessSeats.getText(), row , 6);
				InternationalFlightSchedule.table.setValueAt(distance.getText(), row , 7);
				
				InternationalFlightSchedule.table.repaint();
				
				InternationalFlightSchedule obj=new InternationalFlightSchedule();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(255, 207, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_8 = new JLabel("Time Duration");
		lblNewLabel_8.setBounds(10, 211, 113, 14);
		contentPane.add(lblNewLabel_8);
		
		distance = new JTextField();
		distance.setBounds(133, 208, 86, 20);
		contentPane.add(distance);
		distance.setColumns(10);
		
		
	}

}
