package com.test01;

import java.io.*;
import java.util.Scanner;

public class Main {	
	public static void main(String[] args) throws IOException  
	{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    
	    for(int i=0;i<n;i++){
	      for(int j=0;j<n;j++) {
	    	  if(j>=n)
	    	  {
	    		  System.out.print("*");
	    	  }
	    	  else
	    	  {
	    		  System.out.print(" ");
	    	  }
	      }
	      System.out.println();
	    }
	}
}
