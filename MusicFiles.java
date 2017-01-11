import java.io.*;
public class MusicFiles{
    final String rootpath = "/wifi_music/music";
    public File files[];
    public static void main(String args[]){
        MusicFiles f = new MusicFiles();
        f.output();
    }
    MusicFiles(){
        File dir = new File(rootpath);
        files = dir.listFiles();
    }
    public File[] getFiles(){
        return files;
    }
    public void output(){
        for (File file: files){
            System.out.println(file);
        }
    }
}