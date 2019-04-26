package maze;

public class Menu {
    public String[] items = new String[5];
    public boolean haveMaze;

    public Menu (){
        items[0] = "1. Generate a new maze.";
        items[1] = "2. Load a maze.";
        items[2] = "3. Save the maze.";
        items[3] = "4. Display the maze.";
        items[4] = "0. Exit.";
    }

    public void show(){
        System.out.println("=== Menu ===");
        for (int i = 0; i <items.length ; i++) {
            if ((i == 2 || i == 3) && !haveMaze){continue;}
            System.out.println(items[i]);
        }
    }

}
