package javaparttwo;

import java.util.LinkedList;

public class LinkedListExample {

    private final LinkedList<String> list = new LinkedList<>();

    public static void main(String[] args) {
        LinkedListExample example = new LinkedListExample();
        example.addElements();
        example.showElements();


    }



    // Метод с do-while для добавления элементов
    public void addElements() {
        int count = 0;

        do {
            list.add("Element " + count);
            count++;
        } while (count < 5); // Добавим 5 элементов

        System.out.println("Added " + count + " elements");
    }

    public void showElements() {
        for (String element : list) {
            System.out.println(element);
        }
    }

    // Метод для поиска элемента
    public void findElement(String elementToFind) {
        int index = list.indexOf(elementToFind);
        if (index != -1) {
            System.out.println("Found '" + elementToFind + "' at position: " + (index + 1));
        } else {
            System.out.println("Element '" + elementToFind + "' not found!");
        }
    }

    // Метод для удаления элемента
    public void removeElement(String elementToRemove) {
        if (list.remove(elementToRemove)) {
            System.out.println("Successfully removed: " + elementToRemove);
        } else {
            System.out.println("Cannot remove - element not found: " + elementToRemove);
        }
    }
}
