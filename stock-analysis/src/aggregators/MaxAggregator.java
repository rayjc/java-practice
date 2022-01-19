package aggregators;

import java.util.List;

public class MaxAggregator extends Aggregator{

	public MaxAggregator() {
		super();
	}

	public MaxAggregator(List<Double> numbers) {
		super(numbers);
	}

	@Override
	public double calculate() {
		double max = numbers.get(0);
		for(Double number : numbers){
			max = Math.max(max, number);
		}
		return max;
	}

	@Override
	public List<Double> getValues() {
		return numbers;
	}
	
}
