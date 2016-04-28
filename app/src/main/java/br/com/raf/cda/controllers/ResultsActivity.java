package br.com.raf.cda.controllers;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.raf.cda.R;

/**
 * Classe que mostrará os detalhes do trajeto percorrido
 */
public class ResultsActivity extends Activity
{
	protected void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.results_activity);
	    Bundle bundle = getIntent().getExtras();	//	Recovering data from stored content
	    if (bundle != null)
	    {
	    	//	Recovering the lists
		    ArrayList<String>	lengthOfTime = bundle.getStringArrayList("time");
			ArrayList<String>	speedList = bundle.getStringArrayList("speedList");
			ArrayList<String>	distanceList = bundle.getStringArrayList("distanceList");

			ScrollView scrollView = new ScrollView(this);
	        TableLayout tableLayout= new TableLayout(this);
	        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(this);
	        
	        TableRow titles = new TableRow(this); 
	        TableRow.LayoutParams params = new TableRow.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT,1.0f);
    	    params.setMargins(1, 1, 1, 1);	//	Creates thin margins so that the content is more readable
	        titles.addView(createTextView("Local", params));
	        titles.addView(createTextView("Distância (metros)", params));
	        titles.addView(createTextView("Velocidade (km/h)", params));
	        titles.addView(createTextView("Tempo", params));
	        tableLayout.addView(titles, params);         
	        for (int i = 0; i < distanceList.size(); i++)
	        {
	            TableRow row = new TableRow(this);	//	Each row contains one Location, one Distance, one Speed and one Time
	            
	            TextView tv_location = createTextView(Integer.toString(i), params);
	            row.addView(tv_location);
	            
	            TextView tv_distance = createTextView(distanceList.get(i).toString(), params);
	            row.addView(tv_distance);
	            
	            TextView tv_speed = createTextView(speedList.get(i).toString(), params);
	            row.addView(tv_speed);
	            
	            TextView tv_time = createTextView(lengthOfTime.get(i).toString(), params);
	            row.addView(tv_time);
	            
	            tableLayout.addView(row, params);
	        }
	        TableRow total = new TableRow(this);
	        total.addView(createTextView("Total", params));
	        total.addView(createTextView(Float.toString(bundle.getFloat("totalDistance")), params));
	        total.addView(createTextView(Float.toString(bundle.getFloat("totalSpeed")), params));
	        total.addView(createTextView("", params));
	        tableLayout.addView(total, params); 
	        horizontalScrollView.addView(tableLayout);	//	Adds the table layout to the horizontal scroll view (in case one number is very big and stretches the screen)
	        scrollView.addView(horizontalScrollView);	//	Same thing but for vertical content
	        setContentView(scrollView);	//	Sets the view to the page
	    }
    }
	
	//	Creates the customized text view
	private TextView createTextView(String str, TableRow.LayoutParams params)
	{ 
	    TextView text = new TextView(this); 
	    text.setLayoutParams(params);	//	Applies the layout params
	    text.setPadding(4, 4, 10, 4);
	    text.setBackgroundColor(Color.WHITE);
	    text.setGravity(Gravity.RIGHT);	//	The text is centered on the right
	    text.setText(str);
	    return (text); 
	} 
}
