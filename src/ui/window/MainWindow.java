package ui.window;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	String sorgu;
	DefaultTableModel modelim=new DefaultTableModel();
	Object[] kolonlar= {"ID NO", "Ad", "Soyad"};
	Object[] satirlar= new Object[4];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 721, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 36, 644, 351);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		veritabanı.baglan();
		
		sorgu = "select * from employees";
		modelim.setColumnCount(0);
		modelim.setRowCount(0);
		modelim.setColumnIdentifiers(kolonlar);
		ResultSet rs = veritabanı.listele(sorgu);
		
		try {
			while (rs.next()) {
				satirlar[0]=rs.getString("empid");
				satirlar[1]=rs.getString("empname");
				satirlar[2]=rs.getString("surname");
				satirlar[3]=rs.getString("hire_date");
				modelim.addRow(satirlar);
				
			}
			table.setModel(modelim);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

