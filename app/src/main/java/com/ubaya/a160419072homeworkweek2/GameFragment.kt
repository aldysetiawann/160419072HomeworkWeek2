package id.ac.ubaya.adv160419092week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.ubaya.a160419072homeworkweek2.R
import kotlinx.android.synthetic.main.fragment_game.*
import kotlin.random.Random

class GameFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var nilai = 0
        var jawab = 0

        if(arguments != null){
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            textTurn.text = "$playerName's Turn"
        }
        jawab = playAgain()

        buttonSubmit.setOnClickListener{
            val myAnswer = textAnswer.text.toString().toInt()

            if(jawab.equals(myAnswer)){
                nilai += 1
                textAnswer.text?.clear()
                Toast.makeText(context,"Correct!",Toast.LENGTH_SHORT).show()
                jawab = playAgain()

            }
            else{
                val action = GameFragmentDirections.actionResultFragment(nilai)
                Navigation.findNavController(it).navigate(action)
            }
        }

    }

    fun playAgain():Int{
        val angka1 = Random.nextInt(1, 100)
        textAngkaSatu.text = angka1.toString()

        val angka2 = Random.nextInt(1, 100)
        textAngkaDua.text = angka2.toString()

        val answer = angka1+angka2
        return answer
    }

}