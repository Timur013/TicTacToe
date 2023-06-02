
import java.util.Scanner;

public class GameLogic {
    private Field f = new Field();
    private boolean isTurnCrossPlayer;
    private int turnNumber;
    private int turnsLeftCounter;
    private boolean isGameOver;
    private boolean isGameExit;
    private State winner;
    private Scanner sc = new Scanner(System.in);

    GameLogic() {
        f = new Field();
        reset();
    }

      public void run() {
          System.out.println("Начинаем новую игру!");
          reset();

          while (true) {
              showField();
              showGameInfo();
              makeTurn();

              if (isGameExit)
                  break;

              if (isGameOver) {
                  showWinner();

                  if (!tryAgain()) {
                      break;
                  }
              }

          }
          sc.close();
      }

      private void reset() { //перезапуск
          f.init();
          isTurnCrossPlayer = true;
          isGameOver = false;
          isGameExit = false;
          turnNumber = 1;
          winner = State.Blank;
          turnsLeftCounter = Field.FIELD_WIDTH * Field.FIELD_WIDTH;
      }

      private void makeTurn() {
        try {
            int index = sc.nextInt();

            if (!isIndexCorrect(index))
                return;

            f.save(index, (isTurnCrossPlayer) ? State.X.toString() : State.O.toString());
            turnNumber++;
            turnsLeftCounter--;

            isGameOver = isGameOver(index);
        } catch (Exception ex) {

            if(sc.next().equalsIgnoreCase("q")) {
                isGameExit = true;
            } else {
                System.out.println("Повторите ход!");
            }

        }
      }

      private boolean isIndexCorrect(int index){
        if (index < 0 ||
                index >= Field.FIELD_WIDTH * Field.FIELD_WIDTH ||
                  !f.isBlank(index)) {

            System.out.println("Повторите ход!");
            return false;
        }

          return true;

      }


    private boolean isGameOver(int index) { //метод завершения

        if (turnsLeftCounter == 0)
            return true;

        int x = index / Field.FIELD_WIDTH;
        int y = index % Field.FIELD_WIDTH;

        if (f.isRowFinished(x) ||
                f.isColumnFinished(y) ||
                f.isDiagonalFromTopLeftFinished(x,y)||
                f.isDiagonalFromTopRightFinished(x,y)) {

            winner = (isTurnCrossPlayer) ? State.X : State.O;
            return true;
        }

        isTurnCrossPlayer = !isTurnCrossPlayer;
        return false;
      }

      private void showWinner() {
         showField();
         System.out.print("Игра закончана!");

         if (winner == State.Blank) {
             System.out.println("Ничья!");
         } else {
             System.out.println("Выйграл игрок" + winner + ".");
         }
      }

      private  boolean tryAgain() { // метод для повтора игры.
        while (true) {
            System.out.println("Сыграем снова?(да/нет): ");
            String response = sc.next();
            if (response.equalsIgnoreCase("да")) {
                return true;
            } else if (response.equalsIgnoreCase("нет")) {
                return false;
            }
            System.out.println("Неправильный ввод.");
        }
      }

      private void showField() {
        f.snow();
      }

      private void showGameInfo() {
        System.out.println("ход номер" + turnNumber);
        System.out.print("осталось ходов" + turnsLeftCounter);
        System.out.println("ходит игрок" + ((isTurnCrossPlayer) ? State.X : State.O));
        System.out.println("укажите q для выхода:");
      }
}



































