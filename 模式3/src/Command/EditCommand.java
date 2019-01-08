package Command;

public class EditCommand implements ICommand {

	  public BoardScreen  BoardScreen=new BoardScreen();

    public void excute() {
        BoardScreen.edit();
    }
    public EditCommand(BoardScreen boardScreen) {
        this.BoardScreen = boardScreen;
     }

 
}