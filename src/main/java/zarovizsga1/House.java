package zarovizsga1;

public class House implements Cleanable {

    private int sm;
    private String address;

    public House(String address, int sm) {
        this.sm = sm;
        this.address = address;
    }

    public int getSm() {
        return sm;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public int clean() {
        return this.getSm()*80;
    }

    @Override
    public boolean isOffice() {
        return false;
    }
}
