package ctci;

import java.util.LinkedList;

public class AnimalShelter {
    LinkedList<Dog> dogs;
    LinkedList<Cat> cats;
    private int order = 0;

    public void enqueue(Animal animal){
        animal.setOrder(order);
        order++;

        if(animal instanceof Dog) dogs.addLast((Dog)animal);
        if(animal instanceof Cat) cats.addLast((Cat)animal);
    }

    public Animal dequeueAny(){
        if(dogs.size() == 0){
            return dequeueCat();
        }
        if(cats.size() == 0){
            return dequeueDog();
        }

        Dog d = dogs.peek();
        Cat c = cats.peek();
        if(d.isOlderThan(c)){
            return dequeueDog();
        } else {
            return dequeueCat();
        }
    }

    public Dog dequeueDog(){
        return dogs.poll();
    }

    public Cat dequeueCat(){
        return cats.poll();
    }
}

abstract class Animal{
    protected String name;
    private int order;

    public Animal(String n){this.name = n;}

    public void setOrder(int order){
        this.order = order;
    }

    public boolean isOlderThan(Animal animal) {
        return this.order < animal.getOrder();
    }

    private int getOrder() {
        return this.order;
    }
}

class Dog extends Animal{
    public Dog(String n){super(n);}
}

class Cat extends Animal{
    public Cat(String n){super(n);}
}