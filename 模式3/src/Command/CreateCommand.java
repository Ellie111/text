package Command;

public class CreateCommand implements ICommand  {

	  public BoardScreen  BoardScreen=new BoardScreen();
	  
    public void excute() {
        BoardScreen.create();
    }
    public CreateCommand(BoardScreen boardScreen) {
        this.BoardScreen = boardScreen;
     }

}