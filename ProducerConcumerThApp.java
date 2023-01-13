package concurency;

public class ProducerConcumerThApp {

	public static void main(String[] args) throws InterruptedException {
		System.out.println( Parking.PlaceA);
			
			new ParkTheCar().start(); // Thread 0
			//Thread.sleep(100);
			new Camera().start();;    // Thread 1
			//Thread.sleep(100);
		
		

	}

}
////////////////Recourse/////////////
class Car {
	private String model;
	private String number;

	public Car(String model,String number) {
		
		this.model = model;
		this.number = number;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	//@Override
	//public String toString() {
	//	return "Car [model=" + model + "]";
	//}
	
}

class Parking {
	static Car PlaceA;
}
////////////////Thread/////////////
class ParkTheCar extends Thread {

	@Override
	public void run() {
		Parking.PlaceA = new Car("BMV","XXY 336");
	
	}
	
}

class Camera extends Thread {

	@Override
	public void run() {
		while (Parking.PlaceA == null)  {
			
		}
	shoot();
	}
	
	private void shoot () {
		System.out.println( Parking.PlaceA.getModel());
		System.out.println( Parking.PlaceA.getNumber());
	}
}