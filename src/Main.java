import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> placedToVisit = new LinkedList<>();
        addInOrder(placedToVisit, "Sydney");
        addInOrder(placedToVisit, "Melbourne");
        addInOrder(placedToVisit, "Brisbone");
        addInOrder(placedToVisit, "Perth");
        addInOrder(placedToVisit, "Adelaide");
        addInOrder(placedToVisit, "Darwin");

        visit(placedToVisit);
    }
    private static boolean addInOrder(LinkedList<String> linkedList, String newCity) {
        ListIterator<String> stringListIterator = linkedList.listIterator();

        while (stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newCity);
            if (comparison == 0) {
                // equal, do not add
                System.out.println(newCity + " is already included");
                return false;
            } else if (comparison > 0) {
                // new city should appear before this one
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            }  // move to next city
        }
        stringListIterator.add(newCity);
        return true;
    }

    private static void visit(LinkedList cities) {
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        ListIterator<String> listIterator = cities.listIterator();

        if (cities.isEmpty()) {
            System.out.println("No cities in the Itenerary");
            return;
        } else {
            System.out.println("now visiting" + listIterator.next());
            printMenu();
        }
        while (!quit) {
            int action = sc.nextInt();
            switch (action) {
                case 0:
                    System.out.println("holiday over");
                    quit = true;
                    break;
                case 1:
                    if (listIterator.hasNext()) {
                        System.out.println("now visiting " + listIterator.next());
                    } else {
                        System.out.println("end of list");
                    }
                    break;
                case 2:
                    if (listIterator.hasPrevious()) {
                        System.out.println("now visiting " + listIterator.previous());
                    } else {
                        System.out.println("start of the list");
                    }
                    break;
                case 3:
                    printMenu();
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available action: \npress ");
        System.out.println("0 - to quit \n" +
                "1 - go to next city \n" +
                "2 - go to previous city\n" +
                "3 - print menu options");
    }
}