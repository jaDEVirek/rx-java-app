package org.jadevirek.fileListing;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicLong;

public class FileCounterTask extends RecursiveTask<Long> {

  private final File file;
  private final AtomicLong fileCount;
  private final AtomicLong dirCount;
  private final AtomicLong totalSize = new AtomicLong(0);

  public FileCounterTask(File file, AtomicLong fileCount,
      AtomicLong dirCount) {
    this.file = file;
    this.fileCount = fileCount;
    this.dirCount = dirCount;
  }

  @Override
  protected Long compute() {
    if (file.isFile()) {
      this.fileCount.incrementAndGet();
      return this.file.length();
    } else {
      final List<ForkJoinTask<Long>> forkedTasks = new ArrayList<>();
      long totalFileBytes = 0;
      final File[] files = file.listFiles();

      this.dirCount.incrementAndGet();
      if (files != null) {
        for (File file : files) {
          final ForkJoinTask<Long> task = new FileCounterTask(file,
              this.fileCount,
              this.dirCount).fork();

          forkedTasks.add(task);
        }
      }
      for (ForkJoinTask<Long> task : forkedTasks) {
    // merge operation return back

        // tools JAVA MENTORING
        totalFileBytes += task.join();
      }
      this.totalSize.set(totalFileBytes);
      return totalFileBytes;
    }
  }

  public AtomicLong getFileCount() {
    return fileCount;
  }

  public AtomicLong getDirCount() {
    return dirCount;
  }

  public AtomicLong getTotalSize() {
    return totalSize;
  }
}


