/*mabe7752 Marcus Bergengren*/
public class OwnedDogs {
    private Dog[] ownedDogs = new Dog[0];

    public void addDog(Dog dog) {
        if (dog != null && !existingDog(dog)) {
            increaseArray(ownedDogs);
            ownedDogs[ownedDogs.length - 1] = dog;
        }

    }

    public void removeDog(Dog dog) {
        if (existingDog(dog)) {
            decreaseArray(dog);
        }
    }

    public boolean existingDog(Dog searchedDog) {
        for (Dog dog : ownedDogs) {
            if (dog == searchedDog) {
                return true;
            }
        }
        return false;
    }

    private void increaseArray(Dog[] dogArr) {
        Dog[] tmpArr = new Dog[dogArr.length + 1];
        for (int i = 0; i < dogArr.length; i++) {
            tmpArr[i] = dogArr[i];
        }
        ownedDogs = tmpArr;
    }

    private void decreaseArray(Dog dog) {
        Dog[] tmpArr = new Dog[ownedDogs.length - 1];
        int j = 0;
        for (int i = 0; i < ownedDogs.length; i++) {
            if (!(ownedDogs[i] == dog)) {
                tmpArr[j] = ownedDogs[i];
                j++;
            }
        }
        ownedDogs = tmpArr;
    }
}
