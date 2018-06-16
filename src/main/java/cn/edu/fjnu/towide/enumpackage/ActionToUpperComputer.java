package cn.edu.fjnu.towide.enumpackage;

public enum ActionToUpperComputer {
	GATE_OPENING("gate_opening","开闸"),
	VEHICLE_CHECKING("vehicle_checking","检查车辆")
	;
	
	private String actionCode;
	private String actionDescription;
	private ActionToUpperComputer(String actionCode, String actionDescription) {
		this.setActionCode(actionCode);
		this.setActionDescription(actionDescription);
	}
	public String getActionDescription() {
		return actionDescription;
	}
	public void setActionDescription(String actionDescription) {
		this.actionDescription = actionDescription;
	}
	public String getActionCode() {
		return actionCode;
	}
	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}
	
}

