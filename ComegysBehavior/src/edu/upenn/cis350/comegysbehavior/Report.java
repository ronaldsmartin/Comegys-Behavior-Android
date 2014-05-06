/**
 * 
 */
package edu.upenn.cis350.comegysbehavior;

import android.os.Parcel;
import android.os.Parcelable;

import com.parse.ParseObject;

/**
 * @author Ronald Martin
 * Object describing a behavior report
 */
public class Report implements Parcelable {
	
	// Subject Info
	public String studentName = " ";
	public String studentGrade = "";
	public String reportCreatedDate = "";
	
	/* BEHAVIOR REPORT */
	
	// Behavior Report - Positive
	public boolean behavior_respectForSelfAndOthers = false;
	public boolean behavior_followingDirections = false;
	public boolean behavior_positiveConflictResolution = false;
	public boolean behavior_peerMediation = false;
	public boolean behavior_helpingPeerOrStaff = false;
	public boolean behavior_leadership = false;
	public boolean behavior_dealingWithAdversityPositively = false;
	public boolean behavior_goingAboveAndBeyond = false;
	  
	// Behavior Report - Negative
	public boolean behavior_refusalToFollowDirectionsOrParticipate = false;
	public boolean behavior_disruptionOfClassOrActivity = false;
	public boolean behavior_disrespectOfStaffOrScholars = false;
	public boolean behavior_inappropriateLanguageOrGestures = false;
	public boolean behavior_inappropriatePhysicalContactOrFighting = false;
	public boolean behavior_teasingOrInstigatingConflict = false;
	public boolean behavior_runningInCommonSpaces = false;
	public boolean behavior_leavingSupervisionUnattended = false;
	public boolean behavior_failingToFollowRules = false;
	
	public boolean behavior_other = false; 
	
	public String behaviorSetting = "";
	
	/* ACADEMIC REPORT */
	public boolean academic_respectsLearningForSelfAndOthers = false;
	public boolean academic_followsDirections = false;
	public boolean academic_consistentlyPreparedAndOrganized = false;
	public boolean academic_completesHomeworkAndAssignments = false;
	public boolean academic_staysOnTask = false;
	public boolean academic_peerTutoring = false;
	public boolean academic_struggles = false;
	public boolean academic_disruptionOfClassLessonActivity = false;
	public boolean academic_refusalToFollowDirectionsAndParticipate = false;
	public boolean academic_unPreparedAndDisorganized = false;
	public boolean academic_failureToCompleteHomeworkAssignment = false;
	public boolean academic_questionableAcademicIntegrity = false;
	public boolean academic_other = false;

	/* STRATEGY REPORT */
	public boolean strategy_plannedIgnoring = false;
	public boolean strategy_behaviorLog = false;
	public boolean strategy_reteachReviewExpectations = false;
	public boolean strategy_restorativeAction = false;
	public boolean strategy_apologyVerbalAndOrWritten = false;
	public boolean strategy_scholarPairingTimeOut = false;
	public boolean strategy_timeOut = false;
	public boolean strategy_ageAppropriateWritingActivity = false;
	public boolean strategy_behaviorProcessingForm = false;
	public boolean strategy_teacherScholarConversationOutsideClassroom = false;
	public boolean strategy_conversationWithFamily = false;
	public boolean strategy_conference = false;
	public boolean strategy_lossOfPriveleges = false;
	public boolean strategy_other = false;

	public String academicSetting = "";
	public String reportDetailsAndComments = "";
	
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

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	//We will simply start by Displaying the Student NAME: TODO  Add more data fields
	@Override
	public void writeToParcel(Parcel out, int flags) {
		out.writeString(this.studentName);
		
	}
	
	private Report(Parcel in) {
		this.studentName = in.readString();
	}

	public static final Parcelable.Creator<Report> CREATOR
			= new Parcelable.Creator<Report>() {
		@Override
		public Report createFromParcel(Parcel in) {
			return new Report(in);
		}

		@Override
		public Report[] newArray(int size) {
			return new Report[size];
		}
	};

}
