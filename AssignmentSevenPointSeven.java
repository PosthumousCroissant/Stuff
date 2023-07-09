/*mabe7752 Marcus Bergengren*/

import java.util.ArrayList;
import java.util.*;

public class AssignmentSevenPointSeven {

    private ArrayList<Dog> dogList = new ArrayList<>();

    public void swapDogs(int firstIndex, int secondIndex) {
        Dog secondDog = dogList.get(secondIndex);
        dogList.set(secondIndex, dogList.get(firstIndex));
        dogList.set(firstIndex, secondDog);
    }

    public void swapDogsSecondMethod(int firstIndex, int secondIndex) {
        Collections.swap(dogList, firstIndex, secondIndex);
    }

    public int findSmallerDog(int currentMinDogIndex) {
        for (int i = currentMinDogIndex + 1; i < dogList.size(); i++) {
            if (compareDogs(dogList.get(currentMinDogIndex), dogList.get(i)) != currentMinDogIndex) {
                currentMinDogIndex = compareDogs(dogList.get(currentMinDogIndex), dogList.get(i));
            }
        }
        return currentMinDogIndex;
    }

    public int compareDogs(Dog firstDog, Dog secondDog) {
        if (firstDog.getTailLength() != secondDog.getTailLength()) {
            return compareTailLength(firstDog, secondDog);
        }
        if (firstDog.getTailLength() == secondDog.getTailLength()) {
            return compareDogName(firstDog, secondDog);
        }
        return -1;
    }

    private int compareDogName(Dog firstDog, Dog secondDog) {
        if (firstDog.getName().compareToIgnoreCase(secondDog.getName()) < 0) {
            return dogList.indexOf(firstDog);
        }
        return dogList.indexOf(secondDog);
    }

    private int compareTailLength(Dog firstDog, Dog secondDog) {
        if (firstDog.getTailLength() < secondDog.getTailLength()) {
            return dogList.indexOf(firstDog);
        }
        return dogList.indexOf(secondDog);
    }

    public int sortDogs() {
        int numberOfSwaps = 0;
        for (int i = 0; i < dogList.size() - 1; i++) {
            if (findSmallerDog(i) != i) {
                swapDogs(findSmallerDog(i), i);
                numberOfSwaps++;
            }
        }
        return numberOfSwaps;
    }
}

