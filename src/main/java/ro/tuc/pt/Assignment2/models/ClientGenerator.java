package ro.tuc.pt.Assignment2.models;

public class ClientGenerator {

	private int minimumArrivalTime;
	private int maximumArrivalTime;
	private int minimumServiceTime;
	private int maximumServiceTime;
	private int clientNumber;

	public ClientGenerator(int minA, int maxA, int minS, int maxS) {
		this.maximumArrivalTime = maxA;
		this.minimumArrivalTime = minA;
		this.minimumServiceTime = minS;
		this.maximumServiceTime = maxS;
	}

	public Customer generateClient() {
		int arrivalTime = this.minimumArrivalTime + (int) (Math.random() * (this.maximumArrivalTime - this.minimumArrivalTime));
		int serviceTime = this.minimumServiceTime + (int) (Math.random() * ( this.maximumServiceTime - this.minimumServiceTime));
		clientNumber++;
		return new Customer(clientNumber, arrivalTime, serviceTime);

	}

}
