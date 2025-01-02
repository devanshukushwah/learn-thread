class SharedResource {
    private boolean hasMessage = false;

    // Method for the producer
    public synchronized void produce() throws InterruptedException {
        while (hasMessage) {
            wait(); // Wait if a message is already there
        }
        System.out.println("Produced a message");
        hasMessage = true;
        notify(); // Notify the consumer thread
    }

    // Method for the consumer
    public synchronized void consume() throws InterruptedException {
        while (!hasMessage) {
            wait(); // Wait if no message is there
        }
        System.out.println("Consumed the message");
        hasMessage = false;
        notify(); // Notify the producer thread
    }
}

public class ThreadCommunication {
    public static void main(String[] args) {
        SharedResource shared = new SharedResource();

        // Create a producer thread
        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    shared.produce();
                    Thread.sleep(500); // Pause to simulate some work
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Create a consumer thread
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    shared.consume();
                    Thread.sleep(500); // Pause to simulate some work
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}
