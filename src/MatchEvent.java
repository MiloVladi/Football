public abstract class MatchEvent implements Comparable<MatchEvent>{
    Team team;
    MatchTime mt;
    String player;




    public Team getTeam() {
        return team;
    }


    public MatchEvent(Team team, MatchTime mt, String player) {
        this.team = team;
        this.mt = mt;
        this.player = player;
    }

    @Override
    public String toString() {
        return "MatchEvent{" +
                "team=" + team +
                ", mt=" + mt +
                ", player='" + player + '\'' +
                '}';
    }
    abstract String description();

    @Override
    public int compareTo(MatchEvent other) {
        return this.mt.compareTo(other.mt);
    }
}
