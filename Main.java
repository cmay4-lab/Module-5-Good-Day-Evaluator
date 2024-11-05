import java.lang.Math;

public class Main {

    /*  
        Used for calculating the dew point. A metric commonly associated to human comfortability.
        The dew-point temperature is a relation between the actual "dry bulb" temperature (T) and the relative humidity (RH)
        Source: https://en.wikipedia.org/wiki/Dew_point
    */

    private static boolean isWeatherInhabitable(int temperature, double humidity) {

        final int[] HABITABLE_TEMPERATURES_DOMAIN = {GoodDay.HABITABLE_TEMPERATURE_LOWER_LIMIT, GoodDay.HABITABLE_TEMPERATURE_UPPER_LIMIT};
        final double[] HABITABLE_HUMIDITY_DOMAIN = {GoodDay.HABITABLE_HUMIDITY_LOWER_LIMIT, GoodDay.HABITABLE_HUMIDITY_UPPER_LIMIT};

        boolean weatherIsInhabitable;

        if (temperature < HABITABLE_TEMPERATURES_DOMAIN[0] || HABITABLE_HUMIDITY_DOMAIN[1] < temperature) {

            weatherIsInhabitable = true;
            

        } else if (humidity < HABITABLE_HUMIDITY_DOMAIN[0] || HABITABLE_HUMIDITY_DOMAIN[1] < humidity) {

            weatherIsInhabitable = true;

        } else {

            weatherIsInhabitable = false;

        }
        
        return weatherIsInhabitable;

    }

    private static boolean isWeatherNormal(GoodDay goodDayEvaluator) {

        final boolean WEATHER_IS_INHABITABLE = isWeatherInhabitable(goodDayEvaluator.getTemperature(), goodDayEvaluator.getHumidity());
        final boolean USER_IS_CRAZY = isWeatherInhabitable(goodDayEvaluator.getPreferredTemperature(), goodDayEvaluator.getPreferredHumidity());

        boolean weatherIsNormal;

        if (WEATHER_IS_INHABITABLE || USER_IS_CRAZY) {

            weatherIsNormal = false;

        } else {


            weatherIsNormal = true;

        }

        return weatherIsNormal;
    }

    private static double getDewPointTemperature(int temperature, double humidity) {

        final double DEW_POINT_MULTIPLYING_CONSTANT = 17.625;
        final double DEW_POINT_SUMMING_CONSTANT = 243.04;

        double dewPointTemperature;

        if (humidity == 0) {

            dewPointTemperature = temperature;

        } else {

            double magnusOutput = Math.log(humidity / 100) + ( (DEW_POINT_MULTIPLYING_CONSTANT * temperature) / (DEW_POINT_SUMMING_CONSTANT + temperature) );
            dewPointTemperature = (DEW_POINT_SUMMING_CONSTANT * magnusOutput) / (DEW_POINT_MULTIPLYING_CONSTANT - magnusOutput);

        }

        return dewPointTemperature;

    }

