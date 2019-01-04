/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.petrik.graffeladat;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author MasterZeigh
 */
public class MelysegiBejaras {
        private int V;   // No. of vertices 

        // Array  of lists for Adjacency List Representation 
        private LinkedList<Integer> adj[]; 

        // Constructor 
        MelysegiBejaras(Graf tempGraf, int kezdocsucs) 
        { 
            V = tempGraf.getCsucsok().size(); 
            adj = new LinkedList[V]; 
            for (int i=0; i<V; ++i) 
                adj[i] = new LinkedList(); 
            feltolt(tempGraf);
            
            System.out.println("A mélységi bejárása következik "+ 
                           "(kiindulási csúcsa: "+ kezdocsucs +"):"); 
  
            DFS(kezdocsucs); System.out.println("\n------------------\n");
        } 

        
        private void feltolt(Graf tempGraf){
            int Elekhossz = tempGraf.getElek().size();
            
            for (El el : tempGraf.getElek()) {
                if (el.getSuly() != 0) {
                    addEdge(el.getCsucs1(), el.getCsucs2());
                }
            }
        }
        
        //Function to add an edge into the graph 
        void addEdge(int v, int w) 
        { 
            adj[v].add(w);  // Add w to v's list. 
        } 
    
    
  
    // A function used by DFS 
    private void DFSUtil(int v,boolean visited[]) 
    { 
        // Mark the current node as visited and print it 
        visited[v] = true; 
        System.out.print(v+" "); 
  
        // Recur for all the vertices adjacent to this vertex 
        Iterator<Integer> i = adj[v].listIterator(); 
        while (i.hasNext()) 
        { 
            int n = i.next(); 
            if (!visited[n]) 
                DFSUtil(n, visited); 
        } 
    } 
  
    // Depth First Search rövidítése
    void DFS(int v) 
    { 
        // Mark all the vertices as not visited(set as 
        // false by default in java) 
        boolean visited[] = new boolean[V]; 
  
        // Call the recursive helper function to print DFS traversal 
        DFSUtil(v, visited); 
    } 
    
}