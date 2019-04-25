package maze;

import java.util.Scanner;

/**
 * Created by stanislav.matukevich on 25.04.2019.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Please, enter the size fo maze");
        Scanner scanner = new Scanner(System.in);
        int width=0;
        int height=0;
        try {
            height = scanner.nextInt();
            width = scanner.nextInt();
        } catch (Exception e){
            System.out.println("You must input integer number");
        }
        if (width <3 || height <3) {
            System.out.println("Input number too small");
        }
        Maze maze = new Maze(width, height);
        maze.draw();
    }
}
