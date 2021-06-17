package com.yakovliam.knowbeforeyougo.client.io;

import java.util.function.Consumer;

public class ExecutorFunction {

    /**
     * To execute when failed
     */
    private Consumer<String> whenFailed;

    /**
     * To execute when succeeded
     */
    private Consumer<String> whenSucceeded;

    public Consumer<String> getWhenFailed() {
        return whenFailed;
    }

    public ExecutorFunction withWhenFailed(Consumer<String> whenFailed) {
        this.whenFailed = whenFailed;
        return this;
    }

    public Consumer<String> getWhenSucceeded() {
        return whenSucceeded;
    }

    public ExecutorFunction withWhenSucceeded(Consumer<String> whenSucceeded) {
        this.whenSucceeded = whenSucceeded;
        return this;
    }

    /**
     * Accepted failed
     *
     * @param output output
     */
    public void acceptFailed(String output) {
        if (this.getWhenFailed() != null) {
            this.getWhenFailed().accept(output);
        }
    }

    /**
     * Accept succeeded
     *
     * @param output output
     */
    public void acceptSucceeded(String output) {
        if (this.getWhenSucceeded() != null) {
            this.getWhenSucceeded().accept(output);
        }
    }
}
