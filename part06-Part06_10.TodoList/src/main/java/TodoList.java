import java.util.ArrayList;

public class TodoList {
    private ArrayList<String> list;

    public TodoList(){
        this.list = new ArrayList<>();
    }

    public void add (String task){
        list.add(task);
    }

    public void print(){
        String listPrintout="";
        for (int i = 1;i<=list.size();i++){
            listPrintout = listPrintout + i + ": " + list.get(i-1) + "\n";
        }
        System.out.println(listPrintout);
    }

    public void remove(int number){
        list.remove(number-1);
    }
}
