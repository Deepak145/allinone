package com.my.app.user.models;

import java.util.Arrays;
import java.util.List;

public enum Stream {

	IT, CSE, EC, MECH, ECS ;
	
	public List<SUBJECT> GET_IT() {
		return Arrays.asList(SUBJECT.ADA, SUBJECT.CSE, SUBJECT.COMPUTER_SCIENCE,SUBJECT.ENGLISH);
	}
	public List<SUBJECT> GET_CSE() {
		return Arrays.asList(SUBJECT.C, SUBJECT.DATA_STRUCTURE, SUBJECT.HINDI,SUBJECT.MATHS);
	}
	
	public List<SUBJECT> GET_EC() {
		return Arrays.asList(SUBJECT.HINDI, SUBJECT.PHYSICS, SUBJECT.MECHENICAL,SUBJECT.JAVA);
	}
	
	public List<SUBJECT> GET_MECH() {
		return Arrays.asList(SUBJECT.ADA, SUBJECT.ARCHITECT, SUBJECT.DATA_STRUCTURE,SUBJECT.ENGLISH);
	}
	
	public List<SUBJECT> GET_ECS() {
		return Arrays.asList(SUBJECT.COMPUTER_SCIENCE, SUBJECT.ENGLISH, SUBJECT.MATHS,SUBJECT.PHYSICS);
	}
}
