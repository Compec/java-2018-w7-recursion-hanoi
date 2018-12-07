import java.util.ArrayList;

/**
 * Class that holds the state of a hanoi game
 * It is able to solve the game with a recursive strategy
 */
class Hanoi {
    // List of pegs
    ArrayList<Peg> pegs;

    // Public-facing solve method
    void solve() {
        recursiveSolve(pegs.get(0).disks.get(0),
                0,
                2,
                1);
        System.out.println("Solving this game required " + stepCount);

    }

    int stepCount;

    // Internal implementation of the solution
    // The public|user should not care about these details, that is why
    // we have two methods, one `solve` the other this one
    private void recursiveSolve(int diskIndex, int from, int to, int free) {
        // Base case
        // I am the imaginary 0th disk
        if(diskIndex == 0) {
            stepCount++;
            printState();
            System.out.println();
            return; // Nothing to do :)
        }

        // I ask the disks on top of me to move
        recursiveSolve(diskIndex -1,
                from,
                free,
                to);

//        System.out.println(diskIndex + " moved from " + from + " to " + to);
        // I move myself
        pegs.get(from).pop();
        pegs.get(to).push(diskIndex);

        // I ask the disks on top to move back on top of me
        recursiveSolve(diskIndex - 1, free,to,
                from);

    }

    /**
     * Hanoi constructor
     * @param initialDisks Number of initial disks to have
     */
    Hanoi(int initialDisks) {
        stepCount = 0;
        // Initialize the pegs
        // Typical hanoi game consists of three pegs
        // Although > 3 pegs versions also exists
        pegs = new ArrayList<Peg>();
        pegs.add(new Peg());
        pegs.add(new Peg());
        pegs.add(new Peg());
        for(int i = initialDisks; i > 0; i--) {
            pegs.get(0).push(i);
        }
    }

    void printState() {
        for(int i = 0; i < pegs.size(); i++) {
            pegs.get(i).printContent(i+1);
        }
    }
}

