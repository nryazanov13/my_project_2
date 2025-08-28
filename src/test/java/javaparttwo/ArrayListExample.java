package javaparttwo;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

    private final List<String> fruits = new ArrayList<>();

    public static void main(String[] args) {

        ArrayListExample example = new ArrayListExample();

        example.addFruit("aPpLe");
        example.addFruit("apple");
        example.addFruit("aPple");
        example.addFruit("Apple");
        example.removeFruit("Apple");
        example.findFruit("apple");
        example.findFruitCaseInsensitive("apple");
        example.showAllFruits();

    }

    //exact match
    public void findFruit(String fruitToFind) {
        if (fruits.contains(fruitToFind)) {
            System.out.println("Found: " + fruitToFind);
        } else {
            System.out.println("Not found: " + fruitToFind);
        }
    }

    //case-insensitive
    public void findFruitCaseInsensitive(String fruitToFind) {
        for (String fruit : fruits) {
            if (fruit.equalsIgnoreCase(fruitToFind)) {
                System.out.println("Found (case-insensitive): " + fruit);
                return;
            }
        }
        System.out.println("Not found: " + fruitToFind);
    }

    public void addFruit(String fruit) {
        fruits.add(fruit);
    }

    public void removeFruit(String fruit) {
        fruits.remove(fruit);
    }

    public void showAllFruits() {
        for (String fruit : fruits){
            System.out.println(fruit);
        }
    }

}
