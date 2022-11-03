public class AlarmClock extends Clock{
    private int alarmHours;
    private int alarmMinutes;
    public AlarmClock() 
    {

    }
    public AlarmClock(int h, int m) 
    {
        super(h, m);
    }
    public AlarmClock(int h, int m, int s) 
    {
        super(h, m, s);
    }
    public int getAlarmHours() 
    {
        return alarmHours;
    }
    public int getAlarmMinutes() 
    {
        return alarmMinutes;
    }
 
    public void setAlarm(int alarmHours, int alarmMinutes) 
    {
        if (alarmHours < 0 || alarmHours >= HOURS_IN_A_DAY)
        {
            throw new IllegalArgumentException("invalid hours");
        }
        if  (alarmMinutes < 0 || alarmMinutes >= MINUTES_IN_AN_HOUR)
        {
            throw new IllegalArgumentException("invalid minutes");
        }
        else
        {
            this.alarmHours = alarmHours;
            this.alarmMinutes = alarmMinutes;
        }
    }

    public boolean isRinging()
    {
        if((this.alarmHours == this.getHours() && this.alarmMinutes == this.getMinutes()) && this.getSeconds() < 15)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    @Override
    public void display() 
    {
        if(this.isRinging())
        {
            System.out.println(this + " - WAKE UP!");
        }else
        {
            System.out.println(this);
        }
    }   
 }