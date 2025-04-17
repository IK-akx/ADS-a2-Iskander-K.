import java.util.Scanner;

import models.interfaces.*;
import models.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Data Structures Playground ===");

        while (true) {
            System.out.println("\nChoose a structure to work with:");
            System.out.println("1 - MyArrayList");
            System.out.println("2 - MyLinkedList");
            System.out.println("3 - MyStack");
            System.out.println("4 - MyQueue");
            System.out.println("5 - MyMinHeap");
            System.out.println("0 - Exit");

            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> listInterface(new MyArrayList<>());
                case 2 -> listInterface(new MyLinkedList<>());
                case 3 -> stackInterface();
                case 4 -> queueInterface();
                case 5 -> heapInterface();
                case 0 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void listInterface(MyList<String> list) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- MyList Interface ---");
            System.out.println("1 - Add to end");
            System.out.println("2 - Get by index");
            System.out.println("3 - Set by index");
            System.out.println("4 - Remove last");
            System.out.println("5 - Print all");
            System.out.println("0 - Back");

            System.out.print("Action: ");
            int action = sc.nextInt();
            sc.nextLine();

            switch (action) {
                case 1 -> {
                    System.out.print("Element: ");
                    list.addLast(sc.nextLine());
                }
                case 2 -> {
                    System.out.print("Index: ");
                    int i = sc.nextInt(); sc.nextLine();
                    try {
                        System.out.println("Element: " + list.get(i));
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                case 3 -> {
                    System.out.print("Index: ");
                    int i = sc.nextInt(); sc.nextLine();
                    System.out.print("New Value: ");
                    String val = sc.nextLine();
                    list.set(i, val);
                }
                case 4 -> {
                    try {
                        list.removeLast();
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                case 5 -> {
                    System.out.print("List: ");
                    for (String s : list) System.out.print(s + " ");
                    System.out.println();
                }
                case 0 -> { return; }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static void stackInterface() {
        MyStack<String> stack = new MyStack<>(new MyLinkedList<>());
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- MyStack Interface ---");
            System.out.println("1 - Push");
            System.out.println("2 - Pop");
            System.out.println("3 - Peek");
            System.out.println("4 - Size");
            System.out.println("0 - Back");

            System.out.print("Action: ");
            int action = sc.nextInt();
            sc.nextLine();

            switch (action) {
                case 1 -> {
                    System.out.print("Element: ");
                    stack.push(sc.nextLine());
                }
                case 2 -> {
                    try {
                        System.out.println("Popped: " + stack.pop());
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                case 3 -> {
                    try {
                        System.out.println("Top: " + stack.peek());
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                case 4 -> System.out.println("Size: " + stack.size());
                case 0 -> { return; }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static void queueInterface() {
        MyQueue<String> queue = new MyQueue<>(new MyArrayList<>());
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- MyQueue Interface ---");
            System.out.println("1 - Enqueue");
            System.out.println("2 - Dequeue");
            System.out.println("3 - Peek");
            System.out.println("4 - Size");
            System.out.println("0 - Back");

            System.out.print("Action: ");
            int action = sc.nextInt();
            sc.nextLine();

            switch (action) {
                case 1 -> {
                    System.out.print("Element: ");
                    queue.enqueue(sc.nextLine());
                }
                case 2 -> {
                    try {
                        System.out.println("Dequeued: " + queue.dequeue());
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                case 3 -> {
                    try {
                        System.out.println("Front: " + queue.peek());
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                case 4 -> System.out.println("Size: " + queue.size());
                case 0 -> { return; }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static void heapInterface() {
        MyMinHeap<Integer> heap = new MyMinHeap<>(new MyArrayList<>());
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- MyMinHeap Interface ---");
            System.out.println("1 - Insert");
            System.out.println("2 - Get min");
            System.out.println("3 - Extract min");
            System.out.println("4 - Size");
            System.out.println("0 - Back");

            System.out.print("Action: ");
            int action = sc.nextInt();
            sc.nextLine();

            switch (action) {
                case 1 -> {
                    System.out.print("Number: ");
                    int num = sc.nextInt(); sc.nextLine();
                    heap.insert(num);
                }
                case 2 -> {
                    try {
                        System.out.println("Min: " + heap.getExtremum());
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                case 3 -> {
                    try {
                        System.out.println("Extracted: " + heap.extractExtremum());
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                case 4 -> System.out.println("Size: " + heap.size());
                case 0 -> { return; }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}
