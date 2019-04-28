package maze;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by stanislav.matukevich on 25.04.2019.
 */
public class Main {
    public static void main(String[] args) {
        //System.out.println("Please, enter the size fo maze");
        Scanner scanner = new Scanner(System.in);


        int width=0;
        int height=0;
        /*try {
            height = scanner.nextInt();
            width = scanner.nextInt();
        } catch (Exception e){
            System.out.println("You must input integer number");
        }
        if (width <3 || height <3) {
            System.out.println("Input number too small");
        }*/
        int input =0;
        Maze maze = new Maze();
        Menu menu = new Menu();
        do {
            menu.show();
            try {
                input = scanner.nextInt();
            } catch (Exception e){
                System.out.println("Incorrect option. Please try again");
            }
            if (input == 1){
                System.out.println("Enter the size of a new maze");
                int size = scanner.nextInt();
                maze = new Maze(size, size);
                maze.draw();
                menu.haveMaze = true;
            }
            if (input == 4 ) {
                maze.draw();
            }
            if (input ==3){
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
                String path = scanner.next();
                //System.out.println(path);
                File file = new File(path);
                try (BufferedReader reader = new BufferedReader(new FileReader(file))){
                    String line;
                    line = reader.readLine();
                    //System.out.println(line);
                    int len = line.length();
                    int[][] loadMap = new int[len][len];
                    int row=0;
                    do {
                        for (int i = 0; i <len ; i++) {
                            loadMap[row][i]= Integer.parseInt(line.substring(i,i+1));
                            //System.out.println(loadMap[row][i]);
                        }
                        row++;
                        line = reader.readLine();
                        //System.out.println(line);
                    } while (line != null);
                    maze = new Maze(len, len);
                    maze.map = loadMap;

                        }catch (Exception l){}
                menu.haveMaze = true;
            }

        } while (input !=0);
    }
}
