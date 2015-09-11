public class Service {
	
	Services type;
	int id;
	boolean hasClient = false;
	boolean hasProvider = false;
	private int clientID = -1;
	private int providerID = -1;
	
	public Service(Services type, int id){
		this.type = type;
		this.id = id;
	}
	
	public Services getService(){
		return type;
	}
	
	public int getID(){
		return id;
	}
	
	public void setClient(){
		hasClient = true;
	}
	
	public boolean getClient(){
		return hasClient;
	}
	
	public void setProvider(){
		hasProvider = true;
	}
	
	public boolean getProvider(){
		return hasProvider;
	}
	
	public boolean satisfied(){
		if(hasClient == true && hasProvider == true){
			return true;
		}
		return false;
	}

	public int getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	public int getProviderID() {
		return providerID;
	}

	public void setProviderID(int providerID) {
		this.providerID = providerID;
	}

}
