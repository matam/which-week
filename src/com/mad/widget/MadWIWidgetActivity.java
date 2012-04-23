package com.mad.widget;
 
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.widget.RemoteViews;
 
 
 
    public class MadWIWidgetActivity extends AppWidgetProvider {
 
 
        @Override
        public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
            Timer timer = new Timer();          
            timer.scheduleAtFixedRate(new Aktualizacja(context, appWidgetManager),100, 1000);
 
        }
 
        private class Aktualizacja extends TimerTask{
 
            RemoteViews remoteViews;
            ComponentName thisWidget;
            AppWidgetManager appWidgetManager;            

 
            public Aktualizacja(Context context,AppWidgetManager appWidgetManager){
                this.appWidgetManager = appWidgetManager;
                remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget1);
                thisWidget = new ComponentName(context, MadWIWidgetActivity.class);                
            }
 

 
            @Override
            public void run(){
           
                final Calendar c = Calendar.getInstance();
                Integer mYear = c.get(Calendar.YEAR);
                Integer mMonth = c.get(Calendar.MONTH);
                Integer mDay = c.get(Calendar.DAY_OF_MONTH);

            	remoteViews.setTextViewText(R.id.tv_data,mYear.toString()+":"+mMonth.toString()+":"+mDay.toString() +" "+c.getTimeInMillis());
            	//remoteViews.setTextViewText(R.id.tv_data,"test");
                appWidgetManager.updateAppWidget(thisWidget, remoteViews);
                

 
            }
        }
    }