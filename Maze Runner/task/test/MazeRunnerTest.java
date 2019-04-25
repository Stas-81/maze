import maze.Main;
import org.hyperskill.hstest.v4.stage.MainMethodTest;
import org.hyperskill.hstest.v4.testcase.CheckResult;
import org.hyperskill.hstest.v4.testcase.TestCase;

import java.util.ArrayList;
import java.util.List;


class Clue {
    int size;
    Clue(int s) {
        size = s;
    }
}

public class MazeRunnerTest extends MainMethodTest<Clue> {

    public MazeRunnerTest() throws Exception {
        super(Main.class);
    }

    @Override
    public List<TestCase<Clue>> generateTestCases() {
        return List.of(
            new TestCase<Clue>()
                .setInput("0"),

            new TestCase<Clue>()
                .setInput("1\n16\n0")
                .setAttach(new Clue(16)),

            new TestCase<Clue>()
                .setInput("1\n54\n3\ntest_maze.txt\n0")
                .setAttach(new Clue(54)),

            new TestCase<Clue>()
                .setInput("2\ntest_maze.txt\n4\n0")
                .setAttach(new Clue(54))
        );
    }

    private List<String> getMaze(String reply) {

        List<String> maze = new ArrayList<>();
        String[] rows = reply.split("\n");

        boolean foundMaze = false;

        for (String row : rows) {
            boolean possibleMazeRow = true;
            boolean haveSpecialSymbol = false;
            for (char c : row.toCharArray()) {
                if (c == '█') {
                    haveSpecialSymbol = true;
                }
                if (c != '█' && c != ' ') {
                    possibleMazeRow = false;
                    break;
                }
            }
            if (haveSpecialSymbol && possibleMazeRow) {
                maze.add(row);
                foundMaze = true;
            } else if (foundMaze) {
                break;
            }
        }

        return maze;
    }

    @Override
    public CheckResult check(String reply, Clue clue) {

        List<String> maze = getMaze(reply);

        if (maze.size() != clue.size) {
            return new CheckResult(false,
                "Number of rows in the maze is incorrect");
        }

        int columnsLength = maze.get(0).length();

        if (columnsLength / 2 != clue.size) {
            return new CheckResult(false,
                "Number of columns in the maze is incorrect");
        }

        for (String row : maze) {
            int columnLength = row.length();
            if (columnLength != columnsLength) {
                return new CheckResult(false,
                    "Number of columns " +
                        "should be the same on every row");
            }
        }

        return CheckResult.TRUE;
    }
}
