package org.saimadhuvan.mc.controller;

import java.util.Set;
import org.saimadhuvan.mc.dao.entity.Camp;
import org.saimadhuvan.mc.common.CampActivity;

public class MainWorkFlow extends CampWorkFlow{
	
	public MainWorkFlow(Camp selectedCamp, Set<CampActivity> workFlow) {
		super(selectedCamp, workFlow);
		// TODO Auto-generated constructor stub
	}	

	@Override
	public void performActivity() {
		
		if(workFlow.contains(CampActivity.REGISTER_PATIENT)){
			System.out.println(CampActivity.REGISTER_PATIENT.getGroupName() + " activities ...");
			PatientWorkFlow pFlow = new PatientWorkFlow(selectedCamp, workFlow);
			pFlow.performActivity();
		}
		else if(workFlow.contains(CampActivity.ADD_MEDICINES)){
			System.out.println(CampActivity.ADD_MEDICINES.getGroupName() + " activities ...");
		}
		else{
			System.out.println("Pharmacy activities ...");
		}
	}
	
}
