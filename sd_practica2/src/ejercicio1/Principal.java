package ejercicio1;

import java.net.*;
import java.util.Scanner;
public class Principal {

	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
		System.out.println("Introduce un dominio o una IP: \n" );
		try(Scanner entrada = new Scanner(System.in)){
			String value = entrada.nextLine();
				InetAddress[] address = InetAddress.getAllByName(value);
				if(isIP(value)) {
					System.out.println("Dominio: " + address[0].getHostName());
				}else {
					String ips = "";
					for(int i = 0 ; i < address.length ; i++) {
						ips= ips + "IP"+(i+1)+":"+address[i].getHostAddress()+"\n";
					}
					System.out.println(ips);
				}
			
		}

	}
	
	public static boolean isIP(String cadena) throws NumberFormatException{
			String[] parts = cadena.split("\\.");
			if(parts.length != 4) {
				return false;
			}else {
				int num;
				try {
				for(int i=0 ; i < 4 ; i++) {
					num = Integer.parseInt(parts[i]);
					if(0 > num || 255 < num)	return false;					
				}
				}catch(NumberFormatException ex) {
					return false;
				}
			}
		return true;
	}
}
