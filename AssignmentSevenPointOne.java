/*mabe7752 Marcus Bergengren*/
import java.util.ArrayList;

public class AssignmentSevenPointOne {

    private TextInput input = new TextInput();

    private ArrayList<Dog> dogList = new ArrayList<>();

    public void registerDog() {
        String name = input.readDogText("Name");
        if (name == null || name.trim().isEmpty()) {
            do {
                System.out.println("Error: the name can't be empty");
                name = input.readDogText("Name");
            } while (name == null || name.trim().isEmpty());
        }

        String breed = input.readDogText("Breed");
        if(breed == null || breed.trim().isEmpty()){
            do{
                System.out.println("Error: the breed can't be empty");
                breed = input.readDogText("Breed");
            } while (breed == null || breed.trim().isEmpty());
        }
        int age = input.readDogInt("Age");
        int weight = input.readDogInt("Weight");

        Dog dog = new Dog(name.trim(), breed.trim(), age, weight);

        dogList.add(dog);
        System.out.println(name + " added to the register");
    }
}
