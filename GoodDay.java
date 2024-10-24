/**
 * 
 * GoodDay --- Used to organize properties to a good day.
 * @author     Chase May
 */
public class GoodDay {

    private int temperature;                // Stores temperature in Celsius.
    private double humidity;                // Stores humidity.
    private boolean isHomeworkDone;         // Stores whether homework is done or not.
    private String dinnerMeal;              // Stores dinner meal name.
    private int preferredTemperature;       // Stores the preferred temperature.
    private double preferredHumidity;       // Stores the preferred humidity.

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
     * getIsHomeworkDone --- Gets wether homework is done or not.
     * @return               isHomeworkDone
     */
    public boolean getIsHomeworkDone() {

        return isHomeworkDone;

    }

    /**
     * 
     * getDinnerMeal --- Gets the dinner meal name.
     * @return           dinnerMeal
     */
    public String getDinnerMeal() {
        
        return dinnerMeal;

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
     * setDinnerMeal --- Sets the dinner meal name to equal a new dinner meal name.
     * @param            newDinnerMeal
     */
    public void setDinnerMeal(String newDinnerMeal) {
        
        dinnerMeal = newDinnerMeal;

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
        dinnerMeal = "";

    }

    /**
     * 
     * GoodDay --- Constructs a GoodDay object with user inputed arguments for fields:
     * @param      inputTemperature
     * @param      inputHumidity
     * @param      inputIsHomeworkDone
     * @param      inputDinnerMeal
     */
    public GoodDay(int inputTemperature, double inputHumidity, boolean inputIsHomeworkDone, String inputDinnerMeal) {

        temperature = inputTemperature;
        humidity = inputHumidity;
        isHomeworkDone = inputIsHomeworkDone;
        dinnerMeal = inputDinnerMeal;

    }

}