
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class LocalFlightSchedule extends JFrame {

	private JPanel contentPane;
	static JTable table;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel;
	private JButton btnNewButton_3;
	static ArrayList<Flight> flightList=new ArrayList<Flight>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LocalFlightSchedule frame = new LocalFlightSchedule();
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
	public LocalFlightSchedule() {
		setBackground(Color.PINK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 938, 423);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
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
	//	scrollPane.setColumnHeaderView(table);
		
		btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddLocalFlight obj=new AddLocalFlight();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(161, 250, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRowCount()==1)
				{
					obj.removeRow(table.getSelectedRow());
					flightList.remove(table.getSelectedRowCount()+1);
					JOptionPane.showMessageDialog(null, "Selected flight has been deleted.");
				}
				else if(table.getSelectedRowCount()==0)
				{
					JOptionPane.showMessageDialog(null, "Please select a row first.");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please select one row at a time.");
				}
			}
		});
		btnNewButton_1.setBounds(260, 250, 89, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Edit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRowCount()==1)
				{
					EditLocalFlight obj=new EditLocalFlight();
					obj.setVisible(true);
					dispose();
					

				}
				else if(table.getSelectedRowCount()==0)
				{
					JOptionPane.showMessageDialog(null, "Please select a row first");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please select one row at a time");
				}
			}
		});
		btnNewButton_2.setBounds(359, 250, 89, 23);
		contentPane.add(btnNewButton_2);
		
		lblNewLabel = new JLabel("Local Flight Schedule");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 680, 17);
		contentPane.add(lblNewLabel);
		
		btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu obj=new Menu();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(458, 250, 89, 23);
		contentPane.add(btnNewButton_3);
		
	}

}
