import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.awt.Color;
import java.awt.Font;

import javax.imageio.ImageIO;

public class StickerGenerator {
    
    public static void cria(InputStream inputStream, String nomeArquivo) throws Exception{

        BufferedImage imagemOriginal  = ImageIO.read(inputStream);
        
        int altura = imagemOriginal.getHeight();
        int largura = imagemOriginal.getWidth();

        int novaAltura = altura + 50;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 12);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(font);

        graphics.drawString("TOPZERA", novaImagem.getWidth() / 3, novaImagem.getHeight() - 25 );

        ImageIO.write(novaImagem, "png", new File("img/" + nomeArquivo + ".png"));
    }
}
