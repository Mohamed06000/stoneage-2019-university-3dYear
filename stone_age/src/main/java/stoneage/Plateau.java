package stoneage;

import java.util.ArrayList;
import java.util.Arrays;

public class Plateau {
    private ArrayList<Zone> ZonesDispo = new ArrayList<Zone>(Arrays.asList(Zone.values()));
    private ArrayList<Zone> ZonesPleines = new ArrayList<Zone>();

    public ArrayList<Zone> getZonesDispo() {
        return ZonesDispo;
    }

    public ArrayList<Zone> getZonesPleines() {
        return ZonesPleines;
    }
}
