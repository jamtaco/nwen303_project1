import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService clients = Executors.newFixedThreadPool(5);
		ExecutorService providers = Executors.newFixedThreadPool(5);
		for(int i = 0; i < 100; i++){
			Runnable work = new Client("Thread : " + i);
			if(i%2==0){
				providers.execute(work);
			}
			clients.execute(work);
		}
		clients.shutdown();
		providers.shutdown();
		while(!clients.isTerminated() && !providers.isTerminated()){};
		System.out.println("Finished");
	}

}
