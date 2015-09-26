package com.resouce.app.pojo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class FileObject implements Serializable {

	
	

		//creating a global string variable to store the keys in order to be referenced
		//in order to fetch data from the hashmap
		
		private String[] keys;
		
		
		//getter method for keys
		public String[] getKeys() {
			return keys;
		}

		
		public String getFileString(File fileName) throws IOException{
			
		FileReader f=new FileReader(fileName);
		
		BufferedReader br=new BufferedReader(f);
		
		String s="";
		
		String t;
		
		while((t=br.readLine())!=null){
			
			s=s+"\n"+t;
		}
		
		br.close();
		
		return s;
		}
		
		
		public ArrayList<HashMap<String,String>> getInfo(File dataFile)throws IOException{
			
			ArrayList<HashMap<String,String>> data=new ArrayList<HashMap<String,String>>();
			
			HashMap<String,String> tempHash;
			
			FileReader f=new FileReader(dataFile);
			BufferedReader br=new BufferedReader(f);
			
			String t=br.readLine();
			
			keys=t.split(",");
			
			String tuple;
			
			while((tuple=br.readLine())!=null){
				
				String[] info=tuple.split(",");
				
				tempHash=new HashMap<String,String>();
				
				for(int i=0;i<keys.length;i++){
					String key=keys[i].substring(1,keys[i].length()-1);
					String value=info[i].substring(1,info[i].length()-1);
					
					tempHash.put(key, value);
				}
				
				data.add(tempHash);
				
			}
			
			br.close();
			
			return data;
		}
		
		
		public String searchAndReplace(String source,String target,String replacement){
			String temp="";
			int i;
			
			do{
				i=source.indexOf(target.toString());
				if(i!=-1){
					temp=source.substring(0,i);
					temp=temp+replacement;
					temp=temp+source.substring(i+target.length());
					source=temp;
				}
				
			}while(i!=-1);
			
			return source;
		}
		
		public void createFile(String fileName,String stuff) throws IOException{
			
			FileWriter fw=new FileWriter("output_files/"+fileName);
			
			fw.write(stuff);
			
			fw.close();
		}
		
	
	
	
}
