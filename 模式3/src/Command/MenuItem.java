package Command;

public class MenuItem {
	 private ICommand command;
	  private String itemName;
	  public MenuItem(String itemName,ICommand command) {
			     this.command = command;
			     this.itemName = itemName;
			  }
		
			  public ICommand getCommand() {
			     return command;
			  }
			  public void setCommand(ICommand command) {
			     this.command = command;
			  }
			  public String getItemName() {
			     return itemName;
			  }
			  public void setItemName(String itemName) {
			     this.itemName = itemName;
			  }
			  public void click(){
			     System.out.println("MenuItem中的"+this.itemName+"被执行");
			     this.command.excute();
			  }
			
	  }