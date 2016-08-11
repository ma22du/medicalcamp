/**
 * 
 */
package org.saimadhuvan.mc.controller;

import java.util.Set;
import org.saimadhuvan.mc.common.CampActivity;
import org.saimadhuvan.mc.dao.entity.Camp;

/**
 * @author madhu.b
 *
 */
public class PatientWorkFlow extends CampWorkFlow {

	/**
	 * @param selectedCamp
	 * @param workFlow
	 */
	public PatientWorkFlow(Camp selectedCamp, Set<CampActivity> workFlow) {
		super(selectedCamp, workFlow);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.saimadhuvan.mc.controller.CampWorkFlow#performActivity()
	 */
	@Override
	public
	void performActivity() {
		System.out.println("Performing patient work flow... CampId - " + selectedCamp.getId());
		//TODO 
		//1. List patients registered in selected camp
		//2. Select a patient , update his/her details
		//3. Select a patient , remove his/her registration
		//4. Register a new patient in selected camp 
		
		
	}
}
