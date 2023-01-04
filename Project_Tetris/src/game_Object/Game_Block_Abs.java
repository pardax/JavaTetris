package game_Object;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

//블록 추상
public abstract class Game_Block_Abs {
	public abstract Rectangle getBound();
	public abstract void update();
	public abstract void drawRect(Graphics g);
	public abstract void setBlockState(BufferedImage color, int id, int cid);
	public abstract void setBlockColor(BufferedImage blockImg);
	public abstract void clearBlock();
	public abstract boolean getBlockState();
	public abstract int getBlockID();
	public abstract int getColorID();
	
	
}
