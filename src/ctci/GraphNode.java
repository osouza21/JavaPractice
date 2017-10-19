package ctci;

public class GraphNode {

    public enum State {
        Unvisited, Visited, Visiting;
    }

    private GraphNode adjacent[];
    public int adjacentCount;
    private String vertex;
    public State state;

    public GraphNode(String vertex, int adjacentLength){
        this.vertex = vertex;
        adjacentCount = 0;
        adjacent = new GraphNode[adjacentLength];
    }

    public void addAjacent(GraphNode x){
        if(adjacentCount < adjacent.length){
            this.adjacent[adjacentCount] = x;
            adjacentCount++;
        } else {
            System.out.println("No more adjacent can be added");
        }
    }

    public GraphNode[] getAdjacent() {
        return adjacent;
    }
    public String getVertex(){
        return vertex;
    }
}
