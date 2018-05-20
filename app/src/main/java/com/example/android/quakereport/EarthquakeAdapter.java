package com.example.android.quakereport;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.graphics.drawable.GradientDrawable;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;
import static android.R.attr.inflatedId;
import static android.R.attr.resource;
import static com.example.android.quakereport.R.id.location_offset;

import static com.example.android.quakereport.R.id.primary_location;

/**
 * Created by El.Doc on 01/03/2017.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    public EarthquakeAdapter(Context context, List<Earthquake> earthquakes) {
        super(context,0,earthquakes);
    }
    public View getView (int position , View convertView , ViewGroup parent){
        View listItemView = convertView;
        if(convertView==null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list,parent,false);
        }
        //mag
        Earthquake currentEarthquake = getItem(position);
        TextView mag = (TextView) listItemView.findViewById(R.id.mag);
        String formattedMagnitude = formatMagnitude(currentEarthquake.getMag());
        // Display the magnitude of the current earthquake in that TextView
        mag.setText(formattedMagnitude);
        //optimizing color
        GradientDrawable magnitudeCircle = (GradientDrawable) mag.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMag());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);




        //location
        String name = currentEarthquake.getPlace();
        final  String location_separetor =" of ";
        String[] aftersplit ;
        String locationOffset;
        String primaryLocation;
        if (name.contains(location_separetor)==true){
            aftersplit = name.split(location_separetor);
            locationOffset =aftersplit[0]+location_separetor;
             primaryLocation = aftersplit[1];
        }
        else{
           locationOffset = "near to ";
            primaryLocation = name;

        }
        TextView locationOffset1 = (TextView) listItemView.findViewById(location_offset);
        locationOffset1.setText(locationOffset);

        TextView primaryLocation1 = (TextView) listItemView.findViewById(primary_location);
        primaryLocation1.setText(primaryLocation);




        Date dateObject = new Date(currentEarthquake.getDate());

        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        // Display the date of the current earthquake in that TextView
        dateView.setText(formattedDate);

        // Find the TextView with view ID time
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);
        // Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);
        return listItemView;
    }
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }
    private  int getMagnitudeColor(double mag){
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(mag);
        switch (magnitudeFloor){
        case 0:
        case 1:
        magnitudeColorResourceId = R.color.magnitude1;
        break;
        case 2:
        magnitudeColorResourceId = R.color.magnitude2;
        break;
        case 3:
        magnitudeColorResourceId = R.color.magnitude3;
        break;
        case 4:
        magnitudeColorResourceId = R.color.magnitude4;
        break;
        case 5:
        magnitudeColorResourceId = R.color.magnitude5;
        break;
        case 6:
        magnitudeColorResourceId = R.color.magnitude6;
        break;
        case 7:
        magnitudeColorResourceId = R.color.magnitude7;
        break;
        case 8:
        magnitudeColorResourceId = R.color.magnitude8;
        break;
        case 9:
        magnitudeColorResourceId = R.color.magnitude9;
        break;
        default:
        magnitudeColorResourceId = R.color.magnitude10plus;
        break;
    }
    return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
}
    }

