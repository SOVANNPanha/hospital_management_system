package homeFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RecieptForm {

	private JFrame frame;
	private JLabel p_id;
	private JLabel p_first;
	private JLabel p_last;
	private JLabel p_gender;
	private JLabel p_age ;
	private JLabel p_phone;
	private JLabel p_prix;
	private JLabel r_date;
	private JLabel lblDateout;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecieptForm window = new RecieptForm();
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
	public RecieptForm() {
		initialize();
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(64, 224, 208));
		frame.setBounds(100, 100, 590, 450);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Receipt Form");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(150, 11, 200, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID             :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(150, 67, 75, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		 p_id = new JLabel();
		p_id.setFont(new Font("Tahoma", Font.PLAIN, 14));
		p_id.setBounds(235, 67, 200, 25);
		frame.getContentPane().add(p_id);
		
		 p_first = new JLabel();
		p_first.setFont(new Font("Tahoma", Font.PLAIN, 14));
		p_first.setBounds(235, 103, 75, 25);
		frame.getContentPane().add(p_first);
		
		JLabel lblName = new JLabel("Name       :");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(150, 103, 75, 25);
		frame.getContentPane().add(lblName);
		
		 p_last = new JLabel();
		p_last.setFont(new Font("Tahoma", Font.PLAIN, 14));
		p_last.setBounds(320, 103, 79, 25);
		frame.getContentPane().add(p_last);
		
		 p_gender = new JLabel();
		p_gender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		p_gender.setBounds(235, 139, 168, 25);
		frame.getContentPane().add(p_gender);
		
		JLabel lblGender = new JLabel("Gender     :");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGender.setBounds(150, 139, 75, 25);
		frame.getContentPane().add(lblGender);
		
		JLabel lblAge = new JLabel("Age          :");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAge.setBounds(150, 175, 75, 25);
		frame.getContentPane().add(lblAge);
		
		 p_age = new JLabel();
		p_age.setFont(new Font("Tahoma", Font.PLAIN, 14));
		p_age.setBounds(235, 175, 168, 25);
		frame.getContentPane().add(p_age);
		
		JLabel lblPhone = new JLabel("Phone      :");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPhone.setBounds(150, 211, 75, 25);
		frame.getContentPane().add(lblPhone);
		
		 p_phone = new JLabel();
		p_phone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		p_phone.setBounds(235, 211, 168, 25);
		frame.getContentPane().add(p_phone);
		
		JLabel lblPrix = new JLabel("Prix           :");
		lblPrix.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrix.setBounds(150, 247, 75, 25);
		frame.getContentPane().add(lblPrix);
		
		 p_prix = new JLabel("20 000 riels");
		p_prix.setFont(new Font("Tahoma", Font.PLAIN, 14));
		p_prix.setBounds(235, 247, 168, 25);
		frame.getContentPane().add(p_prix);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getFrame().dispose();
			}
		});
		btnCancel.setForeground(new Color(255, 255, 255));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancel.setBackground(new Color(255, 0, 0));
		btnCancel.setBounds(303, 355, 100, 25);
		frame.getContentPane().add(btnCancel);
		
		JLabel lblDate = new JLabel("Date In     :");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDate.setBounds(150, 283, 85, 25);
		frame.getContentPane().add(lblDate);
		
		 r_date = new JLabel();
		r_date.setFont(new Font("Tahoma", Font.PLAIN, 14));
		r_date.setBounds(235, 283, 168, 25);
		frame.getContentPane().add(r_date);
		
		JLabel lblDateOut = new JLabel("Date out     :");
		lblDateOut.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDateOut.setBounds(150, 319, 85, 25);
		frame.getContentPane().add(lblDateOut);
		
		 lblDateout = new JLabel();
		lblDateout.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDateout.setBounds(235, 319, 168, 25);
		frame.getContentPane().add(lblDateout);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JLabel getP_id() {
		return p_id;
	}

	public void setP_id(JLabel p_id) {
		this.p_id = p_id;
	}

	public JLabel getP_first() {
		return p_first;
	}

	public void setP_first(JLabel p_first) {
		this.p_first = p_first;
	}

	public JLabel getP_last() {
		return p_last;
	}

	public void setP_last(JLabel p_last) {
		this.p_last = p_last;
	}

	public JLabel getP_gender() {
		return p_gender;
	}

	public void setP_gender(JLabel p_gender) {
		this.p_gender = p_gender;
	}

	public JLabel getP_age() {
		return p_age;
	}

	public void setP_age(JLabel p_age) {
		this.p_age = p_age;
	}

	public JLabel getP_phone() {
		return p_phone;
	}

	public void setP_phone(JLabel p_phone) {
		this.p_phone = p_phone;
	}

	public JLabel getP_prix() {
		return p_prix;
	}

	public void setP_prix(JLabel p_prix) {
		this.p_prix = p_prix;
	}

	public JLabel getR_date() {
		return r_date;
	}

	public void setR_date(JLabel r_date) {
		this.r_date = r_date;
	}

	public JLabel getLblDateout() {
		return lblDateout;
	}

	public void setLblDateout(JLabel lblDateout) {
		this.lblDateout = lblDateout;
	}
	
}
