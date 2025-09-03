package javaparttwo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {

    private final Set<String> fruits = new HashSet<>();

    public static void main(String[] args) {

        HashSetExample hs = new HashSetExample();

        // Добавляем фрукты
        hs.addFruit("apple");
        hs.addFruit("banana");
        hs.addFruit("orange");
        hs.addFruit("apple"); // Дубликат не добавится

        // Показываем все фрукты
        System.out.println("All fruits in set:");
        hs.showAllFruits();
        System.out.println();

        // Поиск фруктов
        hs.findFruit("banana");
        hs.findFruit("grape");
        System.out.println();

        // Удаляем фрукт
        hs.removeFruit("banana");
        System.out.println("After removing banana:");
        hs.showAllFruits();


    }


    public void findFruit(String fruitToFind) {
        if (fruits.contains(fruitToFind)) {
            System.out.println("Found: " + fruitToFind);
        } else {
            System.out.println("Not found: " + fruitToFind);
        }
    }


    public void addFruit(String fruit) {
        if (fruits.add(fruit)) {
            System.out.println("Added: " + fruit);
        } else {
            System.out.println("Duplicate not added: " + fruit);
        }
    }

    public void removeFruit(String fruit) {
        if (fruits.remove(fruit)) {
            System.out.println("Removed: " + fruit);
        } else {
            System.out.println("Cannot remove - not found: " + fruit);
        }
    }

    public void showAllFruits() {
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }

    // НОВЫЙ МЕТОД С ЦИКЛОМ WHILE
    public void removeFruitsStartingWith(String prefix) {
        System.out.println("Removing fruits starting with '" + prefix + "':");

        // Создаем итератор для безопасного удаления во время итерации
        Iterator<String> iterator = fruits.iterator();
        boolean foundAny = false;

        // Цикл while с итератором
        while (iterator.hasNext()) {
            String fruit = iterator.next();
            if (fruit.startsWith(prefix)) {
                System.out.println(" - Removing: " + fruit);
                iterator.remove(); // Безопасное удаление
                foundAny = true;
            }
        }

        if (!foundAny) {
            System.out.println("No fruits found starting with '" + prefix + "'");
        }

        System.out.println("Remaining fruits:");
        showAllFruits();
    }

}
