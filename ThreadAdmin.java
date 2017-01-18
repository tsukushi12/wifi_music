import java.util.*;
public class ThreadAdmin{
    static Map<String, Thread> threads = new HashMap<String, Thread>();
    static PlayBack activethread;
    ThreadAdmin(){
        
    }
    static void add(String fn, PlayBack t){
        threads.add(fn, t);
    }
    static void changeTo(String filename){
        if(activeThread != null)
        {
            activeThread.backTo();
        }
    }
}