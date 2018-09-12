package collectionframework.graph.matrix;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class MatrixImpl implements Graph {

	int a[][] = null;

	@Override
	public void prepateGraph(File file) throws FileNotFoundException, IOException {

		Properties properties = new Properties();
		properties.load(new FileInputStream(file));
		
		int nodes = Integer.parseInt(properties.getProperty("TOTAL_NODES"));
		System.out.println("number of nodes "+nodes);

		a = new int[nodes][nodes];
		
		for(int i=0; i<nodes; i++){
			
			String str = properties.getProperty(String.valueOf(i));
			String nodeArray [] = str.split(",");
			
			int nodeIntArr [] = new int[nodeArray.length];
			for(int j=0; j<nodeArray.length; j++){
				nodeIntArr[j] = Integer.parseInt(nodeArray[j]);
			}
			
			for(int k=0; k<nodeIntArr.length; k++){
				a[i][nodeIntArr[k]] = 1; 
			}
			
		}
		
	}
	
	@Override
	public void createCompletePath() {

		for (int i = 0; i < a.length; i++) {

			for (int j = 0; j < a.length; j++) {

				if (i != j && a[i][j] == 1) {

					//System.out.println("Calling Rows : " + j);
					ArrayList<Integer> list = getAllIndex(a, j);

					for (int k = 0; k < list.size(); k++) {
						a[i][list.get(k)] = 1;
					}
				}
			}
		}

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (a[i][j] == 1) {
					a[j][i] = 1;
				}
			}
		}

	}

	private  ArrayList<Integer> getAllIndex(int[][] a, int row) {

		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < a.length; i++) {
			if (a[row][i] == 1) {
				list.add(i);
			}
		}
		//System.out.println(list);
		return list;
	}
	
	
	@Override
	public void displayGraph() {
		
		System.out.println();
		for(int i=0; i<a.length; i++){
			for(int j=0; j<a.length; j++){
				System.out.print(","+a[i][j]);
			}
			System.out.println(); 
		}
	}

	@Override
	public ArrayList<Integer> getReachable(int src) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=0; i<a.length; i++){
			
			if(a[src][i] == 1){
				list.add(i);
			}
		}
		
		return list;
	}

	@Override
	public ShortestPathModel getShortestPath(int src, int des) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
