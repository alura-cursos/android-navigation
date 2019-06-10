package br.com.alura.aluraesporte.ui.viewmodel

import androidx.lifecycle.ViewModel
import br.com.alura.aluraesporte.model.Pagamento
import br.com.alura.aluraesporte.repository.PagamentoRepository
import br.com.alura.aluraesporte.repository.ProdutoRepository

class PagamentoViewModel(
    private val pagamentoRepository: PagamentoRepository,
    private val produtodRepository: ProdutoRepository) : ViewModel() {

    fun salva(pagamento: Pagamento) = pagamentoRepository.salva(pagamento)
    fun buscaProdutoPorId(id: Long) = produtodRepository.buscaPorId(id)

}