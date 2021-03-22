package garcia.luis.popcornfactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_seat_selection.*

class SeatSelection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seat_selection)

        var posMovie = -1
        val bundle = intent.extras

        if (bundle!=null) {
            titleSeats.setText(bundle.getString("name"))
            posMovie = bundle.getInt("id")
        }

        confirm.setOnClickListener {
            Toast.makeText(this, "Enjoy the movie!! :D", Toast.LENGTH_LONG).show()
        }

        row1.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId > -1) {
                row2.clearCheck()
                row3.clearCheck()
                row4.clearCheck()
            }
        }

        row2.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId > -1) {
                row1.clearCheck()
                row3.clearCheck()
                row4.clearCheck()
            }
        }

        row3.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId > -1) {
                row1.clearCheck()
                row2.clearCheck()
                row4.clearCheck()
            }
        }

        row4.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId > -1) {
                row1.clearCheck()
                row2.clearCheck()
                row3.clearCheck()
            }
        }
    }
}