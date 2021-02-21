package viewmodel.model

import android.util.Log
import androidx.lifecycle.ViewModel

class MyCounterViewModel(var mCount: Int) : ViewModel() {
    private var TAG: String = "MyCounterViewModel"
    var count = mCount

    fun incr() {
        ++count
    }

    fun decr() {
        --count
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "onCleared: ")
    }
}