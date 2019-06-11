package br.com.alura.aluraesporte.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import br.com.alura.aluraesporte.R
import br.com.alura.aluraesporte.ui.fragment.DetalhesProdutoFragment
import br.com.alura.aluraesporte.ui.fragment.ListaProdutosFragment
import br.com.alura.aluraesporte.ui.fragment.PagamentoFragment
import org.koin.android.ext.android.inject

private const val COMPRA_REALIZADA = "Compra realizada"

class ProdutosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.produtos_activity)
    }

}
