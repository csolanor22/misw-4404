package cars;

public class Car {
	private Motor motor;
	
	public Car(Motor motor) {
		this.motor = motor;
	}
	
	public void printDashboard() {
		System.out.println("--------------------------------");
		System.out.println("DASHBOARD:");
		System.out.println("\t RPM: " + this.motor.rpm);
		System.out.println("\t Speed: " + this.motor.speed);
		System.out.println("\t Oil level: " + this.motor.oilLevel);
		System.out.println("\t Gas level: " + this.motor.gasLevel);
	}
	
	public static void main(String[] args) {
		Motor motor = new Motor();
		Car car = new Car(motor);
		
		car.printDashboard();
		car.motor.accelerate();
		car.printDashboard();
		car.motor.stop();
		car.printDashboard();
	}
}
