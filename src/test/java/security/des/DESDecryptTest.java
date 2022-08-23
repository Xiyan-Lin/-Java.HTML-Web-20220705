package security.des;

import java.math.BigInteger;
import java.util.Arrays;

public class DESDecryptTest {
	
	public static void main(String[] args) throws Exception {
		// 設定密鑰的路徑與名稱
		String key_path = "C:/Users/MB-207/eclipse-workspace/JavaWeb_20220705/key/user2.key";
		// 建立 DESEncryptService
		DESEncryptService des = new DESEncryptService(key_path);
		
		// 待解密的 hex
		//String hex = "560df430de1dd0451f55021b79011154ab276a8230fd78c71d0f093c6cc49da9ba07e06928761eefece3ec5a106fb3a9";
		String hex = "f83bf80e0af28fb968ddcd3e8e22e59d6a222edacf3a9b7f";
		System.out.println("待解密的 hex: " + hex);
		
		// 將 hex 轉 byte[]
		byte[] byteArray = des.hexToByteArray(hex);
		// 解密
		byte[] deMsg = des.decryptor(byteArray);
		// 將解密後的 byte[] 轉 String
		String output = new String(deMsg);
		System.out.println("解密: " + output);
		
	}

}
