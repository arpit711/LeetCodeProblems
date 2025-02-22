/*Notes
	•	new AsyncTask() does not create a new thread by itself.
	•	CompletableFuture.runAsync(new AsyncTask()) does not explicitly create a thread.
	•	Instead, it submits the Runnable task to the ForkJoinPool.commonPool(), which is a shared thread pool.

This means:
✅ A new thread from the pool picks up AsyncTask and executes it asynchronously.
✅ It does not create a dedicated thread per AsyncTask object, but reuses worker threads.
*/
package LeetcodeCodeProblems;

import java.util.concurrent.*;

public class AsyncJavaExecutionWithThreadInterface {
    public static class AsyncTask implements Runnable {
        private int taskId;

        public AsyncTask(int id) {
            this.taskId = id;
        }

        @Override
        public void run() {
            System.out.println("Async task taskId: " + taskId + "Async Task running on: " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Async Task Completed");
        }
    }



    public static void main(String[] args) {
//        process to call fixed number of executor instances instead of FORKJOINPOOL that is default one and more efficient one.
//        ExecutorService executor = Executors.newFixedThreadPool(3);
//        CompletableFuture<Void> future = CompletableFuture.runAsync(new AsyncTask(1), executor);

        System.out.println("Main thread: " + Thread.currentThread().getName());

        CompletableFuture<Void> future1 = CompletableFuture.runAsync(new AsyncTask(1));
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(new AsyncTask(2));
        System.out.println("Main thread continues execution...");

        CompletableFuture.allOf(future1, future2).join(); // Wait for async task to complete
        System.out.println("Main thread ends.");

    }
}

/* Code for using the thread class instead of interface runnable in case of using the start()
 method adn also using the fixed set of threads for the usecase
 * class MyTask extends Thread {
    private final int taskId;

    public MyTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Task " + taskId + " running on: " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000); // Simulating a time-consuming task
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Task " + taskId + " completed!");
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        System.out.println("Main thread: " + Thread.currentThread().getName());

        // Creating and starting multiple threads manually
        MyTask task1 = new MyTask(1);
        MyTask task2 = new MyTask(2);
        MyTask task3 = new MyTask(3);

        task1.start();  // Executes the run() method in a new thread
        task2.start();
        task3.start();

        System.out.println("Main thread continues execution...");
    }
}*/
