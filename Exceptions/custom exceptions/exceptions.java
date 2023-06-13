class CustomException extends Exception {
    public CustomException() {
        super();
    }

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomException(Throwable cause) {
        super(cause);
    }
}

class Main {
    public static void main(String[] args) {
        try {
            boolean condition = false; // Set the condition here

            if (condition) {
                // Some code that may throw the custom exception
                throw new CustomException("This is a custom exception.");
            } else {
                // Perform other actions if the condition is not met
                System.out.println("Condition not met. Skipping exception throwing.");
            }
        } catch (CustomException e) {
            // Handle the exception
            System.out.println("Caught CustomException: " + e.getMessage());
        }
    }
}
