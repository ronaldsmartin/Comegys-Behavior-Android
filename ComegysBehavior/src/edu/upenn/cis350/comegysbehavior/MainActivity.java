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

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	// spinner for settings
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
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
		
		/*
		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a DummySectionFragment (defined as a static inner class
			// below) with the page number as its lone argument.
			Fragment fragment = new DummySectionFragment();
			Bundle args = new Bundle();
			args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1);
			fragment.setArguments(args);
			return fragment;
		}
		*/
		
		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a StrategySectionFragment (defined as a static inner class
			// below) with the page number as its lone argument.
			Fragment fragment = new BehaviorFragment();
			Bundle args = new Bundle();
			args.putInt(BehaviorFragment.ARG_SECTION_NUMBER, position + 1);
			fragment.setArguments(args);
			return fragment;
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


	
	/**
	 * Fragment that shows behavior report
	 */
	public static class BehaviorFragment extends Fragment {
		
		public static final String ARG_SECTION_NUMBER = "section_number";
		public BehaviorFragment() {
		}
		
		private Spinner strategy_spinner, settings_spinner, behavior_spinner, academic_spinner, grade_spinner;
		private EditText student_name;
		private DatePicker date;
		
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
			
			final Button button = (Button) rootView.findViewById(R.id.submit_report_button);
	         button.setOnClickListener(new View.OnClickListener() {
	             public void onClick(View v) {
	            	 Log.d("DAS BUTTON", "WORKS");
	            	 String studentName = student_name.getText().toString();
	            	 String studentGrade = grade_spinner.getSelectedItem().toString();
	            	 int day = date.getDayOfMonth();
	            	 int month = date.getMonth();
	            	 int year =  date.getYear();

	            	 Calendar calendar = Calendar.getInstance();
	            	 calendar.set(year, month, day);
	            	 SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
	            	 String dateOfInfraction = sdf.format(calendar.getTime());
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
	             }
	         });
			
			return rootView;
		}
		private void setSpinnerContent( View view )
		{
		  strategy_spinner = (Spinner) view.findViewById( R.id.strategy_spinner );
		  settings_spinner = (Spinner) view.findViewById( R.id.settings_spinner );
		  behavior_spinner = (Spinner) view.findViewById( R.id.behavior_spinner);
		  academic_spinner = (Spinner) view.findViewById( R.id.academic_spinner); 
		  grade_spinner = (Spinner) view.findViewById( R.id.grade_spinner);
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
