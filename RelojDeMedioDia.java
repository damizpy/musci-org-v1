
/**
 * Write a description of class RelojDeMedioDia here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RelojDeMedioDia
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString; // simula la pantalla actual del reloj

    /**
     * //Constructor para el objeto de la clase RelojDeMedioDia//, este
     * constructor crea un nuevo reloj seteado a las 00:00.
     */
    public RelojDeMedioDia()
    {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        updateDisplay();
    }
    
    /**
     * //Constructor para el objeto de la clase RelojDeMedioDia//, este
     * constructor crea un nuevo reloj seteado en el tiempo especificado
     * por el usuario con parametros.
     */
    public RelojDeMedioDia(int hour, int minute)
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        setTime(hour, minute);
    }

    /**
     * Este metodo se invoca cada vez que pasa un minuto, hace la
     * visualización del reloj cuando avanza un minuto.
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
     * Establece el tiempo especificado de la pantalla en horas y minutos.
     */
    public void setTime(int hour, int minute)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        updateDisplay();
    }
    
    /**
     * Retorna la hora actual de esta pantalla en el formato HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Actualiza la cadena de caracteres que representa la pantalla del reloj.
     */
    private void updateDisplay()
    {
        displayString = hours.getDisplayValue() + ":" + 
                        minutes.getDisplayValue();
    }
}
