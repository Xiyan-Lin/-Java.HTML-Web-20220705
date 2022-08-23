package security.des;

public class DESDecryptTest {

	public static void main(String[] args) throws Exception {
		// 解密的資料
		// 密文: 560df430de1dd0451f55021b79011154ab276a8230fd78c71d0f093c6cc49da9ba07e06928761eefece3ec5a106fb3a9
		
		// 取得密鑰位置
		String key_path = "C:/Users/MB-207/eclipse-workspace/JavaWeb_20220705/key/user.key";
		DESEncryptService des = new DESEncryptService(key_path);
		
		// 待解密文
		String hex = "560df430de1dd0451f55021b79011154ab276a8230fd78c71d0f093c6cc49da9ba07e06928761eefece3ec5a106fb3a9";
		System.out.println("待解密文: " + hex);
		// 將待解密文轉成 byte[]
		byte[] deByteArray = des.hexToByteArray(hex);
		// 將 byte[] 轉字串
		String msg = new String(deByteArray);
		System.out.println("解密: " + msg);
		
	}

}
