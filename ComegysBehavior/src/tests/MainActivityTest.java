package edu.upenn.cis350.comegysbehavior;

import static org.junit.Assert.*;

import org.junit.Test;

public class MainActivityTest {

	@Test
	public void testResetBehaviorFragment() {
		MainActivity ma = new MainActivity();
		ma.resetBehaviorFragment();
		BehaviorFragment bf = new BehaviorFragment();
		assertFalse(bf.getReport().academic_completesHomeworkAndAssignments);
	}

}
