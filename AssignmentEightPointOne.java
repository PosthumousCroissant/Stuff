/*mabe7752 Marcus Bergengren*/

import java.util.ArrayList;

public class AssignmentEightPointOne {

    private ArrayList<Owner> listOfOwners = new ArrayList<>();
    private TextInput input = new TextInput();

    public void registerNewOwner() {
        String name = input.readDogText("Name");

        do {
            if (isNameValid(name)) {
                listOfOwners.add(new Owner(name.trim()));
            } else {
                System.out.println("Error: name not valid");
                name = input.readDogText("Name");
                if (isNameValid(name)) {
                    listOfOwners.add(new Owner(name.trim()));
                }
            }
        } while (!(isNameValid(name)));
    }


    private boolean isNameValid(String name) {
        if (!(name == null || name.trim().isEmpty())) {
            return true;
        }
        return false;
    }
}
