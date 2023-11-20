package cars;

public class Motor {
	
	public int speed;
	public int rpm;
	public float oilLevel;
	public float gasLevel;
	
	public Motor() {
		
	}
	
	public void accelerate() {
		this.rpm += 100;
		this.speed += 10;
		this.oilLevel -= 0.1;
		this.gasLevel -= 0.5;
	}
	
	public void stop() {
		this.rpm -= 0;
		this.speed -= 0;
		this.oilLevel -= 0.1;
		this.gasLevel -= 0;
	}

}
