
public class BuilderAndBufferComparison {

    private static final int ITERATIONS = 1_000_000;

    public static void main(String[] args) {

        // StringBuffer test
        StringBuffer sbf = new StringBuffer();
        long startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            sbf.append("hello");
        }
        long endTime = System.nanoTime();
        long bufferTime = endTime - startTime;

        // StringBuilder test
        StringBuilder sbd = new StringBuilder();
        startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            sbd.append("hello");
        }
        endTime = System.nanoTime();
        long builderTime = endTime - startTime;

        System.out.println("StringBuffer time (ns): " + bufferTime);
        System.out.println("StringBuilder time (ns): " + builderTime);
    }
}
