package maze;

import java.util.Objects;

public class Node {
    public int x;
    public int y;
    public int value;

    public Node (int x, int y, int value){
        this.x=x;
        this.y=y;
        this.value=value;
    }
    @Override
    public boolean equals (Object a){
        if (this == a) {
            return true;
        }
        if (!(a instanceof Node)){
            return false;
        }
        Node b = (Node) a;
        return Integer.compare(x, b.x)==0  && Integer.compare(y, b.y)==0 && value>=b.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, value);
    }
}