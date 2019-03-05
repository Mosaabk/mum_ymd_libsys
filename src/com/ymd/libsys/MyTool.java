package com.ymd.libsys;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyTool {
	
	/*
	 * filePath like this src/com/ymd/libsys/members
	 */
	public static void WriteStringToFile(String dataString, String filePath) {
		File writename = new File(filePath); 
		try {
			writename.createNewFile();
			BufferedWriter out = new BufferedWriter(new FileWriter(writename));
			out.write(dataString); 
			out.flush(); // 
			out.close(); // 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }
	
	public static String readStringFromFile(String filePath) {
		int len=0;		 
        StringBuffer str=new StringBuffer("");
        File file=new File(filePath);
        try {
            FileInputStream is=new FileInputStream(file);
            InputStreamReader isr= new InputStreamReader(is);
            BufferedReader in= new BufferedReader(isr);
            String line=null;
            while( (line=in.readLine())!=null ) {
                if(len != 0) {
                    str.append("\r\n"+line);
                }
                else {
                    str.append(line);
                }
                len++;
            }
            in.close(); 
            is.close();
        } catch (IOException e) { 
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        return str.toString();
    }

}
