import java.util.ArrayList;
import java.util.List;

public class Pipe<T> {
    private List<T> object;

    public Pipe() {
        this.object = new ArrayList<>();
    }

    public void putIntoPipe(T value) {
        object.add(value);
    }

    public T takeFromPipe(){
        T temp=null;
        if(!object.isEmpty()) {
            temp = object.get(0);
            object.remove(0);
        }
        return temp;
    }

    public boolean isInPipe(){
        if(object.isEmpty()){
            return false;
        }else {
            return true;
        }
    }
}
