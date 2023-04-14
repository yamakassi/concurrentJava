package concurrent;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class FileThreadLoad implements Runnable {
    private final String url;
    private final int batch;
    private final String file;

    public FileThreadLoad(String url, int batch) {
        this.url = url;
        this.batch = batch;
        this.file = "file.txt";
    }


    @Override
    public void run() {
        try(BufferedInputStream in= new BufferedInputStream(new URL(url).openStream());
            FileOutputStream fileOutputStream = new FileOutputStream(file)){
            System.out.println(in);
            System.out.println(fileOutputStream);
            byte[] dataBuffer = new byte[batch];
            int bytesRead;
            long startTime = System.currentTimeMillis();
            long lTime;
            while((bytesRead = in.read(dataBuffer,0,batch)) != -1){
                fileOutputStream.write(dataBuffer, 0, bytesRead);
                lTime = System.currentTimeMillis() - startTime;
                if (lTime < 1000) {
                    Thread.sleep(lTime);
                }
                startTime = System.currentTimeMillis();
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
