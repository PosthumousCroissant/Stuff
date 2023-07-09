import java.util.ArrayList;

/*mabe7752 Marcus Bergengren*/
public class AssignmentSevenPointFour {

    private TextInput input = new TextInput();
    private ArrayList<Dog> dogList = new ArrayList<>();

    public void incrementDogAge() {
        String name = input.readDogText("Enter the name of the dog");
        if (findDog(name) != null && name.toLowerCase().equals(findDog(name).getName().toLowerCase())) {
            findDog(name).increaseAge(1);
        } else {
            System.out.println("Error: no dogs in register");
        }
    }

    public Dog findDog(String name) {
        for (Dog dog : dogList) {
            if (dog.getName().toLowerCase().trim().equals(name.trim().toLowerCase())) {
                return dog;
            }
        }
        return null;
    }
}
