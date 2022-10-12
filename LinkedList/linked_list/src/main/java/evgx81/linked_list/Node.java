package evgx81.linked_list;

/**
 * Класс Node реализует вершину двусвязного списка.
 * 
 * @author evgx81 
 */
public class Node<T> {
    /**
     * Поле хранения информации.
     */
    private T data;

    /**
     * Указатель на следующую вершину.
     */
    private Node<T> next;

    /**
     * Указатель на предыдущую вершину.
     */
    private Node<T> prev;

    /**
     * Создает пустую вершину.
     */
    Node() { 
        next = null;
        prev = null; 
    }

    /**
     * Создает новую вершину и копирует в нее свойства заданной вершины.
     * 
     * @param node вершина, свойства которой скопируются в новую вершину.
     */
    Node(Node<T> node) {
        this.data = node.data;
        this.next = node.next;
        this.prev = node.prev;
    }

    /**
     * Set и get методы для полей data, next и prev.
     */
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNextNode() {
        return next;
    }

    public void setNextNode(Node<T> node) {
        this.next = node;
    }

    public Node<T> getPrevNode() {
        return prev;
    }

    public void setPrevNode(Node<T> node) {
        this.prev = node;
    }
}