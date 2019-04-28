package maze;

import java.io.*;
import java.util.*;

/**
 * Created by stanislav.matukevich on 25.04.2019.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input =0;
        Maze maze = new Maze();
        Menu menu = new Menu();
        //
        //maze = new Maze(21, 21);
        //maze.findPath(new Node(0,2,0),new Node(12,11,999));

        //
        do {
            menu.show();
            try {
                input = scanner.nextInt();
            } catch (Exception e){
                System.out.println("Incorrect option. Please try again");
            }
            if (input == 1){ //generate new mage
                System.out.println("Enter the size of a new maze");
                int size = scanner.nextInt();
                maze = new Maze(size, size);
                maze.draw();
                menu.haveMaze = true;
            }
            if (input == 4 ) { //draw current maze

                maze.draw();
            }

            if (input == 5 ) { //draw current maze with exit path
                for (int i = 0; i <maze.getWidth() ; i++) {
                    maze.map[3][i]=2;
                }
                maze.draw();
            }
            if (input == 3){
                //System.out.print("Please, enter name of file to save current maze: ");
                String path = scanner.next();
                File file = new File(path);
                try (FileWriter writer = new FileWriter(file)){
                    for (int i = 0; i < maze.getHeight(); i++) {
                        for (int j = 0; j < maze.getWidth(); j++) {
                            writer.write(String.valueOf(maze.map[i][j]));
                        }
                        writer.write("\n");
                    }
                } catch (Exception e){}
            }
            if (input == 2){ //load maze
                //System.out.print("Please, enter name of file to load2 current maze: ");
                String path = scanner.next();
                File file = new File(path);
                try (BufferedReader reader = new BufferedReader(new FileReader(file))){
                    String line;
                    line = reader.readLine();
                    int len = line.length();
                    int[][] loadMap = new int[len][len];
                    int row=0;
                    do {
                        for (int i = 0; i <len ; i++) {
                            loadMap[row][i]= Integer.parseInt(line.substring(i,i+1));
                        }
                        row++;
                        line = reader.readLine();
                    } while (line != null);
                    maze = new Maze(len, len);
                    maze.map = loadMap;
                        }catch (Exception l){}
                menu.haveMaze = true;
            }

        } while (input !=0); //exit
    }
}
