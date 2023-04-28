

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MainScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
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
	public MainScreen() {
		setBackground(Color.PINK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 451);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Airline Flight Management System ");
		lblNewLabel.setBackground(Color.PINK);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(81, 11, 414, 28);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Click here to select your login type");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModeSelection obj=new ModeSelection();
				obj.setVisible(true);
			}
		});
		btnNewButton.setBounds(158, 129, 249, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(552, 277, 89, 23);
		contentPane.add(btnNewButton_1);
		
		Flight obj1=new Flight("BK001","10:00-12:00","20-12-2021","Birmingham","London","30","10","2");
		Flight obj2=new Flight("B002","01:00-03:00","20-12-2021","London","Manchester","25","07","4");
		Flight obj3=new Flight("B003","10:00-01:00","20-12-2021","Leeds","Birmingham","22","06","3");
		Flight obj4=new Flight("E004","02:00-05:00","20-12-2021","Manchester","Bristol","18","05","3");
		Flight obj5=new Flight("T005","10:00-12:00","20-12-2021","Liverpool","Leeds","21","09","2");
		Flight obj6=new Flight("A006","10:00-12:00","20-12-2021","Bristol","Manchester","17","08","2");
		
		LocalFlightSchedule.flightList.add(obj1);
		LocalFlightSchedule.flightList.add(obj2);
		LocalFlightSchedule.flightList.add(obj3);
		LocalFlightSchedule.flightList.add(obj4);
		LocalFlightSchedule.flightList.add(obj5);
		LocalFlightSchedule.flightList.add(obj6);
		
		internationalFlight Obj1=new internationalFlight("PC001","10:00-12:00","20-12-2021","Manchester","Oslo","30","10","2");
		internationalFlight Obj2=new internationalFlight("PA002","01:00-03:00","20-12-2021","Brussels","Washington","25","07","4");
		internationalFlight Obj3=new internationalFlight("PI003","10:00-01:00","20-12-2021","Boston","Miami","22","02","3");
		internationalFlight Obj4=new internationalFlight("PS004","02:00-05:00","20-12-2021","Chichago","Barcelona","18","00","3");
		internationalFlight Obj5=new internationalFlight("PF005","10:00-12:00","20-12-2021","Vegas","Osaka","21","09","2");
		internationalFlight Obj6=new internationalFlight("PT006","10:00-12:00","20-12-2021","Los Angeles","Tronto","17","01","2");
		
		InternationalFlightSchedule.flightList2.add(Obj1);
		InternationalFlightSchedule.flightList2.add(Obj2);
		InternationalFlightSchedule.flightList2.add(Obj3);
		InternationalFlightSchedule.flightList2.add(Obj4);
		InternationalFlightSchedule.flightList2.add(Obj5);
		InternationalFlightSchedule.flightList2.add(Obj6);
	}
}
