package edu.upenn.cis350.comegysbehavior;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.parse.ParseObject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

	/**
	 * Fragment that shows behavior report
	 */
	public class BehaviorFragment extends Fragment {
		
		public static final String ARG_SECTION_NUMBER = "section_number";
		
		public BehaviorFragment() {
			
		}
		
		private Report report;
		private Spinner academic_settings_spinner, behavior_settings_spinner, grade_spinner;
		private EditText student_name, academic_comments, behavior_comments, strategy_comments;
		private DatePicker date;
		private CheckBox checkbox_behavior_respectForSelfAndOthers, checkbox_behavior_followingDirections, 
		checkbox_behavior_positiveConflictResolution, checkbox_behavior_peerMediation, checkbox_behavior_helpingPeerOrStaff,
		checkbox_behavior_leadership, checkbox_behavior_dealingWithAdversityPositively, checkbox_behavior_goingAboveAndBeyond,
		checkbox_behavior_refusalToFollowDirectionsOrParticipate, checkbox_behavior_disruptionOfClassOrActivity, 
		checkbox_behavior_disrespectOfStaffOrScholars, checkbox_behavior_inappropriateLanguageOrGestures, 
		checkbox_behavior_inappropriatePhysicalContactOrFighting, checkbox_behavior_teasingOrInstigatingConflict, 
		checkbox_behavior_runningInCommonSpaces, checkbox_behavior_leavingSupervisionUnattended, 
		checkbox_behavior_failingToFollowRules, checkbox_academic_respectsLearningForSelfAndOthers, 
		checkbox_academic_followsDirections, checkbox_academic_consistentlyPreparedAndOrganized, 
		checkbox_academic_completesHomeworkAndAssignments, checkbox_academic_staysOnTask, checkbox_academic_peerTutoring, 
		checkbox_academic_struggles, checkbox_academic_disruptionOfClassLessonActivity,
		checkbox_academic_refusalToFollowDirectionsAndParticipate, checkbox_academic_unPreparedAndDisorganized, 
		checkbox_academic_failureToCompleteHomeworkAssignment, checkbox_academic_questionableAcademicIntegrity,
		checkbox_strategy_plannedIgnoring, checkbox_strategy_behaviorLog, checkbox_strategy_reteachReviewExpectations, 
		checkbox_strategy_restorativeAction, checkbox_strategy_apologyVerbalAndOrWritten, checkbox_strategy_scholarPairingTimeOut,
		checkbox_strategy_timeOut, checkbox_strategy_ageAppropriateWritingActivity, 
		checkbox_strategy_behaviorProcessingForm, checkbox_strategy_teacherScholarConversationOutsideClassroom,
		checkbox_strategy_conversationWithFamily, checkbox_strategy_conference, checkbox_strategy_lossOfPriveleges; 
		
		
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.report,
					container, false);
			setSpinnerContent(rootView);
			
			student_name = (EditText) rootView.findViewById(R.id.scholar_name);
			//student_grade = (EditText) rootView.findViewById(R.id.grade);
			//date = (EditText) rootView.findViewById(R.id.date);
			date = (DatePicker) rootView.findViewById(R.id.SelectDate);
			academic_comments = (EditText) rootView.findViewById(R.id.academic_comment);
			behavior_comments = (EditText) rootView.findViewById(R.id.behavior_comment);
			strategy_comments = (EditText) rootView.findViewById(R.id.strategy_comment);
			checkbox_behavior_respectForSelfAndOthers = (CheckBox) rootView.findViewById(R.id.checkbox_behavior_respectForSelfAndOthers);
			checkbox_behavior_followingDirections = (CheckBox) rootView.findViewById(R.id.checkbox_behavior_followingDirections);
			checkbox_behavior_positiveConflictResolution = (CheckBox) rootView.findViewById(R.id.checkbox_behavior_positiveConflictResolution);
			checkbox_behavior_peerMediation = (CheckBox) rootView.findViewById(R.id.checkbox_behavior_peerMediation);
			checkbox_behavior_helpingPeerOrStaff = (CheckBox) rootView.findViewById(R.id.checkbox_behavior_helpingPeerOrStaff);
			checkbox_behavior_leadership = (CheckBox) rootView.findViewById(R.id.checkbox_behavior_leadership);
			checkbox_behavior_dealingWithAdversityPositively = (CheckBox) rootView.findViewById(R.id.checkbox_behavior_dealingWithAdversityPositively);
			checkbox_behavior_goingAboveAndBeyond = (CheckBox) rootView.findViewById(R.id.checkbox_behavior_goingAboveAndBeyond);
			checkbox_behavior_refusalToFollowDirectionsOrParticipate = (CheckBox) rootView.findViewById(R.id.checkbox_behavior_refusalToFollowDirectionsOrParticipate);
			checkbox_behavior_disruptionOfClassOrActivity = (CheckBox) rootView.findViewById(R.id.checkbox_behavior_disruptionOfClassOrActivity);
			checkbox_behavior_disrespectOfStaffOrScholars = (CheckBox) rootView.findViewById(R.id.checkbox_behavior_disrespectOfStaffOrScholars);
			checkbox_behavior_inappropriateLanguageOrGestures = (CheckBox) rootView.findViewById(R.id.checkbox_behavior_inappropriateLanguageOrGestures);
			checkbox_behavior_inappropriatePhysicalContactOrFighting = (CheckBox) rootView.findViewById(R.id.checkbox_behavior_inappropriatePhysicalContactOrFighting);
			checkbox_behavior_teasingOrInstigatingConflict = (CheckBox) rootView.findViewById(R.id.checkbox_behavior_teasingOrInstigatingConflict);
			checkbox_behavior_runningInCommonSpaces = (CheckBox) rootView.findViewById(R.id.checkbox_behavior_runningInCommonSpaces);
			checkbox_behavior_leavingSupervisionUnattended = (CheckBox) rootView.findViewById(R.id.checkbox_behavior_leavingSupervisionUnattended);
			checkbox_behavior_failingToFollowRules = (CheckBox) rootView.findViewById(R.id.checkbox_behavior_failingToFollowRules);
			checkbox_academic_respectsLearningForSelfAndOthers = (CheckBox) rootView.findViewById(R.id.checkbox_academic_respectsLearningForSelfAndOthers);
			checkbox_academic_followsDirections = (CheckBox) rootView.findViewById(R.id.checkbox_academic_followsDirections);
			checkbox_academic_consistentlyPreparedAndOrganized = (CheckBox) rootView.findViewById(R.id.checkbox_academic_consistentlyPreparedAndOrganized);
			checkbox_academic_completesHomeworkAndAssignments = (CheckBox) rootView.findViewById(R.id.checkbox_academic_completesHomeworkAndAssignments);
			checkbox_academic_staysOnTask = (CheckBox) rootView.findViewById(R.id.checkbox_academic_staysOnTask);
			checkbox_academic_peerTutoring = (CheckBox) rootView.findViewById(R.id.checkbox_academic_peerTutoring);
			checkbox_academic_struggles = (CheckBox) rootView.findViewById(R.id.checkbox_academic_struggles);
			checkbox_academic_disruptionOfClassLessonActivity = (CheckBox) rootView.findViewById(R.id.checkbox_academic_disruptionOfClassLessonActivity);
			checkbox_academic_refusalToFollowDirectionsAndParticipate = (CheckBox) rootView.findViewById(R.id.checkbox_academic_refusalToFollowDirectionsAndParticipate);
			checkbox_academic_unPreparedAndDisorganized = (CheckBox) rootView.findViewById(R.id.checkbox_academic_unPreparedAndDisorganized);
			checkbox_academic_failureToCompleteHomeworkAssignment = (CheckBox) rootView.findViewById(R.id.checkbox_academic_failureToCompleteHomeworkAssignment);
			checkbox_academic_questionableAcademicIntegrity = (CheckBox) rootView.findViewById(R.id.checkbox_academic_questionableAcademicIntegrity);
			checkbox_strategy_plannedIgnoring = (CheckBox) rootView.findViewById(R.id.checkbox_strategy_plannedIgnoring);
			checkbox_strategy_behaviorLog = (CheckBox) rootView.findViewById(R.id.checkbox_strategy_behaviorLog);
			checkbox_strategy_reteachReviewExpectations = (CheckBox) rootView.findViewById(R.id.checkbox_strategy_reteachReviewExpectations);
			checkbox_strategy_restorativeAction = (CheckBox) rootView.findViewById(R.id.checkbox_strategy_restorativeAction);
			checkbox_strategy_apologyVerbalAndOrWritten = (CheckBox) rootView.findViewById(R.id.checkbox_strategy_apologyVerbalAndOrWritten);
			checkbox_strategy_scholarPairingTimeOut = (CheckBox) rootView.findViewById(R.id.checkbox_strategy_scholarPairingTimeOut);
			checkbox_strategy_timeOut = (CheckBox) rootView.findViewById(R.id.checkbox_strategy_timeOut);
			checkbox_strategy_ageAppropriateWritingActivity = (CheckBox) rootView.findViewById(R.id.checkbox_strategy_ageAppropriateWritingActivity);
			checkbox_strategy_behaviorProcessingForm = (CheckBox) rootView.findViewById(R.id.checkbox_strategy_behaviorProcessingForm);
			checkbox_strategy_teacherScholarConversationOutsideClassroom = (CheckBox) rootView.findViewById(R.id.checkbox_strategy_teacherScholarConversationOutsideClassroom);
			checkbox_strategy_conversationWithFamily = (CheckBox) rootView.findViewById(R.id.checkbox_strategy_conversationWithFamily);
			checkbox_strategy_conference = (CheckBox) rootView.findViewById(R.id.checkbox_strategy_conference);
			checkbox_strategy_lossOfPriveleges = (CheckBox) rootView.findViewById(R.id.checkbox_strategy_lossOfPriveleges);
			 
			
			final Button button = (Button) rootView.findViewById(R.id.submit_report_button);
	         button.setOnClickListener(new View.OnClickListener() {
	             public void onClick(View v) {
	            	 Log.d("DAS BUTTON", "WORKS");
	            	 String studentName = student_name.getText().toString();
	            	 report.studentName = studentName;
	            	 String studentGrade = grade_spinner.getSelectedItem().toString();
	            	 report.studentGrade = studentGrade;
	            	 int day = date.getDayOfMonth();
	            	 int month = date.getMonth();
	            	 int year =  date.getYear();
	            	 
	            	 ParseObject gameScore = new ParseObject("Report");
	            	 gameScore.put("studentName", report.studentName);
	            	 gameScore.put("studentGrade", report.studentGrade);
	            	 gameScore.put("day", day);
	            	 gameScore.put("month", month);
	            	 gameScore.put("year", year);

	            	 Calendar calendar = Calendar.getInstance();
	            	 calendar.set(year, month, day);
	            	 SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
	            	 String dateOfInfraction = sdf.format(calendar.getTime());
	            	 
	            	 // -- behavior -- 
	            	 // -- 1 --  
	            	 if (checkbox_behavior_respectForSelfAndOthers.isChecked()) {
	            		 report.behavior_respectForSelfAndOthers = true; 
	            		 checkbox_behavior_respectForSelfAndOthers.setChecked(false);
	            	 }
	            	 gameScore.put("behavior_respectForSelfAndOthers", report.behavior_respectForSelfAndOthers);
	            	// -- 2 --  
	            	 if (checkbox_behavior_followingDirections.isChecked()) {
	            		 report.behavior_followingDirections = true; 
	            		 checkbox_behavior_followingDirections.setChecked(false);
	            	 }
	            	 gameScore.put("behavior_followingDirections", report.behavior_followingDirections);
	            	// -- 3 --  
	            	 if (checkbox_behavior_positiveConflictResolution.isChecked()) {
	            		 report.behavior_positiveConflictResolution = true; 
	            		 checkbox_behavior_positiveConflictResolution.setChecked(false);
	            	 }
	            	 gameScore.put("behavior_positiveConflictResolution", report.behavior_positiveConflictResolution);
	            	// -- 4 --  
	            	 if (checkbox_behavior_peerMediation.isChecked()) {
	            		 report.behavior_peerMediation = true; 
	            		 checkbox_behavior_peerMediation.setChecked(false);
	            	 }
	            	 gameScore.put("behavior_peerMediation", report.behavior_peerMediation);
	            	// -- 5 --  
	            	 if (checkbox_behavior_helpingPeerOrStaff.isChecked()) {
	            		 report.behavior_helpingPeerOrStaff = true; 
	            		 checkbox_behavior_helpingPeerOrStaff.setChecked(false);
	            	 }
	            	 gameScore.put("behavior_helpingPeerOrStaff", report.behavior_helpingPeerOrStaff);
	            	// -- 6 --  
	            	 if (checkbox_behavior_leadership.isChecked()) {
	            		 report.behavior_leadership = true; 
	            		 checkbox_behavior_leadership.setChecked(false);
	            	 }
	            	 gameScore.put("behavior_leadership", report.behavior_leadership);
	            	// -- 7 --  
	            	 if (checkbox_behavior_dealingWithAdversityPositively.isChecked()) {
	            		 report.behavior_dealingWithAdversityPositively = true; 
	            		 checkbox_behavior_dealingWithAdversityPositively.setChecked(false);
	            	 }
	            	 gameScore.put("behavior_dealingWithAdversityPositively", report.behavior_dealingWithAdversityPositively);
	            	// -- 8 --  
	            	 if (checkbox_behavior_goingAboveAndBeyond.isChecked()) {
	            		 report.behavior_goingAboveAndBeyond = true; 
	            		 checkbox_behavior_goingAboveAndBeyond.setChecked(false);
	            	 }
	            	 gameScore.put("behavior_goingAboveAndBeyond", report.behavior_goingAboveAndBeyond);
	            	// -- 9 --  
	            	 if (checkbox_behavior_refusalToFollowDirectionsOrParticipate.isChecked()) {
	            		 report.behavior_refusalToFollowDirectionsOrParticipate = true; 
	            		 checkbox_behavior_refusalToFollowDirectionsOrParticipate.setChecked(false);
	            	 }	
	            	 gameScore.put("behavior_refusalToFollowDirectionsOrParticipate", report.behavior_refusalToFollowDirectionsOrParticipate);
	            	// -- 10 --  
	            	 if (checkbox_behavior_disruptionOfClassOrActivity.isChecked()) {
	            		 report.behavior_disruptionOfClassOrActivity = true; 
	            		 checkbox_behavior_disruptionOfClassOrActivity.setChecked(false);
	            	 }	
	            	 gameScore.put("behavior_disruptionOfClassOrActivity", report.behavior_disruptionOfClassOrActivity);
	            	// -- 11 --  
	            	 if (checkbox_behavior_disrespectOfStaffOrScholars.isChecked()) {
	            		 report.behavior_disrespectOfStaffOrScholars = true; 
	            		 checkbox_behavior_disrespectOfStaffOrScholars.setChecked(false);
	            	 }
	            	 gameScore.put("behavior_disrespectOfStaffOrScholars", report.behavior_disrespectOfStaffOrScholars);
	            	// -- 12 --  
	            	 if (checkbox_behavior_inappropriateLanguageOrGestures.isChecked()) {
	            		 report.behavior_inappropriateLanguageOrGestures = true; 
	            		 checkbox_behavior_inappropriateLanguageOrGestures.setChecked(false);
	            	 }
	            	 gameScore.put("behavior_inappropriateLanguageOrGestures", report.behavior_inappropriateLanguageOrGestures);
	            	// -- 13 --  
	            	 if (checkbox_behavior_inappropriatePhysicalContactOrFighting.isChecked()) {
	            		 report.behavior_inappropriatePhysicalContactOrFighting = true; 
	            		 checkbox_behavior_inappropriatePhysicalContactOrFighting.setChecked(false);
	            	 }	
	            	 gameScore.put("behavior_inappropriatePhysicalContactOrFighting", report.behavior_inappropriatePhysicalContactOrFighting);
	            	// -- 14 --  
	            	 if (checkbox_behavior_teasingOrInstigatingConflict.isChecked()) {
	            		 report.behavior_teasingOrInstigatingConflict = true; 
	            		 checkbox_behavior_teasingOrInstigatingConflict.setChecked(false);
	            	 }
	            	 gameScore.put("behavior_teasingOrInstigatingConflict", report.behavior_teasingOrInstigatingConflict);
	            	// -- 15 --  
	            	 if (checkbox_behavior_runningInCommonSpaces.isChecked()) {
	            		 report.behavior_runningInCommonSpaces = true; 
	            		 checkbox_behavior_runningInCommonSpaces.setChecked(false);
	            	 }
	            	 gameScore.put("behavior_runningInCommonSpaces", report.behavior_runningInCommonSpaces);
	            	// -- 16 --  
	            	 if (checkbox_behavior_leavingSupervisionUnattended.isChecked()) {
	            		 report.behavior_leavingSupervisionUnattended = true; 
	            		 checkbox_behavior_leavingSupervisionUnattended.setChecked(false);
	            	 }
	            	 gameScore.put("behavior_leavingSupervisionUnattended", report.behavior_leavingSupervisionUnattended);
	            	// -- 17 --  
	            	 if (checkbox_behavior_failingToFollowRules.isChecked()) {
	            		 report.behavior_failingToFollowRules = true; 
	            		 checkbox_behavior_failingToFollowRules.setChecked(false);
	            	 }
	            	 gameScore.put("behavior_failingToFollowRules", report.behavior_failingToFollowRules);
	            	 
	            	// -- academic -- 
	            	// -- 1 --  
	            	 if (checkbox_academic_respectsLearningForSelfAndOthers.isChecked()) {
	            		 report.academic_respectsLearningForSelfAndOthers = true; 
	            		 checkbox_academic_respectsLearningForSelfAndOthers.setChecked(false);
	            	 }
	            	 gameScore.put("academic_respectsLearningForSelfAndOthers", report.academic_respectsLearningForSelfAndOthers);
	            	// -- 2 --  
	            	 if (checkbox_academic_followsDirections.isChecked()) {
	            		 report.academic_followsDirections = true; 
	            		 checkbox_academic_followsDirections.setChecked(false);
	            	 }
	            	 gameScore.put("academic_followsDirections", report.academic_followsDirections);
	            	// -- 3 --  
	            	 if (checkbox_academic_consistentlyPreparedAndOrganized.isChecked()) {
	            		 report.academic_consistentlyPreparedAndOrganized = true; 
	            		 checkbox_academic_consistentlyPreparedAndOrganized.setChecked(false);
	            	 }
	            	 gameScore.put("academic_consistentlyPreparedAndOrganized", report.academic_consistentlyPreparedAndOrganized);
	            	// -- 4 --  
	            	 if (checkbox_academic_completesHomeworkAndAssignments.isChecked()) {
	            		 report.academic_completesHomeworkAndAssignments = true; 
	            		 checkbox_academic_completesHomeworkAndAssignments.setChecked(false);
	            	 }
	            	 gameScore.put("academic_completesHomeworkAndAssignments", report.academic_completesHomeworkAndAssignments); 
	            	// -- 5 --  
	            	 if (checkbox_academic_staysOnTask.isChecked()) {
	            		 report.academic_staysOnTask = true; 
	            		 checkbox_academic_staysOnTask.setChecked(false);
	            	 }
	            	 gameScore.put("academic_staysOnTask", report.academic_staysOnTask);
	            	// -- 6 --  
	            	 if (checkbox_academic_peerTutoring.isChecked()) {
	            		 report.academic_peerTutoring = true; 
	            		 checkbox_academic_peerTutoring.setChecked(false);
	            	 }
	            	 gameScore.put("academic_peerTutoring", report.academic_peerTutoring);
	            	// -- 7 --  
	            	 if (checkbox_academic_struggles.isChecked()) {
	            		 report.academic_struggles = true; 
	            		 checkbox_academic_struggles.setChecked(false);
	            	 }
	            	 gameScore.put("academic_struggles", report.academic_struggles);
	            	// -- 8 --  
	            	 if (checkbox_academic_disruptionOfClassLessonActivity.isChecked()) {
	            		 report.academic_disruptionOfClassLessonActivity = true; 
	            		 checkbox_academic_disruptionOfClassLessonActivity.setChecked(false);
	            	 }
	            	 gameScore.put("academic_disruptionOfClassLessonActivity", report.academic_disruptionOfClassLessonActivity);
	            	// -- 9 --  
	            	 if (checkbox_academic_refusalToFollowDirectionsAndParticipate.isChecked()) {
	            		 report.academic_refusalToFollowDirectionsAndParticipate = true; 
	            		 checkbox_academic_refusalToFollowDirectionsAndParticipate.setChecked(false);
	            	 }
	            	 gameScore.put("academic_refusalToFollowDirectionsAndParticipate", report.academic_refusalToFollowDirectionsAndParticipate);
	            	// -- 10 --  
	            	 if (checkbox_academic_unPreparedAndDisorganized.isChecked()) {
	            		 report.academic_unPreparedAndDisorganized = true; 
	            		 checkbox_academic_unPreparedAndDisorganized.setChecked(false);
	            	 }
	            	 gameScore.put("academic_unPreparedAndDisorganized", report.academic_unPreparedAndDisorganized);
	            	// -- 11 --  
	            	 if (checkbox_academic_failureToCompleteHomeworkAssignment.isChecked()) {
	            		 report.academic_failureToCompleteHomeworkAssignment = true; 
	            		 checkbox_academic_failureToCompleteHomeworkAssignment.setChecked(false);
	            	 }
	            	 gameScore.put("academic_failureToCompleteHomeworkAssignment", report.academic_failureToCompleteHomeworkAssignment);
	            	// -- 12 --  
	            	 if (checkbox_academic_questionableAcademicIntegrity.isChecked()) {
	            		 report.academic_questionableAcademicIntegrity = true; 
	            		 checkbox_academic_questionableAcademicIntegrity.setChecked(false);
	            	 }
	            	 gameScore.put("academic_questionableAcademicIntegrity", report.academic_questionableAcademicIntegrity);
	            	 
	            	 // -- strategy --
	            	// -- 1 --  
	            	 if (checkbox_strategy_plannedIgnoring.isChecked()) {
	            		 report.strategy_plannedIgnoring = true; 
	            		 checkbox_strategy_plannedIgnoring.setChecked(false);
	            	 }
	            	 gameScore.put("strategy_plannedIgnoring", report.strategy_plannedIgnoring);
	            	// -- 2 --  
	            	 if (checkbox_strategy_behaviorLog.isChecked()) {
	            		 report.strategy_behaviorLog = true; 
	            		 checkbox_strategy_behaviorLog.setChecked(false);
	            	 }
	            	 gameScore.put("strategy_behaviorLog", report.strategy_behaviorLog);
	            	// -- 3 --  
	            	 if (checkbox_strategy_reteachReviewExpectations.isChecked()) {
	            		 report.strategy_reteachReviewExpectations = true; 
	            		 checkbox_strategy_reteachReviewExpectations.setChecked(false);
	            	 }
	            	 gameScore.put("strategy_reteachReviewExpectations", report.strategy_reteachReviewExpectations);
	            	// -- 4 --  
	            	 if (checkbox_strategy_restorativeAction.isChecked()) {
	            		 report.strategy_restorativeAction = true; 
	            		 checkbox_strategy_restorativeAction.setChecked(false);
	            	 }
	            	 gameScore.put("strategy_restorativeAction", report.strategy_restorativeAction);
	            	// -- 5 --  
	            	 if (checkbox_strategy_apologyVerbalAndOrWritten.isChecked()) {
	            		 report.strategy_apologyVerbalAndOrWritten = true; 
	            		 checkbox_strategy_apologyVerbalAndOrWritten.setChecked(false);
	            	 }
	            	 gameScore.put("strategy_apologyVerbalAndOrWritten", report.strategy_apologyVerbalAndOrWritten);
	            	// -- 6 --  
	            	 if (checkbox_strategy_scholarPairingTimeOut.isChecked()) {
	            		 report.strategy_scholarPairingTimeOut = true; 
	            		 checkbox_strategy_scholarPairingTimeOut.setChecked(false);
	            	 }
	            	 gameScore.put("strategy_scholarPairingTimeOut", report.strategy_scholarPairingTimeOut);
	            	// -- 7 --  
	            	 if (checkbox_strategy_timeOut.isChecked()) {
	            		 report.strategy_timeOut = true; 
	            		 checkbox_strategy_timeOut.setChecked(false);
	            	 }
	            	 gameScore.put("strategy_timeOut", report.strategy_timeOut);
	            	// -- 8 --  
	            	 if (checkbox_strategy_ageAppropriateWritingActivity.isChecked()) {
	            		 report.strategy_ageAppropriateWritingActivity = true; 
	            		 checkbox_strategy_ageAppropriateWritingActivity.setChecked(false);
	            	 }
	            	 gameScore.put("strategy_ageAppropriateWritingActivity", report.strategy_ageAppropriateWritingActivity);
	            	// -- 9 --  
	            	 if (checkbox_strategy_behaviorProcessingForm.isChecked()) {
	            		 report.strategy_behaviorProcessingForm = true; 
	            		 checkbox_strategy_behaviorProcessingForm.setChecked(false);
	            	 }
	            	 gameScore.put("strategy_behaviorProcessingForm", report.strategy_behaviorProcessingForm);
	            	// -- 10 --  
	            	 if (checkbox_strategy_teacherScholarConversationOutsideClassroom.isChecked()) {
	            		 report.strategy_teacherScholarConversationOutsideClassroom = true; 
	            		 checkbox_strategy_teacherScholarConversationOutsideClassroom.setChecked(false);
	            	 }
	            	 gameScore.put("strategy_teacherScholarConversationOutsideClassroom", report.strategy_teacherScholarConversationOutsideClassroom);
	            	// -- 11 --  
	            	 if (checkbox_strategy_conversationWithFamily.isChecked()) {
	            		 report.strategy_conversationWithFamily = true; 
	            		 checkbox_strategy_conversationWithFamily.setChecked(false);
	            	 }
	            	 gameScore.put("strategy_conversationWithFamily", report.strategy_conversationWithFamily);
	            	// -- 12 --  
	            	 if (checkbox_strategy_conference.isChecked()) {
	            		 report.strategy_conference = true; 
	            		 checkbox_strategy_conference.setChecked(false);
	            	 }
	            	 gameScore.put("strategy_conference", report.strategy_conference);
	            	// -- 13 --  
	            	 if (checkbox_strategy_lossOfPriveleges.isChecked()) {
	            		 report.strategy_lossOfPriveleges = true; 
	            		 checkbox_strategy_lossOfPriveleges.setChecked(false);
	            	 }
	            	 gameScore.put("strategy_lossOfPriveleges", report.strategy_lossOfPriveleges); 
	            	 
	            	 
	            	 gameScore.saveInBackground();

	            	 
	             }
	         });
			
			return rootView;
		}
		private void setSpinnerContent( View view )
		{
		  behavior_settings_spinner = (Spinner) view.findViewById( R.id.behavior_settings_spinner );
		  academic_settings_spinner = (Spinner) view.findViewById( R.id.academic_settings_spinner); 
		  grade_spinner = (Spinner) view.findViewById( R.id.grade_spinner);
		  
		 }
		
	
		
		
	}