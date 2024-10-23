import java.lang.Math;

public class Main {

    // https://en.wikipedia.org/wiki/Dew_point
    // Calculating the dew point
    // The dew-point temperature is a relation between the actual "dry bulb" temperature (T) and the relative humidity (RH)

    private static double getDewPointTemperature(int temperature, double humidity) {

        final double DEW_POINT_MULTIPLYING_CONSTANT = 17.625;
        final double DEW_POINT_SUMMING_CONSTANT = 243.04;

        double magnusOutput = Math.log(humidity / 100) + ( (DEW_POINT_MULTIPLYING_CONSTANT * temperature) / (DEW_POINT_SUMMING_CONSTANT + temperature) );
        double dewPointTemperature = (DEW_POINT_SUMMING_CONSTANT * magnusOutput) / (DEW_POINT_MULTIPLYING_CONSTANT - magnusOutput);

        return dewPointTemperature;

    }
    

    private static boolean isTodayGood(GoodDay goodDayEvaluator) {



        return false;
    }


    private static boolean isWeatherGood(GoodDay goodDayEvaluator) {

        double currentTemperature = goodDayEvaluator.getTemperature();
        double currentHumidity = goodDayEvaluator.getHumidity();

        double preferredTemperature = goodDayEvaluator.getPreferredTemperature();
        double preferredHumidity = goodDayEvaluator.getPreferredHumidity();

        double neutralTemperature = (currentTemperature + preferredTemperature) / 2;
        double neutralHumidity = (currentHumidity + preferredHumidity) / 2;

        return false;

    }

    





    public static void main(String[] args) {

        System.out.print("\n\n");    // Prints new lines to distinguish where the console's preconfigurations end and where the main method begins.

        // The main idea behind this next section is that the tests simulates an imaginary user using the Good Day
        // Evaluator. This is the 1st user, and this is their 1st day using it. Since their GoodDay attributes are
        // extreme, they are likely having a bad day...

        GoodDay goodDay = new GoodDay();    // Instantiates a blank GoodDay object to test the default constructor.





    }

}
