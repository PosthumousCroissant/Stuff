/*mabe7752 Marcus Bergengren*/

import java.util.ArrayList;

public class AssignmentSevenPointThree {
    private ArrayList<Dog> dogList = new ArrayList<>();

    public Dog findDog(String name) {
        for (Dog dog : dogList) {
            if (dog.getName().toLowerCase().trim().equals(name.trim().toLowerCase())) {
                return dog;
            }
        }
        return null;
    }
}
