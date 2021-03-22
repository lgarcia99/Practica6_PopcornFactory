package garcia.luis.popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_detalle_pelicula.*

class DetallePelicula : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pelicula)

        val bundle = intent.extras
        var seats = 0
        var id = -1
        var title = ""

        if (bundle != null){
            seats = bundle.getInt("numberSeats")
            title = bundle.getString("titulo")!!

            tv_pelicula_img.setImageResource(bundle.getInt("header"))
            tv_pelicula_titulo.text = bundle.getString("titulo")
            tv_pelicula_desc.text = bundle.getString("sinopsis")
            seats_left.setText("$seats seats available")
            id = bundle.getInt("pos")
        }

        if (seats == 0) {
            buy_ticket.isVisible = false
        } else {
            buy_ticket.setOnClickListener {
                val intent: Intent = Intent(this, SeatSelection::class.java)

                intent.putExtra("id", id)
                intent.putExtra("name", title)

                startActivity(intent)
            }
        }
    }
}
