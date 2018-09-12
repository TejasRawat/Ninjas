package collection.graph.matrix;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface Graph {
	
	public void prepateGraph(File file) throws FileNotFoundException, IOException ;
	
	public void createCompletePath();
	
	public ArrayList<Integer> getReachable(int src);
	
	public ShortestPathModel getShortestPath(int src, int des);
	
	public void displayGraph();
}
