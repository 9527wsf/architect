package com.springboot.architecture.controller.allArchitecture.demo1.demo3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Output implements Observer {
    private ArrayList<String> kwicList;
    private BufferedWriter outputFile;
    private String filename;
    public Output(ArrayList<String> kwicList,String filename) {
        this.kwicList = kwicList;
        this.filename = filename;
    }

    @Override
    public void toDo(){
        System.out.println("Output: Writing to file " + filename);  // 日志记录
        Iterator<String> it = kwicList.iterator();
        try {
            outputFile = new BufferedWriter(new FileWriter(filename));
            while (it.hasNext()) {
                outputFile.write(it.next()+"\n");
            }
        }catch (IOException e){
            System.err.println("Output: Error writing to file - " + e.getMessage());  // 日志记录
            e.printStackTrace();
        }finally {
            try {
                if (outputFile!=null) {
                    System.out.println("Output: File write operation completed.");  // 日志记录
                    outputFile.close();
                }
            } catch (IOException e) {
                System.err.println("Output: Error closing the file - " + e.getMessage());  // 日志记录
                e.printStackTrace();
            }
        }
    }

}
