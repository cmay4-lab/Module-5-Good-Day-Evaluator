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

        int happinessLevel = 0



        if (isWeatherGood(goodDayEvaluator)) {

            ++happinessLevel;

        }

        if (isSchoolGood(goodDayEvaluator)) {

            ++happinessLevel;

        }




        return false;
    }

    private static boolean isWeatherInhabitable(int temperature, double humidity) {

        boolean weatherIsInhabitable;

        boolean temperatureIsInhabitable = temperature <= GoodDay.HABITABLE_TEMPERATURE_LOWER_LIMIT || temperature >= GoodDay.HABITABLE_TEMPERATURE_UPPER_LIMIT;
        boolean humidityIsInhabitable = humidity <= GoodDay.HABITABLE_HUMIDITY_LOWER_LIMIT || humidity >= GoodDay.HABITABLE_HUMIDITY_UPPER_LIMIT;
        
        if (temperatureIsInhabitable || humidityIsInhabitable) {

            weatherIsInhabitable = true;

        } else {

            weatherIsInhabitable = false;

        }
        
        return weatherIsInhabitable;

    }

    private static boolean isWeatherGood(GoodDay goodDayEvaluator) {

        boolean weatherIsGood;

        int temperature = goodDayEvaluator.getTemperature();
        double humidity = goodDayEvaluator.getHumidity();

        if (isWeatherInhabitable(temperature, humidity)) {

            weatherIsGood = false;

        } else {

            int preferredTemperature = goodDayEvaluator.getPreferredTemperature();
            double preferredHumidity = goodDayEvaluator.getPreferredHumidity();

            double dewPointTemperature = getDewPointTemperature(temperature, humidity);
            double preferredDewPointTemperature = getDewPointTemperature(preferredTemperature, preferredHumidity);

            if (dewPointTemperature == preferredDewPointTemperature) {

                weatherIsGood = true;

            } else {

                final double MINIMUM_DEW_POINT_TEMPERATURE = getDewPointTemperature(GoodDay.HABITABLE_TEMPERATURE_LOWER_LIMIT, GoodDay.HABITABLE_HUMIDITY_LOWER_LIMIT);
                final double MAXIMUM_DEW_POINT_TEMPERATURE = getDewPointTemperature(GoodDay.HABITABLE_TEMPERATURE_UPPER_LIMIT, GoodDay.HABITABLE_HUMIDITY_UPPER_LIMIT);
                
                double levelOfDiscomfort;
                double levelOfSafety;

                if (preferredDewPointTemperature <= MINIMUM_DEW_POINT_TEMPERATURE || preferredDewPointTemperature >= MAXIMUM_DEW_POINT_TEMPERATURE) {

                    weatherIsGood = false;

                } else if (dewPointTemperature > preferredDewPointTemperature) {

                    levelOfDiscomfort = dewPointTemperature - preferredDewPointTemperature;
                    levelOfSafety = preferredDewPointTemperature - MINIMUM_DEW_POINT_TEMPERATURE;

                    if (levelOfSafety > levelOfDiscomfort) {

                        weatherIsGood = true;
    
                    } else {
    
                        weatherIsGood = false;
    
                    }

                } else {

                    levelOfDiscomfort = preferredDewPointTemperature - dewPointTemperature;
                    levelOfSafety = MAXIMUM_DEW_POINT_TEMPERATURE - preferredDewPointTemperature;

                    if (levelOfSafety > levelOfDiscomfort) {

                        weatherIsGood = true;
    
                    } else {
    
                        weatherIsGood = false;
    
                    }

                }

            }

        }

        return weatherIsGood;

    }

    private static boolean isFoodGood(GoodDay goodDayEvaluator) {

        boolean foodIsGood = true;

        String favoriteMeal = goodDayEvaluator.getFavoriteDinnerMeal();
        String leastFavoriteMeal = goodDayEvaluator.getLeastFavoriteMeal();
        String dinnerMeal = goodDayEvaluator.getDinnerMeal();

        if (dinnerMeal.isBlank() || dinnerMeal.equalsIgnoreCase(leastFavoriteMeal)) {

            foodIsGood = false;

        }

        return foodIsGood;

    }

    public static void main(String[] args) {

        System.out.print("\n\n");    // Prints new lines to distinguish where the console's preconfigurations end and where the main method begins.

        // The main idea behind this next section is that the tests simulates an imaginary user using the Good Day
        // Evaluator. This is the 1st user, and this is their 1st day using it. Since their GoodDay attributes are
        // extreme, they are likely having a bad day...

        GoodDay goodDay = new GoodDay();    // Instantiates a blank GoodDay object to test the default constructor.

    }

}
