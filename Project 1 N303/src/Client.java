import java.util.ArrayList;

public class Client implements Runnable {

	private int id;
	public ArrayList<Service> board;
	private Service service;
	private boolean satisfied = false;
	private boolean first = true;

	public Client(int id, ArrayList<Service> board, Service service) {
		this.id = id;
		this.service = service;
		this.board = board;
	}

	@Override
	public void run() {
		service = new Service(Services.Build, service.id);

		// System.out.println(Thread.currentThread().getName() +
		// "Starting Client Thread: " + name);
		System.out.println("Starting Client Thread: " + id);

		while (!satisfied) {
			post();
		}
		// System.out.println(Thread.currentThread().getName() + " End.");
		System.out.println("Ending Client Thread: " + id);

	}

	private void post() {
		int place = checkBoard();
		System.out.println("Client Thread: " + id + " Checking For: " + service.type
				+ " Returning: " + place);
		if (place >= 0) {
			remove(place);
		}else if(first){
			service.setClient();
			service.setClientID(id);
			board.add(service);
			first = false;
		}
		// try {
		// Thread.sleep(5000);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }

	}

	private void remove(int place) {
		if (board.get(place).type == this.service.type && board.get(place).hasClient == false) {
			//board.remove(place);
			board.get(place).setClient();
			satisfied = true;
		}else{
			System.out.println("Client Thread:" + id + " Was Too Slow");
		}
	}

	private int checkBoard() {
		for (int i = 0; i < board.size(); i++) {
			if (board.get(i).type == this.service.type && board.get(i).hasClient == false) {
				return i;
			}
		}
		return -1;
	}
}
