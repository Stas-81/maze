package maze;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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
                menu.haveMaze = true;
            }
            if (input == 4 ) {
                maze.draw();
            }
            if (input ==3){
                File file = new File("test_maze.txt");
                try (FileWriter writer = new FileWriter(file)){
                    for (int i = 0; i < maze.getHeight(); i++) {
                        for (int j = 0; j < maze.getWidth(); j++) {
                            writer.write(String.valueOf(maze.map[i][j]));
                        }
                        writer.write("\n");
                    }
                } catch (Exception e){}
            }
            if (input == 2){
                File file = new File("test_maze.txt");
                try (FileReader reader= new FileReader(file)){
                    while (reader.ready()){

                    }


                        }
                        //.write("\n");
                    }
                } catch (Exception l){}
            }
            }

        } while (input !=0);
    }
}
