
/**
 * The ClockDisplay class implements a digital clock display for a
 * European-style 24 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 00:00 (midnight) to 23:59 (one minute before 
 * midnight).
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;    // simulates the actual display
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplay()
    {
        //tarea 2:
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay(int hour, int minute)
    {
        //tarea 2:
        assert hour >= 0 && hour < 12;
        assert minute >= 0 && minute < 60;
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        setTime(hour, minute);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        // tarea 2:
        if(hours.getValue() > 0 && hours.getValue() < 12){
            displayString = hours.getDisplayValue() + ":" + 
                        minutes.getDisplayValue() + "AM";
        }else{
            if(hours.getValue() >= 12 && hours.getValue() <= 23){
                if(hours.getValue() == 12){
                    displayString = "12:" + 
                        minutes.getDisplayValue() + "PM";
                }
                else{
                    displayString = (hours.getValue() - 12) + ":" +
                        minutes.getDisplayValue() + "PM";
                }
            }else{
                displayString = "12:" + 
                        minutes.getDisplayValue() + "AM";
            }
        }
        //displayString = hours.getDisplayValue() + ":" + 
                        //minutes.getDisplayValue();
    }
}
