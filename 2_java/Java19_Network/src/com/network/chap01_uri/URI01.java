package com.network.chap01_uri;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

public class URI01 {
	public static void main(String[] args) throws URISyntaxException, IOException{
		// URI 클래스 
		URI u = new URI("https://www.google.com/search?q=%EC%82%AC%EA%B3%BC&oq=&gs_lcrp=EgZjaHJvbWUqBggAEEUYOzIGCAAQRRg7MgoIARAuGLEDGIAEMg0IAhAAGIMBGLEDGIAEMgoIAxAAGLEDGIAEMgcIBBAAGIAEMgcIBRAuGIAEMhAIBhAuGK8BGMcBGLEDGIAEMgcIBxAAGIAEMhAICBAuGIMBGNQCGLEDGIAEMhAICRAuGIMBGNQCGLEDGIAE0gELMzg5MzU2MWowajeoAgCwAgA&sourceid=chrome&ie=UTF-8");
		
		// getScheme : https 프로토콜
		System.out.println(u.getScheme());
		// getHost : www.google.com
		System.out.println(u.getHost());
		// getQuery : q=사과&oq=&gs_lcrp=Eg ... 
		System.out.println(u.getQuery());
		
		URL url = new URL("https://item.kakaocdn.net/do/9dc14126ee3e2d16b00d0a503b592cbb9f17e489affba0627eb1eb39695f93dd");
		
		URLConnection urlConn = url.openConnection();
		
		// 입력 스트림. 네트워크상에 존재하는 img를 읽어온다. 
		DataInputStream di = new DataInputStream(urlConn.getInputStream());
		
		// 출력 스트림. 입력 받은 이미지를 내 컴퓨터에 저장
		FileOutputStream fo = new FileOutputStream("ganady.png");
		
		byte[] b = new byte[1];
		while(di.read(b, 0, 1) != -1) {
			fo.write(b, 0, 1);
		}
		System.out.println("완료");
		di.close();
		fo.close();
	}
}
