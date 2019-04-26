package maze;

import java.util.Random;

/**
 * Created by stanislav.matukevich on 25.04.2019.
 */
public class Maze {
    public int[][] map;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    private int height;
    private int width;
    private Random random;

    public Maze(int width, int height) {
        random = new Random();
        this.height = height;
        this.width = width;
        this.map = new int[height][width];
        generate();
    }
    public Maze(){}

    public void generate() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i==0 || i==height-1 || j==0 || j==width-1){ map[i][j]=1;}
            }
        }
        Room room = new Room(1,1,width-1,height-1);
        buildMaze(room);
    }

    public void buildMaze (Room room){
        if (room.maxX - room.minX >3 && room.maxY-room.minY >3) {
            Random rnddir = new Random();
            if (rnddir.nextInt(1+1)>0) {
                int wallX = random.nextInt(room.maxX - room.minX + 1 -4) + room.minX+2;
                for (int i = room.minY; i < room.maxY; i++) {
                    map[i][wallX]=1;
                }
                Random rng = new Random();
                map[rng.nextInt(room.maxY - room.minY + 1 -2 ) + room.minY+1][wallX]=0;
                buildMaze(new Room(room.minX, room.minY, wallX-1,room.maxY));
                buildMaze(new Room(wallX+1, room.minY, room.maxX,room.maxY));
            } else {
                int wallY = random.nextInt(room.maxY - room.minY + 1 -4 ) + room.minY+2;
                for (int i = room.minX; i < room.maxX; i++) {
                    map[wallY][i]=1;
                }
                Random rng = new Random();
                map[wallY][rng.nextInt(room.maxX - room.minX + 1 - 2) + room.minX + 1] = 0;
                buildMaze(new Room(room.minX, room.minY, room.maxX,wallY-1));
                buildMaze(new Room(room.minX, wallY+1, room.maxX,room.maxY));
            }
        }
    }

    public void draw() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (map[i][j]==0) {
                    System.out.print(".");
                } else if (map[i][j]==1){
                    System.out.print("X");
                }//\u2588
            }
            System.out.println();
        }
    }
}