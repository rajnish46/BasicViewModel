package viewmodel.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MyViewModelFactory(private var n: Int = 0) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MyCounterViewModel::class.java)) {
            return MyCounterViewModel(n) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }

}