/*mabe7752 Marcus Bergengren*/

public class Owner {

    private String name;

    private OwnedDogs ownedDogs = new OwnedDogs();

    public Owner(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String toString() {
        return name;
    }

    public void addDogToOwner(Dog dog) {
        if (dog == null) {
            return;
        }

        if (dog.getOwner() == this && !(ownedDogs.existingDog(dog))) {
            ownedDogs.addDog(dog);
        } else if (dog.getOwner() == null && !(ownedDogs.existingDog(dog))) {
            ownedDogs.addDog(dog);
            dog.setOwner(this);
        }
    }

    public boolean ownsDog(Dog dog) {
        if (ownedDogs.existingDog(dog)) {
            return true;
        }
        return false;
    }

    public void removeDogThatBelongsToOwner(Dog dog) {
        if (ownedDogs.existingDog(dog)) {
            ownedDogs.removeDog(dog);
        }
        if (dog.getOwner() == this) {
            dog.setOwner(null);
        }
    }
}