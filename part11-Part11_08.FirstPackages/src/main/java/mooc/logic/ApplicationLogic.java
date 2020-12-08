package mooc.logic;

import mooc.ui.TextInterface;
import mooc.ui.UserInterface;

public class ApplicationLogic {
    private UserInterface ui;

    public ApplicationLogic(UserInterface ui) {
        this.ui = ui;

    }

    public void execute(int times){
        int i=0;
        while (i<times){
            System.out.println("Application logic is working");
            i++;
            this.ui.update();
        }
    }
}


