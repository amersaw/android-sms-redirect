package dev.sawan.smsredirect

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.SmsMessage
import android.util.Log
import android.widget.Toast


class MyReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val pdu = (intent?.extras?.get("pdus") as? Array<*>)?.get(0) as? ByteArray
        pdu?.let {
            val message = SmsMessage.createFromPdu(it)
            Log.d("TAG","Received")
            Toast.makeText(context, "Phone : ${message.displayOriginatingAddress} \n Text : ${message.displayMessageBody}", Toast.LENGTH_LONG).show()
            SendTelegramMessageTask().execute("Phone : ${message.displayOriginatingAddress}" +
                    " Text : ${message.displayMessageBody}")

        }
    }
}
