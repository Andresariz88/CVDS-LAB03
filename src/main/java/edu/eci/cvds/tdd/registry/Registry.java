package edu.eci.cvds.tdd.registry;

import java.util.ArrayList;

public class Registry {
	
	private ArrayList<Integer> ids = new ArrayList<Integer>();
	
	public RegisterResult registerVoter(Person p) {
		RegisterResult result = p.isValid();
		if (result == RegisterResult.VALID) {
			if (ids.contains(p.getId())) {
				result = RegisterResult.DUPLICATED;
				return result;
			}
		}
		ids.add(p.getId());
		return result;
	}
}
