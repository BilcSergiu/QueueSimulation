package ro.tuc.pt.Assignment2.models;

public class Customer implements Comparable<Customer>{

	private int clientNumber;
	private String clientName;
	

	private int arrivalTime;
	private int serviceTime;
	private int waitingTime;
	private int leavingTime;
	
	
	public Customer(int number,int arrivalTime, int serviceTime) {
		this.arrivalTime = arrivalTime;
		this.serviceTime = serviceTime;
		this.clientNumber = number;
		this.clientName = "Client "+number;
	}
	
	
	public String printCustomer() {
		String print = "";
		print ="Client: "+this.clientNumber+" with the arrival time: " +Integer.toString(this.arrivalTime)+"  Service time: "+ Integer.toString(this.serviceTime);
		return print;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	
	public int getClientNumber() {
		return clientNumber;
	}

	public void setClientNumber(int clientNumber) {
		this.clientNumber = clientNumber;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(int serviceTime) {
		this.serviceTime = serviceTime;
	}

	public int getWaitingTime() {
		return waitingTime;
	}

	public void setWaitingTime(int waitingTime) {
		this.waitingTime = waitingTime;
	}

	public int getLeavingTime() {
		return leavingTime;
	}

	public void setLeavingTime(int leavingTime) {
		this.leavingTime = leavingTime;
	}

	@Override
	public int compareTo(Customer arg0) {
		// TODO Auto-generated method stub
		return this.arrivalTime - arg0.arrivalTime;
	};
	
}
