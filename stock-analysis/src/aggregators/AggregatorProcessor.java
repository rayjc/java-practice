package aggregators;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fileprocessors.StockFileData;
import fileprocessors.StockFileReader;

public class AggregatorProcessor <E extends Aggregator> {
	private final E agg;
	private final String filename;
	private final StockFileReader fr;
	private final List<HashMap<String, Double>> dataMap;
	
	public AggregatorProcessor(E agg, String filename) throws IOException {
		super();
		this.agg = agg;
		this.filename = filename;
		this.fr = new StockFileReader(filename);
		this.dataMap = StockFileData.populateStockFileData(fr.getHeaders(), fr.readFileData());
	}
	
	private String getColumnName(int num) {
		List<String> columns;
		try {
			columns = fr.getHeaders();
			return columns.get(num);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Column " + num + " does not exist!");
		}
		return "";
	}

	public String getFilename() {
		return filename;
	}

	public List<HashMap<String, Double>> getDataMap() {
		return dataMap;
	}
	
	public double runAggregator(int column) {
		// get column name
		String key = getColumnName(column);
		// loop through column data and add to aggregator
		for (Map<String, Double> row : dataMap) {
			Double data = row.get(key);
			agg.add(data);
		}
		// return aggregator calculation
		return agg.calculate();
	}
	
	
}
