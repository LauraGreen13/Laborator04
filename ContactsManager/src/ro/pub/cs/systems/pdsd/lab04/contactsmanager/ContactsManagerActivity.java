package ro.pub.cs.systems.pdsd.lab04.contactsmanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class ContactsManagerActivity extends Activity {
	
	public static final int CONTACTS_MANAGER_RESULT_CODE = 1;
	public static final String CONTACTS_MANAGER_REQUEST_CODE = "CONTACTS_MANAGER_REQUEST_CODE";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contacts_manager);
		
		Intent intent = getIntent();
		  if (intent != null) {
			    String action = intent.getAction();
			    String phoneNumber = intent.getStringExtra(CONTACTS_MANAGER_REQUEST_CODE);
			    
			    EditText editText = (EditText) findViewById(R.id.editText2);
			    editText.setText(phoneNumber);
			  }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.contacts_manager, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		String phoneNumber = intent.getStringExtra(CONTACTS_MANAGER_REQUEST_CODE);
		
		
		switch(requestCode) {
		  case CONTACTS_MANAGER_RESULT_CODE:
		    setResult(resultCode, new Intent());
		    finish();
		    break;
		  }
		}
	
}
