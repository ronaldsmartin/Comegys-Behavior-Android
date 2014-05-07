package edu.upenn.cis350.comegysbehavior;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PastReportDetails extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.past_reports_details);

		// Retrieve brother data from intent.
		final Report pastReport = (Report) getIntent().getParcelableExtra(getString(R.string.past_report_data));

		// Set all labels.
		//Set Name
		TextView nameLabel = (TextView) findViewById(R.id.name);
		String name =  pastReport.studentName;
		nameLabel.setText(name); 
		
		//Set Grade
		TextView gradeLabel = (TextView) findViewById(R.id.grade);
		String grade =  pastReport.studentGrade;
		gradeLabel.setText(grade);
		
		//Set Date
		TextView dateLabel = (TextView) findViewById(R.id.date);
		String date =  pastReport.reportCreatedDate;
		dateLabel.setText(date);
		
		//Set Behavior Setting
		TextView bSettingLabel = (TextView) findViewById(R.id.behavior_location);
		String bSetting =  pastReport.behaviorSetting;
		bSettingLabel.setText(bSetting);
		
		//Set Behavior Details
		TextView behaviorLabel = (TextView) findViewById(R.id.behavior_report_details);
		String behavior =  pastReport.behaviorSummary;
		behaviorLabel.setText(behavior);
		
		//Set Behavior Comments
		TextView bCommsLabel = (TextView) findViewById(R.id.behavior_report_comments);
		String behaviorCom =  pastReport.behaviorComment;
		bCommsLabel.setText(behaviorCom);
		
		//Set Acedemic Setting
		TextView aSettingLabel = (TextView) findViewById(R.id.academic_location);
		String aSetting =  pastReport.academicSetting;
		aSettingLabel.setText(aSetting);
		
		//Set Acedemic Details
		TextView academicLabel = (TextView) findViewById(R.id.academic_report_details);
		String academic =  pastReport.academicSummary;
		academicLabel.setText(academic);
		
		//Set Acedemic Comments
		TextView academicComsLabel = (TextView) findViewById(R.id.academic_report_comments);
		String academicCom =  pastReport.academicComment;
		academicComsLabel.setText(academicCom);
		
		//Set Strategies Details
		TextView strategiesLabel = (TextView) findViewById(R.id.strategies_report_details);
		String strategy =  pastReport.strategySummary;
		strategiesLabel.setText(strategy);
		
		//Set strategies Comments
		TextView strategiesComLabel = (TextView) findViewById(R.id.strategies_report_comments);
		String strategyCom =  pastReport.strategyComment;
		strategiesComLabel.setText(strategyCom);

		
	
	}
}