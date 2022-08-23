package security.md5;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Arrays;

public class MD5Digest {
	
	public static void main(String[] args) throws Exception {
		// 原始密碼
		String input = "1234";
		System.out.println("input: " + input);
		// 透過MD5加密
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		byte[] result = md5.digest(input.getBytes()); // input 資料加密
		System.out.println("byte[]: " + Arrays.toString(result));
		// 印出 16 進位字串(%X 表示 16進位) ("032" 代表 32 個字不足補 0)
		String output = String.format("%032X", new BigInteger(result));
		System.out.println("output: " + output); // 存放到資料庫的加密字串內容
		
	}
}
