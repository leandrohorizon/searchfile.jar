/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searcharchive;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author leanddro
 */
public class SearchArchive {

  /**
   * @param args the command line arguments
   */
  
  private void listFiles (List<File> files, File directory, String fileName){
    for (File file : directory.listFiles(new Filter(fileName))) {
      if (file.isDirectory()) {
        listFiles (files, file, fileName);
      }else{
        files.add (file);
      }
    }
  }
  
  public List<File> listFiles (File directory, String fileName) {
    List<File> files = new ArrayList<File>();
    listFiles (files, directory, fileName);
    return files;
  }
  
  public static void main(String[] args) {
    SearchArchive archives = new SearchArchive();
    Scanner scan = new Scanner(System.in);
    
    System.out.println("inform the folder you want to use");
    String path_ = scan.nextLine();
    
    File path = new File(path_);
    
    System.out.println("inform the file you are looking for");
    String file_search = scan.nextLine();
    
    List<File> files = archives.listFiles(path, file_search);
    System.out.println(files.size()+ " files were found.");
    
    for(File file : files){
      System.out.println(file.getAbsoluteFile());
    }
  }
  
}
