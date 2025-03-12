import static help.Helper.*;
class Main {
	public static void main(String[] args) 
    {
		Board board1 = new Board(61); // 20 starting squares
		Board board2 = new Board(51); // 30 starting squares
		Board board3 = new Board(41); // 40 starting squares
        println("Hard");
		board1.printBoard();
		println("Medium");
		board2.printBoard();
		println("Easy");
		board3.printBoard();
	}
}