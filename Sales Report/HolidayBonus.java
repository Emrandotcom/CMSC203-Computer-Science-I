
public class HolidayBonus {

	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other) {

		int storeNumber = data.length;

		double[] holidayBonuse = new double[storeNumber];

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				if (data[i][j] > 0) {
					if (data[i][j] == TwoDimRaggedArrayUtility.getHighestInColumn(data, j)) {
						holidayBonuse[i] += high;
					} else if (data[i][j] == TwoDimRaggedArrayUtility.getLowestInColumn(data, j)) {
						holidayBonuse[i] += low;
					} else {
						holidayBonuse[i] += other;
					}
				}
			}
		}
		return holidayBonuse;
	}

	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other) {

		double[] holidayBonusList = calculateHolidayBonus(data, high, low, other);

		double holidayBonusTotal = 0;

		for (int i = 0; i < data.length; i++)
			holidayBonusTotal += holidayBonusList[i];

		return holidayBonusTotal;
	}

}
