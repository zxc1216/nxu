package edu.zhangmolei.zhangmolei.widget;

import android.appwidget.AppWidgetProvider;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import edu.zhangmolei.zhangmolei.R;
import edu.zhangmolei.zhangmolei.MainActivity;

public class zhangMoleiWidget extends AppWidgetProvider {
    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
    }
    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);
    }
    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
    }
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager,
                         int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        Intent intent = new Intent(context,MainActivity.class);
        PendingIntent Pfullintent=PendingIntent.getActivity(context, 0, intent, 0);
        RemoteViews views= new RemoteViews(context.getPackageName(), R.layout.zhangmolei_widget);
        views.setOnClickPendingIntent(R.id.imageView1,Pfullintent);
        appWidgetManager.updateAppWidget(appWidgetIds, views);

    }
}
