package evgx81.linked_list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit тесты для класса LinkedList.
 */
public class LinkedListTest 
{
    @Test
    public void createEmptyList()
    {
        LinkedList<Integer> list = new LinkedList<Integer>();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    public void copyList()
    {
        LinkedList<Integer> list1 = new LinkedList<Integer>();
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        list1.addLast(4);
        list1.addLast(5);

        LinkedList<Integer> list2 = new LinkedList<Integer>(list1);
        
        int[] seq = {1, 2, 3, 4, 5};
        for (int i = 0; i < list2.size(); i++) {
            assertEquals((Integer)seq[i], list2.get(i));
        }
    }

    @Test
    public void addFirstElement()
    {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.addFirst(3);

        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
        assertEquals((Integer)3, list.getFirst());
    }

    @Test
    public void addNewFirstElement()
    {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.addFirst(10);
        list.addFirst(2);
        list.addFirst(5);

        assertFalse(list.isEmpty());
        assertEquals(3, list.size());
        assertEquals((Integer)5, list.getFirst());
    }

    @Test
    public void addLastElement()
    {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.addLast(3);

        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
        assertEquals((Integer)3, list.getFirst());
    }

    @Test
    public void addNewLastElement()
    {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.addLast(10);
        list.addLast(2);
        list.addLast(5);

        assertFalse(list.isEmpty());
        assertEquals(3, list.size());
        assertEquals((Integer)5, list.getLast());
    }

    @Test
    public void addFirstElementByIndex()
    {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        list.add(0, 0);

        assertFalse(list.isEmpty());
        assertEquals(4, list.size());
        assertEquals((Integer)0, list.getFirst());
    }

    @Test
    public void addLastElementByIndex()
    {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        list.add(3, 4);

        assertFalse(list.isEmpty());
        assertEquals(4, list.size());
        assertEquals((Integer)4, list.getLast());
    }

    @Test
    public void addElementByIndex()
    {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        list.add(1, 4);

        assertFalse(list.isEmpty());
        assertEquals(4, list.size());
        assertEquals((Integer)4, list.get(1));
        assertEquals((Integer)2, list.get(2));     
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addElementByIndexOutOfArray() {

        LinkedList<Integer> list = new LinkedList<Integer>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        list.add(4, 4);
    }

    @Test
    public void removeFirstElement()
    {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        list.removeFirst();

        assertFalse(list.isEmpty());
        assertEquals(2, list.size());
        assertEquals((Integer)2, list.getFirst());
    }

    @Test
    public void removeLastElement()
    {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        list.removeLast();

        assertFalse(list.isEmpty());
        assertEquals(2, list.size());
        assertEquals((Integer)2, list.getLast());
    }

    @Test
    public void removeFirstElementByIndex()
    {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        list.remove(0);

        assertFalse(list.isEmpty());
        assertEquals(2, list.size());
        assertEquals((Integer)2, list.getFirst());
    }

    @Test
    public void removeLastElementByIndex()
    {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        list.remove(2);

        assertFalse(list.isEmpty());
        assertEquals(2, list.size());
        assertEquals((Integer)2, list.getLast());
    }

    @Test
    public void removeElementByIndex()
    {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        list.remove(1);

        assertFalse(list.isEmpty());
        assertEquals(2, list.size());
        assertEquals((Integer)1, list.get(0));
        assertEquals((Integer)3, list.get(1));     
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeElementByIndexOutOfArray() {

        LinkedList<Integer> list = new LinkedList<Integer>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.remove(4);
    }

    @Test
    public void clear() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        list.clear();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    public void iterator() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        int i = 0;
        int[] seq = {1, 2, 3, 4, 5};
        ListIterator<Integer> iter = list.iterator();
        while(iter.hasNext()) {
            assertEquals((Integer)seq[i], iter.next());
            i++;
        }
    }
}
