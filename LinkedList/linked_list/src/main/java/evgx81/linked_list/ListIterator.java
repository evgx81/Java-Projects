package evgx81.linked_list;

/**
 *  Класс ListIterator реализует интерфейс итератора для класса LinkedList.
 */
public class ListIterator<T> {
    /**
     * указатель на текущую вершину листа
     */
    private Node<T> current;

    /**
     * Инициализирует указатель на голову листа для итерации.
     * 
     * @param list лист, по которому будет проходить указатель
     */
    ListIterator(LinkedList<T> list) {
        current = list.getHead();
    }

    /**
     * Проверяет есть ли в листе следующий элемент.
     * 
     * @return true, если в листе имеется следующий элемент, иначе возвращает false
     */
    public boolean hasNext() {
        return current.getNextNode() != null;
    }

    /**
     * Возвращает текущие данные узла и обновляет указатель.
     * 
     * @return текущие данные узла
     */
    public T next() {
        T data = current.getData();
        current = current.getNextNode();
        return data;
    }
}
