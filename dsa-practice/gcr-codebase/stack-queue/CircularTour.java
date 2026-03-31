// Circular Tour

public class CircularTour {

    // returns starting index, or -1 if not possible
    public static int findStart(int[] petrol, int[] dist) {
        int n = petrol.length;
        if (n == 0 || dist.length != n) {
            return -1;
        }

        int start = 0;       // front of our "queue"
        int end = 0;         // next pump to include
        int currFuel = 0;    // surplus fuel for pumps in current window

        // push first petrol pump into the window
        currFuel += petrol[end] - dist[end];
        end = (end + 1) % n;

        // run till we either cover all pumps with non-negative fuel,
        // or we know it's impossible
        while (end != start || currFuel < 0) {
            // if surplus becomes negative, pop from front (move start)
            while (currFuel < 0 && start != end) {
                currFuel -= petrol[start] - dist[start];
                start = (start + 1) % n;

                // came back to 0 → no solution
                if (start == 0) {
                    return -1;
                }
            }

            // include next pump into the window
            currFuel += petrol[end] - dist[end];
            end = (end + 1) % n;
        }

        // start is the first index from which full tour is possible
        return start;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] dist = {6, 5, 3, 5};

        int startIndex = findStart(petrol, dist);
        System.out.println("Starting index: " + startIndex);
    }
}
