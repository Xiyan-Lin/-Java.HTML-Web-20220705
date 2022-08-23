package security.des;

import java.math.BigInteger;

public class DESEncryptTest {

	public static void main(String[] args) throws Exception {
		// 設定密鑰的路徑與名稱
		String key_path = "C:/Users/MB-207/eclipse-workspace/JavaWeb_20220705/key/user.key";
		// 建立 DESEncryptService
		DESEncryptService des = new DESEncryptService(key_path);
		
		// 明文
		String msg = "跟家人中秋賞月吃月餅吃燒烤...";
		System.out.println("明文: " + msg);
		
		// 加密
		byte[] enMsg = des.encrytor(msg); // 將明文加密
		String output = String.format("%X", new BigInteger(enMsg));
		System.out.println("密文: " + output);
		
	}

}
