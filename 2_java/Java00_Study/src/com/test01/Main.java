package com.test01;

import java.io.*;
import java.util.StringTokenizer;

public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[] arr = new int[N];
    //바구니 채우기
    for(int i=0;i<N;i++){
      arr[i]=(i+1);
    }
    for(int k=0;k<M;k++){
      st = new StringTokenizer(br.readLine());
      int i=Integer.parseInt(st.nextToken());
      int j=Integer.parseInt(st.nextToken());
      //역순으로 만들기
      int ij = i+j;
      int tmp =0;
      for(int p=i-1;p<(int)((ij-1)/2);p++){
        tmp=arr[p];
        arr[p]=arr[j-1];
        arr[j-1]=tmp;
        j--;
      }
    }
    for(int i=0;i<N;i++){
      System.out.print(arr[i]+" ");
    }
  }
}
