package com.example.JavaProject.SviluppoDati;

public class NumStatistics {
	
	double avg;
	double min;
	double max;
	double devStd;
	double sum;
	int count;
	
	/**
	 * 
	 * @param avg
	 * @param min
	 * @param max
	 * @param devStd
	 * @param sum
	 * @param count
	 */
	
	/**
	 * Costruttore
	 */
	public NumStatistics(double avg, double min, double max, double devStd, double sum, int count) {
		this.avg = avg;
		this.min = min;
		this.max = max;
		this.devStd = devStd;
		this.sum = sum;
		this.count = count;
	}

	/**
	 * @return the avg
	 */
	public double getAvg() {
		return avg;
	}

	/**
	 * @param avg the avg to set
	 */
	public void setAvg(double avg) {
		this.avg = avg;
	}

	/**
	 * @return the min
	 */
	public double getMin() {
		return min;
	}

	/**
	 * @param min the min to set
	 */
	public void setMin(double min) {
		this.min = min;
	}

	/**
	 * @return the max
	 */
	public double getMax() {
		return max;
	}

	/**
	 * @param max the max to set
	 */
	public void setMax(double max) {
		this.max = max;
	}

	/**
	 * @return the devStd
	 */
	public double getDevStd() {
		return devStd;
	}

	/**
	 * @param devStd the devStd to set
	 */
	public void setDevStd(double devStd) {
		this.devStd = devStd;
	}

	/**
	 * @return the sum
	 */
	public double getSum() {
		return sum;
	}

	/**
	 * @param sum the sum to set
	 */
	public void setSum(double sum) {
		this.sum = sum;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "Statistiche numeriche [avg = " + avg + ", min = " + min + ", max = " + max + ", devStd = " + devStd + ", sum = " + sum
				+ ", count = " + count + "]";
	}
	

}
