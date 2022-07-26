package captcha;

import java.io.IOException;
import java.util.Random;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// CAPTCHA 圖靈驗正碼
// 1. 自動產出 A~z + 000~999 之間的認證碼圖像(含干擾資訊)
// 2. 並且將該碼存放到 session 屬性中與使用者輸入的驗證碼進行比對
@WebServlet("/captcha/authcodeimage")
public class AuthCodeImageServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("image/jpeg");
		Random random = new Random();
		// 產生認證碼
		String authCode = String.format("%c%03d", random.nextInt(52) + 65, random.nextInt(1000));
		System.out.printf("authCode: %s\n", authCode);
		
		// 將驗證碼存放在 session 屬性中
		req.getSession().setAttribute("authCode", authCode);
		System.out.printf("authCode from session: %s\n", req.getSession().getAttribute("authCode"));
		
		// 產出認證碼圖片串流
		try {
			ImageIO.write(getAuthCodeImage(authCode), "JPEG", resp.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 產出認證碼圖片串流
	private BufferedImage getAuthCodeImage(String authCode) {
		Random random = new Random();
		// 1. 建立圖像暫存區
		BufferedImage img = new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);
		// 2. 建立畫布
		Graphics g = img.getGraphics();
		// 3. 設定畫布的顏色
		g.setColor(Color.YELLOW);
		// 4. 塗滿背景
		g.fillRect(0, 0, 80, 30);
		// 5. 設定顏色
		g.setColor(Color.BLACK);
		// 6. 設定字型(字體,字樣,尺寸)
		// 7. 繪文字
		for(int i=0;i<authCode.length();i++) {
			//Graphics2D g2 = (Graphics2D) g;
			g.setFont(new Font("consolas", i%2==0?Font.BOLD:Font.ITALIC, random.nextInt(20) + 10));
			g.drawString(authCode.charAt(i) + "", 5 + i*20, 23);
		}
		//g.setFont(new Font("Arial", Font.BOLD, 30));
		//g.drawString(authCode, 10, 23);
		// 繪製干擾線
		g.setColor(Color.RED);
		for(int i=0;i<15;i++) {
			int x1 = random.nextInt(80);
			int y1 = random.nextInt(30);
			int x2 = random.nextInt(80);
			int y2 = random.nextInt(30);
			g.drawLine(x1, y1, x2, y2);
		}
		return img;
	} 
	
}
