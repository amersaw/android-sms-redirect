package dev.sawan.smsredirect

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.telephony.SmsMessage
import android.util.Log
import android.widget.Toast


class MyReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action.equals(Telephony.Sms.Intents.SMS_RECEIVED_ACTION)) {
            var msgBody = "";
            var msgSender = ""
            val smsMessages =
                Telephony.Sms.Intents.getMessagesFromIntent(intent)
            for (message in smsMessages) { // Do whatever you want to do with SMS.
                msgBody += message.messageBody
                msgSender = message.displayOriginatingAddress
            }
            Toast.makeText(context, "Phone : $msgSender \n Text : $msgBody", Toast.LENGTH_LONG)
                .show()
            SendTelegramMessageTask().execute(
                "Phone : $msgSender" +
                        " Text : $msgBody"
            )
        }
    }
}
