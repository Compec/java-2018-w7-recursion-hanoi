import java.util.Stack;

/**
 * Peg class that behaves like a Stack
 * Holds the information of which disks are currently in it
 * and exposes a push and pop method to put and remove a disk
 * respectively
 */
class Peg {
    // "Pile" or "Stack" of disks on this peg
    Stack<Integer> disks;

    /**
     * Peg constructor
     * Initializes the disks
     */
    Peg() {
        disks = new Stack<Integer>();
    }

    /**
     * Push a disk to the peg
     * @param diskNumber Number or index of the disk to be pushed
     */
    void push(int diskNumber) {
        disks.push(diskNumber);
    }

    /**
     * Pops a disk from the peg
     */
    void pop() {
        disks.pop();
    }

    /**
     * Prints the content of this peg
     * @param index Index of the peg
     */
    void printContent(int index) {
        System.out.print("Peg " + index + ": ");
        for(int i = 0; i < disks.size(); i++) {
            System.out.print(disks.get(i) + " ");
        }
        System.out.println();
    }

}

