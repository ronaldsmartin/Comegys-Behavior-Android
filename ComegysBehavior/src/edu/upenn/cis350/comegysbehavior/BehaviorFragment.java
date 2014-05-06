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
		checkbox_strategy_strategy_timeOut, checkbox_strategy_ageAppropriateWritingActivity, 
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
	            	 gameScore.saveInBackground();
	            	 */
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