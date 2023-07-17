import java.util.Scanner;

public class GameLogic {
    private final Field field = new Field();
    private final Scanner sc = new Scanner(System.in);
    public void run() {
        while (getWinner().equals(State.BLANK)) {
            System.out.println("First player move");
            Integer p1Move = makeTurn();
            this.field.save(p1Move, State.X);
            showField();
            if (!getWinner().equals(State.BLANK)){
                break;
            }
            System.out.println("Second player move");
            Integer p2Move = makeTurn();
            this.field.save(p2Move, State.O);
            showField();
        }
        if (getWinner() == State.X) {
            System.out.println("First player win");
        } else if (getWinner() == State.O) {
            System.out.println("Second player win");
        } else
            System.out.println("Nobody win");
    }

    private State getWinner() {
        for (int i = 0; i < 3; i++) {
            if (this.field.getItem(3 * i) == this.field.getItem(3 * i + 1)
                    && this.field.getItem(3 * i) == this.field.getItem(3 * i + 2)) {
                return this.field.getItem(3 * i);
            }
            if (this.field.getItem(i) == this.field.getItem(i + 3)
                    && this.field.getItem(i) == this.field.getItem(i + 6)) {
                return this.field.getItem(i);
            }
        }
        if (this.field.getItem(0) == this.field.getItem(4)
                && this.field.getItem(0) == this.field.getItem(8)) {
            return this.field.getItem(0);
        }
        if (this.field.getItem(2) == this.field.getItem(4)
                && this.field.getItem(2) == this.field.getItem(6)) {
            return this.field.getItem(2);
        }
        for (int i = 0; i<9; i++) {
            if(this.field.getItem(i) == State.BLANK)
                return State.BLANK;
        }

        return null;
    }


    private Integer makeTurn() {
        System.out.println("Enter number 0 ... 8");
        Integer input = sc.nextInt();

        while (!validateInput(input)) {
            System.out.println("Enter again");
            input = sc.nextInt();
        }

        return input;
    }


    private boolean validateInput(Integer input) {
        return (input >=0 && input <= 8) && this.field.getItem(input) == State.BLANK;
    }

    private void showField() {
        field.snow();
    }

}

