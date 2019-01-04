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
public class SzelessegiBejaras {
    private int V;   // No. of vertices 
    private LinkedList<Integer> adj[]; //Adjacency Lists 
  
    // Constructor 
    SzelessegiBejaras(Graf tempGraf, int kezdocsucs) 
    { 
        /*V = v; 
        adj = new LinkedList[v]; 
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList(); */
        
        V = tempGraf.getCsucsok().size(); 
            adj = new LinkedList[V]; 
            for (int i=0; i<V; ++i) 
                adj[i] = new LinkedList(); 
            feltolt(tempGraf);
            
            System.out.println("A szélességi bejárása következik "+ 
                           "(kiindulási csúcsa: "+ kezdocsucs +"):"); 
  
            BFS(kezdocsucs); System.out.println("\n------------------\n");
    } 
    
    private void feltolt(Graf tempGraf){
            int Elekhossz = tempGraf.getElek().size();
            
            for (El el : tempGraf.getElek()) {
                if (el.getSuly() != 0) {
                    addEdge(el.getCsucs1(), el.getCsucs2());
                }
            }
        }
  
    // Function to add an edge into the graph 
    void addEdge(int v,int w) 
    { 
        adj[v].add(w); 
    } 
  
    // Breadth First Search rövidítése
    void BFS(int s) 
    { 
        // Mark all the vertices as not visited(By default 
        // set as false) 
        boolean visited[] = new boolean[V]; 
  
        // Create a queue for BFS 
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
  
        // Mark the current node as visited and enqueue it 
        visited[s]=true; 
        queue.add(s); 
  
        while (queue.size() != 0) 
        { 
            // Dequeue a vertex from queue and print it 
            s = queue.poll(); 
            System.out.print(s+" "); 
  
            // Get all adjacent vertices of the dequeued vertex s 
            // If a adjacent has not been visited, then mark it 
            // visited and enqueue it 
            Iterator<Integer> i = adj[s].listIterator(); 
            while (i.hasNext()) 
            { 
                int n = i.next(); 
                if (!visited[n]) 
                { 
                    visited[n] = true; 
                    queue.add(n); 
                } 
            } 
        } 
    } 
}
