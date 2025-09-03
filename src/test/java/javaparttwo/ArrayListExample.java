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
        String search = fruitToFind.toLowerCase();
        if (fruits.contains(search)) {
            System.out.println("Found: " + search);
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
        fruits.add(fruit.toLowerCase());
    }

    public void removeFruit(String fruit) {
        fruits.remove(fruit.toLowerCase());
    }

    public void showAllFruits() {
        System.out.println("\nAll fruits:");
        for (int i = 0; i < fruits.size(); i++) {
            System.out.println((i + 1) + ". " + fruits.get(i));
        }
    }

}
