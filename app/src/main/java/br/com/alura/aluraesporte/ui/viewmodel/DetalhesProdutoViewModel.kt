package br.com.alura.aluraesporte.ui.viewmodel

import androidx.lifecycle.ViewModel
import br.com.alura.aluraesporte.repository.ProdutoRepository

class DetalhesProdutoViewModel(
    produtoId: Long,
    repository: ProdutoRepository
) : ViewModel() {

    val produtoEncontrado = repository.buscaPorId(produtoId)

}