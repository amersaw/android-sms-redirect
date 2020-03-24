package dev.sawan.smsredirect

import android.os.AsyncTask
import android.util.Log
import com.github.kittinunf.fuel.httpGet


internal class SendTelegramMessageTask : AsyncTask<String, String, String>() {

    val TelegramToken = ""
    val TelegramDestination = ""
    override fun doInBackground(vararg req: String?): String {


            val url = "https://api.telegram.org/bot${TelegramToken}/sendmessage?chat_id=${TelegramDestination}&text=${req.first()}"
            Log.i("Telegram","URL:${url}")

            val res = url.httpGet()
                .responseString()

            Log.i("Telegram",res.toString())
           return  res.toString()

    }

    override fun onPostExecute(str: String?) {
        // TODO: check this.exception
        // TODO: do something with the feed
    }
}