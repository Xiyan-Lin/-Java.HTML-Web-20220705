package security.md5;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Scanner;

public class MD5Digest {
	
	public static String getEncryptString(String input) throws Exception {
		// 透過MD5加密
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		byte[] result = md5.digest(input.getBytes()); // input 資料加密
		//System.out.println("byte[]: " + Arrays.toString(result));
		// 印出 16 進位字串(%X 表示 16進位) ("032" 代表 32 個字不足補 0)
		String output = String.format("%032X", new BigInteger(result));
		return output;
	}
	
	public static void main(String[] args) throws Exception {
		// 原始密碼
		String input = "1234";
		System.out.println("input(明文)未加鹽: " + input);
		// 鹽
		String salt = "rose";
		// 原始密碼 + 鹽
		input = input + salt;
		// 將 input 透過MD5加密
		String output = getEncryptString(input);  // 存放到資料庫的加密字串內容
		System.out.println("output(密文含鹽): " + output);
		
		// 測試登入
		Scanner scanner = new Scanner(System.in);
		System.out.print("請輸入密碼: ");
		String pwd_input = scanner.next();
		pwd_input = pwd_input + "rose"; // 加鹽比對
		// 將 pwd 進行加密
		String pwd_output = getEncryptString(pwd_input);
		System.out.println("pwd_output(密文): " + pwd_output);
		// 比較 pwd_output 是否等於 output(密文) 的內容
		if(pwd_output.equals(output)) {
			System.out.println("登入成功");
		} else {
			System.out.println("登入失敗");
		}
		
		
	}
}
