/**
 * 
 */
package edu.upenn.cis350.comegysbehavior;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.parse.FindCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseException;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * @author Administrator
 *
 */
public class ReportsListFragment extends Fragment {

	private List<Report> reports;
	/**
	 * 
	 */
	public ReportsListFragment() {
		// Auto-generated constructor stub
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.reports_list, container, false);
		this.reports = new ArrayList<Report>();
		
		retrieveReports();
		
		return view;
	}
	
	protected void retrieveReports() {
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Report");
		query.findInBackground(new FindCallback<ParseObject>() {
			@Override
			public void done(List<ParseObject> parseReportList, ParseException e) {
				if (e == null) {
					for (ParseObject parseReport : parseReportList) {
						ReportsListFragment.this.reports.add(new Report(parseReport));
						Collections.sort(ReportsListFragment.this.reports, new ReportNameComparator());
					}
					updateView();
				} else {
					
				}
			}
		});
	}
	
	protected void updateView() {
		ArrayList<String> alphabetizedStudentNames = new ArrayList<String>();
		for (Report report : ReportsListFragment.this.reports) {
			alphabetizedStudentNames.add(report.studentName);
		}
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, alphabetizedStudentNames) ;
		
		ListView listView = (ListView) getActivity().findViewById(R.id.reports_list);
		listView.setAdapter(adapter);
	}

	public class ReportNameComparator implements Comparator<Report> {
		@Override
		public int compare(Report reportOne, Report reportTwo) {
			// Retrieve names
			final String reportOneName = reportOne.studentName;
			final String reportTwoName = reportTwo.studentName;
			
			// Compare and return lexographic ordering of names
			return reportOneName.compareToIgnoreCase(reportTwoName);
		}
	}
}
