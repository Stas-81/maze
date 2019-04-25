package maze;

public class Menu {
    public String[] items = new String[4];
    public boolean haveMaze;

    public Menu (){
        items[0] = "1. Generate a new maze.";
        items[0] = "2. Load a maze.";
        items[0] = "3. Save the maze.";
        items[0] = "4. Display the maze.";
        items[0] = "5. Exit.";
    }

    public void showMenu (){
        for (int i = 0; i <items.length ; i++) {
            if (i == 2 || i==3 && !haveMaze){continue;}
            System.out.println(items[i]);
        }
    }

}
