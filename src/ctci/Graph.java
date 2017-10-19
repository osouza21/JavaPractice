package ctci;

/**
 * Graph data structur for ctci problems
 */
public class Graph {
    public static int MAX_VERTICES = 6;
    private GraphNode vertices[];
    public int count;

    public Graph() {
        vertices = new GraphNode[MAX_VERTICES];
        count = 0;
    }

    public void addNode(GraphNode x){
        if(count < vertices.length){
            vertices[count] = x;
            count++;
        } else {
            System.out.println("Graph full");
        }
    }

    public GraphNode[] getNodes(){
        return vertices;
    }
}
