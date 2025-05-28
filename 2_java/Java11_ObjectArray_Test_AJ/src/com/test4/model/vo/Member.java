package com.test4.model.vo;

public class Member implements Comparable{
	private String userId;		// 아이디
	private String userPwd;		// 비밀번호
	private String name;		// 이름
	private int age;			// 나이
	private char gender;		// 성별
	private String email;		// 이메일
	
	public Member() {}

	public Member(String userId, String userPwd, String name, int age, char gender, String email) {
		this.userId = userId;
		this.userPwd = userPwd;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.email = email;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public String information() {
		return "[userId=" + userId + ", userPwd=" + userPwd + ", name=" + name + ", age=" + age + ", gender="
				+ gender + ", email=" + email + "]";
	}

	@Override
	public int compareTo(Object o) {
		Member other = (Member)o;
		/* "A".compareTo("B") → -1  // A가 B보다 앞에 있으므로 음수
		   "B".compareTo("A") → 1   // B가 A보다 뒤에 있으므로 양수
	 	   "A".compareTo("A") → 0   // 같으므로 0
		 * */
		// 오름차순 
	    return this.getUserId().compareTo(other.getUserId());
	}

	
		
}
