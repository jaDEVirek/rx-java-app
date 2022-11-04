//package org.jadevirek;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.RecursiveTask;
//
//public class FileListing extends RecursiveTask<List<String>> {
//
//  private final String path;
//
//  public FileListing(String path) {
//    this.path = path;
//  }
//
//  //Implement the compute() method. As you parameterized the RecursiveTask
//  // class with the List<String> type,
//  //this method has to return an object of that type.
//  @Override
//  protected List<String> compute() {
//    //List to store the names of the files stored in the folder.
//    List<String> list = new ArrayList<String>();
//    List<FileListing> tasks = new ArrayList<FileListing>();
//    //Get the content of the folder.
//    File file = new File(path);
//    File[] content = file.listFiles();
//    //For each element in the folder, if there is a subfolder, create a new
//    // FolderProcessor object
//    //and execute it asynchronously using the fork() method.
//    if (content != null) {
//      for (File value : content) {
//        if (value.isDirectory()) {
//          FileListing task =
//              new FileListing(value.getAbsolutePath());
//          task.fork();
//          tasks.add(task);
//        }
//        //Otherwise, compare the extension of the file with the extension you
//        // are looking for using the checkFile() method
//        //and, if they are equal, store the full path of the file in the list
//        // of strings declared earlier.
//        else {
//          if (value.isFile()) {
//            list.add(value.getAbsolutePath());
//          }
//        }
//      }
//    }
//  }
//}
