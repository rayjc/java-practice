package fileprocessors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class StockFileData {
	
	List<HashMap<String, Double>> data = new LinkedList<>();
	
	public void printData(){
		System.out.println(data);
	}
	
	public void addData(List<HashMap<String, Double>> dataIn){
		data = dataIn;
	}
	
	public static List<HashMap<String, Double>> populateStockFileData(List<String> headers, List<String> lines){
		List<HashMap<String, Double>> dataResult = new ArrayList<>();
		// loop through each line
		for(String line : lines) {
			// split csv row
			String[] data = line.split(",");
			HashMap<String, Double> map = new HashMap<>();
			// map each column of data to respective header
			for(int i = 0; i < headers.size(); i++) {
				map.put(headers.get(i), Double.parseDouble(data[i]));
			}
			// add map to final result
			dataResult.add(map);
		}
		return dataResult;
	}
}
