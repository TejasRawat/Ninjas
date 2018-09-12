package collection.graph.matrix;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class GraphTest {
	
	public static void main(String args[]){
		
		Graph graph = new MatrixImpl();
		
		File file = new File("Graph.properties");
		
		try {
			
			graph.prepateGraph(file);
			
			graph.displayGraph();
			
			graph.createCompletePath();
			
			graph.displayGraph();
			
			ArrayList<Integer> listRechable = graph.getReachable(1);
			
			System.out.println(listRechable);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
