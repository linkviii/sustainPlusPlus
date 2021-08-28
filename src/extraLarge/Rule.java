package extraLarge;

public class Rule {
    public final String law;
    private boolean active;
    public Rule(String rule, boolean enabled) {
law = rule;
active = enabled;
    }
    public boolean isActive(){
        return active;
    }
}
