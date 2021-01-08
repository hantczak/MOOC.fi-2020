import java.util.ArrayList;
import java.util.List;

public class TodoList {
    private List<String> toDoList;

    public TodoList() {
        this.toDoList = new ArrayList<>();
    }

    public void add(String task) {
        toDoList.add(task);
    }

    public void print() {
        int i = 1;
        for(String row:toDoList){
            System.out.println(i+": "+ row);
            i++;
        }
    }

    public void remove(int position){
        toDoList.remove(position-1);
    }
}
