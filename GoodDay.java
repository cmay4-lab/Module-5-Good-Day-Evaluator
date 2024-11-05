/**
 * 
 * GoodDay --- Used to organize properties to a good day.
 * @author     Chase May
 */
public class GoodDay {

    // Static Constants to what makes a "good day"
    public static final int HABITABLE_TEMPERATURE_LOWER_LIMIT = 1;      // Stores the lowest temperature that the human body could possibly withstand for long periods fo time relative to the exponentially rising risk of frostbite (failure of homeostasis) as temperature increases.
    public static final int HABITABLE_TEMPERATURE_UPPER_LIMIT = 39;     // Stores the hottest temperature that the human body could possibly withstand for long periods of time relative to the exponentially rising risk of heat stroke (failure of homeostasis) as temperature increases.
    public static final double HABITABLE_HUMIDITY_LOWER_LIMIT = 1;      // Stores the percent of humidity that is impossibly dry: causing deteriorating health (excessive dehydration, extremely weaken immune system, skin damage, etc.) no matter the temperature.
    public static final double HABITABLE_HUMIDITY_UPPER_LIMIT = 99;     // Stores the percent of humidity that disables the human body's ability to sweat (eventually causing failure of homeostasis).

    private int temperature;                    // Stores temperature in Celsius.
    private double humidity;                    // Stores humidity in percent.
    private boolean isHomeworkDone;             // Stores whether homework is done or not.
    private String homeworkDifficulty;          // Stores the difficulty of the homework
    private String dinnerMeal;                  // Stores dinner meal name.
    private String favoriteDinnerMeal;          // Stores the name of the user's favorite dinner meal.
    private String leastFavoriteDinnerMeal;     // Stores the name of the user's least favorite dinner meal.
    private int preferredTemperature;           // Stores the preferred temperature in Celsius.
    private double preferredHumidity;           // Stores the preferred humidity in percent.

    /**
     * 
     * getTemperature --- Gets temperature.
     * @return            temperature
     */
    public int getTemperature() {

        return temperature;

    }

    /**
     * 
     * getHumidity --- Gets humidity.
     * @return         humidity
     */
    public double getHumidity() {

        return humidity;
        
    }

    /**
     * 
     * getIsHomeworkDone --- Gets whether homework is done or not.
     * @return               isHomeworkDone
     */
    public boolean getIsHomeworkDone() {

        return isHomeworkDone;

    }

    /**
     *
     * getHomeworkDifficulty --- Gets the difficulty of the homework.
     * @return                   homeworkDifficulty
     */
    public String getHomeworkDifficulty() {

        return homeworkDifficulty;

    }

    /**
     * 
     * getDinnerMeal --- Gets the name of the dinner meal.
     * @return           dinnerMeal
     */
    public String getDinnerMeal() {
        
        return dinnerMeal;

    }

    /**
     *
     * getFavoriteDinnerMeal --- Gets the name of the user's favorite dinner meal.
     * @return                   FavoriteDinnerMeal
     */
    public String getFavoriteDinnerMeal() {

        return favoriteDinnerMeal;

    }

    /**
     *
     * getFavoriteDinnerMeal --- Gets the name of the user's least favorite dinner meal.
     * @return                   leastFavoriteDinnerMeal
     */
    public String getLeastFavoriteMeal() {

        return leastFavoriteDinnerMeal;

    }

    /**
     *
     * getPreferredTemperature --- Gets the preferred temperature of the user.
     * @return                     preferredTemperature
     */
    public int getPreferredTemperature() {

        return preferredTemperature;

    }

    /**
     *
     * getPreferredHumidity --- Gets the preferred humidity of the user.
     * @return
     */
    public double getPreferredHumidity() {

        return preferredHumidity;

    }

    /**
     * 
     * setTemperature --- Sets temperature to equal the new temperature.
     * @param             newTemperature
     */
    public void setTemperature(int newTemperature) {

        temperature = newTemperature;

    }

    /**
     * 
     * setHumidity --- Sets humidity to equal the new Humidity.
     * @param          newHumidity
     */
    public void setHumidity(double newHumidity) {

        humidity = newHumidity;

    }

