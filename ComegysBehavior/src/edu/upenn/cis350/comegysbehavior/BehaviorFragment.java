package edu.upenn.cis350.comegysbehavior;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import android.support.v4.app.Fragment;

import android.os.Bundle;
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
	
	private Report report = new Report();
	
	public BehaviorFragment() {
	}
	
	private Spinner academic_settings_spinner, behavior_settings_spinner, grade_spinner;
	private EditText student_name, strategy_comment, behavior_comment, academic_comment;
	private DatePicker date;
	
	private static int[] checkboxBehaviorIds = {};
	private static int[] checkboxAcademicIds = {};
	private static int[] checkboxStrategyIds = {};
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.report, container, false);
		setSpinnerContent(rootView);
		
		student_name = (EditText) rootView.findViewById(R.id.scholar_name);
		strategy_comment = (EditText) rootView.findViewById(R.id.strategy_comment);
		academic_comment = (EditText) rootView.findViewById(R.id.academic_comment);
		behavior_comment = (EditText) rootView.findViewById(R.id.behavior_comment);
		date = (DatePicker) rootView.findViewById(R.id.SelectDate);
		
		final Button button = (Button) rootView.findViewById(R.id.submit_report_button);
         button.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
            	 Log.d("DAS BUTTON", "WORKS");
            	 String studentName = student_name.getText().toString();
            	 report.studentName = studentName;
            	 String studentGrade = grade_spinner.getSelectedItem().toString();
            	 report.studentGrade = studentGrade;
            	 String strategyComment = strategy_comment.getText().toString();
            	 report.strategyComment = strategyComment;
            	 String academicComment = academic_comment.getText().toString();
            	 report.academicComment = academicComment;
            	 String behaviorComment = behavior_comment.getText().toString();
            	 report.behaviorComment = behaviorComment;
            	 int day = date.getDayOfMonth();
            	 int month = date.getMonth();
            	 int year =  date.getYear();

            	 Calendar calendar = Calendar.getInstance();
            	 calendar.set(year, month, day);
            	 SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
            	 String dateOfInfraction = sdf.format(calendar.getTime());
            	 

            	 report.getParseObject().saveInBackground();
             }
         });
		
		return rootView;
	}
	
	private void createSummaries() {
		
	}
	
	
	public void onCheckboxClicked(View view) {
	    // Is the view now checked?
	    boolean checked = ((CheckBox) view).isChecked();
	    
	    // Check which checkbox was clicked
	    switch(view.getId()) {
	        case R.id.checkbox_behavior_respectForSelfAndOthers:
	            if (checked)
	            	report.behavior_respectForSelfAndOthers = true;
	            else
	            	report.behavior_respectForSelfAndOthers = false;
	            break;
	            
	        case R.id.checkbox_behavior_followingDirections:
	        	if (checked)
	            	report.behavior_followingDirections = true;
	            else
	            	report.behavior_followingDirections = false;    
	            break;
	            
	        case R.id.checkbox_behavior_positiveConflictResolution:
	            if (checked)
	            	report.behavior_positiveConflictResolution = true;
	            else
	            	report.behavior_positiveConflictResolution = false; 
	            break;
	            
	        case R.id.checkbox_behavior_peerMediation:
	            if (checked)
	            	report.behavior_peerMediation = true;
	            else
	            	report.behavior_peerMediation = false;  
	            break;
	            
	        case R.id.checkbox_behavior_helpingPeerOrStaff:
	            if (checked)
	            	report.behavior_helpingPeerOrStaff = true;
	            else
	            	report.behavior_helpingPeerOrStaff = false;  
	            break;
	            
	        case R.id.checkbox_behavior_leadership:
	            if (checked)
	            	report.behavior_leadership = true;
	            else
	            	report.behavior_leadership = false;  
	            break;
	            
	        case R.id.checkbox_behavior_dealingWithAdversityPositively:
	            if (checked)
	            	report.behavior_dealingWithAdversityPositively = true;
	            else
	            	report.behavior_dealingWithAdversityPositively = false;  
	            break;
	            
	        case R.id.checkbox_behavior_goingAboveAndBeyond:
	            if (checked)
	            	report.behavior_goingAboveAndBeyond = true;
	            else
	            	report.behavior_goingAboveAndBeyond = false;  
	            break;
	            
	        case R.id.checkbox_behavior_refusalToFollowDirectionsOrParticipate:
	            if (checked)
	            	report.behavior_refusalToFollowDirectionsOrParticipate = true;
	            else
	            	report.behavior_refusalToFollowDirectionsOrParticipate = false;  
	            break;
	            
	        case R.id.checkbox_behavior_disruptionOfClassOrActivity:
	            if (checked)
	            	report.behavior_disruptionOfClassOrActivity = true;
	            else
	            	report.behavior_disruptionOfClassOrActivity = false;  
	            break;
	            
	        case R.id.checkbox_behavior_disrespectOfStaffOrScholars:
	            if (checked)
	            	report.behavior_disrespectOfStaffOrScholars = true;
	            else
	            	report.behavior_disrespectOfStaffOrScholars = false;  
	            break;
	            
	        case R.id.checkbox_behavior_inappropriateLanguageOrGestures:
	            if (checked)
	            	report.behavior_inappropriateLanguageOrGestures = true;
	            else
	            	report.behavior_inappropriateLanguageOrGestures = false;  
	            break;
	            
	        case R.id.checkbox_behavior_inappropriatePhysicalContactOrFighting:
	            if (checked)
	            	report.behavior_inappropriatePhysicalContactOrFighting = true;
	            else
	            	report.behavior_inappropriatePhysicalContactOrFighting = false;  
	            break;
	            
	        case R.id.checkbox_behavior_teasingOrInstigatingConflict:
	            if (checked)
	            	report.behavior_teasingOrInstigatingConflict = true;
	            else
	            	report.behavior_teasingOrInstigatingConflict = false;  
	            break;
	            
	        case R.id.checkbox_behavior_runningInCommonSpaces:
	            if (checked)
	            	report.behavior_runningInCommonSpaces = true;
	            else
	            	report.behavior_runningInCommonSpaces = false;  
	            break;
	            
	        case R.id.checkbox_behavior_leavingSupervisionUnattended:
	            if (checked)
	            	report.behavior_leavingSupervisionUnattended = true;
	            else
	            	report.behavior_leavingSupervisionUnattended = false;  
	            break;
	            
	        case R.id.checkbox_behavior_failingToFollowRules:
	            if (checked)
	            	report.behavior_failingToFollowRules = true;
	            else
	            	report.behavior_failingToFollowRules = false;  
	            break;
	            
	        
	            // academic
	        case R.id.checkbox_academic_respectsLearningForSelfAndOthers:
	            if (checked)
	            	report.academic_respectsLearningForSelfAndOthers = true;
	            else
	            	report.academic_respectsLearningForSelfAndOthers = false;  
	            break;
	            
	        case R.id.checkbox_academic_followsDirections:
	            if (checked)
	            	report.academic_followsDirections = true;
	            else
	            	report.academic_followsDirections = false;  
	            break;
	            
	        case R.id.checkbox_academic_consistentlyPreparedAndOrganized:
	            if (checked)
	            	report.academic_consistentlyPreparedAndOrganized = true;
	            else
	            	report.academic_consistentlyPreparedAndOrganized = false;  
	            break;
	            
	        case R.id.checkbox_academic_completesHomeworkAndAssignments:
	            if (checked)
	            	report.academic_completesHomeworkAndAssignments = true;
	            else
	            	report.academic_completesHomeworkAndAssignments = false;  
	            break;
	            
	        case R.id.checkbox_academic_staysOnTask:
	            if (checked)
	            	report.academic_staysOnTask = true;
	            else
	            	report.academic_staysOnTask = false;  
	            break;
	            
	        case R.id.checkbox_academic_peerTutoring:
	            if (checked)
	            	report.academic_peerTutoring = true;
	            else
	            	report.academic_peerTutoring = false;  
	            break;
	            
	        case R.id.checkbox_academic_struggles:
	            if (checked)
	            	report.academic_struggles = true;
	            else
	            	report.academic_struggles = false;  
	            break;
	            
	        case R.id.checkbox_academic_disruptionOfClassLessonActivity:
	            if (checked)
	            	report.academic_disruptionOfClassLessonActivity = true;
	            else
	            	report.academic_disruptionOfClassLessonActivity = false;  
	            break;
	            
	        case R.id.checkbox_academic_refusalToFollowDirectionsAndParticipate:
	            if (checked)
	            	report.academic_refusalToFollowDirectionsAndParticipate = true;
	            else
	            	report.academic_refusalToFollowDirectionsAndParticipate = false;  
	            break;
	            
	        case R.id.checkbox_academic_unPreparedAndDisorganized:
	            if (checked)
	            	report.academic_unPreparedAndDisorganized = true;
	            else
	            	report.academic_unPreparedAndDisorganized = false;  
	            break;
	            
	        case R.id.checkbox_academic_failureToCompleteHomeworkAssignment:
	            if (checked)
	            	report.academic_failureToCompleteHomeworkAssignment = true;
	            else
	            	report.academic_failureToCompleteHomeworkAssignment = false;  
	            break;
	            
	        case R.id.checkbox_academic_questionableAcademicIntegrity:
	            if (checked)
	            	report.academic_questionableAcademicIntegrity = true;
	            else
	            	report.academic_questionableAcademicIntegrity = false;  
	            break;
	            
	        case R.id.checkbox_strategy_plannedIgnoring:
	            if (checked)
	            	report.strategy_plannedIgnoring = true;
	            else
	            	report.strategy_plannedIgnoring = false;  
	            break;
	            
	            
	            //strategies
	        case R.id.checkbox_strategy_behaviorLog:
	            if (checked)
	            	report.strategy_behaviorLog = true;
	            else
	            	report.strategy_behaviorLog = false;  
	            break;
	            
	        case R.id.checkbox_strategy_reteachReviewExpectations:
	            if (checked)
	            	report.strategy_reteachReviewExpectations = true;
	            else
	            	report.strategy_reteachReviewExpectations = false;  
	            break;
	            
	        case R.id.checkbox_strategy_restorativeAction:
	            if (checked)
	            	report.strategy_restorativeAction = true;
	            else
	            	report.strategy_restorativeAction = false;  
	            break;
	            
	        case R.id.checkbox_strategy_apologyVerbalAndOrWritten:
	            if (checked)
	            	report.strategy_apologyVerbalAndOrWritten = true;
	            else
	            	report.strategy_apologyVerbalAndOrWritten = false;  
	            break;
	            
	        case R.id.checkbox_strategy_scholarPairingTimeOut:
	            if (checked)
	            	report.strategy_scholarPairingTimeOut = true;
	            else
	            	report.strategy_scholarPairingTimeOut = false;  
	            break;
	            
	        case R.id.checkbox_strategy_timeOut:
	            if (checked)
	            	report.strategy_timeOut = true;
	            else
	            	report.strategy_timeOut = false;  
	            break;
	            
	        case R.id.checkbox_strategy_ageAppropriateWritingActivity:
	            if (checked)
	            	report.strategy_ageAppropriateWritingActivity = true;
	            else
	            	report.strategy_ageAppropriateWritingActivity = false;  
	            break;
	            
	        case R.id.checkbox_strategy_behaviorProcessingForm:
	            if (checked)
	            	report.strategy_behaviorProcessingForm = true;
	            else
	            	report.strategy_behaviorProcessingForm = false;  
	            break;
	            
	        case R.id.checkbox_strategy_teacherScholarConversationOutsideClassroom:
	            if (checked)
	            	report.strategy_teacherScholarConversationOutsideClassroom = true;
	            else
	            	report.strategy_teacherScholarConversationOutsideClassroom = false;  
	            break;
	            
	        case R.id.checkbox_strategy_conversationWithFamily:
	            if (checked)
	            	report.strategy_conversationWithFamily = true;
	            else
	            	report.strategy_conversationWithFamily = false;  
	            break;
	            
	        case R.id.checkbox_strategy_conference:
	            if (checked)
	            	report.strategy_conference = true;
	            else
	            	report.strategy_conference = false;  
	            break;
	            
	        case R.id.checkbox_strategy_lossOfPriveleges:
	            if (checked)
	            	report.strategy_lossOfPriveleges = true;
	            else
	            	report.strategy_lossOfPriveleges = false;  
	            break;
	    }
	}
	
	private void setSpinnerContent(View view) {
	  behavior_settings_spinner = (Spinner) view.findViewById( R.id.behavior_settings_spinner );
	  academic_settings_spinner = (Spinner) view.findViewById( R.id.academic_settings_spinner); 
	  grade_spinner = (Spinner) view.findViewById( R.id.grade_spinner);
	}
}