/**
 * 
 */
package org.saimadhuvan.mc.common;

import java.util.EnumSet;
import java.util.Set;

import org.saimadhuvan.mc.common.ActivityType;
/**
 * @author madhu.b
 *
 */
public enum CampActivity {
	REGISTER_PATIENT(ActivityType.PATIENT_REGISTER,"Registeration"),
	UPDATE_PATIENT(ActivityType.PATIENT_REGISTER,"Updation"),
	REMOVE_PATIENT(ActivityType.PATIENT_REGISTER,"Deletion"),
	LIST_PATIENT_VISITS(ActivityType.PATIENT_REGISTER,"List Visits"),
	LIST_PATIENT_MEDICATION(ActivityType.PATIENT_REGISTER,"List Medications"),
	ADD_MEDICINES(ActivityType.STOCK_REGISTER,"Add Medicines"),
	UPDATE_MEDICINE_DETAILS(ActivityType.STOCK_REGISTER,"Update Medicine details"),
	DELETE_MEDICINE(ActivityType.STOCK_REGISTER,"Remove Medicine"),
	UPDATE_MEDICINE_STOCK(ActivityType.STOCK_REGISTER,"Update Medicine Stock"),
	REPORT_MEDICINE_STOCK(ActivityType.STOCK_REGISTER,"Report Medicine Stock"),
	RECORD_VISIT(ActivityType.PHARMACY,"Record Patient Visit"),
	SUPPLY_MEDICINES(ActivityType.PHARMACY,"Allot Medicine");
	
	private String groupName;
    private String subActivityName;

    private CampActivity(ActivityType type, String subActivityName) {
        this.groupName = type.getActivityName();
        this.subActivityName = subActivityName;
    }
    
    /**
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * @return the subActivityName
	 */
	public String getSubActivityName() {
		return subActivityName;
	}
	
	public static Set<CampActivity> PatientActivities = EnumSet.of(REGISTER_PATIENT, UPDATE_PATIENT,REMOVE_PATIENT,LIST_PATIENT_VISITS,LIST_PATIENT_MEDICATION);
	public static Set<CampActivity> StockActivities = EnumSet.of(ADD_MEDICINES,UPDATE_MEDICINE_DETAILS,DELETE_MEDICINE,UPDATE_MEDICINE_STOCK,REPORT_MEDICINE_STOCK);
	public static Set<CampActivity> PharmacyActivities = EnumSet.of(RECORD_VISIT,SUPPLY_MEDICINES);
}
