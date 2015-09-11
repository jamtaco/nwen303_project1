import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class BulletinBoard {
	
	public static ArrayList<Service> board = new ArrayList<Service>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ExecutorService cluster = Executors.newFixedThreadPool(10);
		for(int i = 0; i < 2; i++){
			Runnable work;
			Service service = new Service(Services.getRandomService(),i);
			System.out.println(service.type);
			if(i%2==0){
				work = new Provider(i,board,service);
			}else{
				work = new Client(i,board,service);
			}
			cluster.execute(work);
		}
		cluster.shutdown();
		while(!cluster.isTerminated()){};
		System.out.println("Finished");
		System.out.println(board.size());
	}

}
