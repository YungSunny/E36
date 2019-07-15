import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage e36;
    public static BufferedImage audi;
    public static BufferedImage bullet;
    public static BufferedImage back;
    public static BufferedImage star;
    public static BufferedImage e36big;

    public static void init (){
        Image image1 = new Image(ImageLoader.loadImage("/e36.png/"));
        Image image2 = new Image(ImageLoader.loadImage("/80.png/"));
        Image image3 = new Image(ImageLoader.loadImage("/bum.png/"));
        Image image4 = new Image(ImageLoader.loadImage("/back.png"));
        Image image5 = new Image(ImageLoader.loadImage("/star.png"));
        Image image7 = new Image(ImageLoader.loadImage("/e36big.png"));
        e36 = image1.getImage();
        audi= image2.getImage();
        bullet = image3.getImage();
        back = image4.getImage();
        star = image5.getImage();
        e36big = image7.getImage();
    }
}
