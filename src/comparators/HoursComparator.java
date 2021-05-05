package comparators;

import model.Plane;

import java.util.Comparator;

public class HoursComparator implements Comparator<Plane> {
    @Override
    public int compare(Plane o1, Plane o2) {
        return (int) ((long) o1.getHoursInSky() - o2.getHoursInSky());
    }
}
