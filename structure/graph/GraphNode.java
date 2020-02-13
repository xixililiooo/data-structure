//图中每个节点的类
public class GraphNode{
    /**
     * value:节点的值
     * in：节点的入度
     * out:节点的出度
     */
    public int value; 
    public int in;
    public int  out;
    public ArrayList<Node> nexts;
    public ArrayList<Edge> edges;
    public GraphNode(int value){
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}