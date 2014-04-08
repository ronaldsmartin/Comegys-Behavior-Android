/**
 * 
 */
package edu.upenn.cis350.comegysbehavior;

import com.parse.ParseObject;

/**
 * @author Ronald Martin
 * Object describing a behavior report
 */
public class Report {
	
	// Subject Info
	public String studentName;
	public String studentGrade;
	public String reportCreatedDate;
	
	/* BEHAVIOR REPORT */
	
	// Behavior Report - Positive
	public boolean behavior_respectForSelfAndOthers;
	public boolean behavior_followingDirections;
	public boolean behavior_positiveConflictResolution;
	public boolean behavior_peerMediation;
	public boolean behavior_helpingPeerOrStaff;
	public boolean behavior_leadership;
	public boolean behavior_dealingWithAdversityPositively;
	public boolean behavior_goingAboveAndBeyond;
	
	// Behavior Report - Negative
	public boolean behavior_refusalToFollowDirectionsOrParticipate;
	public boolean behavior_disruptionOfClassOrActivity;
	public boolean behavior_disrespectOfStaffOrScholars;
	public boolean behavior_inappropriateLanguageOrGestures;
	public boolean behavior_inappropriatePhysicalContactOrFighting;
	public boolean behavior_teasingOrInstigatingConflict;
	public boolean behavior_runningInCommonSpaces;
	public boolean behavior_leavingSupervisionUnattended;
	public boolean behavior_failingToFollowRules;
	
	public String behaviorSetting;
	
	/* ACADEMIC REPORT */
	public boolean academic_respectsLearningForSelfAndOthers;
	public boolean academic_followsDirections;
	public boolean academic_consistentlyPreparedAndOrganized;
	public boolean academic_completesHomeworkAndAssignments;
	public boolean academic_staysOnTask;
	public boolean academic_peerTutoring;
	public boolean academic_struggles;
	public boolean academic_disruptionOfClassLessonActivity;
	public boolean academic_refusalToFollowDirectionsAndParticipate;
	public boolean academic_unPreparedAndDisorganized;
	public boolean academic_failureToCompleteHomeworkAssignment;
	public boolean academic_questionableAcademicIntegrity;
	public boolean academic_other;
	
	/* STRATEGY REPORT */
	public boolean strategy_plannedIgnoring;
	public boolean strategy_behaviorLog;
	public boolean strategy_reteachReviewExpectations;
	public boolean strategy_restorativeAction;
	public boolean strategy_apologyVerbalAndOrWritten;
	public boolean strategy_scholarPairingTimeOut;
	public boolean strategy_timeOut;
	public boolean strategy_ageAppropriateWritingActivity;
	public boolean strategy_behaviorProcessingForm;
	public boolean strategy_teacherScholarConversationOutsideClassroom;
	public boolean strategy_conversationWithFamily;
	public boolean strategy_conference;
	public boolean strategy_lossOfPriveleges;
	public boolean strategy_other;

	public String academicSetting;
	public String reportDetailsAndComments;
	
	/**
	 * 
	 */
	public Report() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * Create a Report object from an object retrieved from Parse
	 */
	public Report(ParseObject parseObject) {
		
	}
	
