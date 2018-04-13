package ro.tuc.pt.Assignment2.models;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

import ro.tuc.pt.Assignment2.controllers.Shop;

public class Server implements Runnable {

	private BlockingQueue<Customer> queue;
	private AtomicInteger waitingTime = new AtomicInteger(0);
	private AtomicInteger serviceTime = new AtomicInteger(0);
	private AtomicInteger emptyTime = new AtomicInteger(0);
	private int numarCasa;
	private AtomicInteger nrClients = new AtomicInteger(0);
	private String name;


	Shop shop;

	private Timer timer;
	private TimerTask timerTask;
	private boolean done;

	public Server(int n, Shop shop) {
		this.queue = new LinkedBlockingQueue<Customer>();
		this.setNumarCasa(n);
		this.name = "Server " + n;
		this.shop = shop;
		this.timer = new Timer();

		done = false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void increaseEmptyTime() {
		emptyTime.getAndAdd(1);
	}

	public synchronized void addCustomer(Customer client) {
		this.shop.printLog(
				"Clientul " + client.getClientNumber() + "(" + client.getArrivalTime() + ", " + client.getServiceTime()
						+ ") a intrat in coada: " + this.getNumarCasa() + " la ora: " + shop.getRealTime() + "\n");
		client.setWaitingTime(getWaitingTime());
		waitingTime.getAndAdd(client.getWaitingTime());
		serviceTime.getAndAdd(client.getServiceTime());
		nrClients.getAndIncrement();

		this.queue.add(client);
		
	}

	public synchronized int getWaitingTime() {
		int waitingTime = 0;
		for (Customer customer : this.queue) {
			waitingTime += customer.getServiceTime();
		}
		return waitingTime;
	}

	public float getAvgWaitingTime() {
		return (float) waitingTime.get() / nrClients.get();
	}

	public float getAvgServiceTime() {
		return (float) serviceTime.get() / nrClients.get();
	}

	public float getEmptyTime() {
		return (float) emptyTime.get();
	}

	public Customer removeFirstCustomer() {
		if (queue.isEmpty()) {
			return null;
		}
		Customer cust = this.queue.remove();

		return cust;
	}

	public Queue<Customer> getQueue() {
		return queue;
	}

	

	public int getNumarCasa() {
		return numarCasa;
	}

	public void setNumarCasa(int numarCasa) {
		this.numarCasa = numarCasa;
	}

	public void startTimer() {
		timer.scheduleAtFixedRate(timerTask, 0, 500);

	}

	public void defineTaskTimer() {
		timerTask = new TimerTask() {
			public void run() {
				if (done == false) {
					if (shop.getRealTime() <= shop.getRunningTime()) {

						Customer c;
						
						while (!queue.isEmpty()) {
							// System.out.println(name + " " + shop.getRealTime() + " <= " +
							// shop.getRunningTime());
							c = queue.peek();
							try {
								Thread.sleep(c.getServiceTime() * 1000);
							} catch (InterruptedException e1) {

								e1.printStackTrace();
							}
							if (shop.getRealTime() <= shop.getRunningTime()) {
								shop.printLog("Clientul " + c.getClientNumber() + "(" + c.getArrivalTime() + ", "
										+ c.getServiceTime() + ") a IESIT din coada: " + getNumarCasa() + " la ora: "
										+ shop.getRealTime() + "\n");
								removeFirstCustomer();
								shop.getView().removeFromQueue(name);
							} else {
								queue.removeAll(queue);
							}
						}
					} else {
						this.cancel();
						timer.cancel();
						timer.purge();
					}
				}
			}
		};
	}

	@Override
	public void run() {
		this.defineTaskTimer();
		this.startTimer();
		
	}

	public void shutdown() {
		done = true;

	}
}
