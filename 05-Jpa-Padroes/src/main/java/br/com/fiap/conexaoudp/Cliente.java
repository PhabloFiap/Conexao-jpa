package br.com.fiap.conexaoudp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;



public class Cliente {

	
	public void comunicarServidor() throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("localhost");
        int port = 5252;

        String texto = "";
        Scanner entrada = new Scanner(System.in);

        while (!texto.trim().equalsIgnoreCase("fim")) {
            System.out.println("Digite o id: ");
            texto = entrada.nextLine();
            byte saida[];
            saida = texto.getBytes();
            
            DatagramPacket datagram = new DatagramPacket(saida, saida.length, address, port);
            // connect() method
            socket.connect(address, port);

            // send() method
            socket.send(datagram);
            System.out.println("Pacote enviado...");
        }
    }

    public static void main(String[] args) {
        try {
            Cliente cliente = new Cliente();
            cliente.comunicarServidor();
        } catch(Exception e){
            e.printStackTrace();
        }
    } 
}
