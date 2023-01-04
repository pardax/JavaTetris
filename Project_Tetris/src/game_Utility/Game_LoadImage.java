package game_Utility;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Game_LoadImage {
	
	public static BufferedImage getImg(String path) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(path));
		} catch (IOException e) {
			System.out.println("블록 이미지 불러오기 실패");
		}
		return img;
	}
}
