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
		TextView nameLabel = (TextView) findViewById(R.id.name);
		String name = "Scholar Name: "+ pastReport.studentName;
		nameLabel.setText(name); 

		/*TextView emailLabel = (TextView) findViewById(R.id.email);
		emailLabel.setText(brother.Email_Address);

		TextView phone = (TextView) findViewById(R.id.phone);
		phone.setText(brother.Phone_Number);

		TextView yearLabel = (TextView) findViewById(R.id.year);
		yearLabel.setText(brother.Expected_Graduation_Year);

		TextView pledgeClassLabel = (TextView) findViewById(R.id.pledge_class);
		pledgeClassLabel.setText(brother.Pledge_Class);

		TextView majorLabel = (TextView) findViewById(R.id.major);
		majorLabel.setText(brother.Major);*/
	
	}
}