import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.Scanner;
import java.awt.Image;
import java.io.Console;
import java.io.File;
import java.io.FileFilter;
import java.util.LinkedList;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Queue;
import java.awt.image.BufferedImage;

public class Imagesort extends JFrame{

    public static void main(String[] args) {
    try {       

    Scanner input = new Scanner(System.in);
    File sourcefile = new File("source");
    File current;
    File finished = new File("destination");
    String inputstring;
    BufferedImage image;

    if(!sourcefile.exists()){sourcefile.mkdir();}
    if(!finished.exists()){finished.mkdir();}


    File[] imagefilearray = sourcefile.listFiles( new FileFilter(){
        @Override
        public boolean accept(File pathname) {
            if(pathname.getName().endsWith(".jpg")){ return true;}
            if(pathname.getName().endsWith(".png")){ return true;}
            return false;
        }
    });

    Queue<File> imagesources = new LinkedList<File>(Arrays.asList(imagefilearray));
    imagefilearray = null;




    JLabel mainlabel = new JLabel();
    mainlabel.setVerticalAlignment(JLabel.CENTER);
    mainlabel.setHorizontalAlignment(0);

    
    JFrame frame = new JFrame("Window");
    frame.setSize(750,750);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);

    

    frame.add(mainlabel);
    frame.setVisible(true);
    
    while(true){
        System.out.flush();
        if(imagesources.peek() == null){ System.out.println("No source left");break;}
        current = imagesources.poll();
        image = ImageIO.read(current);
        mainlabel.setIcon(new ImageIcon( image.getScaledInstance(500,500,Image.SCALE_FAST)));
        inputstring = input.nextLine();
        if(inputstring == ".q"){System.out.println("quitting"); break;}
        finished = new File("./destination/"+inputstring);
        if(!finished.exists()){ finished.mkdir(); };
        finished = new File(finished.getPath()+"/"+Math.random()+".jpg");
        ImageIO.write(image, "jpg", finished);
        current.delete();


    }


        frame.dispose();
    }   catch (Exception e) {

        }

    }

}