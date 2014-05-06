package edu.upenn.cis350.comegysbehavior;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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
	            	// -- 2 --  
	            	 if (checkbox_behavior_followingDirections.isChecked()) {
	            		 report.behavior_followingDirections = true; 
	            		 checkbox_behavior_followingDirections.setChecked(false);
	            	 }
	            	// -- 3 --  
	            	 if (checkbox_behavior_positiveConflictResolution.isChecked()) {
	            		 report.behavior_positiveConflictResolution = true; 
	            		 checkbox_behavior_positiveConflictResolution.setChecked(false);
	            	 }
	            	// -- 4 --  
	            	 if (checkbox_behavior_peerMediation.isChecked()) {
	            		 report.behavior_peerMediation = true; 
	            		 checkbox_behavior_peerMediation.setChecked(false);
	            	 }
	            	// -- 5 --  
	            	 if (checkbox_behavior_helpingPeerOrStaff.isChecked()) {
	            		 report.behavior_helpingPeerOrStaff = true; 
	            		 checkbox_behavior_helpingPeerOrStaff.setChecked(false);
	            	 }
	            	// -- 6 --  
	            	 if (checkbox_behavior_leadership.isChecked()) {
	            		 report.behavior_leadership = true; 
	            		 checkbox_behavior_leadership.setChecked(false);
	            	 }	 
	            	// -- 7 --  
	            	 if (checkbox_behavior_dealingWithAdversityPositively.isChecked()) {
	            		 report.behavior_dealingWithAdversityPositively = true; 
	            		 checkbox_behavior_dealingWithAdversityPositively.setChecked(false);
	            	 }	
	            	// -- 8 --  
	            	 if (checkbox_behavior_goingAboveAndBeyond.isChecked()) {
	            		 report.behavior_goingAboveAndBeyond = true; 
	            		 checkbox_behavior_goingAboveAndBeyond.setChecked(false);
	            	 }	
	            	// -- 9 --  
	            	 if (checkbox_behavior_refusalToFollowDirectionsOrParticipate.isChecked()) {
	            		 report.behavior_refusalToFollowDirectionsOrParticipate = true; 
	            		 checkbox_behavior_refusalToFollowDirectionsOrParticipate.setChecked(false);
	            	 }	
	            	// -- 10 --  
	            	 if (checkbox_behavior_disruptionOfClassOrActivity.isChecked()) {
	            		 report.behavior_disruptionOfClassOrActivity = true; 
	            		 checkbox_behavior_disruptionOfClassOrActivity.setChecked(false);
	            	 }	
	            	// -- 11 --  
	            	 if (checkbox_behavior_disrespectOfStaffOrScholars.isChecked()) {
	            		 report.behavior_disrespectOfStaffOrScholars = true; 
	            		 checkbox_behavior_disrespectOfStaffOrScholars.setChecked(false);
	            	 }	
	            	// -- 12 --  
	            	 if (checkbox_behavior_inappropriateLanguageOrGestures.isChecked()) {
	            		 report.behavior_inappropriateLanguageOrGestures = true; 
	            		 checkbox_behavior_inappropriateLanguageOrGestures.setChecked(false);
	            	 }	
	            	// -- 13 --  
	            	 if (checkbox_behavior_inappropriatePhysicalContactOrFighting.isChecked()) {
	            		 report.behavior_inappropriatePhysicalContactOrFighting = true; 
	            		 checkbox_behavior_inappropriatePhysicalContactOrFighting.setChecked(false);
	            	 }	
	            	// -- 14 --  
	            	 if (checkbox_behavior_teasingOrInstigatingConflict.isChecked()) {
	            		 report.behavior_teasingOrInstigatingConflict = true; 
	            		 checkbox_behavior_teasingOrInstigatingConflict.setChecked(false);
	            	 }
	            	// -- 15 --  
	            	 if (checkbox_behavior_runningInCommonSpaces.isChecked()) {
	            		 report.behavior_runningInCommonSpaces = true; 
	            		 checkbox_behavior_runningInCommonSpaces.setChecked(false);
	            	 }
	            	// -- 16 --  
	            	 if (checkbox_behavior_leavingSupervisionUnattended.isChecked()) {
	            		 report.behavior_leavingSupervisionUnattended = true; 
	            		 checkbox_behavior_leavingSupervisionUnattended.setChecked(false);
	            	 }
	            	// -- 17 --  
	            	 if (checkbox_behavior_failingToFollowRules.isChecked()) {
	            		 report.behavior_failingToFollowRules = true; 
	            		 checkbox_behavior_failingToFollowRules.setChecked(false);
	            	 }
	            	 
	            	// -- academic -- 
	            	// -- 1 --  
	            	 if (checkbox_academic_respectsLearningForSelfAndOthers.isChecked()) {
	            		 report.academic_respectsLearningForSelfAndOthers = true; 
	            		 checkbox_academic_respectsLearningForSelfAndOthers.setChecked(false);
	            	 }
	            	// -- 2 --  
	            	 if (checkbox_academic_followsDirections.isChecked()) {
	            		 report.academic_followsDirections = true; 
	            		 checkbox_academic_followsDirections.setChecked(false);
	            	 }
	            	// -- 3 --  
	            	 if (checkbox_academic_consistentlyPreparedAndOrganized.isChecked()) {
	            		 report.academic_consistentlyPreparedAndOrganized = true; 
	            		 checkbox_academic_consistentlyPreparedAndOrganized.setChecked(false);
	            	 }
	            	// -- 4 --  
	            	 if (checkbox_academic_completesHomeworkAndAssignments.isChecked()) {
	            		 report.academic_completesHomeworkAndAssignments = true; 
	            		 checkbox_academic_completesHomeworkAndAssignments.setChecked(false);
	            	 }
	            	// -- 5 --  
	            	 if (checkbox_academic_staysOnTask.isChecked()) {
	            		 report.academic_staysOnTask = true; 
	            		 checkbox_academic_staysOnTask.setChecked(false);
	            	 }
	            	// -- 6 --  
	            	 if (checkbox_academic_peerTutoring.isChecked()) {
	            		 report.academic_peerTutoring = true; 
	            		 checkbox_academic_peerTutoring.setChecked(false);
	            	 }
	            	// -- 7 --  
	            	 if (checkbox_academic_struggles.isChecked()) {
	            		 report.academic_struggles = true; 
	            		 checkbox_academic_struggles.setChecked(false);
	            	 }
	            	// -- 8 --  
	            	 if (checkbox_academic_disruptionOfClassLessonActivity.isChecked()) {
	            		 report.academic_disruptionOfClassLessonActivity = true; 
	            		 checkbox_academic_disruptionOfClassLessonActivity.setChecked(false);
	            	 }
	            	// -- 9 --  
	            	 if (checkbox_academic_refusalToFollowDirectionsAndParticipate.isChecked()) {
	            		 report.academic_refusalToFollowDirectionsAndParticipate = true; 
	            		 checkbox_academic_refusalToFollowDirectionsAndParticipate.setChecked(false);
	            	 }
	            	// -- 10 --  
	            	 if (checkbox_academic_unPreparedAndDisorganized.isChecked()) {
	            		 report.academic_unPreparedAndDisorganized = true; 
	            		 checkbox_academic_unPreparedAndDisorganized.setChecked(false);
	            	 }
	            	// -- 11 --  
	            	 if (checkbox_academic_failureToCompleteHomeworkAssignment.isChecked()) {
	            		 report.academic_failureToCompleteHomeworkAssignment = true; 
	            		 checkbox_academic_failureToCompleteHomeworkAssignment.setChecked(false);
	            	 }
	            	// -- 12 --  
	            	 if (checkbox_academic_questionableAcademicIntegrity.isChecked()) {
	            		 report.academic_questionableAcademicIntegrity = true; 
	            		 checkbox_academic_questionableAcademicIntegrity.setChecked(false);
	            	 }
	            	 
	            	 // -- strategy --
	            	// -- 1 --  
	            	 if (checkbox_strategy_plannedIgnoring.isChecked()) {
	            		 report.strategy_plannedIgnoring = true; 
	            		 checkbox_strategy_plannedIgnoring.setChecked(false);
	            	 }
	            	// -- 2 --  
	            	 if (checkbox_strategy_behaviorLog.isChecked()) {
	            		 report.strategy_behaviorLog = true; 
	            		 checkbox_strategy_behaviorLog.setChecked(false);
	            	 }
	            	// -- 3 --  
	            	 if (checkbox_strategy_reteachReviewExpectations.isChecked()) {
	            		 report.strategy_reteachReviewExpectations = true; 
	            		 checkbox_strategy_reteachReviewExpectations.setChecked(false);
	            	 }
	            	// -- 4 --  
	            	 if (checkbox_strategy_restorativeAction.isChecked()) {
	            		 report.strategy_restorativeAction = true; 
	            		 checkbox_strategy_restorativeAction.setChecked(false);
	            	 }
	            	// -- 5 --  
	            	 if (checkbox_strategy_apologyVerbalAndOrWritten.isChecked()) {
	            		 report.strategy_apologyVerbalAndOrWritten = true; 
	            		 checkbox_strategy_apologyVerbalAndOrWritten.setChecked(false);
	            	 }
	            	// -- 6 --  
	            	 if (checkbox_strategy_scholarPairingTimeOut.isChecked()) {
	            		 report.strategy_scholarPairingTimeOut = true; 
	            		 checkbox_strategy_scholarPairingTimeOut.setChecked(false);
	            	 }
	            	// -- 7 --  
	            	 if (checkbox_strategy_timeOut.isChecked()) {
	            		 report.strategy_timeOut = true; 
	            		 checkbox_strategy_timeOut.setChecked(false);
	            	 }
	            	// -- 8 --  
	            	 if (checkbox_strategy_ageAppropriateWritingActivity.isChecked()) {
	            		 report.strategy_ageAppropriateWritingActivity = true; 
	            		 checkbox_strategy_ageAppropriateWritingActivity.setChecked(false);
	            	 }
	            	// -- 9 --  
	            	 if (checkbox_strategy_behaviorProcessingForm.isChecked()) {
	            		 report.strategy_behaviorProcessingForm = true; 
	            		 checkbox_strategy_behaviorProcessingForm.setChecked(false);
	            	 }
	            	// -- 10 --  
	            	 if (checkbox_strategy_teacherScholarConversationOutsideClassroom.isChecked()) {
	            		 report.strategy_teacherScholarConversationOutsideClassroom = true; 
	            		 checkbox_strategy_teacherScholarConversationOutsideClassroom.setChecked(false);
	            	 }
	            	// -- 11 --  
	            	 if (checkbox_strategy_conversationWithFamily.isChecked()) {
	            		 report.strategy_conversationWithFamily = true; 
	            		 checkbox_strategy_conversationWithFamily.setChecked(false);
	            	 }
	            	// -- 12 --  
	            	 if (checkbox_strategy_conference.isChecked()) {
	            		 report.strategy_conference = true; 
	            		 checkbox_strategy_conference.setChecked(false);
	            	 }
	            	// -- 13 --  
	            	 if (checkbox_strategy_lossOfPriveleges.isChecked()) {
	            		 report.strategy_lossOfPriveleges = true; 
	            		 checkbox_strategy_lossOfPriveleges.setChecked(false);
	            	 }
	            	 
	            	 
	            	 
	            	 /*
	            	
	            	 String strategyInput = strategy_spinner.getSelectedItem().toString();
	            	 String settingsInput = settings_spinner.getSelectedItem().toString();
	            	 String behaviorInput = behavior_spinner.getSelectedItem().toString();
	            	 String academicInput = academic_spinner.getSelectedItem().toString();
	            	 //Log.d("DAS BUTTON", strategyInput);
	            	 
	            	 ParseObject gameScore = new ParseObject("Report");
	            	 gameScore.put("studentName", studentName);
	            	 gameScore.put("studentGrade", studentGrade);
	            	 gameScore.put("date", dateOfInfraction);
	            	 gameScore.put("strategyInput", strategyInput);
	            	 gameScore.put("settingsInput", settingsInput);
	            	 gameScore.put("behaviorInput", behaviorInput);
	            	 gameScore.put("academicInput", academicInput);
	            	 gameScore.saveInBackground();*/
	            	 
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