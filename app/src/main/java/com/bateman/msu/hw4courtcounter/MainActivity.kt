import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bateman.msu.hw4courtcounter.CounterViewModel
import com.bateman.msu.hw4courtcounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var counterViewModel: CounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        counterViewModel = ViewModelProvider(this).get(CounterViewModel::class.java)
        displayScores()

    }

    /**
     * Increase the score for Team A by 1 point.
     */
    fun addOneForTeamA(v: View?) {
        counterViewModel.scoreTeamA++
        displayScores()
    }

    /**
     * Increase the score for Team A by 2 points.
     */
    fun addTwoForTeamA(v: View?) {
        counterViewModel.scoreTeamA += 2
        displayScores()
    }

    /**
     * Increase the score for Team A by 3 points.
     */
    fun addThreeForTeamA(v: View?) {
        counterViewModel.scoreTeamA += 3
        displayScores()
    }

    /**
     * Increase the score for Team B by 1 point.
     */
    fun addOneForTeamB(v: View?) {
        counterViewModel.scoreTeamB++
        displayScores()
    }

    /**
     * Increase the score for Team B by 2 points.
     */
    fun addTwoForTeamB(v: View?) {
        counterViewModel.scoreTeamB += 2
        displayScores()
    }

    /**
     * Increase the score for Team B by 3 points.
     */
    fun addThreeForTeamB(v: View?) {
        counterViewModel.scoreTeamB += 3
        displayScores()
    }

    /**
     * Resets the score for both teams back to 0.
     */
    fun resetScore(v: View?) {
        counterViewModel.scoreTeamA = 0
        counterViewModel.scoreTeamB = 0
        displayScores()
    }

    private fun displayScores() {
        binding.teamAScore.text = counterViewModel.scoreTeamA.toString()
        binding.teamBScore.text = counterViewModel.scoreTeamB.toString()

    }
}