    /**
     * 
     * setIsHomeworkDone --- Sets whether homework is done to equal the new answer to whether is done.
     * @param                newIsHomeworkDone
     */
    public void setIsHomeworkDone(boolean newIsHomeworkDone) {
        
        isHomeworkDone = newIsHomeworkDone;

    }

    /**
     *
     * setHomeworkDifficulty --- Sets the difficulty of the homework to equal the difficulty of the new homework.
     * @param                    newHomeworkDifficulty
     */
    public void setHomeworkDifficulty(String newHomeworkDifficulty) {

        homeworkDifficulty = newHomeworkDifficulty;

    }

    /**
     * 
     * setDinnerMeal --- Sets the dinner meal name to equal a new dinner meal name.
     * @param            newDinnerMeal
     */
    public void setDinnerMeal(String newDinnerMeal) {
        
        dinnerMeal = newDinnerMeal;

    }

    /**
     *
     * setFavoriteDinnerMeal --- Sets the user's favorite dinner meal name to equal a new favorite dinner meal name.
     * @param                    newFavoriteDinnerMeal
     */
    public void setFavoriteDinnerMeal(String newFavoriteDinnerMeal) {

        favoriteDinnerMeal = newFavoriteDinnerMeal;

    }

    /**
     *
     * setFavoriteDinnerMeal --- Sets the user's least favorite dinner meal name to equal a new least favorite dinner meal name.
     * @param                    newLeastFavoriteDinnerMeal
     */
    public void setLeastFavoriteMeal(String newLeastFavoriteDinnerMeal) {

        leastFavoriteDinnerMeal = newLeastFavoriteDinnerMeal;

    }

    /**
     *
     * setPreferredTemperature --- Sets the preferred temperature to equal a new temperature.
     * @param                      newPreferredTemperature
     */
    public void setPreferredTemperature(int newPreferredTemperature) {

        preferredTemperature = newPreferredTemperature;

    }

    /**
     *
     * getPreferredHumidity --- Gets the preferred humidity of the user.
     * @param                   newPreferredHumidity
     */
    public void setPreferredHumidity(double newPreferredHumidity) {

        preferredHumidity = newPreferredHumidity;

    }

    /**
     * 
     * GoodDay --- Constructs a GoodDay object with default fields: 
     *             Integers will default to 0
     *             Doubles will default to 0 
     *             Booleans will default to false
     *             Strings will default to ""
     */
    public GoodDay() {

        temperature = 0;
        humidity = 0;
        isHomeworkDone = false;
        homeworkDifficulty = "";
        dinnerMeal = "";
        preferredTemperature = 0;
        preferredHumidity = 0;
        favoriteDinnerMeal = "";
        leastFavoriteDinnerMeal = "";

    }

    /**
     * 
     * GoodDay --- Constructs a GoodDay object with user inputed arguments for fields:
     * @param      inputTemperature
     * @param      inputHumidity
     * @param      inputIsHomeworkDone
     * @param      inputHomeworkDifficulty
     * @param      inputDinnerMeal
     * @param      inputFavoriteDinnerMeal
     * @param      inputLeastFavoriteDinnerMeal
     * @param      inputPreferredTemperature
     * @param      inputPreferredHumidity
     */
    public GoodDay(int inputTemperature, double inputHumidity, boolean inputIsHomeworkDone, String inputHomeworkDifficulty, String inputDinnerMeal, String inputFavoriteDinnerMeal, String inputLeastFavoriteDinnerMeal, int inputPreferredTemperature, double inputPreferredHumidity) {

        temperature = inputTemperature;
        humidity = inputHumidity;
        isHomeworkDone = inputIsHomeworkDone;
        homeworkDifficulty = inputHomeworkDifficulty;
        dinnerMeal = inputDinnerMeal;
        favoriteDinnerMeal = inputFavoriteDinnerMeal;
        leastFavoriteDinnerMeal = inputLeastFavoriteDinnerMeal;
        preferredTemperature = inputPreferredTemperature;
        preferredHumidity = inputPreferredHumidity;
        
    }

}