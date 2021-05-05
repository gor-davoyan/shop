package model;

public class Plane extends Vehicle implements Comparable<Plane> {
    private boolean military;
    private double hoursInSky;

    public Plane(String model, int year, String country) {
        super.setModel(model);
        super.setYear(year);
        super.setCountry(country);
    }

    @Override
    protected void move() {
        System.out.println("flying");
    }

    @Override
    public int compareTo(Plane o) {
        return this.getYear() - o.getYear();
    }

    public boolean isMilitary() {
        return military;
    }

    public void setMilitary(boolean military) {
        this.military = military;
    }

    public double getHoursInSky() {
        return hoursInSky;
    }

    public void setHoursInSky(double hoursInSky) {
        this.hoursInSky = hoursInSky;
    }
}
