package br.com.fiap.conexaoudp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import javax.persistence.EntityManager;
import br.com.fiap.jpa.dao.GenericDaoImpl;
import br.com.fiap.jpa.dao.ProdutoDao;
import br.com.fiap.jpa.dao.ProdutoDaoImpl;
import br.com.fiap.jpa.entity.Produto;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;



public class Servidor {

	public void rodarServidor() throws Exception {
        System.out.println("Servidor iniciado!");
        DatagramSocket socket = new DatagramSocket(5252);

        String mensagem = "";

        while(!mensagem.trim().equalsIgnoreCase("fim")) {
            byte[] buffer = new byte[200];

            DatagramPacket datagram = new DatagramPacket(buffer, 200);
            socket.receive(datagram);

            mensagem = new String(datagram.getData());
            System.out.println(mensagem);
            
            
      
            	 int mensagemInt;
                 String intMensagem;
                 mensagemInt= Integer.parseInt(mensagem.trim());
                 //mensagemInt = Integer.valueOf(mensagem);
                 
        
                 EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
        
                 
                 
                 ProdutoDao daoProd = new ProdutoDaoImpl(em);
                 Produto buscar = daoProd.buscar(mensagemInt);    
                 System.out.println(buscar.mostrar());
                 
                 
   
                 System.out.println(mensagemInt);
                 System.out.println("Endereço: " + datagram.getSocketAddress());
 
                 
                 
			
            
//            int mensagemInt;
//            String intMensagem;
//            mensagemInt= Integer.parseInt(mensagem);
//            mensagemInt = Integer.valueOf(mensagem);
//            
            
          
        }
    }

    public static void main(String[] args) {
        try {
            Servidor servidor = new Servidor ();
            servidor.rodarServidor();
        } catch(Exception e){
            e.printStackTrace();
        }
    } 
	
}
