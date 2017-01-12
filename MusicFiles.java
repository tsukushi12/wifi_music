import java.io.*;
public class MusicFiles{
    final static String rootpath = "/wifi_music/music/";
    public File dir;
    public static void main(String args[]){
        MusicFiles f = new MusicFiles();
        f.output();
    }
    MusicFiles(){
        dir = new File(rootpath);
    }
    public File[] getFiles(){
        return dir.listFiles();
    }
    public String[] getFileNames(){
        return dir.list();
    }
    public static File getFilePath(String filename){
        return new File(rootpath + filename);
    }
    public void output(){
        String files[] = dir.list();
        for (String file: files){
            System.out.println(file);
        }
    }
}