    private static boolean isWeatherGood(GoodDay goodDayEvaluator) {

        boolean weatherIsGood;

        if (isWeatherInhabitable(goodDayEvaluator.getTemperature(), goodDayEvaluator.getHumidity())) {

            weatherIsGood = false;

        } else {

            final double CURRENT_DEW_POINT_TEMPERATURE = getDewPointTemperature(goodDayEvaluator.getTemperature(), goodDayEvaluator.getHumidity());

            

            final int PREFERRED_TEMPERATURE = goodDayEvaluator.getPreferredTemperature();
            final double PREFERRED_HUMIDITY = goodDayEvaluator.getPreferredHumidity();

            
            final double PREFERRED_DEW_POINT_TEMPERATURE = getDewPointTemperature(PREFERRED_TEMPERATURE, PREFERRED_HUMIDITY);

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

        String leastFavoriteMeal = goodDayEvaluator.getLeastFavoriteMeal();
        String dinnerMeal = goodDayEvaluator.getDinnerMeal();

        if (dinnerMeal == "" || dinnerMeal.equalsIgnoreCase(leastFavoriteMeal)) {

            foodIsGood = false;

        }

        return foodIsGood;

    }

    private static boolean isTodayGood(GoodDay goodDayEvaluator) {

        int happinessLevel;

        final boolean WEATHER_IS_NOT_NORMAL = !isWeatherNormal(goodDayEvaluator);

        if (WEATHER_IS_NOT_NORMAL) {

            happinessLevel = 0;

        } else {

            final boolean WEATHER_IS_GOOD = isWeatherGood(goodDayEvaluator);
            final boolean FOOD_IS_GOOD = isFoodGood(goodDayEvaluator);


            if (WEATHER_IS_GOOD) {

                happinessLevel++;

            }


        }

        if (isWeatherGood(goodDayEvaluator)) {

            happinessLevel++;

        }

        if (isFoodGood(goodDayEvaluator)) {

            if (!goodDayEvaluator.getDinnerMeal().isBlank()) {

                if (goodDayEvaluator.getFavoriteDinnerMeal() == goodDayEvaluator.getDinnerMeal()) {

                    happinessLevel++;
    
                } else {
    
                    happinessLevel += 0.5;
    
                }

            }

        }

        if (goodDayEvaluator.getIsHomeworkDone()) {

            happinessLevel++;

        } else {

            double mostLikelyHomeworkGrade = 1;

            switch (goodDayEvaluator.getHomeworkDifficulty()) {
    
                case "Easy" -> mostLikelyHomeworkGrade = 0.9;
                case "Medium" -> mostLikelyHomeworkGrade = 0.8;
                case "Hard" -> mostLikelyHomeworkGrade = 0.7;
                case "Very Hard" -> mostLikelyHomeworkGrade = 0.6;
                default -> mostLikelyHomeworkGrade = 1;
    
            }

            happinessLevel += mostLikelyHomeworkGrade * 0.3;

        }

        double happinessPercent = (100*happinessLevel) / 4;

        if (happinessPercent == 0) {

            todayIsGood = true;

        } else {

            todayIsGood = false;

        }

        return todayIsGood;
    }

    public static void main(String[] args) {

        System.out.print("\n\n");     // New Lines for readability
        GoodDay day = new GoodDay();    // New "default" user for good day evaluation

        /* Testing the Getter Methods of all the Properties of the GoodDay Class (Default) */
        System.out.println("Getter Methods and Their Returns (Default):");
        System.out.print("\n");
        System.out.print("Current Ambient temperature: " + day.getTemperature());
        System.out.print("\n");
        System.out.print("Current Relative Humidity: " + day.getHumidity());
        System.out.print("\n");
        System.out.print("Whether Homework Is Done or Not: " + day.getIsHomeworkDone());
        System.out.print("\n");
        System.out.print("The Difficulty of the Homework: " + day.getHomeworkDifficulty());
        System.out.print("\n");
        System.out.print("The Name of What the User Is Having for Dinner: " + day.getDinnerMeal());
        System.out.print("\n");
        System.out.print("The Name of the User's Favorite Meal for Dinner: ");
        System.out.print("\n");
        System.out.print("The Name of the User's Least Favorite Meal for Dinner: ");
        System.out.print("\n");
        System.out.print("The User's Personally Perferred Temperature (Or Whatever They Are Used To): " + day.getPreferredTemperature());
        System.out.print("\n");
        System.out.print("The User's Personally Perferred Relative Humidity (Or Whatever They Are Used To): " + day.getPreferredHumidity());
        System.out.print("\n");

        /* Testing the getDewPointTemperature Method of the Main Class (Default) */ 
        System.out.print("The Current Dew-Point Temperature is therefore: " + getDewPointTemperature(day.getTemperature(), day.getHumidity()));
        System.out.print("\n");
        System.out.print("The Dew-Point Temperature that the User Is Most Comfortable at Is: " + getDewPointTemperature(day.getPreferredTemperature(), day.getPreferredHumidity()));
        System.out.print("\n");

        /* Testing the isWeatherInhabitable Method of the Main Class (Default) */
        if (isWeatherInhabitable(day.getTemperature(), day.getHumidity())) {

            System.out.print("The Weather Is Inhabitable.");

        } else {

            System.out.print("The Weather Is Habitable.");

        }
        System.out.print("\n");

        /* Testing the isWeatherGood Method of the Main Class (Default) */
        if (isWeatherGood(day)) {

            System.out.print("The Weather Is Good.");

        } else {

            System.out.print("The Weather Is Bad.");

        }
        System.out.print("\n");

        /* Testing the isFoodGood Method of the Main Class (Default) */
        if (isFoodGood(day)) {

            System.out.print("The Meal for Dinner Is Good.");

        } else {

            System.out.print("The Meal for Dinner Is Bad.");

        }
        System.out.print("\n");

        /* Testing the isTodayGood Method of the Main Class (Default) */
        if (isTodayGood(day)) {

            System.out.print("Today is a Good Day.");

        } else {

            System.out.print("Today is a Bad Day.");

        }
        System.out.print("\n");

        /* Testing the Setter Methods of all the Properties of the GoodDay Class (Default) */
        System.out.println("Setting new properties for GoodDay Class and Printing Them (Default):");
        System.out.print("\n");
        System.out.print("\n");

        /* Real life Estimated Statistics in New York City Mixed with Story-Telling by Yours Truly */ 
        System.out.print("Picture a student living in New York City on the date of 11/3/2024 at 8:48 PM:");
        System.out.print("\nTheir Unweighted GPA is 3.94, and they come from an Upper-Middle Class Background..."); 
        System.out.print("\n");

        day.setTemperature(11);
        System.out.print("Current Ambient temperature: " + day.getTemperature());
        System.out.print("\n");

        day.setHumidity(38);
        System.out.print("Current Relative Humidity: " + day.getHumidity());
        System.out.print("\n");

        day.setIsHomeworkDone(true);
        System.out.print("Whether their Homework Was Done Is " + day.getIsHomeworkDone() + ".");
        System.out.print("\n");

        day.setHomeworkDifficulty("Easy");
        System.out.print("The homework was " + day.getHomeworkDifficulty() + " to complete.");
        System.out.print("\n");

        day.setDinnerMeal("Ribbony Shrimp and Pasta Scampi");
        System.out.print("With the extra time, they were able to cook something very healthy yet still very tasty for dinner, so they decided on making " + day.getDinnerMeal() + ".");
        System.out.print("\n");

        day.setFavoriteDinnerMeal("Classic New York City Pizza");
        System.out.print("Although it is not their favorite meal, " + day.getFavoriteDinnerMeal() + ". They know that that choice is not thst good for you even if it easier to get.");
        System.out.print("\n");

        day.setLeastFavoriteMeal("a perfectly good pizza but with anchovies on it");
        System.out.print("If one thing for certain, it is whole of a lot better than " + day.getLeastFavoriteMeal() + ".");
        System.out.print("\n");

        day.setPreferredTemperature(20);
        System.out.print("At this time of year though, They wishe they lived farther down south closer to " + day.getPreferredTemperature() + "Celsius.");
        System.out.print("\n");

        day.setPreferredHumidity(50);
        System.out.print("They also do not mind higher humidites unlike other northerners. They actually prefer it to be somewhere around " + day.getPreferredHumidity() + "%.");
        System.out.print("\n");
        System.out.print("\n");
        
        /* Lastly, testing the parameterized constructor */
        GoodDay dayFlorida = new GoodDay(23, 76.952, false, "Hard", "Spinch Ravioli", "Spinch Ravoli", "Traditional Spaghetti", 22, 75);
        /* At 9:39 PM, 11/3/2024, in Georgia, another student had already been using the good day evaluator. */
        System.out.print("At 9:39 PM, 11/3/2024, in Florida, another student had already been using the good day evaluator:");
        System.out.print("\n");
        System.out.print("Their GPA is closer is around 3.73, and but also upper-middle class...");
        System.out.print("\n");
        System.out.print("\n");

        /* Testing the getDewPointTemperature Method of the Main Class (Parameterized) */ 
        System.out.print("The Current Dew-Point Temperature is therefore: " + getDewPointTemperature(dayFlorida.getTemperature(), dayFlorida.getHumidity()));
        System.out.print("\n");
        System.out.print("The Dew-Point Temperature that the User Is Most Comfortable at Is: " + getDewPointTemperature(dayFlorida.getPreferredTemperature(), dayFlorida.getPreferredHumidity()));
        System.out.print("\n");

        /* Testing the isWeatherInhabitable Method of the Main Class (Parameterized) */
        if (isWeatherInhabitable(dayFlorida.getTemperature(), dayFlorida.getHumidity())) {

            System.out.print("The Weather Is Inhabitable.");

        } else {

            System.out.print("The Weather Is Habitable.");

        }
        System.out.print("\n");

        /* Testing the isWeatherGood Method of the Main Class (Parameterized) */
        if (isWeatherGood(dayFlorida)) {

            System.out.print("The Weather Is Good.");

        } else {

            System.out.print("The Weather Is Bad.");

        }
        System.out.print("\n");

        /* Testing the isFoodGood Method of the Main Class (Parameterized) */
        if (isFoodGood(dayFlorida)) {

            System.out.print("The Meal for Dinner Is Good.");

        } else {

            System.out.print("The Meal for Is Bad.");

        }
        System.out.print("\n");

        /* Testing the isTodayGood Method of the Main Class (Parameterized) */
        if (isTodayGood(dayFlorida)) {

            System.out.print("Today is a Good Day.");

        } else {

            System.out.print("Today is a Bad Day.");

        }
        System.out.print("\n");

    }

}
