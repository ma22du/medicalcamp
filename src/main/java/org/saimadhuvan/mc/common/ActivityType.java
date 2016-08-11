/**
 * 
 */
package org.saimadhuvan.mc.common;

/**
 * @author madhu.b
 *
 */
public enum ActivityType {
	PATIENT_REGISTER("Patient"),
	STOCK_REGISTER("Stock"),
	PHARMACY("Pharmacy");
	
	private final String activityName;
	
	private ActivityType(String activityName){
		this.activityName = activityName;
	}
	
	public String getActivityName(){
		return this.activityName;
	}
}
