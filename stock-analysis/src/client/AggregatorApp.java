package client;

import java.io.IOException;

import aggregators.AggregatorProcessor;
import aggregators.MaxAggregator;
import aggregators.MeanAggregator;
import aggregators.MinAggregator;

public class AggregatorApp {

	public static void main(String[] args) throws IOException {
		int column = 1;
		MinAggregator agg = new MinAggregator();
		AggregatorProcessor<MinAggregator> aggsProcessor = new AggregatorProcessor<MinAggregator>(agg, "table.csv");
		double value = aggsProcessor.runAggregator(column);
		System.out.println(value);

		MaxAggregator maxAgg = new MaxAggregator();
		AggregatorProcessor<MaxAggregator> maxAggsProcessor = new AggregatorProcessor<MaxAggregator>(maxAgg, "table.csv");
		System.out.println(maxAggsProcessor.runAggregator(column));

		MeanAggregator meanAgg = new MeanAggregator();
		AggregatorProcessor<MeanAggregator> meanAggsProcessor = new AggregatorProcessor<MeanAggregator>(meanAgg, "table.csv");
		System.out.println(meanAggsProcessor.runAggregator(column));
	}

}
