package br.com.alura.aluraesporte.ui.activity

import android.os.Bundle
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
        if (savedInstanceState == null) {
            val produtosFragment: ListaProdutosFragment by inject()
            transacaoFragment {
                replace(R.id.container, produtosFragment)
            }
        }
    }

    override fun onAttachFragment(fragment: Fragment?) {
        super.onAttachFragment(fragment)
        when (fragment) {
            is ListaProdutosFragment -> {
                fragment.quandoProdutoSelecionado = { produtoSelecionado ->
                    val detalhesProdutoFragment: DetalhesProdutoFragment by inject()
                    val argumentos = Bundle()
                    argumentos.putLong(CHAVE_PRODUTO_ID, produtoSelecionado.id)
                    detalhesProdutoFragment.arguments = argumentos
                    transacaoFragment {
                        addToBackStack(null)
                        replace(R.id.container, detalhesProdutoFragment)
                    }
                }
            }
            is DetalhesProdutoFragment -> {
                fragment.quandoProdutoComprado = { produtoComprado ->
                    val pagamentoFragment: PagamentoFragment by inject()
                    val dado = Bundle()
                    dado.putLong(CHAVE_PRODUTO_ID, produtoComprado.id)
                    pagamentoFragment.arguments = dado
                    transacaoFragment {
                        addToBackStack(null)
                        replace(R.id.container, pagamentoFragment)
                    }
                }
            }
            is PagamentoFragment -> {
                fragment.quandoPagamentoRealizado = {
                    Toast.makeText(this, COMPRA_REALIZADA, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

}
