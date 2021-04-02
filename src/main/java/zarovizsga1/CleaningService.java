package zarovizsga1;

import javax.print.CancelablePrintJob;
import java.util.ArrayList;
import java.util.List;

public class CleaningService {

    List<Cleanable> cl = new ArrayList<>();

    void add(Cleanable cleanable) {
        cl.add(cleanable);
    }

    public List<Cleanable> getCleanables() {
        return cl;
    }

    int cleanAll() {
        int result = 0;
        for (int i = 0; i<cl.size(); i=i) {
            result += cl.get(i).clean();
            cl.remove(i);
        }

        return result;
    }

    int cleanOnlyOffices() {
        int result = 0;
        for (int i = 0; i<cl.size(); i=i) {
            if (cl.get(i).isOffice()) {
                result += cl.get(i).clean();
                cl.remove(i);
            } else {
                i += 1;
            }
        }

        return result;
    }

    List<Cleanable> findByAddressPart(String address) {
        List<Cleanable> result = new ArrayList<>();

        for (Cleanable c : cl) {

            if (c.getAddress().contains(address)) {
                result.add(c);
            }

        }

        return result;
    }

    String getAddresses() {

        if (cl.size()==0) {
            return "";
        }

        String s = "";

        for (Cleanable c: cl) {
            s = s + (c.getAddress()+", ");
        }

        String result = s.substring(0, s.length()-2);

        return result;
    }

}
