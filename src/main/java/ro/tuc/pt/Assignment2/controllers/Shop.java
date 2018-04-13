package ro.tuc.pt.Assignment2.controllers;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

import ro.tuc.pt.Assignment2.models.ClientGenerator;
import ro.tuc.pt.Assignment2.models.Customer;
import ro.tuc.pt.Assignment2.models.Server;
import ro.tuc.pt.Assignment2.views.View;

public class Shop {

	private View view = new View();
	private ClientGenerator clientGenerator;
	private Timer timer;
	private Timer timer1;
	private TimerTask timerTask;
	private TimerTask timerTask1;
	private Queue<Customer> customersToEnterQueues;
	private List<Server> servers;
	private List<Thread> threads;
	private List<Customer> toRemove;
	private int numberOfServers;
	private int minimumArrivalTime;
	private int maximumArrivalTime;
	private int minimumServiceTime;
	private int maximumServiceTime;
	private int runningTime;
	private long startTime;
	private int peakHour;
	private int mostClients;
	private int nrOfClients;

	public Shop() {
		this.view.setVisible(true);
		customersToEnterQueues = new LinkedList<Customer>();
		servers = new ArrayList<Server>();
		threads = new ArrayList<Thread>();
		toRemove = new ArrayList<Customer>();
		timer = new Timer();
		timer1 = new Timer();
		
		view.actionStart(l -> {
			try {
				this.runningTime = Integer.parseInt(view.getTxtTimpRulare().getText());
				this.numberOfServers = Integer.parseInt(view.getTxtNrQueues().getText());
				this.minimumArrivalTime = Integer.parseInt(view.getTxtArrivalTimeMin().getText());
				this.maximumArrivalTime = Integer.parseInt(view.getTxtArrivalTimeMax().getText());
				this.minimumServiceTime = Integer.parseInt(view.getTxtServireMin().getText());
				this.maximumServiceTime = Integer.parseInt(view.getTxtServireMax().getText());
				this.clientGenerator = new ClientGenerator(this.minimumArrivalTime, this.maximumArrivalTime,
						this.minimumServiceTime, this.maximumServiceTime);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(view, "Introduceti doar numere!");
			}
			this.clearEverything();

			startTime = System.currentTimeMillis();

			for (int i = 0; i < numberOfServers; i++) {
				servers.add(new Server(i + 1, this));
			}

			for (int i = 0; i < numberOfServers; i++) {
				threads.add(new Thread(servers.get(i), "Server " + i));
			}

			defineTaskTimer();
			defineTaskTimer1();
			generateClients();

			for (Customer customer : this.customersToEnterQueues) {
				view.addToQueue("Clienti", customer.getClientName());
			}

			for (Thread thread : this.threads) {
				thread.start();
			}

			this.view.openQueue(numberOfServers);
			this.printLog("Casele au fost deschise!\n");
			startTimer();

		});
	}

	public void startTimer() {
		timer.scheduleAtFixedRate(timerTask, 0, 1000);
		timer1.scheduleAtFixedRate(timerTask1, 0, 1000);
	}

	public int getRunningTime() {
		return runningTime;
	}

	public long getRealTime() {
		return (long) ((System.currentTimeMillis() - startTime) / 1000);
	}

	public Server getBestQueue() {
		Server server;
		float minimumTime = servers.get(0).getWaitingTime();
		server = servers.get(0);
		nrOfClients = 0;
		for (Server s1 : servers) {
			if (minimumTime > s1.getWaitingTime()) {
				minimumTime = s1.getWaitingTime();
				server = s1;
			}
			if (s1.getQueue().isEmpty()) {
				s1.increaseEmptyTime();
			}
			nrOfClients += s1.getQueue().size();
		}

		if (mostClients < nrOfClients) {
			mostClients = nrOfClients;
			peakHour = (int) getRealTime();
		}
		return server;
	}

	public synchronized void addToBestQueue(Customer client) {
		Server server = getBestQueue();

		view.move(client.getClientName(),
				new Point(view.getServerX(server.getName()) + 14, server.getQueue().size() * 14 + 28));

		server.addCustomer(client);

		this.view.addToQueue(server.getName(), client.getClientName());

	}

