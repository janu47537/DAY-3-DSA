import java.util.*;
class Graph {
    private Map<Integer,List<Integer>> adjacencyList;
    public Graph(){
        adjacencyList=new HashMap<>();
    }
    public void addNode(int v){
        adjacencyList.putIfAbsent(v,new ArrayList<>());
        for(int node: adjacencyList.keySet()){
            if(node!=v){
                addEdge(node,v);
            }

        }
    }
    public void addEdge(int u,int v){
        if(!adjacencyList.containsKey(u))addNode(u);
        if(!adjacencyList.containsKey(v))addNode(v);
        if(!adjacencyList.get(u).contains(v)) adjacencyList.get(u).add(v);
        if(!adjacencyList.get(v).contains(u)) adjacencyList.get(v).add(u);
    }
    public void printGraph01(){
        for(int v: adjacencyList.keySet()){
            System.out.println(v+"->"+adjacencyList.get(v));
        }
    }
    public boolean isConnected(int v, int u) {
    if (adjacencyList.containsKey(v) && adjacencyList.get(v).contains(u)) {
        return true;
    }
    return false;
}
public void removeEdge(int v,int u){
    if(adjacencyList.containsKey(v)){
        adjacencyList.get(v).remove(Integer.valueOf(u));
    }
    if(adjacencyList.containsKey(u)){
        adjacencyList.get(u).remove(Integer.valueOf(v));
    }
}
public int countOfEdges(){
    int count=0;
    for(int node:adjacencyList.keySet()){
        count+=adjacencyList.get(node).size();
    }
    return count/2;
}
public void countOfAdj(){
    int count=0;
    for(int v:adjacencyList.keySet()){
        count=adjacencyList.get(v).size();
        System.out.println(v+":"+count);
    }
return;
}


    public static void main(String[]args){
        Graph a=new Graph();
        a.addNode(3);
        a.addNode(1);
        a.addNode(3);
        a.addNode(2);
        a.addNode(3);
        a.addNode(2);
        a.printGraph01();
        System.out.println(a.isConnected(3,2));
        a.removeEdge(1,3);
        System.out.println(a.isConnected(1,3));
        System.out.println("After removing edge");
        a.printGraph01();
        System.out.println("Number of edges:"+a.countOfEdges());
        System.out.println("Number of adjacent nodes:");
        a.countOfAdj();


    }

    

}
