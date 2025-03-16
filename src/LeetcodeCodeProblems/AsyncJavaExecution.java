package LeetcodeCodeProblems;

import java.util.concurrent.CompletableFuture;

public class AsyncJavaExecution {
    public AsyncJavaExecution() {
    }

    public void asyncCallExample() {
        System.out.println("Main Thread: " + Thread.currentThread().getName());
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("Async Thread Name: " + Thread.currentThread().getName() + "running in Async Mode");
            try {
                Thread.sleep(3000); //Long waiting process runs mimics.
            } catch (InterruptedException e) {
                System.out.println(e);
                Thread.currentThread().interrupt();
            }
            System.out.println("Async Execution Completed!");
        });
        System.out.println("Main Program execution continues: ");
        future.join();
        System.out.println("Main thread Execution Completed");
    }

    public void asyncCallExample2() {
        System.out.println("Main Thread: " + Thread.currentThread().getName());
        CompletableFuture<Void> future = new CompletableFuture<>();

    }
}
