package br.com.alura.aluraesporte.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.aluraesporte.R
import br.com.alura.aluraesporte.extensions.formatParaMoedaBrasileira
import br.com.alura.aluraesporte.model.Produto
import kotlinx.android.synthetic.main.item_produto.view.*

class ProdutosAdapter(
    private val context: Context,
    private val produtos: MutableList<Produto> = mutableListOf(),
    var onItemClickListener: (produto: Produto) -> Unit = {}
) : RecyclerView.Adapter<ProdutosAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewCriada = LayoutInflater.from(context).inflate(
            R.layout.item_produto,
            parent,
            false
        )
        return ViewHolder(viewCriada)
    }

    override fun getItemCount() = produtos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.vincula(produtos[position])
    }

    fun atualiza(produtosNovos: List<Produto>) {
        notifyItemRangeRemoved(0, produtos.size)
        produtos.clear()
        produtos.addAll(produtosNovos)
        notifyItemRangeInserted(0, produtos.size)
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        private lateinit var produto: Produto
        private val campoNome by lazy { itemView.item_produto_nome }
        private val campoPreco by lazy { itemView.item_produto_preco }

        init {
            itemView.setOnClickListener {
                if (::produto.isInitialized) {
                    onItemClickListener(produto)
                }
            }
        }

        fun vincula(produto: Produto) {
            this.produto = produto
            campoNome.text = produto.nome
            campoPreco.text = produto.preco.formatParaMoedaBrasileira()
        }

    }

}
