public final class ErrorReporter {
    private static int errorCount = 0;

    public static boolean hasError() {
        return errorCount > 0;
    }

    public static void reportError(String msg) {
        errorCount += 1;
        System.err.println(msg);
    }

    public static void exitOnErrors() {
        if (hasError()) {
            // debug info
            System.out.println("Exiting on errors.");
            System.exit(1);
        }
    }
}
