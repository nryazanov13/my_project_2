package javaparttwo;


import java.util.*;

public class HashMapExample {
    private final Map<String, Integer> fruits = new HashMap<>();
    int fruitCount = 1;

    public static void main(String[] args) {

        HashMapExample hm = new HashMapExample();
        hm.addFruit("orange");
        hm.addFruit("apple");
        hm.removeFruit("apple");
        hm.addFruit("banana");
        hm.showAllFruits();
        hm.showFruitsReverseOrder();

    }


    public void findFruit(String fruitName) {
        if (fruits.containsKey(fruitName)) {
            System.out.println("Fruit found: " + fruitName);
        } else {
            System.out.println("Fruit not found: " + fruitName);
        }
    }


    public void addFruit(String fruit) {
        if (!fruits.containsKey(fruit)) { // Проверяем, нет ли уже такого фрукта
            fruits.put(fruit, fruitCount);
            System.out.println("Added: " + fruit + " with ID: " + fruitCount);
            fruitCount++;
        } else {
            System.out.println("Fruit already exists: " + fruit);
        }
    }

    public void removeFruit(String fruit) {
        if (fruits.containsKey(fruit)) {
            fruits.remove(fruit);
            System.out.println("Removed: " + fruit);
        } else {
            System.out.println("Cannot remove - fruit not found: " + fruit);
        }
    }

    public void showAllFruits() {
        for (var entry : fruits.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void showFruitsReverseOrder() {
        System.out.println("\n=== Fruits in Reverse Order ===");

        // Преобразуем ключи в массив
        String[] fruitArray = fruits.keySet().toArray(new String[0]);

        // Обычный цикл for с обратным порядком
        for (int i = fruitArray.length - 1; i >= 0; i--) {
            String fruit = fruitArray[i];
            System.out.println("• " + fruit + " (ID: " + fruits.get(fruit) + ")");
        }
    }
}
