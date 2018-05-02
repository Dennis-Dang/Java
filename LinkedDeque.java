import java.util.NoSuchElementException;

/**
 * LinkedDeque a data structure that behaves like both a queue and a stack.
 * Behaving like so, this data structure can interact with elements stored on both the front and
   the back of the deque.
 *
 * @author Dennis Dang
 * @version 16 November 2017
 */
public class LinkedDeque<E>
{
   private int size;
   private ListNode<E> front;
   private ListNode<E> back;

   /**
    * Adds the specified element in the front of the deque.
    *
    * @param x Element being added at the front of the deque.
    */
   public void push(E x)
   {
      ListNode<E> cur = front;
      ListNode<E> temp = new ListNode<E>(x, cur);
      front = temp;
   
      if (size == 0)
      {
         temp.next = null;
         back = front;
      }
      this.size++;
   }

   /**
    * Returns the value and remove it from the front of the deque.
    *
    * @return the value that was from the front of the deque.
    */
   public E pop()
   {
      if (front == null)
         throw new NoSuchElementException();
      E value = front.data;
      front = front.next;
   
      if (front == null)
         back = null;
      this.size--;
      return value;
   }

   /**
    * Adds the element to the back of the deque structure.
    *
    * @param x the element that is being added to the back of the deque.
    */
   public void add(E x)
   {
   
      if (size == 0)
      {
         front = new ListNode<E>(x, front);
         back = front;
      }
      else
      {
         ListNode<E> cur = front;
         while(cur.next != null)
            cur = cur.next;
         cur.next = new ListNode<E>(x, cur.next);
         back = cur.next;
      }
      this.size++;
   }

   /**
    * Removes and returns the value in the front of the deque.
    * Called to pop() to make implementation compatible with queue-like data structures.
    *
    * @return the front of the deque.
    */
   public E remove()
   {
      return pop();
   }

   /**
    * Returns the value in the front of the deque.
    *
    * @throws NoSuchElementException if there are no values in the front of the deque.
    * @return The front of the deque.
    */
   public E peek()
   {
      if (front == null)
         throw new NoSuchElementException();
      return front.data;
   }

   /**
    * Returns true if the deque is empty.
    *
    * @return true if the deque is empty.
    */
   public boolean isEmpty()
   {
      return front == null;
   }

   /**
    * Return current size of the deque.
    *
    * @return How many elements are inside of the deque.
    */
   public int size()
   {
      return size;
   }

   /**
    * Returns the deque in a text-representation from the front to back of the deque.
    *
    * @return String-representation on the deque.
    */
   public String toString()
   {
      String s = "[";
      ListNode cur = front;
      for(int i = 1; i < size; i++)
      {
         s += cur.data + ", ";
         cur = cur.next;
         if (i % 8 == 0)
            s += "\n ";
      }
      if (cur == null)
         return s + "]";
      s += cur.data + "]";
      return s;
   }
}