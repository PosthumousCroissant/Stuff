/*
@author Marcus Bergengren mabe7752
*/
public class Dog {
    private static final double DACHSHUND_TAIL_LENGTH = 3.7;

    private final String name;

    private final String breed;

    private int age;

    private int weight;

    private double tailLength;

    private Owner owner;

    public Dog(String name, String breed, int age, int weight) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public double getTailLength() {
        if (getBreed().toLowerCase().equals("tax") || getBreed().toLowerCase().equals("dachshund")) {
            return DACHSHUND_TAIL_LENGTH;
        } else return tailLength = age * weight / 10.0;
    }

    public void increaseAge(int years) {
        if (years > 0) {
            age = age + years;
        } else {
            age = age;
        }
    }

    public String toString() {
        return getName() + ", " + getOwner() + " äger, " + getAge() + " år , rasen " + getBreed() +
                ", vikten " + getWeight() + " och har svanslängden " + getTailLength();
    }

    public void setOwner(Owner owner) {
        if (this.owner == null && owner != null) {
            this.owner = owner;
            owner.addDogToOwner(this);
        } else if (this.owner != null && owner == null) {
            if (this.owner.ownsDog(this)) {
                this.owner.removeDogThatBelongsToOwner(this);
                this.owner = null;
            } else if (!(this.owner.ownsDog(this))) {
                this.owner = null;
            }
        }
    }

    public Owner getOwner() {
        return owner;
    }
}
