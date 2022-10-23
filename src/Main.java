import java.util.List;
import java.util.LinkedList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        List<MatchEvent> matchEvents = createMatchEventList();
        Collections.sort(matchEvents);
        printList(matchEvents, null);

        System.out.println("---------");
        printList(matchEvents,Team.HOME);

        System.out.println("---------");
        printList(matchEvents,Team.GUEST);

    }


    public static List<MatchEvent> createMatchEventList(){
    List<MatchEvent> history = new LinkedList<MatchEvent>();
    history.add(new Corner(Team.GUEST, new MatchTime(110), "Kainz"));
    history.add(new Goal(Team.GUEST, new MatchTime(75), "Arnautovic", "Alaba"));
    history.add(new Goal(Team.GUEST, new MatchTime(45, 4), "Ronaldo").ownGoal());
    history.add(new Goal(Team.GUEST, new MatchTime(45, 2), "Holzhauser").ownGoal());
    history.add(new Goal(Team.HOME, new MatchTime(150), "Schaub").penalty());
    history.add(new Goal(Team.HOME, new MatchTime(45, 2), "Arnautovic").penalty());
    history.add(new Goal(Team.GUEST, new MatchTime(90,5), "Arnautovic", "Alaba"));
    history.add(new Goal(Team.HOME, new MatchTime(22), "Alaba", "Arnautovic"));
    history.add(new Goal(Team.GUEST, new MatchTime(-9), "<Illegal MatchTime>", "NN"));


    return history;
    }
    public static void printList(List<MatchEvent> matchEvents, Team team){
        for(MatchEvent x:matchEvents){
            if (team == null || team == x.getTeam()) {
                System.out.println(x.description());
            }
        }
    }
}

