package structure.graph;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {
    public HashMap<Integer,GraphNode> nodes;
    public HashSet<Edge> edges;
    public Graph(){
        nodes = new HashMap();
        edges = new HashSet();
    }
}