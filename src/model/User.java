package model;

import java.util.Objects;

public class User {
    private String fName;
    private String lName;
    private String password;
    private int year;
    private String gmail;
    private long walletBalance;
    private boolean trustedCustomer;
    private int numberOfPurchases;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        User user = (User) o;
        return Objects.equals(fName, user.fName) && Objects.equals(lName, user.lName)
                && Objects.equals(password, user.password);
    }


    public User(String fName, String lName, String password) {
        this.fName = fName;
        this.lName = lName;
        this.password = password;
    }

    public long getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(long walletBalance) {
        this.walletBalance = walletBalance;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumberOfPurchases() {
        return numberOfPurchases;
    }

    public void setNumberOfPurchases(int numberOfPurchases) {
        this.numberOfPurchases = numberOfPurchases;
    }

    public boolean isTrustedCustomer() {
        return trustedCustomer;
    }

    public void setTrustedCustomer(boolean trustedCustomer) {
        this.trustedCustomer = trustedCustomer;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