	/*
	 * Return this Report as a Parse Object to push to the database.
	 */
	public ParseObject getParseObject() {
		ParseObject reportParse = new ParseObject("Report");
		// Add report subject info.
		reportParse.put("studentName", studentName);
		reportParse.put("studentGrade", studentGrade);
		reportParse.put("date", reportCreatedDate);
		
		// Add behavior report data.
		reportParse.put("behavior_respectForSelfAndOthers", behavior_respectForSelfAndOthers);
		reportParse.put("behavior_followingDirections", behavior_followingDirections);
		reportParse.put("behavior_positiveConflictResolution", behavior_positiveConflictResolution);
		reportParse.put("behavior_peerMediation", behavior_peerMediation);
		reportParse.put("behavior_helpingPeerOrStaff", behavior_helpingPeerOrStaff);
		reportParse.put("behavior_leadership", behavior_leadership);
		reportParse.put("behavior_dealingWithAdversityPositively", behavior_dealingWithAdversityPositively);
		reportParse.put("behavior_goingAboveAndBeyond", behavior_goingAboveAndBeyond);
		reportParse.put("behavior_refusalToFollowDirectionsOrParticipate", behavior_refusalToFollowDirectionsOrParticipate);
		reportParse.put("behavior_disruptionOfClassOrActivity", behavior_disruptionOfClassOrActivity);
		reportParse.put("behavior_disrespectOfStaffOrScholars", behavior_disrespectOfStaffOrScholars);
		reportParse.put("behavior_inappropriateLanguageOrGestures", behavior_inappropriateLanguageOrGestures);
		reportParse.put("behavior_inappropriatePhysicalContactOrFighting", behavior_inappropriatePhysicalContactOrFighting);
		reportParse.put("behavior_teasingOrInstigatingConflict", behavior_teasingOrInstigatingConflict);
		reportParse.put("behavior_runningInCommonSpaces", behavior_runningInCommonSpaces);
		reportParse.put("behavior_leavingSupervisionUnattended", behavior_leavingSupervisionUnattended);
		reportParse.put("behavior_failingToFollowRules", behavior_failingToFollowRules);
		reportParse.put("behavior_setting", behaviorSetting);
		
		// Add academic data.
		reportParse.put("academic_respectsLearningForSelfAndOthers", academic_respectsLearningForSelfAndOthers);
		reportParse.put("academic_followsDirections", academic_followsDirections);
		reportParse.put("academic_consistentlyPreparedAndOrganized", academic_consistentlyPreparedAndOrganized);
		reportParse.put("academic_completesHomeworkAndAssignments", academic_completesHomeworkAndAssignments);
		reportParse.put("academic_staysOnTask", academic_staysOnTask);
		reportParse.put("academic_peerTutoring", academic_peerTutoring);
		reportParse.put("academic_struggles", academic_struggles);
		reportParse.put("academic_disruptionOfClassLessonActivity", academic_disruptionOfClassLessonActivity);
		reportParse.put("academic_refusalToFollowDirectionsAndParticipate", academic_refusalToFollowDirectionsAndParticipate);
		reportParse.put("academic_unPreparedAndDisorganized", academic_unPreparedAndDisorganized);
		reportParse.put("academic_failureToCompleteHomeworkAssignment", academic_failureToCompleteHomeworkAssignment);
		reportParse.put("academic_questionableAcademicIntegrity", academic_questionableAcademicIntegrity);
		reportParse.put("academic_other", academic_other);
		
		// Add strategy data.
	    reportParse.put("strategy_plannedIgnoring", strategy_plannedIgnoring);
	    reportParse.put("strategy_behaviorLog", strategy_behaviorLog);
	    reportParse.put("strategy_reteachReviewExpectations", strategy_reteachReviewExpectations);
	    reportParse.put("strategy_restorativeAction", strategy_restorativeAction);
	    reportParse.put("strategy_apologyVerbalAndOrWritten", strategy_apologyVerbalAndOrWritten);
	    reportParse.put("strategy_scholarPairingTimeOut", strategy_scholarPairingTimeOut);
	    reportParse.put("strategy_timeOut", strategy_timeOut);
	    reportParse.put("strategy_ageAppropriateWritingActivity", strategy_ageAppropriateWritingActivity);
	    reportParse.put("strategy_behaviorProcessingForm", strategy_behaviorProcessingForm);
	    reportParse.put("strategy_teacherScholarConversationOutsideClassroom", strategy_teacherScholarConversationOutsideClassroom);
	    reportParse.put("strategy_conversationWithFamily", strategy_conversationWithFamily);
	    reportParse.put("strategy_conference", strategy_conference);
	    reportParse.put("strategy_lossOfPriveleges", strategy_lossOfPriveleges);
	    reportParse.put("strategy_other", strategy_other);
		
		reportParse.put("report_details", reportDetailsAndComments);
		return reportParse;
	}

}
