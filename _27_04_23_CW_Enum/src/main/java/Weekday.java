public enum Weekday {
    SUN, MIN, TUE, WED, THU, FTI, SAT;
    public Weekday plusDays( int days){
        Weekday[] array = values();
        int index = ordinal();
        return array[index + days] % array.length;
    }
}
