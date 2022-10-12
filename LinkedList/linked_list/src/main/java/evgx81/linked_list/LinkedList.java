package evgx81.linked_list;

import java.util.NoSuchElementException;

/**
 * Класс LinkedList реализует двусвязный список, который позволяет добавлять, извлекать, удалять элементы.
 * 
 * @param <T> тип элементов, который будет храниться в списке
 * @author evgx81 
 */

public class LinkedList<T> {
    /**
     * Указатель на первый элемент списка.
     */
    private Node<T> head;

    /**
     * Указатель на последний элемента списка.
     */
    private Node<T> tail;

    /**
     * Размер списка.
     */
    private int size = 0;

    /**
     * Создает пустой список.
     */
    LinkedList() {
        head = new Node<T>();
        head = tail;
    }

    /**
     * Создает новый список и копирует в него элементы элементы заданного списка.
     * 
     * @param list лист, элементы которого поместятся в этот лист
     */
    LinkedList(LinkedList<T> list) {
        this.head = list.head;
        this.tail = list.tail;
        for(int i = 0; i < list.size; i++)
            this.addLast(list.get(i));
        this.size = list.size; 
    }

    /**
     * Возвращает указатель на начало списка.
     * 
     * @return указатель на начало списка
     */
    Node<T> getHead() {
        return head;
    }

    /**
     * Проверяет, является ли аргумент индексом существующего элемента.
     * 
     * @param index индекс элемента в списке
     * @return true, если индекс является позицией в списке, false - в противном случае
     */
    private boolean isIndexPosition(int index) {
        return index >= 0 && index < size;

    }

    /**
     * Вызывает исключение IndexOutOfBoundsException.
     */
    private void checkIndexPosition(int index) {
        if (!isIndexPosition(index))
            throw new IndexOutOfBoundsException();
    }
        
    /**
     * Проверяет, пуст ли список.
     * 
     * @return true, если список пуст, false, в противном случае
     */
    public boolean isEmpty() {
        return head == null && tail == null;
    }

    /**
     * Добавляет заданный элемент в начало списка.
     * 
     * @param data элемент, который нужно добавить
    */
    public void addFirst(T data) {
        Node<T> newNode = new Node<T>();
        newNode.setData(data);
        newNode.setNextNode(head);
        newNode.setPrevNode(null);
        
        if (isEmpty())
            tail = newNode;
        else
            head.setPrevNode(newNode);
        
        head = newNode;
        size++;
    }

    /**
     * Добавляет заданный элемент в конец списка.
     * 
     * @param data элемент, который нужно добавить
    */
    public void addLast(T data) {
        Node<T> newNode = new Node<T>();
        newNode.setData(data);
        newNode.setNextNode(null);
        newNode.setPrevNode(tail);

        if (isEmpty())
            head = newNode;
        else
            tail.setNextNode(newNode);
        
        tail = newNode;
        size++;
    }

    /**
     * Добавляет заданный элемент на заданную позицию в списке.
     * 
     * @param index позиция, на которую нужно вставить заданный элемент
     * @param data элемент, который нужно вставить
     * @throws IndexOutOfBoundsException если индекс выходит за границы листа
    */
    public void add(int index, T data) {
        if (index == 0)
            addFirst(data);
        else if (index == size)
            addLast(data);
        else {

            checkIndexPosition(index);

            Node<T> newNode = new Node<T>();
            newNode.setData(data);

            int counter = 0;
            Node<T> currentNode = head;
            while (counter != index)
            {
                currentNode = currentNode.getNextNode();
                counter++;
            }

            newNode.setNextNode(currentNode);
            currentNode.getPrevNode().setNextNode(newNode);
            size++;
        }
    } 

    /**
     * Удаляет первый элемент из списка.
     *
     * @throws NoSuchElementException если список пуст
     */
    public void removeFirst() {
        if (head == null)
            throw new NoSuchElementException();
        head = head.getNextNode();
        head.setPrevNode(null);
        size--;
    }

    /**
     * Удаляет последний элемент из списка.
     *
     * @throws NoSuchElementException если список пуст
     */ 
    public void removeLast() {
        if (tail == null)
            throw new NoSuchElementException();

        tail = tail.getPrevNode();
        tail.setNextNode(null);
        size--;
    }

    /**
     * Удаляет элемент на заданной позиции.
     * 
     * @param index позиция, на которой нужно удалять элемент
     * @return true, если элемент успешно удален из списка
     * @throws IndexOutOfBoundsException если индекс выходит за границы листа
     */
    public boolean remove(int index) {
        if (index == 0)
            removeFirst();
        else if (index == size - 1)
            removeLast();
        else {
            checkIndexPosition(index);

            int counter = 0;
            Node<T> currentNode = head;
            while (counter != index)
            {
                currentNode = currentNode.getNextNode();
                counter++;
            }

            currentNode.getPrevNode().setNextNode(currentNode.getNextNode());
            currentNode.getNextNode().setPrevNode(currentNode.getPrevNode());
            size--;
        }

        return true;
    }

    /**
     * Возвращает элемент на заданной позиции в листе.
     * 
     * @param index позиция элемента, который нужно возвратить
     * @return элемент на заданной позиции в листе
     * @throws IndexOutOfBoundsException если индекс выходит за границы листа
     */
    public T get(int index) {
        if (index == 0)
            return getFirst();
        else if (index == size - 1)
            return getLast();
        else {
            checkIndexPosition(index);

            int counter = 0;
            Node<T> currentNode = head;
            while (counter != index)
            {
                currentNode = currentNode.getNextNode();
                counter++;
            }

            return currentNode.getData();
        }
    }

    /**
     * Возвращает первый элемент списка.
     *
     * @return первый элемент списка
     * @throws NoSuchElementException если список пуст
     */
    public T getFirst() {
        if (head == null)
            throw new NoSuchElementException();
        return head.getData();
    }

    /**
     * Возвращает последний элемент списка.
     *
     * @return последний элемент списка
     * @throws NoSuchElementException если список пуст
     */

    public T getLast() {
        if (tail == null)
            throw new NoSuchElementException();
        return tail.getData();
    }

    /**
     * Возвращает количество элементов в списке.
     * 
     * @return количество элементов в списке
     */
    public int size() {
        return size;
    }

    /**
     * Удаляет все элементы из списка.
     * После вызова этой функции список будет пуст.
     */
    public void clear() {
        Node<T> currentNode = head;
        while (currentNode != null) {
            Node<T> nextNode = currentNode.getNextNode();
            currentNode.setNextNode(null);
            currentNode.setPrevNode(null);
            currentNode = nextNode;
        }
        
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Возвращает итератор, который проходит по всем элементам этого листа.
     * 
     * @return итератор, который проходит по всем элементам этого листа
     */
    public ListIterator<T> iterator() {
        return new ListIterator<T>(this);
    }
}
