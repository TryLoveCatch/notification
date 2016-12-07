package com.tlc.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.RemoteViews;

/**
 * Created by kris on 16/4/14.
 * 常驻通知帮助类
 */
public class ResidentNotificationHelper {
    public static final String NOTICE_ID_KEY = "NOTICE_ID";
    public static final String ACTION_CLOSE_NOTICE = "cn.campusapp.action.closenotice";
    public static final String CLICK_INTENT_ACTION = "com.tlc.haha.click";
    public static final String FULL_INTENT_ACTION = "com.tlc.haha.full";
    public static final int NOTICE_ID_TYPE_0 = R.string.app_name;

    public static void sendResidentNoticeType0(Context context) {

        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.view_notification_type_0);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setAutoCancel(true)
                .setOngoing(false)
                .setVisibility(Notification.VISIBILITY_PUBLIC)
                .setPriority(NotificationCompat.PRIORITY_MAX)
//                .setDefaults(Notification.DEFAULT_ALL)
                .setFullScreenIntent(PendingIntent.getBroadcast(context, 0, fullIntent(), PendingIntent
                        .FLAG_CANCEL_CURRENT), true)

                .setSmallIcon(R.drawable.logo)
                .setContent(remoteViews);
//        builder.addAction(R.drawable.logo, "呵呵", null);
//        builder.addAction(R.drawable.push_close, "哈哈", null);

        Notification notification = builder.build();

        if(android.os.Build.VERSION.SDK_INT >= 16) {
            notification.bigContentView = remoteViews;
        }

//        remoteViews = new RemoteViews(context.getPackageName(), R.layout.view_notification_type_1);
//        notification.contentView = remoteViews;
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(NOTICE_ID_TYPE_0, notification);
    }

    public static void other(Context context) {

        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.view_notification_type_0);
                remoteViews.setTextViewText(R.id.title, "title");
        //        remoteViews.setTextViewText(R.id.content_tv, "msgmsgmsgmgsmgsmgsmgmm");
        //        remoteViews.setTextViewText(R.id.time_tv, getTime());
        //        remoteViews.setImageViewResource(R.id.icon_iv, R.drawable.logo);
        //        Intent intent = new Intent(context, MainActivity.class);
        //        intent.putExtra(NOTICE_ID_KEY, NOTICE_ID_TYPE_0);
        //        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        //        int requestCode = (int) SystemClock.uptimeMillis();
        //        PendingIntent pendingIntent = PendingIntent.getActivity(context, requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        //        remoteViews.setOnClickPendingIntent(R.id.notice_view_type_0, pendingIntent);
        //        int requestCode1 = (int) SystemClock.uptimeMillis();
        //        Intent intent1 = new Intent(ACTION_CLOSE_NOTICE);
        //        intent1.putExtra(NOTICE_ID_KEY, NOTICE_ID_TYPE_0);
        //        PendingIntent pendingIntent1 = PendingIntent.getBroadcast(context, requestCode1, intent1, PendingIntent.FLAG_UPDATE_CURRENT);
        //        remoteViews.setOnClickPendingIntent(R.id.close_iv, pendingIntent1);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setAutoCancel(true)
                .setOngoing(false)
                .setVisibility(Notification.VISIBILITY_PUBLIC)
                .setPriority(NotificationCompat.PRIORITY_MAX)
                                .setDefaults(Notification.DEFAULT_ALL)

                .setSmallIcon(R.drawable.logo)
                .setContent(remoteViews);
//        builder.addAction(R.drawable.logo, "呵呵", null);
//        builder.addAction(R.drawable.push_close, "哈哈", null);

        Notification notification = builder.build();

        if(android.os.Build.VERSION.SDK_INT >= 16) {
            notification.bigContentView = remoteViews;
        }

        //        remoteViews = new RemoteViews(context.getPackageName(), R.layout.view_notification_type_1);
        //        notification.contentView = remoteViews;
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(10002, notification);
    }

    public static void clearNotification(Context context, int noticeId) {
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.cancel(noticeId);
    }

    private static Intent fullIntent() {
        Intent tIntent = new Intent();
        tIntent.setAction(FULL_INTENT_ACTION);
        return tIntent;
    }

    private Intent clickIntent() {
        Intent tIntent = new Intent();
        tIntent.setAction(CLICK_INTENT_ACTION);
        return tIntent;
    }

}
