package edu.upenn.cis350.comegysbehavior;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseObject;

public class MainActivity extends FragmentActivity implements
		ActionBar.TabListener {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;
	
	static Report report;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	// spinner for settings
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		report = new Report();
		
		// Initialize Parse
		Parse.initialize(this, "Q60Xc0o3UZOBLeB8mO83gX19LNV25xwr4LtaX34n", "o4JPB1gTW3Vov6UASIRMeuqVeB0Kg6uwy2G3ufXs");

		// Set up the action bar.
		final ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

		// When swiping between different sections, select the corresponding
		// tab. We can also use ActionBar.Tab#select() to do this if we have
		// a reference to the Tab.
		mViewPager
				.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
					@Override
					public void onPageSelected(int position) {
						actionBar.setSelectedNavigationItem(position);
					}
				});

		// For each of the sections in the app, add a tab to the action bar.
		for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
			// Create a tab with text corresponding to the page title defined by
			// the adapter. Also specify this Activity object, which implements
			// the TabListener interface, as the callback (listener) for when
			// this tab is selected.
			actionBar.addTab(actionBar.newTab()
					.setText(mSectionsPagerAdapter.getPageTitle(i))
					.setTabListener(this));
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onTabSelected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
		// When the given tab is selected, switch to the corresponding page in
		// the ViewPager.
		mViewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}
		
		
		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a StrategySectionFragment (defined as a static inner class
			// below) with the page number as its lone argument.
			if (position == 0) {
				Fragment fragment = new BehaviorFragment();
				Bundle args = new Bundle();
				args.putInt(BehaviorFragment.ARG_SECTION_NUMBER, position + 1);
				fragment.setArguments(args);
				return fragment;
			} else {
				Fragment fragment = new ReportsListFragment();
				return fragment;
			}
			
		}

		@Override
		public int getCount() {
			// Show 2 total pages.
			return 2;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.title_section1).toUpperCase(l);
			case 1:
				return getString(R.string.title_section2).toUpperCase(l);
			}
			return null;
		}
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
	
	/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
	public static class DummySectionFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";

		public DummySectionFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main_dummy,
					container, false);
			TextView dummyTextView = (TextView) rootView
					.findViewById(R.id.section_label);
			dummyTextView.setText(Integer.toString(getArguments().getInt(
					ARG_SECTION_NUMBER)));
			return rootView;
		}
	}

}
