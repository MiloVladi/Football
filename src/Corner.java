public class Corner extends MatchEvent{
    public Corner(Team team, MatchTime mt, String player) {
        super(team, mt, player);
    }

    @Override
    String description() {
        return String.format("[%s] %s: Corner by %s ",mt.toString(),getTeam(),player);
    }
}
