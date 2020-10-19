package com.week2.programs;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.RecursiveTask;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.apache.log4j.Logger;

public class Task<Integer> extends RecursiveTask<Integer> {

    private static final Logger logger = Logger.getLogger(Task.class.getName());

    private static final short UNVISITED = 0;
    private static final short VISITED = 1;

    private Set<Task<Integer>> dependencies = new HashSet();

    private final String name;
    private final Callable<Integer> callable;

    @SuppressWarnings("unchecked")
    public Task(String name, Callable<Integer> callable, Task taskA, Task taskB) {
        this.name = name;
        this.callable = callable;
       // this.dependencies = Set.of(dependencies);
    }

    @Override
    protected Integer compute() {

        dependencies.stream()
                .filter(new Predicate<Task<Integer>>() {
					public boolean test(Task<Integer> task) {
						return (task.updateTaskAsVisited());
					}
				})
                .forEachOrdered(new Consumer<Task<Integer>>() {
					public void accept(Task<Integer> task) {
					    logger.info("Tagged: " + task + "(" + task.getForkJoinTaskTag() + ")");
					    task.fork();
					}
				});

        for (Task task : dependencies) {
            task.join();
        }

        try {
            return callable.call();
        } catch (Exception ex) {
            logger.error( "Exception: " + ex);
        }

        return null;
    }

    public boolean updateTaskAsVisited() {
        return compareAndSetForkJoinTaskTag(UNVISITED, VISITED);
    }

    @Override
    public String toString() {
        return name;
    }
}


