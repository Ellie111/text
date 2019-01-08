package Command;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BoardScreen boardScreen = new BoardScreen();
		MenuItem menuItem = new MenuItem("新建",new CreateCommand(boardScreen));//使用CreateCommand类
		     ICommand creatCommand=new CreateCommand(boardScreen);
		     menuItem.setCommand(creatCommand);
		     menuItem.click();
		     MenuItem menuItem2 = new MenuItem("打开",new OpenCommand(boardScreen));//使用CreateCommand类
		     ICommand openCommand=new OpenCommand(boardScreen);
		     menuItem2.setCommand(openCommand);
		     menuItem2.click();
		     MenuItem menuItem3 = new MenuItem("编辑",new EditCommand(boardScreen));//使用CreateCommand类
		     ICommand editCommand=new EditCommand(boardScreen);
		     menuItem3.setCommand(editCommand);
		     menuItem3.click();
	}

}
