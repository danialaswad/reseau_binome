package polytech.si3.firstserver.host.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 07/05/2016.
 */
public class Ideas {
    private List<Idea> list;
    public static int MAX_SIZE = 1024;

    public Ideas(){
        list = new ArrayList();
    }

    public void add(Idea idea){
        list.add(idea);
    }

    public Idea find(Idea idea){
        return list.get(list.indexOf(idea));
    }

    public boolean contains(Idea idea){
        return list.contains(idea);
    }

    public int size(){
        return list.size();
    }

    public Idea get(int i){
        return list.get(i);
    }

    @Override
    public String toString(){
        String s = "TITLE | DESCRIPTION | MANAGERID\n";
        for(int i = 0; i < list.size(); i++)
            s+=list.get(i).toString() + "\n";

        return s;
    }

}
