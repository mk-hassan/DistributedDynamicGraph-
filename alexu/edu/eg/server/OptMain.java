package alexu.edu.eg.server;
// Java program for alexu.edu.eg.server application
import java.rmi.*;
import java.rmi.registry.*;
public class OptMain {

    public static void main(String args[])
    {
        try
        {
            // Create an object of the interface
            // implementation class
            IServer obj = new OptServer();

            // rmiregistry within the alexu.edu.eg.server JVM with
            // port number 1800
            LocateRegistry.createRegistry(1800);

            // Binds the remote object by the name
            Naming.rebind("rmi://localhost:1800"+
                    "/OptimalServer",obj);
            System.out.println("The optimal Server ready for requests.");
        }
        catch(Exception ae)
        {
            System.out.println(ae);
        }
    }
}

