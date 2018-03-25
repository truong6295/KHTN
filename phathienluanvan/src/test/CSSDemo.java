package test;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.concurrent.ConcurrentSkipListSet;

public class CSSDemo {

    public static void main(String[] args) {
        NavigableSet<String> citySet = new ConcurrentSkipListSet<String>();
        citySet.add("New Delhi");
        citySet.add("Mumbai");
        citySet.add("Mumbai");
        citySet.add("Hyderabad");
        
        System.out.println("---- Traversing the set-----");
        Iterator<String> itr = citySet.iterator();
        while(itr.hasNext()){
            System.out.println("Value -  " + itr.next());
        }
    }
}
