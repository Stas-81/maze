package maze;

import java.util.ArrayList;
import java.util.List;
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
    ArrayList<Node> path = new ArrayList<>();

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
        int exitY = random.nextInt(room.maxY-3)+1; //set exits
        int exitX = random.nextInt(room.maxX-3)+1;
        while (map[exitY][1] == 1){
            exitY++;
        }
        map[exitY][0] =0;
        while (map[exitX][room.maxX-1] == 1){
            exitX++;
        }
        map[exitX][room.maxX] =0;
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
                    System.out.print("  ");
                } else if (map[i][j]==1){
                    System.out.print("XX");
                }
            }
            System.out.println();
        }
    }

    public void findPath (Node a, Node b){
        path.add(a);
        addAdjNodes(a);
        System.out.println(path.toString());
        //addAdjNodes(a);

    }

    public void addAdjNodes(Node a){
        ArrayList<Node> adj = new ArrayList<>();
        System.out.println(a.x + " "+a.y);
        if (a.x-1>=0 && map[a.y][a.x-1]==0) {adj.add(new Node(a.x-1,a.y,a.value+1));}
        if (a.x+1<this.width && map[a.y][a.x+1]==0) {adj.add(new Node(a.x+1,a.y,a.value+1));}
        if (a.y-1>=0 && map[a.y-1][a.x]==0) {adj.add(new Node(a.x,a.y-1,a.value+1));}
        if (a.y+1<this.height && map[a.y+1][a.x]==0) {adj.add(new Node(a.x,a.y+1,a.value+1));}
        //System.out.println(adj.toString());
        adj.forEach();
        path.addAll(adj);
    }

    public boolean findNode (Node b) {
        return false;
    }
}