package evgx81.linked_list;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit тесты для класса Node.
 */
public class NodeTest {
    @Test
    public void createEmptyNode() {
        Node<Integer> node = new Node<Integer>();

        assertEquals(null, node.getPrevNode());
        assertEquals(null, node.getNextNode());
    }

    @Test
    public void createNotEmptyNode() {
        Node<Integer> node = new Node<Integer>();
        node.setData(5);

        assertEquals(null, node.getPrevNode());
        assertEquals(null, node.getNextNode());
        assertEquals((Integer)5, node.getData());
    }

    @Test 
    public void copyNode() {
        Node<Integer> node1 = new Node<Integer>();
        node1.setData(5);

        Node<Integer> node2 = new Node<Integer>(node1);

        assertEquals(null, node2.getPrevNode());
        assertEquals(null, node2.getNextNode());
        assertEquals((Integer)5, node2.getData());
    }
}
