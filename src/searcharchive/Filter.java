/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searcharchive;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author leanddro
 */
public class Filter implements FileFilter {
  private String fileName;
  private int best_occurrence = 0;
  
  public Filter(String fileName){
    this.fileName = fileName;
  }
  
  public boolean accept(File file){
    String str_regex = this.fileName.replaceAll(" ", "|");
    Pattern pattern = Pattern.compile(this.fileName, Pattern.CASE_INSENSITIVE);
   
    Matcher matcher = pattern.matcher(file.getName());
    if(file.isDirectory()){
      return true;
    }
    return matcher.find();
  }
}
