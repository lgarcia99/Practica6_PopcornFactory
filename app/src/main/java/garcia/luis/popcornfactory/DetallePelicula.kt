package garcia.luis.popcornfactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detalle_pelicula.*

class DetallePelicula : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pelicula)

        val bundle = intent.extras

        if (bundle != null){


            tv_pelicula_img.setImageResource(bundle.getInt("header"))
            tv_pelicula_titulo.text = bundle.getString("titulo")
            tv_pelicula_desc.text = bundle.getString("sinopsis")
        }

    }
}
