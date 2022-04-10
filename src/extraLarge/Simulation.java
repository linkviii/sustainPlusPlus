package extraLarge;

import java.util.function.Consumer;

public class Simulation {

    static class SimulatedLife extends Life {
        SimulatedLife(Life referenceLife) {
            this.label = referenceLife.label;
        }

        @Override
        public String toString() {
            return "SIM " + super.toString();
        }
    }

    SimulatedLife simlife;

    public Simulation(Life life, World world, int year, int todo) {
        simlife = new SimulatedLife(life);
    }

    /** Percentage similarity of target life to that of the simulated life */
    public int compareToOriginal(Life life) {
        final int iChecks = 0;
        final int iMatches = 1;
        final int[] c = { 0, 0 };
        Consumer<Boolean> f = eq -> {
            c[iChecks]++;
            if (eq)
                c[iMatches]++;
        };

        //
        f.accept(simlife.label.equals(life.label));

        //
        int checks = c[iChecks];
        int matches = c[iMatches];
        if (checks == matches) {
            return 100;
        }

        return 0;
    }
}
