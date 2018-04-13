package ro.tuc.pt.Assignment2.views;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import java.awt.SystemColor;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Point;

public class View extends JFrame {

	private JPanel contentPane;
	private JTextField txtNrQueues;
	private JTextField txtTimpRulare;
	private JTextField txtServireMin;
	private JTextField txtServireMax;
	private JTextField txtArrivalTimeMin;
	private JTextField txtArrivalTimeMax;
	private JPanel panelInput;
	private JPanel panelOutput;
	private JButton btnStart;
	private JPanel panelServers;
	private JPanel panelServer3;
	private JPanel panelServer4;
	private JPanel panelServer5;
	private JPanel panelServer2;
	private JPanel panelSosireClienti;
	private JTextArea textAreaLog;
	private JPanel panelServer1;
	private JPanel panelLog;
	private JLabel lblServer3;
	private JLabel lblServer1;
	private JLabel lblServer2;
	private JLabel lblServer4;
	private JLabel lblServer5;
	private JPanel panelInnerOutPut;
	private JLabel lblQueue;
	private JLabel lblQueue_1;
	private JLabel lblQueue_2;
	private JLabel lblQueue_3;
	private JLabel lblQueue_4;
	private JLabel lblPeekHour;
	private JTextField txtPeakHour;
	private JLabel lblMaximumNoCustomers;
	private JTextField txtMostClients;
	public JTextField getTxtPeakHour() {
		return txtPeakHour;
	}

	public JTextField getTxtMostClients() {
		return txtMostClients;
	}

	private JLabel lblWTQ1;
	private JLabel lblWTQ2;
	private JLabel lblWTQ3;
	private JLabel lblWTQ4;
	private JLabel lblWTQ5;
	private JLabel lblSTQ1;
	private JLabel lblSTQ2;
	private JLabel lblSTQ3;
	private JLabel lblSTQ4;
	private JLabel lblSTQ5;
	private JLabel lblETQ1;
	private JLabel lblETQ2;
	private JLabel lblETQ3;
	private JLabel lblETQ4;
	private JLabel lblETQ5;
	private JScrollPane scrollPane;
	private JTextField txtTime;

