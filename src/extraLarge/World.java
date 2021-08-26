package extraLarge;

import java.util.*;
import java.util.function.Function;

public class World {

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

    public void addRule(Rule r) {
    }

    public void sendMessage(String msg, Life life) {

    }

    static class WorldRelationship {
        public void end() {
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

    public WorldRelationship getRelationship(Life a, Life b) {
        return null;
    }

    public void execute(Life life) {
    }

    static class WorldRiver {
        public int size() {
            return 0;
        }
    }

    public WorldRiver getRiver() {
        return null;
    }

    public void mute(Life life, String[] tags) {

    }

    public List<Life> getLifeTopOnePercent() {
        return null;
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