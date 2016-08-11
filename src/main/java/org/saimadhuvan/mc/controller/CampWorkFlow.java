package org.saimadhuvan.mc.controller;

import java.util.Set;

import org.saimadhuvan.mc.common.CampActivity;
import org.saimadhuvan.mc.dao.entity.Camp;

public abstract class CampWorkFlow {
	
	protected Set<CampActivity> workFlow;
	protected CampActivity activity;
	protected Camp selectedCamp;

	public CampWorkFlow(Camp selectedCamp,Set<CampActivity> workFlow){
		this.workFlow = workFlow;
		this.selectedCamp = selectedCamp ;
	}

	/**
	 * @return the work flow
	 */
	public Set<CampActivity> getWorkFlow()
	{
		return workFlow;
	}

	/**
	 * @return the selectedCamp
	 */
	public Camp getSelectedCamp(){
		return selectedCamp;
	}
	
	/**
	 * @return the activity
	 */
	public CampActivity getActivity(){
		return activity;
	}
	
	public void setCurrentActivity(CampActivity activity) {
		this.activity = activity;
		
	}
	
	/**
	 * do the activity
	 */
	abstract public void performActivity();
}
