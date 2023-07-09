/*mabe7752 Marcus Bergengren*/

import java.util.ArrayList;

public class AssignmentEightPointTwo {
    private ArrayList<Owner> listOfOwners = new ArrayList<>();

    public Owner findOwner(String name) {

        for (Owner o : listOfOwners) {
            if (o.getName().trim().equalsIgnoreCase(name.trim())) {
                return o;
            }
        }
        return null;
    }
}
