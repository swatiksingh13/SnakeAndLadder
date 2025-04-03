package in.game.models;

public class Snake extends BoardEntity {
    public Snake(int start, int end) {
        super(start, end, BoardEntityType.SNAKE);
    }

    @Override
    public void printMessage() {
        System.out.println("Yayy, You encountered a Snake ~~~~ :)");
    }

    @Override
    public void printEntity() {
        System.out.print("S(" + this.getEnd() + ") ");
    }
}

