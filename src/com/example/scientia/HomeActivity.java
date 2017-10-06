package com.example.scientia;

import android.app.Activity;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;

import android.widget.Toast;
import android.widget.ViewFlipper;

public class HomeActivity extends Activity implements NavigationDrawerFragment.NavigationDrawerCallbacks {

	private NavigationDrawerFragment mNavigationDrawerFragment; //manages behaviors of navigation drawer
	
	private CharSequence mTitle; //stores title of last screen


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager().findFragmentById(R.id.navigation_drawer);
		mTitle = getTitle();

		// Set up the drawer.
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout));
	}

	@Override
	public void onNavigationDrawerItemSelected(int position) {
		// update the main content by replacing fragments
		FragmentManager fragmentManager = getFragmentManager();
		final FragmentTransaction ft = fragmentManager.beginTransaction();
		fragmentManager.beginTransaction().replace(R.id.fragment1, PlaceholderFragment.newInstance(position + 1))
				.commit();
		
		if(position == 1)
		{
			Fragment f1 = new IqQuiz();
			ft.replace(R.id.fragment1, f1);
			ft.commit();
		}
		if(position == 2)
		{
			Fragment f1 = new LogicalQuiz();
			ft.replace(R.id.fragment1, f1);
			ft.commit();
		}
		if(position == 3)
		{
			Fragment f1 = new AptitudeQuiz();
			ft.replace(R.id.fragment1, f1);
			ft.commit();
		}
		if(position == 4)
		{
			Fragment f1 = new VerbalQuiz();
			ft.replace(R.id.fragment1, f1);
			ft.commit();
		}
		if(position == 5)
		{
			//Fragment f1 = new HomeFragment();
			//ft.replace(R.id.fragment1, f1);
			//ft.commit();
			Intent i = new Intent(HomeActivity.this, Contact.class);
			startActivity(i);
		}
		
	}

	public void onSectionAttached(int number) {
		switch (number) {
		case 1:
			mTitle = getString(R.string.title_section1);
			break;
		case 2:
			mTitle = getString(R.string.title_section2);
			break;
		case 3:
			mTitle = getString(R.string.title_section3);
			break;
		case 4:
			mTitle = getString(R.string.title_section4);
			break;
		case 5:
			mTitle = getString(R.string.title_section5);
			break;
		case 6:
			mTitle = getString(R.string.title_section6);
			break;
		}
	}

	public void restoreActionBar() {
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(mTitle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (!mNavigationDrawerFragment.isDrawerOpen()) {
			getMenuInflater().inflate(R.menu.home, menu);
			restoreActionBar();
			return true;
		}
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) { //handles action bar item clicks
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public static class PlaceholderFragment extends Fragment { 		//placeholder containes a simple view
		
		private static final String ARG_SECTION_NUMBER = "section_number";
		
		public static PlaceholderFragment newInstance(int sectionNumber) {
			PlaceholderFragment fragment = new PlaceholderFragment(); //returns new fragment for the section number
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_home, container, false);
			ViewFlipper viewflipper = (ViewFlipper) rootView.findViewById(R.id.view_flipper);
			viewflipper.setAutoStart(true);
			viewflipper.setFlipInterval(5000);
			viewflipper.startFlipping();
			Toast.makeText(getActivity(), "Welcome to Scientia", 4000);
			return rootView;
		}

		@Override
		public void onAttach(Activity activity) {
			super.onAttach(activity);
			((HomeActivity) activity).onSectionAttached(getArguments().getInt(ARG_SECTION_NUMBER));
		}
	}

}
