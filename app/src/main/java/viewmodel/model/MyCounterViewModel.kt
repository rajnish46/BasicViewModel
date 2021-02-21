package viewmodel.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyCounterViewModel(mCount: Int=0) : ViewModel() {
    private var TAG: String = "MyCounterViewModel"

    private var count = MutableLiveData<Int>()
    val liveData: LiveData<Int> = count

    init {
        count.value = mCount
    }

    fun incr() {
        count.value = count.value!!.plus(1)
    }

    fun decr() {
        count.value = count.value!!.minus(1)
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "onCleared: ")
    }
}