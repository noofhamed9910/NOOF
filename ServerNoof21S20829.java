import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ServerNoof21S20829 implements Runnable
{
    public void run()
            
    {
        try{
            
            //connect the server to the databases
            
            String Nhost="jdbc:derby://localhost:1527/noofhamed11";

            String Nuname="noof11";

            String Npass="09876";

           
            
            Connection NOOFconne=DriverManager.getConnection(Nhost, Nuname, Npass);
            
            
          //defining the server and port and client connection
            ServerSocket Noofserver = new ServerSocket (5772);

            System.out.println("Server is RUN..... ");

           
            //lube to solve the problem
             while(true){

                
                Socket NOOFSoc = Noofserver.accept();

 

 
                   //Connect the server socket to the client socket
                DataInputStream NOOFFdis = new DataInputStream(NOOFSoc.getInputStream());

                int NOOFCode = NOOFFdis.readInt();

                int NQequired = NOOFFdis.readInt();

               
                    //Print code and quantity
                 
                    System.out.println("The code is:"+NOOFCode);

                    System.out.println("The Qequired is"+NQequired);

             
                    //Open Statement
                 Statement NOOFST=NOOFconne.createStatement();
                 
                 //Fetch the table and check the code
            String NTable="SELECT * FROM UNTITLED WHERE BEVERAGECODE="+NOOFCode;
                //It is called the Result Set
            ResultSet Nrs=NOOFST.executeQuery(NTable);

           
                //Write the required letter and send it to the client via Loeb
                
            DataOutputStream NOOFFdos = new DataOutputStream(NOOFSoc.getOutputStream());

                while(Nrs.next()){

                   
                    //Get the name from the data
                    String NOOFname=Nrs.getString("BEVERAGENAME");

                   

                    

                            
                    //Fetch the price and make the equation satisfied
                    double NOOPRI=Nrs.getDouble("PRICE");

                    double NOOFprice= NQequired*NOOPRI;

                   

                    
                    
                    NOOFFdos.writeUTF(NOOFname);

                    NOOFFdos.writeDouble(NOOFprice);

                    System.out.println("Send to the cliet");

                    

                } 

                }

 

             }
             //  finish
             catch(SQLException e)

           

                        {

                        System.out.println(e);

                        }
        
                catch (IOException ex)
                        
                        
                        {

          
        }

        }

 

    }
