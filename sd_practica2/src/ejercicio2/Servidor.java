package ejercicio2;

import java.io.*;
import java.net.*;

public class Servidor {

	public static void main(String[] args) throws IOException {
		AgendaTfno agenditaResulona = new AgendaTfno();		
		try(ServerSocket server = new ServerSocket(6666);){
			while(true) {
				try(Socket cliente = server.accept();
						DataInputStream dis = new DataInputStream(cliente.getInputStream());
						DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());){
						String [] mensaje = dis.readLine().split(" ");
						if(mensaje[0].equals("PUT")) {
							agenditaResulona.añadeTelefono(mensaje[1],mensaje[2]);
							dos.writeChars("OK\n");
							dos.flush();
						}else if(mensaje[0].equals("GET")) {
							String numTfno = agenditaResulona.getTfno(mensaje[1]);
							if(numTfno !=null) {
								dos.writeChars(numTfno+"\n");
								dos.flush();
							}else {
								dos.writeChars("Desconocido\n");
								dos.flush();
							}
						}else {
							dos.writeChars("ERROR\n");
							dos.flush();
						}
				}
					
				
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
