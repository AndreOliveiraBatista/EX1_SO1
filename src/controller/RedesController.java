package controller;

public class RedesController {

	public RedesController() {
		super();
	}
	
	private String os() {
		String osName = System.getProperty("os.name");
		return osName;
	}
	
	public void ip() {
		if(os().contains("Windows"));
		
	}
}
