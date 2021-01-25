package com.usebastian.tripadoo;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{

	private DrawerLayout drawerLayout;

	@Override
	protected void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_main );

		Toolbar toolbar = findViewById( R.id.toolbar );

		drawerLayout = findViewById( R.id.drawer_layout );

		NavigationView navigationView = findViewById( R.id.nav_view );
		navigationView.setNavigationItemSelectedListener( this );

		ActionBarDrawerToggle toggle = new ActionBarDrawerToggle( this, drawerLayout, toolbar,
				R.string.navigation_drawer_open, R.string.navigation_drawer_close );
		drawerLayout.addDrawerListener( toggle );
		toggle.syncState();
	}

	@Override
	public boolean onNavigationItemSelected( @NonNull MenuItem item )
	{

		if( item.getItemId() == R.id.nav_romania )
		{
			startActivity( new Intent( this, RomaniaActivity.class ) );
		}
		if( item.getItemId() == R.id.nav_genius )
		{

			startActivity( new Intent( this, GeniuProgramActivity.class ) );
		}

		drawerLayout.closeDrawer( GravityCompat.START );
		return true;
	}

	@Override
	public void onBackPressed()
	{
		if( drawerLayout.isDrawerOpen( GravityCompat.START ) )
		{
			drawerLayout.closeDrawer( GravityCompat.START );
		}
		else
		{
			super.onBackPressed();
		}
	}
}
