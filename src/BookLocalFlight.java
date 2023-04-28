
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class BookLocalFlight extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookLocalFlight frame = new BookLocalFlight();
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
	public BookLocalFlight() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 843, 419);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Local Flight Schedule");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(28, 0, 679, 28);
		contentPane.add(lblNewLabel);
		
		String[] columns = {"Flight ID", "Time", "Date", "Daparture Destination",
                "Land Destination" , "Economy Seats" , "Business Seats" , "Time Duration"};

		DefaultTableModel obj=new DefaultTableModel(columns,0);
        
	    for (int i=0 ; i<LocalFlightSchedule.flightList.size() ; i++)
	    {
	    	
	        Object[] update= {LocalFlightSchedule.flightList.get(i).getFlightID() , LocalFlightSchedule.flightList.get(i).getDepartTime() , LocalFlightSchedule.flightList.get(i).getLandTime()
	        			, LocalFlightSchedule.flightList.get(i).getDepartDestination() , LocalFlightSchedule.flightList.get(i).getLandDestination() , 
	        			LocalFlightSchedule.flightList.get(i).getEconomySeats() , LocalFlightSchedule.flightList.get(i).getBusinessSeats() , LocalFlightSchedule.flightList.get(i).getDistance()};
	        
	    	obj.addRow(update);
	    }
	    
	     table = new JTable(obj);
	    JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 39, 764, 200);
		contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("Cancel Flight");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for (Passengers x: SignUP.PassengerList)
				{
					if (x.getUsername().equals(SignUP.username.getText()))
					{
						if (x.getBooked()==true)
						{
							double hour=Integer.valueOf((String) table.getModel().getValueAt(table.getSelectedRow(), 7));
							
							double cost=(hour*10000)+((hour*10000)*5/100);
							JOptionPane.showMessageDialog(null, "Your flight has been cancelled successfully with a penalty of "+ (cost*25/100));
							SignUP.PassengerList.get(0).setBooked(false);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Please book your flight first.");
						}
					}
				}
				
				
			}
		});
		btnNewButton.setBounds(249, 250, 112, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Book Flight");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRowCount()==1)
				{
					String selectClass = JOptionPane.showInputDialog(null, "Enter '1' for Economy and '2' for Business class.",null);
					int slctClass = Integer.valueOf(selectClass);
					
					switch (slctClass)
					{
						case 1:
						{
							for (Passengers x: SignUP.PassengerList)
							{
								if (x.getUsername().equals(SignUP.username.getText()))
								{
									if(x.getBooked()==true)
									{
										JOptionPane.showMessageDialog(null, "Your flight has already been booked against your Passport: "+x.getPassport());
									}
									if (Integer.valueOf((String) table.getModel().getValueAt(table.getSelectedRow(), 5)) > 0 )
									{
										x.setBooked(true);
										JOptionPane.showMessageDialog(null, "Your flight has been booked against your Passport: "+x.getPassport());
									}
									else
									{
										JOptionPane.showMessageDialog(null, "This flight has no available seats in Economy class.");
									}
									
								}
							}
							break;
						}
						case 2:
						{
							for (Passengers x: SignUP.PassengerList)
							{
								if (x.getUsername().equals(SignUP.username.getText()))
								{
									if(x.getBooked()==true)
									{
										JOptionPane.showMessageDialog(null, "Your flight has already been booked against your Passport: "+x.getPassport());
									}
									if (Integer.valueOf((String) table.getModel().getValueAt(table.getSelectedRow(), 6)) > 0 )
									{
										x.setBooked(true);
										JOptionPane.showMessageDialog(null, "Your flight has been booked against your Passport: "+x.getPassport());
									}
									else
									{
										JOptionPane.showMessageDialog(null, "This flight has no available seats in Business class.");
									}
								}
							}
							
							break;
						}
						default:
						{
							JOptionPane.showMessageDialog(null, "You entered an invalid input. Try again");
							break;
						}
					}
				}
				else if(table.getSelectedRowCount()==0)
				{
					JOptionPane.showMessageDialog(null, "Please select a flight to book.");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please select one flight at a time.");
				}
			}
		});
		btnNewButton_1.setBounds(127, 250, 111, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("View Ticket Price");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double hour=Integer.valueOf((String) table.getModel().getValueAt(table.getSelectedRow(), 7));
				
				double cost=(hour*10000)+((hour*10000)*5/100);
				JOptionPane.showMessageDialog(null, "The cost for this flight is: "+cost);
			}
		});
		btnNewButton_2.setBounds(371, 250, 136, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PassengerMenu obj=new PassengerMenu();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(517, 250, 112, 23);
		contentPane.add(btnNewButton_3);
	

}
}
