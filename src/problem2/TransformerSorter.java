package problem2;

import java.util.Comparator;


// This is a optional class
public class TransformerSorter implements Comparator<Transformer> {
    @Override
    public int compare(Transformer t1, Transformer t2) {
        if(t1.getRank() == t2.getRank()){
            return 0;
        }else if(t1.getRank() > t2.getRank()){
            return 1;
        }else {
            return -1;
        }
    }
}
