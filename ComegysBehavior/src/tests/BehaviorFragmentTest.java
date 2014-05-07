package edu.upenn.cis350.comegysbehavior;

import static org.junit.Assert.*;

import org.junit.Test;

public class BehaviorFragmentTest {

	@Test
	public void testOnCheckboxClicked() {
		MainActivity ma = new MainActivity();
		ma.resetBehaviorFragment();
		BehaviorFragment bf = new BehaviorFragment();
		assertFalse(bf.getReport().academic_completesHomeworkAndAssignments);
	}

}
