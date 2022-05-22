package alexu.edu.eg.server;
// Java program for alexu.edu.eg.server application

import java.rmi.*;
import java.rmi.registry.*;
public class Main {

    public static void main(String args[])
    {
        try
        {
            // Create an object of the interface
            // implementation class
            IServer obj = new Server();

            // rmiregistry within the alexu.edu.eg.server JVM with
            // port number 1900
            LocateRegistry.createRegistry(1900);

            // Binds the remote object by the name
            Naming.rebind("rmi://localhost:1900"+
                    "/OrdinaryServer",obj);
            System.out.println("The ordinary Server ready for requests.");
        }
        catch(Exception ae)
        {
            System.out.println(ae);
        }
    }
}