	public void generateClients() {
		for (int i = 0; i < this.runningTime * 3; i++) {
			Customer customer = clientGenerator.generateClient();
			customersToEnterQueues.add(customer);
		}
	}

	public void printLog(String string) {
		this.view.getTextAreaLog().append(string);
	}

	public void defineTaskTimer1() {
		timerTask1 = new TimerTask() {
			@SuppressWarnings("deprecation")
			public void run() {
				if (getRealTime() <= runningTime) {
					view.refreshTime(Long.toString(getRealTime()));
				}
			}
		};
		
	}

	public void defineTaskTimer() {
		timerTask = new TimerTask() {
			@SuppressWarnings("deprecation")
			public void run() {
				if (getRealTime() <= runningTime) {
					view.refreshTime(Long.toString(getRealTime()));

					Customer cust = customersToEnterQueues.poll();
					try {
						if (cust.getArrivalTime() != 0) {
							Thread.sleep(cust.getArrivalTime() * 1000);
						}
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
					if (getRealTime() <= runningTime) {
						view.removeFromQueue("Clienti");
						addToBestQueue(cust);
					}

				} else {
					for (Thread thread : threads) {
						thread.stop();
					}
					for (Server server : servers) {
						server.shutdown();
					}

					printLog("Casele au fost inchise!\n");
					view.closeAllQueues();
					fillLabels();
					timer.cancel();
					timer.purge();
				}
			}
		};
	}

	public View getView() {
		return this.view;
	}

	public void clearEverything() {
		this.view.clearEveryting();
		customersToEnterQueues = new LinkedList<Customer>();
		servers = new ArrayList<Server>();
		threads = new ArrayList<Thread>();
		toRemove = new ArrayList<Customer>();
		timer = new Timer();
		peakHour = 0;
		mostClients = 0;
	}

	public void fillLabels() {
		this.view.getTxtMostClients().setText(Integer.toString(mostClients));
		this.view.getTxtPeakHour().setText(Integer.toString(peakHour));
		try {
			if (servers.get(0) != null) {
				this.view.getLblETQ1().setText(String.format("%.2f", servers.get(0).getEmptyTime()));
				this.view.getLblSTQ1().setText((String.format("%.2f", servers.get(0).getAvgServiceTime())));
				this.view.getLblWTQ1().setText((String.format("%.2f", servers.get(0).getAvgWaitingTime())));
			}
			if (servers.get(1) != null) {
				this.view.getLblETQ2().setText((String.format("%.2f", servers.get(1).getEmptyTime())));
				this.view.getLblSTQ2().setText((String.format("%.2f", servers.get(1).getAvgServiceTime())));
				this.view.getLblWTQ2().setText((String.format("%.2f", servers.get(1).getAvgWaitingTime())));
			}
			if (servers.get(2) != null) {
				this.view.getLblETQ3().setText((String.format("%.2f", servers.get(2).getEmptyTime())));
				this.view.getLblSTQ3().setText((String.format("%.2f", servers.get(2).getAvgServiceTime())));
				this.view.getLblWTQ3().setText((String.format("%.2f", servers.get(2).getAvgWaitingTime())));

			}
			if (servers.get(3) != null) {
				this.view.getLblETQ4().setText((String.format("%.2f", servers.get(3).getEmptyTime())));
				this.view.getLblSTQ4().setText((String.format("%.2f", servers.get(3).getAvgServiceTime())));
				this.view.getLblWTQ4().setText((String.format("%.2f", servers.get(3).getAvgWaitingTime())));
			}
			if (servers.get(4) != null) {
				this.view.getLblETQ5().setText((String.format("%.2f", servers.get(4).getEmptyTime())));
				this.view.getLblSTQ5().setText((String.format("%.2f", servers.get(4).getAvgServiceTime())));
				this.view.getLblWTQ5().setText((String.format("%.2f", servers.get(4).getAvgWaitingTime())));
			}
		} catch (IndexOutOfBoundsException e) {

		}

		this.view.revalidate();
		this.view.repaint();
	}

}
