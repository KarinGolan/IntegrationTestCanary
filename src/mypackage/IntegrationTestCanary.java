package mypackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class IntegrationTestCanary {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		BufferedReader in;
		PrintWriter out;
		double total_cost=35.0;
		BufferedWriter output = null ;
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
        
	        if (Double.parseDouble(response) == 41.95) 
	             {
	        	try {
	                File file = new File("\\var\\lib\\jenkins\\workspace\\IntegrationTestCanary\\TestFile");
	                output = new BufferedWriter(new FileWriter(file));
	                output.write("File is created successfully");
	            } catch ( IOException e ) {
	                e.printStackTrace();
	            } finally {
		              if ( output != null ) {
		                output.close();
		              }
	            }	
	        }
	        else 
	        {
	        	try {
	                File file = new File("\\var\\lib\\jenkins\\workspace\\IntegrationTestCanary\\TestFile");
	                output = new BufferedWriter(new FileWriter(file));
	                output.write("Can't create the file");
	            } catch ( IOException e ) {
	                e.printStackTrace();
	            } finally {
		              if ( output != null ) {
		                output.close();
		              }
                }
         
	        }
       
	}}
//internal-backend-ELB-1702404713.eu-west-1.elb.amazonaws.com   
///var/lib/jenkins/workspace/IntegrationTestCanary/TestFile
