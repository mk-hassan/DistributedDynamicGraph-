package alexu.edu.eg.server;


import java.util.concurrent.Callable;

import alexu.edu.eg.graph.IGraph;

public class ReaderCallable implements Callable{

            private final int src,des,index;
            private final IGraph graph;
            private final int[] result;
            public ReaderCallable(int index, int src , int des,IGraph graph,int [] result){
                this.index = index;
                this.src = src;
                this.des = des;
                this.graph = graph;
                this.result = result;
            }

            public Integer call() {
                this.result[index] = graph.query(src,des);
                return 0;
            }
}

