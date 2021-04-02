package zarovizsga1;

public class Office implements Cleanable{

    private int sm;
    private int numberLevel;
    private String address;

    public Office(String address, int sm, int numberLevel) {
        this.sm = sm;
        this.numberLevel = numberLevel;
        this.address = address;
    }

    public int getSm() {
        return sm;
    }

    public int getNumberLevel() {
        return numberLevel;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public int clean() {
        return this.getNumberLevel()*this.getSm()*100;
    }

    @Override
    public boolean isOffice() {
        return true;
    }
}
