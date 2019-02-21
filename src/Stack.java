public class Stack {

    static int stackSize = 5; /* Size of the stack */

    static int topOfStack = -1; /* Pointer for the top of the stack */
    static int[] stack = new int[stackSize]; /* Array that holds the values in the stack */
    static boolean errorFree = true; /* Stores whether there is an error in the stack */

    public static boolean isEmpty () {
        return topOfStack == -1; // If there are no elements in the stack returns true
    }

    public static boolean isFull () {
        return topOfStack == stackSize - 1;
    }

    public static void empty () {
        errorFree = true; // Reset the error status of the stack
        topOfStack = -1;
    }

    public static int top () {
	errorFree = ! (isEmpty ()) & errorFree;
	// Returns the top value in the stack if the stack is error free AND not empty
	if (errorFree) {
	    return stack[topOfStack]; // Return top value
	} else { // Return 0 if the stack is empty or has errors
	    return 0;
        } 
    }

    public static void push (int value) {
	    errorFree = ! (isFull ()) & errorFree;
	    /* Increment the top pointer then add the value given to the top of the stack if the stack is not full
	     and error free  */
	    if (errorFree) {
            topOfStack = topOfStack + 1;
                stack[topOfStack] = value;
	    }
    }

    public static void pop () {
        errorFree = ! (isEmpty ()) & errorFree;
        // Decrease the top pointer of the stack if the stack is not empty and error free
        if (errorFree) {
            topOfStack = topOfStack - 1;
        }
    }

public static void main (String args[]) {
    int test;

    System.out.println(" --- Begin Experiment 1 ---");


    System.out.println(" --- Empty ---");
    empty ();

    System.out.println("Build up a stack of one entry:");
    push(1);
    System.out.println("   push 1");

    System.out.println("Inspect the stack:");
    test = top();
    System.out.println("   top: " + test);

    System.out.println("Make the stack empty:");
    pop();
    System.out.println("   pop");

    System.out.println("Test how 'top' works on the empty stack:");
    test = top();

    if (errorFree) {
       System.out.println("   top: " + test);
    } else {
       System.out.println("   An error has occured.");
    }

    System.out.println(" --- End Experiment 1 ---");

    System.out.println(" --- Begin Experiment 2 ---");

    System.out.println(" --- Empty ---");
    empty ();

    System.out.println("Build up a stack of five entries:");

    push(1);
    System.out.println("   push 1");
    push(2);
    System.out.println("   push 2");
    push(3);
    System.out.println("   push 3");
    push(4);
    System.out.println("   push 4");
    push(5);
    System.out.println("   push 5");

    System.out.println("Push another entry and check if 'out of memory'-protection works:");

    push(6);
    if (errorFree) {
           System.out.println("   push 6");
    } else {
       System.out.println("   An error has occured.");
    }

    System.out.println(" --- End Experiment 2 ---");


    System.out.println(" --- Begin Experiment 3 ---");

    empty ();
    System.out.println(" --- Empty ---");

    System.out.println("Build up a stack of three entries:");

    push(1);
    System.out.println("   push 1");
    push(2);
    System.out.println("   push 2");
    push(3);
    System.out.println("   push 3");

    System.out.println("Take these three entries away.");
    while (! isEmpty ()) {
        test = top ();
        System.out.println("   top: " + test);
        pop ();
        System.out.println("   pop");
    }

    System.out.println(" --- End Experiment 3 ---");
}

}

