package Command;

public class OpenCommand implements ICommand {

	    public BoardScreen  BoardScreen=new BoardScreen();

	    @Override
	    public void excute() {
	        BoardScreen.open();
	    }
	    public OpenCommand(BoardScreen boardScreen) {
	        this.BoardScreen = boardScreen;
	     }

	}
