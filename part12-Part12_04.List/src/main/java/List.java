public class List<Type> {
    private Type[] values;
    private int firstFreeIndex;

    public List() {
        this.values = (Type[]) new Object[10];
        this.firstFreeIndex = 0;
    }

    public void add(Type value) {
        if (this.values.length == this.firstFreeIndex) {
            grow();
        }
        this.values[this.firstFreeIndex] = value;
        this.firstFreeIndex++;
    }

    public void grow() {
        int newSize = this.values.length + this.values.length / 2;
        Type[] newValues = (Type[]) new Object[newSize];
        for (int i = 0; i < this.values.length; i++) {
            newValues[i] = this.values[i];
        }
        this.values = newValues;
    }

    public void remove(Type value) {
        int indexOfValue = indexOfValue(value);
        if(indexOfValue<0){
            return;
        }
        moveToTheLeft(indexOfValue);
        this.firstFreeIndex--;

    }

    public void moveToTheLeft(int fromIndex) {
        for (int i = fromIndex; i < firstFreeIndex; i++) {
            this.values[i]=this.values[i+1];
        }
    }

    public int indexOfValue(Type value) {
        for (int i = 0; i < this.firstFreeIndex; i++) {
            if (this.values[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Type value){
        return indexOfValue(value) >=0;
    }
}
