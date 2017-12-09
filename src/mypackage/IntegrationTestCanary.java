package mypackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class IntegrationTestCanary {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		BufferedReader in;
		PrintWriter out;
		double total_cost=35.0;
		
		Socket socket = new Socket("internal-backend-ELB-1702404713.eu-west-1.elb.amazonaws.com",6060);
        in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        out.println(total_cost);
        String response;
        try {
            response = in.readLine();
            if (response == null || response.equals("")) {
                  System.exit(0);
              }
        } catch (IOException ex) {
               response = "Error: " + ex;
        }
        System.out.println("The total cost is : "+response);
        
       
        	
        
	}

}
