import java.util.ArrayList;


public class Provider implements Runnable{
	
	private int id;
	public ArrayList<Service> board;
	private Service service;

	public Provider(int id, ArrayList<Service> board, Service service){
		this.id = id;
		this.board = board;
		this.service = service;
	}
	
	@Override
	public void run() {
		//System.out.println(Thread.currentThread().getName() + "Starting Provider Thread: " + name);
		System.out.println("Starting Provider Thread: " + id);
		post();
		//System.out.println(Thread.currentThread().getName() + " End.");
		System.out.println("Ending Provider Thread: " + id);

	}

	private void post() {
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		Service s = new Service(Services.Build,service.id);
		board.add(s);
		System.out.println("Provider Thread: " + id + " Added: " + s.type);
	}

}