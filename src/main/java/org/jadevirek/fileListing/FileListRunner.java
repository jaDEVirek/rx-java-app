package org.jadevirek.fileListing;

import java.io.File;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.collections4.queue.CircularFifoQueue;

public class FileListRunner {

  private static final CircularFifoQueue<String> circularFifoQueue = new CircularFifoQueue(
      List.of(" \\ ", " | ", " / ", " - "));
  final static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
  private static final ForkJoinPool sFJPool =
      ForkJoinPool.commonPool();

  public static void main(String[] args) {
    final File fileResource = new File("D:\\");

    executorService
        .scheduleAtFixedRate(FileListRunner::animateAnalize, 0, 200, TimeUnit.MILLISECONDS);
    runFileListing(ForkJoinPool.commonPool(),
        new FileCounterTask(
            fileResource, new AtomicLong(0), new AtomicLong(0)),
        fileResource.getAbsolutePath());

    executorService.shutdown();
  }

  private static void runFileListing(ForkJoinPool fJPool,
      FileCounterTask testTask,
      String testName) {
    fJPool.invoke(testTask);

    System.out.println("\r" + testName
        + ": "
        + "files ("
        + testTask.getDirCount()
        + " documents and "
        + testTask.getFileCount()
        + " folders) contained "
        + testTask.getTotalSize()
        + " bytes.");
  }

  static void animateAnalize() {
    String poll = circularFifoQueue.poll();
    System.out.print("\r" + poll + " Analyzing");
    circularFifoQueue.add(poll);
  }
}



