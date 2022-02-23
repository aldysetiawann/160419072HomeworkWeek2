package id.ac.ubaya.adv160419092week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.ubaya.a160419072homeworkweek2.R
import kotlinx.android.synthetic.main.fragment_result.*

class ResultFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(arguments != null){
            val nilaiPlayer = ResultFragmentArgs.fromBundle(requireArguments()).playerScore
            textScore.text = "Your score is $nilaiPlayer"
        }

        buttonBack.setOnClickListener{
            val action = ResultFragmentDirections.actionMainFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}