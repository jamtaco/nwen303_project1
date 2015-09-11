
public class Client implements Runnable{
	
	private String name;

	public Client(String s){
		this.name = s;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "Start. Command = " + name);
		temp();
		System.out.println(Thread.currentThread().getName() + " End.");
	}

	private void temp() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
