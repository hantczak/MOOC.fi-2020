public class Hideout <T> {
    private T object;

    public Hideout(){
        object=null;
    }

    public void putIntoHideout(T toHide){
        this.object = toHide;
    }

    public T takeFromHideout(){
        T temp=object;
        object=null;
        return temp;
    }

    public boolean isInHideout(){
        if(object!=null){
            return true;
        }else {
            return false;
        }
    }
}
