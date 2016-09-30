package com.flp.ems.comparator;

import java.util.Comparator;

import com.flp.ems.domain.Employee;

public class CompareById implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		
	 Integer id1 = ((Employee)o1).getEmp_id();
	 Integer id2 = ((Employee)o2).getEmp_id();	
		int diff = id1-id2;
			return diff;
		
		
	}

}
