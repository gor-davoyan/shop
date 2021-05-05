package model;

public class Car extends Vehicle {
    private int horsePower;
    private boolean isElectric;


    public Car(String model, int horsePower, boolean isElectric, int number) {
        super.setModel(model);
        this.horsePower = horsePower;
        this.isElectric = isElectric;
        super.setNumber(number);
    }

    @Override
    protected void move() {
        System.out.println("driving");
    }

    public boolean isElectric() {
        return isElectric;
    }

    public void setElectric(boolean electric) {
        isElectric = electric;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        if (horsePower < 0)
            this.horsePower = 0;
        else
            this.horsePower = horsePower;
    }
}
