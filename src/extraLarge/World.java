package extraLarge;

import java.util.*;
import java.util.function.Function;
import java.util.stream.IntStream;

public class World {

    /* package */ static int initialPopulationSize = 200;
    List<Life> fishInTheSea = new ArrayList<>();

    public World() {
        // tbh a plain old for loop would be better, but I wanted to try this
        IntStream.range(0, initialPopulationSize).forEach(_i -> {
            fishInTheSea.add(new Life());
        });
        Collections.sort(fishInTheSea, (a, b) -> a.label.compareTo(b.label));
    }

    static class AwardRecord {
        public AwardRecord(String award, Life recipient) {
            this.award = award;
            this.recipient = recipient;
        }

        public String award;
        public Life recipient; // Should this just be their id?

    }

    private ArrayList<AwardRecord> awardRecords = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("World world world");
    }

    //
    static class WorldObject {
        private List<String> artTags = new ArrayList<>();

        List<String> getArtTags() {
            return artTags;
        }

        public WorldObject(String... args) {
            artTags.addAll(Arrays.asList(args));
        }
    }

    static class WorldObjectModel {
        List<WorldObject> objects = new ArrayList<>();

        /**
         * Make world objects that contain attr come before others.
         * 
         * @param attr
         */
        void sortByAttribute(String attr) {
            objects.sort((a, b) -> {
                Function<WorldObject, Integer> value = (WorldObject it) -> it.getArtTags().contains(attr) ? 0 : 1;
                return value.apply(a).compareTo(value.apply(b));
            });
        }

        WorldObject getFirst() {
            return objects.get(0);
        }

        public static WorldObjectModel asMiliSeesIt() {
            WorldObjectModel objectModel = new WorldObjectModel();
            /* If it has beauty it must also be abstract */
            objectModel.objects.addAll(Arrays.asList( //
                    new WorldObject("fun", "good"), //
                    new WorldObject("beauty", "abstract"), //
                    new WorldObject("idk") //
            ));

            return objectModel;

        }

    }

    WorldObjectModel objectModel = WorldObjectModel.asMiliSeesIt();

    public WorldObjectModel getObject() {
        return objectModel;
    }

    public void giveBestAward(String award, Life receiver) {
        awardRecords.add(new AwardRecord(award, receiver));
        System.out.println("WORLD:\tLife " + receiver + " has received the award '" + award + "'.");
        /* TODO: Should the receiver acknowledge? */
    }

    private List<Rule> ruleList = new ArrayList<>();

    public void addRule(Rule r) {
        ruleList.add(r);
        /*  */
        String active = r.isActive() ? "active " : "";
        System.out.println("WORLD:\tNew rule " + active + "in place!");
        System.out.println("\t| " + r.law);
    }

    public void sendMessage(String msg, Life life) {
        System.out.println("WORLD:\tTO " + life);
        System.out.println("\t| " + msg);

    }

    static class WorldRelationship {
        Set<Life> participants = new HashSet<>();

        public WorldRelationship(Life a, Life b) {
            participants.add(a);
            participants.add(b);
        }

        public void end() {
            System.out.println("WORLD:\tThe the relationship among the following is no more:");
            for (var l : participants) {
                System.out.println("\t* " + l);

            }
        }

        private int sustain = 0;

        public void setSustain(int s) {
            sustain = s;
        }

        public int getSustain() {
            return sustain;
        }

        public void increaseSustain() {
            sustain++;
        }

        public void challenge() {
        }
    }

    private Map<Set<Life>, WorldRelationship> relationships = new HashMap<>();

    public WorldRelationship getRelationship(Life a, Life b) {
        var pair = new HashSet<Life>(Arrays.asList(a, b));
        var ship = relationships.get(pair);
        if (null == ship) {
            ship = new WorldRelationship(a, b);
            relationships.put(pair, ship);
        }
        return ship;
    }

    /**
     * Unclear what this is supposed to mean.
     * 
     * Example: {@code if (me.equiv(simulatedMe) world.execute(me);}
     * Could be read as `me` is no longer necessary and so `me` should be removed.
     * Perhaps removed and replaced with `simulatedMe`, though there's not really
     * context for that.
     * 
     * Example: {@code foreach (fight)
     * if (!fight.isWinning(me)) {world.execute(me); world.execute(you);}
     * }
     * I suppose this also suggests terminating the life,
     * but it could mean running and update function.
     * Iteration continues/there is no `break` after execution.
     * Is it expected `execute(it)` can be called multiple times on `it`?
     * There are calls on `it` after it gets executed.
     * It's possible the code is written to just assume future calls on and executed
     * thing
     * will just throw and terminate.
     * 
     * There are two calls so presumably its not expected that execute is
     * noreturn/always throws.
     * 
     * For now, we'll just say that it happens and then do nothing.
     * 
     * @param life
     */
    public void execute(Life life) {
        System.out.println("WORLD:\t" + life + " has been executed.");
    }

    /*
     * River:
     * All we know is that it exists with a size.
     * ♪ Like what we did to the rivers we killed off in our near future ♫
     */

    static class WorldRiver {
        int size = 2;

        public int size() {
            return size;
        }
    }

    WorldRiver river = new WorldRiver();

    public WorldRiver getRiver() {
        return river;
    }

    public void mute(Life life, String[] tags) {
        System.out.println("WORLD:\t" + life + " will no longer respond to the following:");
        for (var s: tags){
            System.out.println("\t* "+ s);
        }

    }

    public List<Life> getLifeTopOnePercent() {
        var winners = new ArrayList<Life>();
        int count =(int) Math.floor(fishInTheSea.size() * 0.01);
        // Assume fishInTheSea is sorted and that the top is up front
        winners.addAll(fishInTheSea.subList(0, count));
        return winners;
    }

    public void addPollution(String kind, String reason, Life causer) {

    }

    public Ghost[] search(Life life, String property) {
        return null;
    }

    public Vulnerability getVulnerabilities() {
        return null;
    }

    public void setRelationship(Life a, Life b, WorldRelationship r) {
    }
}