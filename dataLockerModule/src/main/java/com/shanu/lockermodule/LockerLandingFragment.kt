package com.shanu.lockermodule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.AsyncListUtil.DataCallback
import com.shanu.lockermodule.databinding.FragmentLockerLandingBinding

/**
 * A simple [Fragment] subclass.
 * Use the [LockerLandingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LockerLandingFragment : Fragment() {

    private var _binding: FragmentLockerLandingBinding? = null
    private val binding get() = _binding!!

    private lateinit var lockerModuleDataCallback: () -> Unit

    fun registerLockerModuleDataCallback(dataCallback: () -> Unit) {
        lockerModuleDataCallback = dataCallback
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                /*val intent = Intent(activity, LoginActivity::class.java)
                startActivity(intent)
                activity?.finish()*/
//                Intent(
//                    requireActivity(),
//                    Class.forName("com.shanu.nmsuperapp.presentation.activity.LoginActivity")
//                ).apply {
//                    startActivity(this)
//                }.also {
//                    activity?.finish()
//                }
                lockerModuleDataCallback.invoke()
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // inflate the layout and bind to the _binding
        _binding = FragmentLockerLandingBinding.inflate(inflater, container, false)

        // Inflate the layout for this fragment
        return binding.root
    }
}