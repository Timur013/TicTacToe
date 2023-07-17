import java.util.Arrays;

public class Field {private final Integer STORAGE_LENGTH = 9;

    private final State[] storage = new State[STORAGE_LENGTH];

    public Field() {
        Arrays.fill(storage, State.BLANK);
    }

    public void save(int index, State s) {
        this.storage[index] = s;
    }

    public State getItem(Integer index) {
        return storage[index];
    }

    public void snow() {
        System.out.println("************************");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
            System.out.print(storage[i * 3 + j] + " ");

            }
            System.out.println();
        }
        System.out.println("************************");
    }

}



