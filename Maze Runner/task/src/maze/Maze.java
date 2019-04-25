package maze;

import java.util.Random;

/**
 * Created by stanislav.matukevich on 25.04.2019.
 */
public class Maze {
    public int[][] map;
    private int height;
    private int width;

    public Maze(int width, int height) {
        this.height = height;
        this.width = width;
        this.map = generate(width, height);
    }

    public int[][] generate(int width, int height) {

        int[][] map = new int[height][width];
        Random rng = new Random();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                //algorithm

                map[i][j] = rng.nextInt(1+1);
                if (i==0 || i==height-1 || j==0 || j==width-1){ map[i][j]=1;}

            }
        }
        return map;
    }

    public void draw() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (map[i][j]==0) {
                    System.out.print("  ");
                } else if (map[i][j]==1){
                    System.out.print("XX");
                }//\u2588
            }
            System.out.println();
        }
    }
}