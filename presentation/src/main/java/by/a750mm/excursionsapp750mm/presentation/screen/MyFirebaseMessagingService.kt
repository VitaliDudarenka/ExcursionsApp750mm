package by.a750mm.excursionsapp750mm.presentation.screen

import android.annotation.SuppressLint
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.media.RingtoneManager
import android.support.v4.app.NotificationCompat
import by.a750mm.excursionsapp750mm.R
import by.a750mm.excursionsapp750mm.presentation.screen.excursion.ExcursionActivity
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


@SuppressLint("Registered")
class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage?) {

        sendNotification(remoteMessage!!.notification!!.body)

    }

    private fun sendNotification(messageBody: String?) {
        val intent = Intent(this, ExcursionActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

        val notificationBuilder = NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.rails)
                .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.drawable.rails))
                .setContentTitle(this.getString(R.string.app_name))
                .setContentText(messageBody)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        notificationManager.notify(0, notificationBuilder.build())
    }

}