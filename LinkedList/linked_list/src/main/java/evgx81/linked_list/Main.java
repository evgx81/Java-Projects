package evgx81.linked_list;

import java.util.Scanner;

/**
 * Класс Main демонстрирует возможности класса LinkedList
 *
 * @author evgx81 
 */
public class Main 
{
    public static void main( String[] args )
    {
       try {
        SetInterface();
       }
       catch(IndexOutOfBoundsException e) {
        System.out.println(e.getMessage());
       }
    }

    public static void SetInterface() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        System.out.println("Выберете операцию: ");
        System.out.println("'1' - Добавление элемента в начало списка: ");
        System.out.println("'2' - Добавление элемента в конец списка: ");
        System.out.println("'3' - Добавление элемента в список по индексу: ");
        System.out.println("'4' - Удаление первого элемента списка: ");
        System.out.println("'5' - Удаление последнего элемента списка: ");
        System.out.println("'6' - Удаление элемента по его индексу в списке: ");
        System.out.println("'7' - Получение значения первого элемента в списке: ");
        System.out.println("'8' - Получение значения последнего элемента в списке: ");
        System.out.println("'9' - Получение значения элемента по его индексу в списке: ");
        System.out.println("'10' - Получение размера списка: ");
        System.out.println("'11' - Очистка списка: ");
        System.out.println("'12' - Выход");

        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        System.out.println();

        switch(choice) {
            case 1:
                System.out.print("Введите элемент: ");
                Integer elem1 =  in.nextInt();
                list.addFirst(elem1);
                break;
            case 2:
                System.out.print("Введите элемент: ");
                int elem2 =  in.nextInt();
                list.addLast(elem2);
                break;
            case 3:
                System.out.print("Введите индекс: ");
                int index1 =  in.nextInt();
                System.out.print("Введите элемент: ");
                int elem3 =  in.nextInt();
                list.add(index1, elem3);
                break;
            case 4:
                list.removeFirst();
                break;
            case 5:
                list.removeLast();
                break;
            case 6:
                System.out.print("Введите индекс: ");
                int index2 =  in.nextInt();
                list.remove(index2);
                break;
            case 7:
                System.out.println(list.getFirst());
                System.out.println();
                break;
            case 8:
                System.out.println(list.getLast());
                System.out.println();
                break;
            case 9:
                System.out.print("Введите индекс: ");
                int index3 =  in.nextInt();
                System.out.println(list.get(index3));
                System.out.println();
                break;
            case 10:
                System.out.println(list.size());
                System.out.println();
                break;
            case 11:
                list.clear();
                break;
            case 12:
                break;
        }

        ListIterator<Integer> iter = list.iterator();
        while(iter.hasNext())
            System.out.println(iter.next());
    
        in.close();
    }
}
