import java.util.ArrayList;

public class SelectByQueue implements Command {
	private int controller_id;
	private int coffee_machine_id;
	private int orderID;
	private String drinkName;
	private String requestType;
	
	public SelectByQueue(int orderID, String drinkName) {
		this.orderID = orderID;
		this.drinkName = drinkName;
		applyMachineSelection();
	}

	
	@Override
	public int getMachineId() {
		return coffee_machine_id;
	}

	@Override
	public void applyMachineSelection() {
		// machine selection is currently hard coded but could be
		// updated to view database and select machine and controller
		// based on machine queue
		this.controller_id = 1;
		this.coffee_machine_id = 2;
		this.requestType = "Simple";
	}
	
	@Override
	public int getControllerId() {
		return controller_id;
	}

	@Override
	public int getOrderId() {
		return orderID;
	}
}	
