package com.hungry.githubaacstudy.ui.search

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.hungry.githubaacstudy.Alarm
import com.hungry.githubaacstudy.core.BaseViewModel
import com.hungry.githubaacstudy.ui.networktest.ResVOApiPlosResponseDocs
import com.hungry.githubaacstudy.ui.networktest.SearchAPI
import com.hungry.githubaacstudy.util.NotNullMutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*

class SearchViewModel(private val api: SearchAPI) : BaseViewModel() {
//class SearchViewModel : BaseViewModel() {


    private var cntNumber = "0"


    private val _items: NotNullMutableLiveData<List<ResVOApiPlosResponseDocs>> = NotNullMutableLiveData(arrayListOf())
    val items: NotNullMutableLiveData<List<ResVOApiPlosResponseDocs>>
        get() = _items

    val numFoundValue: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>(0)
    }
    val startValue: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>(0)
    }
    val maxScoreValue: MutableLiveData<Double> by lazy {
        MutableLiveData<Double>(0.0)
    }

    val textValue: MutableLiveData<String> by lazy {
        MutableLiveData<String>("0")
    }

    val textValueRandom: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun startIncrease() {
        var cntNumberInt = Integer.parseInt(cntNumber)

        cntNumberInt++
//        Log.d("TEST", "cntNumberInt : $cntNumberInt")
        cntNumber = cntNumberInt.toString()
        textValue.value = cntNumber
    }

    fun addAlarm(){

//        var alarmManager = this.getSystemService(Context.ALARM_SERVICE) as AlarmManager
//        var alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
//        var intent = Intent(context, Alarm::class.java)
//        var pIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT)
//
//        val cal = Calendar.getInstance()
//        cal.set(Calendar.YEAR, 2021)
//        cal.set(Calendar.MONTH, 9)
//        cal.set(Calendar.DAY_OF_MONTH, 24)
//        cal.set(Calendar.HOUR_OF_DAY, 17)
//        cal.set(Calendar.MINUTE, 0)
//        cal.set(Calendar.SECOND, 0)
//
//        alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, cal.timeInMillis, pIntent)
    }

    fun startRandom() {
        val random = Random()
        val numRandom = random.nextInt(5)
        /* val num 변수에 0~4 사이의 무작위 Int 저장 */
//        Log.d("TEST", "numRandom : $numRandom")
        textValueRandom.value = numRandom.toString()
    }

    fun saveToBookmark(repository: ResVOApiPlosResponseDocs) {
        Log.d("TEST", "repository : ${repository.id}")
    }

    fun doNet() {
        Log.d("TEST", "doNet Start.....$api")

        /*val reqVOAppTokenSave = ReqVOAppTokenSave(
            "1111111",
            "22222",
            "Android",
            "333333",
            "1",
            "N",
            "555"
        )*/

//        addToDisposable(api.requestSingle(reqVOAppTokenSave)
        addToDisposable(
            api.requestSingle()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

                .subscribe({
                    // handle success
                    Log.d("TEST", "suuuuuu it : $it")
                    numFoundValue.value = it.response.numFound
                    startValue.value = it.response.start
                    maxScoreValue.value = it.response.maxScore

                    Log.d("TEST", "suuuuuu it : ${it.response.docs[0].id}")


                    _items.value = it.response.docs

                }, {
                    // handle fail
                    Log.d("TEST", "fffaaaaa it : $it")
                })
        )

    }

}