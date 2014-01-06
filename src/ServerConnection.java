import com.enterprisedt.net.ftp.*;

import java.io.IOException;
import java.net.URI;
import java.util.Date;

/**
 * Created by bensimms on 06/01/2014.
 */
public class ServerConnection extends TheTinyGifMaker {

    FileTransferClient ftp;

    public void connectToServer(String exportedAnimation) {
        Date date = new Date();
        long dateSubmitted = date.getTime();
        FileTransferClient ftp = null;

        try {
            ftp = new FileTransferClient();
            println("Connecting To Server");

            // Log in and choose folder
            ftp.setRemoteHost("");
            ftp.setUserName("");
            ftp.setPassword("");
            ftp.connect();
            ftp.setContentType(FTPTransferType.BINARY);
            ftp.changeDirectory("public_html/bensimms/TheTinyGifMaker/");
            println("Connected");
            println(ftp.getRemoteDirectory());

            //Upload the animation
            ftp.uploadFile(exportedAnimation, "image" + dateSubmitted + ".gif");

            //Launch Native browser and navigate to the uploaded gif.
            println("UPLOADED WOO HOO!!");
            java.awt.Desktop.getDesktop().browse(URI.create("http://www.bensimms.co.uk/TheTinyGifMaker/" + "image" + dateSubmitted + ".gif"));


        } catch (Exception e) {
            println("Failed to connect");
        }
    }


}



