package client;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import fileprocessors.StockFileData;
import fileprocessors.StockFileReader;

public class StockFileApplication {
	
	public static void main(String args[]) throws IOException{
		StockFileReader fr = new StockFileReader("table.csv");
		
		List<HashMap<String, Double>> dataResult = StockFileData.populateStockFileData(fr.getHeaders(), fr.readFileData());
		StockFileData fileData = new StockFileData();
		fileData.addData(dataResult);
		fileData.printData();
		System.out.println(dataResult.size());
	}
	/**
	 * Complete the method body so that it returns the given structure needed to 
	 * populate the data field in the StockFileData class. 
	 * @param headers
	 * @param lines
	 * @return List
	 */
//	public static List<HashMap<String, Double>> populateStockFileData(List<String> headers, List<String> lines){
//		List<HashMap<String, Double>> dataResult = new ArrayList<>();
//		// loop through each line
//		for(String line : lines) {
//			// split csv row
//			String[] data = line.split(",");
//			HashMap<String, Double> map = new HashMap<>();
//			// map each column of data to respective header
//			for(int i = 0; i < headers.size(); i++) {
//				map.put(headers.get(i), Double.parseDouble(data[i]));
//			}
//			// add map to final result
//			dataResult.add(map);
//		}
//		return dataResult;
//	}
	
	
}
