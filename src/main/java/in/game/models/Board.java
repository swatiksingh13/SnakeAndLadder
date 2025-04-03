package in.game.models;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private int dimension;
    private int cellCount;
    private Map<Integer, BoardEntity> boardEntityMap;

    public Board(int dimension) {
        this.dimension = dimension;
        this.cellCount = dimension * dimension;
        boardEntityMap = new HashMap<>();

        //Add n number of Snakes and Ladders in the HashMap (Where n is the dimension of the board).
        addSnakesAndLadders();
    }

    //Snake -> s, e => s > e
    //Ladder -> s, e => e > s

    private void addSnakesAndLadders() {
        //n snakes to the board (start > end)
        addSnakes();

        //n ladders to the board (end > start)
        addLadders();
    }

    private void addSnakes() {
        for(int i=0; i< dimension; i++) {
            int min = 2;
            int max = cellCount - 1;

            int start = (int) Math.floor(Math.random() * (max - min +1) + min);
            max = start - 1;
            int end = (int) Math.floor(Math.random() * (max - min + 1) + min);

            // no snakes or ladders should be present
            if(!hasSnakeOrLadder(start)) {
                boardEntityMap.put(start, new Snake(start, end));
            }
        }
    }

    private void addLadders() {
        for(int i=0; i< dimension; i++) {
            int min = 2;
            int max = cellCount - 1;

            int end = (int) Math.floor(Math.random() * (max - min +1) + min);
            max = end - 1;
            int start = (int) Math.floor(Math.random() * (max - min + 1) + min);

            if(!hasSnakeOrLadder(start)) {
                boardEntityMap.put(start, new Ladder(start, end));
            }
        }
    }

    public void display() {
        int tempCellCount = cellCount;
        int index;
        for (int row = 0; row < dimension; row++) {
            // Print left to right if even row, right to left if odd
            if (row % 2 == 0) {
                for (int col = 0; col < dimension; col++) {
                    index = tempCellCount;

                    System.out.printf("%4d", tempCellCount);

                    if (hasSnakeOrLadder(index)) {
                        BoardEntity entity = boardEntityMap.get(index);
                        entity.printEntity();
                    }

                    tempCellCount-=1;
                }
            } else {
                int temp = tempCellCount - dimension+ 1;
                for (int col = 0; col < dimension; col++) {

                    System.out.printf("%4d", temp);

                    if (hasSnakeOrLadder(temp)) {
                        BoardEntity entity = boardEntityMap.get(temp);
                        entity.printEntity();
                    }

                    temp+=1;
                }
                tempCellCount -= dimension;
            }
            System.out.println(); // New line for each row
        }
    }

    public boolean hasSnakeOrLadder(int index) {
        return boardEntityMap.containsKey(index);
    }


    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public Map<Integer, BoardEntity> getBoardEntityMap() {
        return boardEntityMap;
    }

    public void setBoardEntityMap(Map<Integer, BoardEntity> boardEntityMap) {
        this.boardEntityMap = boardEntityMap;
    }

    public int getCellCount() {
        return cellCount;
    }

    public void setCellCount(int cellCount) {
        this.cellCount = cellCount;
    }

}

    /*
    n = 10;
    min = 2
    max = 99

    Math.random() -> [0, 1)

    (int) (Math.random() * (max - min + 1) + min);

    floor(x * 98 + 2)

    x = 0.1 => 9.8 + 2 = 11.8 = 11
    x = 0.3 => 0.3 * 98 + 2 = 29.4 + 2 = 31.4 = 31
    x = 0.5 => 0.5 * 98 + 2 = 49.0 + 2 = 51
    x = 0.37 => 0.37 * 98 + 2 = 36.26 + 2 = 38.26 = 38
     */