	public View() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 624);
		contentPane = new JPanel();
		panelInput = new JPanel();
		panelLog = new JPanel();
		panelOutput = new JPanel();
		panelServers = new JPanel();
		panelServer1 = new JPanel();
		panelServer2 = new JPanel();
		panelServer3 = new JPanel();
		panelServer4 = new JPanel();
		panelServer5 = new JPanel();
		JLabel lblNumarCozi = new JLabel("Number of queues:");
		JLabel lblTimpRulare = new JLabel("Runtime:");
		JLabel lblTimpDeServire = new JLabel("Min service:");
		JLabel lblTimpMaxim = new JLabel("Max service:");
		JLabel lblArrivalTime = new JLabel("Min arrival time:");
		JLabel lblArrivalTime2 = new JLabel("Max arrival time:");
		lblServer3 = new JLabel("Server 3");
		lblServer5 = new JLabel("Server 5");
		lblServer4 = new JLabel("Server 4");
		lblServer2 = new JLabel("Server 2");
		lblServer1 = new JLabel("Server 1");
		lblServer1.setBackground(Color.RED);
		lblServer2.setBackground(Color.RED);
		lblServer3.setBackground(Color.RED);
		lblServer4.setBackground(Color.RED);
		lblServer5.setBackground(Color.RED);

		// this.paintComponent();
		lblServer1.setOpaque(true);
		lblServer2.setOpaque(true);
		lblServer3.setOpaque(true);
		lblServer4.setOpaque(true);
		lblServer5.setOpaque(true);
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelInput.setBounds(29, 11, 177, 198);
		contentPane.add(panelInput);
		panelInput.setLayout(null);

		lblNumarCozi.setBounds(10, 11, 107, 14);
		panelInput.add(lblNumarCozi);

		txtNrQueues = new JTextField();
		txtNrQueues.setBounds(120, 8, 50, 20);
		panelInput.add(txtNrQueues);
		txtNrQueues.setColumns(10);

		lblTimpRulare.setBounds(10, 36, 107, 14);
		panelInput.add(lblTimpRulare);

		lblTimpDeServire.setBounds(10, 61, 107, 14);
		panelInput.add(lblTimpDeServire);

		lblTimpMaxim.setBounds(10, 86, 107, 14);
		panelInput.add(lblTimpMaxim);

		lblArrivalTime.setBounds(10, 111, 107, 14);
		panelInput.add(lblArrivalTime);

		lblArrivalTime2.setBounds(10, 138, 107, 14);
		panelInput.add(lblArrivalTime2);

		txtTimpRulare = new JTextField();
		txtTimpRulare.setBounds(120, 33, 50, 20);
		panelInput.add(txtTimpRulare);
		txtTimpRulare.setColumns(10);

		txtServireMin = new JTextField();
		txtServireMin.setBounds(120, 58, 50, 20);
		panelInput.add(txtServireMin);
		txtServireMin.setColumns(10);

		txtServireMax = new JTextField();
		txtServireMax.setBounds(120, 83, 50, 20);
		panelInput.add(txtServireMax);
		txtServireMax.setColumns(10);

		txtArrivalTimeMin = new JTextField();
		txtArrivalTimeMin.setBounds(120, 108, 50, 20);
		panelInput.add(txtArrivalTimeMin);
		txtArrivalTimeMin.setColumns(10);

		txtArrivalTimeMax = new JTextField();
		txtArrivalTimeMax.setBounds(120, 135, 50, 20);
		panelInput.add(txtArrivalTimeMax);
		txtArrivalTimeMax.setColumns(10);

		btnStart = new JButton("Start");
		btnStart.setBounds(40, 171, 89, 23);
		panelInput.add(btnStart);

		panelOutput.setBounds(216, 11, 368, 198);
		contentPane.add(panelOutput);
		panelOutput.setLayout(null);

		panelInnerOutPut = new JPanel();
		panelInnerOutPut.setBounds(10, 27, 348, 82);
		panelOutput.add(panelInnerOutPut);
		GridBagLayout gbl_panelInnerOutPut = new GridBagLayout();
		gbl_panelInnerOutPut.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_panelInnerOutPut.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_panelInnerOutPut.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelInnerOutPut.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelInnerOutPut.setLayout(gbl_panelInnerOutPut);

		lblQueue = new JLabel("Queue 1");
		GridBagConstraints gbc_lblQueue = new GridBagConstraints();
		gbc_lblQueue.insets = new Insets(0, 0, 5, 5);
		gbc_lblQueue.gridx = 1;
		gbc_lblQueue.gridy = 0;
		panelInnerOutPut.add(lblQueue, gbc_lblQueue);

		lblQueue_1 = new JLabel("Queue 2");
		GridBagConstraints gbc_lblQueue_1 = new GridBagConstraints();
		gbc_lblQueue_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblQueue_1.gridx = 2;
		gbc_lblQueue_1.gridy = 0;
		panelInnerOutPut.add(lblQueue_1, gbc_lblQueue_1);

		lblQueue_2 = new JLabel("Queue 3");
		GridBagConstraints gbc_lblQueue_2 = new GridBagConstraints();
		gbc_lblQueue_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblQueue_2.gridx = 3;
		gbc_lblQueue_2.gridy = 0;
		panelInnerOutPut.add(lblQueue_2, gbc_lblQueue_2);

		lblQueue_3 = new JLabel("Queue 4");
		GridBagConstraints gbc_lblQueue_3 = new GridBagConstraints();
		gbc_lblQueue_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblQueue_3.gridx = 4;
		gbc_lblQueue_3.gridy = 0;
		panelInnerOutPut.add(lblQueue_3, gbc_lblQueue_3);

		lblQueue_4 = new JLabel("Queue 5");
		GridBagConstraints gbc_lblQueue_4 = new GridBagConstraints();
		gbc_lblQueue_4.insets = new Insets(0, 0, 5, 0);
		gbc_lblQueue_4.gridx = 5;
		gbc_lblQueue_4.gridy = 0;
		panelInnerOutPut.add(lblQueue_4, gbc_lblQueue_4);

		JLabel lblWaitingTime = new JLabel("Waiting time:");
		GridBagConstraints gbc_lblWaitingTime = new GridBagConstraints();
		gbc_lblWaitingTime.insets = new Insets(0, 0, 5, 5);
		gbc_lblWaitingTime.gridx = 0;
		gbc_lblWaitingTime.gridy = 1;
		panelInnerOutPut.add(lblWaitingTime, gbc_lblWaitingTime);

		lblWTQ1 = new JLabel("");
		GridBagConstraints gbc_lblWTQ1 = new GridBagConstraints();
		gbc_lblWTQ1.insets = new Insets(0, 0, 5, 5);
		gbc_lblWTQ1.gridx = 1;
		gbc_lblWTQ1.gridy = 1;
		panelInnerOutPut.add(lblWTQ1, gbc_lblWTQ1);

		lblWTQ2 = new JLabel("");
		GridBagConstraints gbc_lblWTQ2 = new GridBagConstraints();
		gbc_lblWTQ2.insets = new Insets(0, 0, 5, 5);
		gbc_lblWTQ2.gridx = 2;
		gbc_lblWTQ2.gridy = 1;
		panelInnerOutPut.add(lblWTQ2, gbc_lblWTQ2);

		lblWTQ3 = new JLabel("");
		GridBagConstraints gbc_lblWTQ3 = new GridBagConstraints();
		gbc_lblWTQ3.insets = new Insets(0, 0, 5, 5);
		gbc_lblWTQ3.gridx = 3;
		gbc_lblWTQ3.gridy = 1;
		panelInnerOutPut.add(lblWTQ3, gbc_lblWTQ3);

		lblWTQ4 = new JLabel("");
		GridBagConstraints gbc_lblWTQ4 = new GridBagConstraints();
		gbc_lblWTQ4.insets = new Insets(0, 0, 5, 5);
		gbc_lblWTQ4.gridx = 4;
		gbc_lblWTQ4.gridy = 1;
		panelInnerOutPut.add(lblWTQ4, gbc_lblWTQ4);

		lblWTQ5 = new JLabel("");
		GridBagConstraints gbc_lblWTQ5 = new GridBagConstraints();
		gbc_lblWTQ5.insets = new Insets(0, 0, 5, 0);
		gbc_lblWTQ5.gridx = 5;
		gbc_lblWTQ5.gridy = 1;
		panelInnerOutPut.add(lblWTQ5, gbc_lblWTQ5);

		JLabel lblServiceTime = new JLabel("Service time:");
		GridBagConstraints gbc_lblServiceTime = new GridBagConstraints();
		gbc_lblServiceTime.insets = new Insets(0, 0, 5, 5);
		gbc_lblServiceTime.gridx = 0;
		gbc_lblServiceTime.gridy = 2;
		panelInnerOutPut.add(lblServiceTime, gbc_lblServiceTime);

		lblSTQ1 = new JLabel("");
		GridBagConstraints gbc_lblSTQ1 = new GridBagConstraints();
		gbc_lblSTQ1.insets = new Insets(0, 0, 5, 5);
		gbc_lblSTQ1.gridx = 1;
		gbc_lblSTQ1.gridy = 2;
		panelInnerOutPut.add(lblSTQ1, gbc_lblSTQ1);

		lblSTQ2 = new JLabel("");
		GridBagConstraints gbc_lblSTQ2 = new GridBagConstraints();
		gbc_lblSTQ2.insets = new Insets(0, 0, 5, 5);
		gbc_lblSTQ2.gridx = 2;
		gbc_lblSTQ2.gridy = 2;
		panelInnerOutPut.add(lblSTQ2, gbc_lblSTQ2);

		lblSTQ3 = new JLabel("");
		GridBagConstraints gbc_lblSTQ3 = new GridBagConstraints();
		gbc_lblSTQ3.insets = new Insets(0, 0, 5, 5);
		gbc_lblSTQ3.gridx = 3;
		gbc_lblSTQ3.gridy = 2;
		panelInnerOutPut.add(lblSTQ3, gbc_lblSTQ3);

		lblSTQ4 = new JLabel("");
		GridBagConstraints gbc_lblSTQ4 = new GridBagConstraints();
		gbc_lblSTQ4.insets = new Insets(0, 0, 5, 5);
		gbc_lblSTQ4.gridx = 4;
		gbc_lblSTQ4.gridy = 2;
		panelInnerOutPut.add(lblSTQ4, gbc_lblSTQ4);

		lblSTQ5 = new JLabel("");
		GridBagConstraints gbc_lblSTQ5 = new GridBagConstraints();
		gbc_lblSTQ5.insets = new Insets(0, 0, 5, 0);
		gbc_lblSTQ5.gridx = 5;
		gbc_lblSTQ5.gridy = 2;
		panelInnerOutPut.add(lblSTQ5, gbc_lblSTQ5);

		JLabel lblEmptyQueue = new JLabel("Empty time:");
		GridBagConstraints gbc_lblEmptyQueue = new GridBagConstraints();
		gbc_lblEmptyQueue.insets = new Insets(0, 0, 0, 5);
		gbc_lblEmptyQueue.gridx = 0;
		gbc_lblEmptyQueue.gridy = 3;
		panelInnerOutPut.add(lblEmptyQueue, gbc_lblEmptyQueue);

		lblETQ1 = new JLabel("");
		GridBagConstraints gbc_lblETQ1 = new GridBagConstraints();
		gbc_lblETQ1.insets = new Insets(0, 0, 0, 5);
		gbc_lblETQ1.gridx = 1;
		gbc_lblETQ1.gridy = 3;
		panelInnerOutPut.add(lblETQ1, gbc_lblETQ1);

		lblETQ2 = new JLabel("");
		GridBagConstraints gbc_lblETQ2 = new GridBagConstraints();
		gbc_lblETQ2.insets = new Insets(0, 0, 0, 5);
		gbc_lblETQ2.gridx = 2;
		gbc_lblETQ2.gridy = 3;
		panelInnerOutPut.add(lblETQ2, gbc_lblETQ2);

		lblETQ3 = new JLabel("");
		GridBagConstraints gbc_lblETQ3 = new GridBagConstraints();
		gbc_lblETQ3.insets = new Insets(0, 0, 0, 5);
		gbc_lblETQ3.gridx = 3;
		gbc_lblETQ3.gridy = 3;
		panelInnerOutPut.add(lblETQ3, gbc_lblETQ3);

		lblETQ4 = new JLabel("");
		GridBagConstraints gbc_lblETQ4 = new GridBagConstraints();
		gbc_lblETQ4.insets = new Insets(0, 0, 0, 5);
		gbc_lblETQ4.gridx = 4;
		gbc_lblETQ4.gridy = 3;
		panelInnerOutPut.add(lblETQ4, gbc_lblETQ4);

		lblETQ5 = new JLabel("");
		GridBagConstraints gbc_lblETQ5 = new GridBagConstraints();
		gbc_lblETQ5.gridx = 5;
		gbc_lblETQ5.gridy = 3;
		panelInnerOutPut.add(lblETQ5, gbc_lblETQ5);

		lblPeekHour = new JLabel("Peek hour:");
		lblPeekHour.setBounds(10, 138, 70, 14);
		panelOutput.add(lblPeekHour);

		txtPeakHour = new JTextField();
		txtPeakHour.setEditable(false);
		txtPeakHour.setBounds(79, 135, 50, 20);
		panelOutput.add(txtPeakHour);
		txtPeakHour.setColumns(10);

		lblMaximumNoCustomers = new JLabel("Maximum no. customers:");
		lblMaximumNoCustomers.setBounds(138, 138, 148, 14);
		panelOutput.add(lblMaximumNoCustomers);

		txtMostClients = new JTextField();
		txtMostClients.setEditable(false);
		txtMostClients.setBounds(285, 135, 50, 20);
		panelOutput.add(txtMostClients);
		txtMostClients.setColumns(10);
		
		txtTime = new JTextField();
		txtTime.setEditable(false);
		txtTime.setHorizontalAlignment(SwingConstants.CENTER);
		txtTime.setText("Time: ");
		txtTime.setBounds(148, 171, 86, 20);
		panelOutput.add(txtTime);
		txtTime.setColumns(10);

		BufferedImage img = null;
		/*
		 * try { img = ImageIO.read(new
		 * File("E:\\PT2018\\pt2018_30224_bilc_sergiu_assignment_2\\468442-200.png"));
		 * 
		 * } catch (IOException e) { e.printStackTrace(); }
		 */

		panelServers.setBounds(29, 402, 555, 172);
		contentPane.add(panelServers);
		panelServers.setLayout(null);
		panelSosireClienti = new JPanel();

		panelSosireClienti.setBounds(0, 11, 67, 161);
		panelSosireClienti.setBackground(UIManager.getColor("Button.background"));
		panelSosireClienti.setLayout((new BoxLayout(this.panelSosireClienti, BoxLayout.Y_AXIS)));
		panelServers.add(panelSosireClienti);

		panelServer3.setBounds(266, 0, 75, 189);
		panelServer3.setBackground(UIManager.getColor("Button.background"));

		panelServer3.setLayout(new BoxLayout(this.panelServer3, BoxLayout.Y_AXIS));
		panelServers.add(panelServer3);

		lblServer3.setAlignmentX(CENTER_ALIGNMENT);
		panelServer3.add(lblServer3);

		panelServer4.setBounds(350, 0, 75, 189);
		panelServer4.setBackground(UIManager.getColor("Button.background"));

		panelServer4.setLayout(new BoxLayout(this.panelServer4, BoxLayout.Y_AXIS));
		panelServers.add(panelServer4);

		lblServer4.setAlignmentX(CENTER_ALIGNMENT);
		panelServer4.add(lblServer4);

		panelServer5.setBounds(436, 0, 75, 189);
		panelServer5.setBackground(UIManager.getColor("Button.background"));

		panelServer5.setLayout(new BoxLayout(this.panelServer5, BoxLayout.Y_AXIS));
		panelServers.add(panelServer5);

		lblServer5.setAlignmentX(CENTER_ALIGNMENT);
		panelServer5.add(lblServer5);

		panelServer2.setBounds(180, 0, 75, 189);
		panelServer2.setBackground(UIManager.getColor("Button.background"));

		panelServer2.setLayout(new BoxLayout(this.panelServer2, BoxLayout.Y_AXIS));
		panelServers.add(panelServer2);

		lblServer2.setAlignmentX(CENTER_ALIGNMENT);
		panelServer2.add(lblServer2);

		panelServer1.setLayout(new BoxLayout(this.panelServer1, BoxLayout.Y_AXIS));
		panelServer1.setBackground(SystemColor.menu);
		panelServer1.setBounds(96, 0, 75, 189);
		panelServers.add(panelServer1);

		lblServer1.setAlignmentX(CENTER_ALIGNMENT);
		panelServer1.add(lblServer1);

		panelLog.setBounds(29, 219, 555, 172);
		contentPane.add(panelLog);
		panelLog.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 552, 164);
		panelLog.add(scrollPane);

		textAreaLog = new JTextArea();
		scrollPane.setViewportView(textAreaLog);
		this.panelServer1.setOpaque(false);
		this.panelServer2.setOpaque(false);
		this.panelServer3.setOpaque(false);
		this.panelServer4.setOpaque(false);
		this.panelServer5.setOpaque(false);

	}

	public void openQueue(int numberOfQueues) {
		switch (numberOfQueues) {
		case 1:
			lblServer1.setBackground(Color.GREEN);
			break;
		case 2:
			lblServer1.setBackground(Color.GREEN);
			lblServer2.setBackground(Color.GREEN);
			break;
		case 3:
			lblServer1.setBackground(Color.GREEN);
			lblServer2.setBackground(Color.GREEN);
			lblServer3.setBackground(Color.GREEN);
			break;
		case 4:
			lblServer1.setBackground(Color.GREEN);
			lblServer2.setBackground(Color.GREEN);
			lblServer3.setBackground(Color.GREEN);
			lblServer4.setBackground(Color.GREEN);
			break;
		case 5:
			lblServer1.setBackground(Color.GREEN);
			lblServer2.setBackground(Color.GREEN);
			lblServer3.setBackground(Color.GREEN);
			lblServer4.setBackground(Color.GREEN);
			lblServer5.setBackground(Color.GREEN);
			break;
		}

		this.revalidate();
		this.repaint();
	}

	public void closeAllQueues() {
		lblServer1.setBackground(Color.RED);
		lblServer2.setBackground(Color.RED);
		lblServer3.setBackground(Color.RED);
		lblServer4.setBackground(Color.RED);
		lblServer5.setBackground(Color.RED);
	}

	public void addToQueue(String server, String client) {
		JLabel lbl = new JLabel(client);

		lbl.setAlignmentX(CENTER_ALIGNMENT);

		switch (server) {
		case "Clienti":
			this.panelSosireClienti.add(Box.createRigidArea(new Dimension(15, 0)));
			this.panelSosireClienti.add(lbl);
			// System.out.println(lbl.getLocation().x);
			break;
		case "Server 1":
			this.panelServer1.add(Box.createRigidArea(new Dimension(15, 0)));
			this.panelServer1.add(lbl);
			break;
		case "Server 2":
			this.panelServer2.add(Box.createRigidArea(new Dimension(15, 0)));
			this.panelServer2.add(lbl);
			break;
		case "Server 3":
			this.panelServer3.add(Box.createRigidArea(new Dimension(15, 0)));
			this.panelServer3.add(lbl);
			break;
		case "Server 4":
			this.panelServer4.add(Box.createRigidArea(new Dimension(15, 0)));
			this.panelServer4.add(lbl);
			break;
		case "Server 5":
			this.panelServer5.add(Box.createRigidArea(new Dimension(15, 0)));
			this.panelServer5.add(lbl);
			break;
		}

		this.revalidate();
		this.repaint();
	}


	public int getServerX(String server) {

		switch (server) {
		case "Clienti":
			return this.panelSosireClienti.getX();
		case "Server 1":
			return this.panelServer1.getX();
		case "Server 2":
			return this.panelServer2.getX();
		case "Server 3":
			return this.panelServer3.getX();
		case "Server 4":
			return this.panelServer4.getX();
		case "Server 5":
			return this.panelServer5.getX();
		default:
			return 0;
		}
	}

	public void removeFromQueue(String server) {

		switch (server) {
		case "Clienti":
			this.panelSosireClienti.remove(0);
			this.panelSosireClienti.remove(0);
			break;
		case "Server 1":
			this.panelServer1.remove(1);
			this.panelServer1.remove(1);
			break;
		case "Server 2":
			this.panelServer2.remove(1);
			this.panelServer2.remove(1);
			break;
		case "Server 3":
			this.panelServer3.remove(1);
			this.panelServer3.remove(1);
			break;
		case "Server 4":
			this.panelServer4.remove(1);
			this.panelServer4.remove(1);
			break;
		case "Server 5":
			this.panelServer5.remove(1);
			this.panelServer5.remove(1);
			break;
		}

		this.revalidate();
		this.repaint();
	}
	
	public void clearEveryting() {
		this.textAreaLog.setText("");
		panelServer1.removeAll();
		panelServer1.add(lblServer1);
		panelServer2.removeAll();
		panelServer2.add(lblServer2);
		panelServer3.removeAll();
		panelServer3.add(lblServer3);
		panelServer4.removeAll();
		panelServer4.add(lblServer4);
		panelServer5.removeAll();
		panelServer5.add(lblServer5);
		
		this.revalidate();
		this.repaint();
	}

	public void move(String client, Point finish) {

		new Thread(new Runnable() {
			JLabel lbl = new JLabel(client);
			Point aux = lbl.getLocation();
			int velX = 2;
			int velY = 1;

			@Override
			public void run() {
				lbl.setBounds(getServerX("Clienti"), 22, 46, 14);
				panelServers.add(lbl);
				if (finish.x >= 150) {
					velX = 4;
				}
				if (finish.x >= 300) {
					velX = 6;
				}
				if (finish.x >= 400) {
					velX = 8;
				}
				if (finish.x >= 500) {
					velX = 9;
				}
				while (true) {
					while (aux.x != finish.x) {
						if (aux.x > finish.x) {
							break;
						}
						aux.x += velX;
						aux.y += velY;

						lbl.setLocation(aux);
						try {
							Thread.sleep(5);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						repaint();

					}

					if (aux.y >= finish.y) {
						velY = -velY;
					}
					while (aux.y != finish.y) {
						aux.y += velY;
						lbl.setLocation(aux);

						try {
							Thread.sleep(5);
						} catch (InterruptedException e) {

							e.printStackTrace();
						}
						repaint();
					}

					if (aux.y == finish.y && aux.x >= finish.x) {

						lbl.setVisible(false);
						panelServers.remove(lbl);
						repaint();
						break;
					}
				}

			}

		}).start();
	}

	public void refreshTime(String time) {
		this.txtTime.setText("Time: " + time);
		this.revalidate();
		this.repaint();
	}

	public JTextArea getTextAreaLog() {
		return textAreaLog;
	}

	public void setTextAreaLog(JTextArea textAreaLog) {
		this.textAreaLog = textAreaLog;
	}

	public JTextField getTxtNrQueues() {
		return txtNrQueues;
	}

	public void setTxtNrQueues(JTextField txtNrQueues) {
		this.txtNrQueues = txtNrQueues;
	}

	public JTextField getTxtTimpRulare() {
		return txtTimpRulare;
	}

	public void setTxtTimpRulare(JTextField txtTimpRulare) {
		this.txtTimpRulare = txtTimpRulare;
	}

	public JTextField getTxtServireMin() {
		return txtServireMin;
	}

	public void setTxtServireMin(JTextField txtServireMin) {
		this.txtServireMin = txtServireMin;
	}

	public JTextField getTxtServireMax() {
		return txtServireMax;
	}

	public void setTxtServireMax(JTextField txtServireMax) {
		this.txtServireMax = txtServireMax;
	}

	public JTextField getTxtArrivalTimeMin() {
		return txtArrivalTimeMin;
	}

	public void setTxtArrivalTimeMin(JTextField txtArrivalTimeMin) {
		this.txtArrivalTimeMin = txtArrivalTimeMin;
	}

	public JTextField getTxtArrivalTimeMax() {
		return txtArrivalTimeMax;
	}

	public JLabel getLblWTQ1() {
		return lblWTQ1;
	}

	public JLabel getLblWTQ2() {
		return lblWTQ2;
	}

	public JLabel getLblWTQ3() {
		return lblWTQ3;
	}

	public JLabel getLblWTQ4() {
		return lblWTQ4;
	}

	public JLabel getLblWTQ5() {
		return lblWTQ5;
	}

	public JLabel getLblSTQ1() {
		return lblSTQ1;
	}

	public JLabel getLblSTQ2() {
		return lblSTQ2;
	}

	public JLabel getLblSTQ3() {
		return lblSTQ3;
	}

	public JLabel getLblSTQ4() {
		return lblSTQ4;
	}

	public JLabel getLblSTQ5() {
		return lblSTQ5;
	}

	public JLabel getLblETQ1() {
		return lblETQ1;
	}

	public JLabel getLblETQ2() {
		return lblETQ2;
	}

	public JLabel getLblETQ3() {
		return lblETQ3;
	}

	public JLabel getLblETQ4() {
		return lblETQ4;
	}

	public JLabel getLblETQ5() {
		return lblETQ5;
	}

	public void setTxtArrivalTimeMax(JTextField txtArrivalTimeMax) {
		this.txtArrivalTimeMax = txtArrivalTimeMax;
	}

	public void actionStart(ActionListener l) {
		this.btnStart.addActionListener(l);
	}
}
