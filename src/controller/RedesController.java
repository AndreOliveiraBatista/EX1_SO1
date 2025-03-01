package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RedesController {

	public RedesController() {
		super();
	}
	
	private String os() {
		String osName = System.getProperty("os.name");
		return osName;
	}
	
	@SuppressWarnings("deprecation")
	public void ip() {
		String proc = "";
		if(os().contains("Windows")) {
			proc = "IPCONFIG";
			
		}else if(os().contains("Linux")) {
			proc = "ifconfig";
		}
			try {
				Process p = Runtime.getRuntime().exec(proc);
				BufferedReader buffer = new BufferedReader(new InputStreamReader(p.getInputStream()));
				String linha = buffer.readLine();
				while( linha != null) {
					if(linha.contains("Adaptador")) {
						while(linha != "Adaptador") {
							if(linha.contains("Endereço IPV4")) {
								System.out.println(linha);
							}
							linha = buffer.readLine();
						}
						System.out.println(linha);
					}
					linha = buffer.readLine();	
				}
				}catch(Exception e){
				System.err.println(e.getMessage());
			}
	}	
	
	
}

