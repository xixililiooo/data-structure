import class_06.Edge;

public class graphGenerator{
    //根据图的点集和边集来生成一个图
    public static Graph createGraph(Integer[][] matrix){
        Graph graph = new Graph();
        for(int i = 0;i<matrix.length;i++){
            Integer weight = matrix[i][0];
            Integer from = matrix[i][1];
            Integer to  = matrix[i][1];
            if(!graph.nodes.containskey(from)){
                graph.nodes.put(from,new GraphNode(from));
            }
            if(!graph.nodes.containskey(to)){
                graph.nodes.put(to,new GraphNode(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode  = graph.nodes.get(to);
            Edge newEdge = new Edge(weight, fromNode, toNode);
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.edges.add(newEdge);
            graph.edges.add(newEdge);
        }
        return graph;
    }
}