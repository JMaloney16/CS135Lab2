/**
 * <h1>File-name</h1>
 * <p>Queue.java</p>
 * <h1>Purpose</h1>
 * <p>Creates a queue data type that can be accessed from other classes</p>
 * @since 19/02/2019
 * <h2>Modification Date</h2>
 * <p>19/02/2019</p>
 * <h1>Copyright Notice</h1>
 * <p>-no copyright</p>
 * <h1>Version History</h1>
 * <p>Version 1.1: Code commented<br>
 * Version 1.0: Code downloaded</p>
 * @author 991384, 979883
 * @version 1.1
 *
 */

public class Queue {

	private int front = queueSize - 1, back = queueSize - 1, length = 0;

	private int[] queue = new int[queueSize];
	private boolean ERROR_FREE = true;

	private final static int queueSize = 5;

	/**
	 * checks if the queue is empty
	 * <p> no side-effects</p>
	 * <p> not referentially transparent</p>
	 * @return Returns true if the queue is empty
	 */
	public boolean isEmpty() {
		return length == 0;
	}

	/**
	 * checks if the queue is full
	 * <p> no side-effects</p>
	 * <p> not referentially transparent</p>
	 * @return Returns true if the queue is full
	 */
	public boolean isFull() {
		return (length == queueSize);
	}

	/**
	 * checks if the queue is error free
	 * <p> no side-effects</p>
	 * <p> not referentially transparent</p>
	 * @return the state of the boolean ERROR_FREE
	 */
	public boolean isErrorFree() {
		return ERROR_FREE;
	}

	/**
	 * empties the queue of all elements
	 * <p> does have side-effects</p>
	 * <p> is referentially transparent</p>
	 */
	public void Empty() {
		front = queueSize - 1;
		back = queueSize - 1;
		length = 0;
		ERROR_FREE = true; // Reset error status
	}

	/**
	 * returns the element at the front of the queue and removes it's pointer by incrementing the front
	 * <p> has side-effects</p>
	 * <p> not referentially transparent</p>
	 * @return elements at the front of the queue
	 */
	public int dequeue() {
		ERROR_FREE = !(isEmpty()) & (ERROR_FREE);
		if (ERROR_FREE) { //If the queue is error free reduce the length
			length--;
			if (front == queueSize - 1) { //If the queue is full set the front pointer to the first element
				front = 0;
			} else { // Increment the front pointer
				front++;
			}
			return queue[front];
		} else {
			return 0;
		}
	}

	/**
	 * adds the given value to the end of the queue
	 * <p> has side-effects</p>
	 * <p> is referntially transparent</p>
	 * @param value the value to be added to the queue
	 */
	public void enqueue(int value) {
		ERROR_FREE = !(isFull()) & ERROR_FREE;
		if (ERROR_FREE) { //If the queue is error free increase the length
			length++;
			if (back == queueSize - 1) { //If the end pointer is the last element set the pointer to the first element
				back = 0;
			} else { //Increment the rear pointer
				back++;
			}
			queue[back] = value;
		}
	}
}
