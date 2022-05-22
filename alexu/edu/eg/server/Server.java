package alexu.edu.eg.server;

import java.rmi.*;
import java.rmi.server.*;
import alexu.edu.eg.graph.IGraph;
import alexu.edu.eg.graph.Graph;

import java.util.ArrayList;
import java.util.List;


public class Server extends UnicastRemoteObject implements IServer {
   // private ReadWriteLock rwLock;
    private IGraph graph;

    protected Server() throws RemoteException {
        super();
        graph = new Graph();
        //rwLock = new ReadWriteLock();
    }

    public synchronized List<Integer> shortestPath(List<String> patch) throws RemoteException {
        List<Integer> result = new ArrayList<>();


        for(String query: patch){


            if(query.equals("F")) {
                //runReadQueries(result, readQueries);
                break;
            }

            String [] str = query.split(" ");
            String statement = str[0];
            Integer src = Integer.parseInt(str[1]);
            Integer des = Integer.parseInt(str[2]);

          
            if(statement.equals("A")){
                //runReadQueries(result, readQueries);
                graph.add(src,des);
                //System.out.println("Added " + src + " " + des);
            } else if(statement.equals("D")){
                //runReadQueries(result, readQueries);
                graph.remove(src,des);
            } else if(statement.equals("Q")){
                //readQueries.add(new int[]{src,des});
               result.add(graph.query(src,des));
            }
        }

        return result;
    }

}
