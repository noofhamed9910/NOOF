import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class clientNoofhamed21S20829 implements Runnable

{

  
    public void run()

   

    {

       try{

            Socket NOOFSoc=new Socket("localhost",5772);

          

            //scanner code

            Scanner NoofscaN=new Scanner(System.in);

            System.out.println("Enter ther :CODE 100 to 107 ");
            

           

            int NOOFCode=NoofscaN.nextInt();

          

            //scanner req

            System.out.println("Enter the Qequired Quantity");

            int NQequired=NoofscaN.nextInt();

           

            //send to Server

           

            DataOutputStream NOOFdos=new DataOutputStream(NOOFSoc.getOutputStream());

            NOOFdos.writeInt(NOOFCode);

            NOOFdos.writeInt(NQequired);

            NOOFdos.flush();

           

            

            //receive the prise and name

            DataInputStream NOOFdis=new DataInputStream(NOOFSoc.getInputStream());

            String NOOFname=NOOFdis.readUTF();

            double NOOFprice=NOOFdis.readDouble();

           

            

            //disply

            
             
            System.out.println("The NAME IS:"+NOOFname);

          
            System.out.println("The Code:"+NOOFCode);

           
            System.out.println("cups:"+NQequired);

           
           System.out.println("Total Price"+NOOFprice);

        
           

        
        }

        catch(IOException e)

        {

            System.out.println(e);

        }

    }

}
