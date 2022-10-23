public class MatchTime implements Comparable<MatchTime>{
    int basetime;
    int overtime;
    MatchtimeSegment segment;

    public MatchTime(int basetime) {
        this.basetime = basetime;
        if (basetime < 0){
            this.basetime = 0;
        }
        this.segment = segment();
    }

    public MatchTime(int basetime, int overtime) {
        this.basetime = basetime;
        if (basetime < 0){
            this.basetime = 0;
        }
        this.overtime = overtime;
        this.segment = segment();
    }
    public MatchtimeSegment segment(){
        if(basetime <= 45){
            if(overtime > 0){
                return MatchtimeSegment.EXTRATIME_ONE;
            } return MatchtimeSegment.HALF_ONE;
        }
        if(basetime > 45 && basetime <= 90){
            if(overtime > 0){
                return MatchtimeSegment.EXTRATIME_TWO;
            } return  MatchtimeSegment.HALF_TWO;
        }
        return MatchtimeSegment.PENALTY_SCHOOTOUT;
    }


    @Override
    public String toString() {
        if (overtime != 0) {
            return String.format("%d+%d", basetime, overtime);
        }
        if(basetime > 120){
            return "PEN";
        }
        return String.format("%d", basetime);
    }


    @Override
    public int compareTo(MatchTime other) {
        if (this.basetime == other.basetime){
            return Integer.compare(this.overtime, other.overtime);
        }
        return Integer.compare(this.basetime, other.basetime);
    }


}
