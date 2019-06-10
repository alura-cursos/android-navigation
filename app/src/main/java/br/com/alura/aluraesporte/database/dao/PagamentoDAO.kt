package br.com.alura.aluraesporte.database.dao

import androidx.room.Dao
import androidx.room.Insert
import br.com.alura.aluraesporte.model.Pagamento

@Dao
interface PagamentoDAO {

    @Insert
    fun salva(pagamento: Pagamento) : Long

}