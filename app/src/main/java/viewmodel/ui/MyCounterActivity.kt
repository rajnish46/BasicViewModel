package viewmodel.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import rajnish.view.model.databinding.ActivityMainBinding
import viewmodel.model.MyCounterViewModel
import viewmodel.model.MyViewModelFactory

class MyCounterActivity : AppCompatActivity() {

    lateinit var factory: MyViewModelFactory
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*1.*/
//        var viewModel: MyCounterViewModel = ViewModelProvider(this).get(MyCounterViewModel()::class.java)
        /*2.*/
//        var factory: MyViewModelFactory = MyViewModelFactory() // non parameterized Factory
        var factory: MyViewModelFactory = MyViewModelFactory(10)  // // parameterized Factory
        var viewModel: MyCounterViewModel = ViewModelProvider(this, factory).get(MyCounterViewModel::class.java)
        /*3.*/
//        var viewModel: MyCounterViewModel = ViewModelProvider(
//            this,
//            ViewModelProvider.NewInstanceFactory()
//        ).get(MyCounterViewModel::class.java)

        viewModel.liveData.observe(this, Observer {
            binding.countVal.text = viewModel.liveData.value.toString()
        })

        binding.incr.setOnClickListener {
            viewModel.incr()
            binding.countVal.text = viewModel.liveData.value.toString()
        }

        binding.decr.setOnClickListener {
            viewModel.decr()
            binding.countVal.text = viewModel.liveData.value.toString()
        }

    }
}