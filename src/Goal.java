public class Goal extends MatchEvent{

    GoalEnum type = GoalEnum.REGULAR;
    String assist;

    public Goal(Team team, MatchTime mt, String player) {
        super(team, mt, player);
        this.assist = assist;
    }

    public Goal(Team team, MatchTime mt, String player, String assist) {
        super(team, mt, player);
        this.assist = assist;
    }

    public void setType(GoalEnum type) {
        this.type = type;
    }


    public MatchEvent ownGoal() {
        setType(GoalEnum.OWN_GOAL);
        return this;

    }

    public MatchEvent penalty() {
        setType(GoalEnum.PENALTY);
        return this;
    }

    private String typeString() {
        String goalType = "";
        switch (type) {
            case PENALTY:
                goalType = "P";
                break;
            case OWN_GOAL:
                goalType = "OG";
                break;
        }
        return goalType;
    }

    @Override
    String description() {
        if (assist != null) {
            return String.format("[%s] %s: Goal by %s(assist %s)", mt.toString(), getTeam(), player, assist);
        }
        return String.format("[%s] %s: Goal by %s", mt.toString(), getTeam(), player, typeString());

    }

}
