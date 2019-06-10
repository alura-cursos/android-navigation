package br.com.alura.aluraesporte.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.com.alura.aluraesporte.database.converter.ConversorBigDecimal
import br.com.alura.aluraesporte.database.dao.PagamentoDAO
import br.com.alura.aluraesporte.database.dao.ProdutoDAO
import br.com.alura.aluraesporte.model.Pagamento
import br.com.alura.aluraesporte.model.Produto

@Database(
    version = 2,
    entities = [Produto::class, Pagamento::class],
    exportSchema = false
)
@TypeConverters(ConversorBigDecimal::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun produtoDao(): ProdutoDAO
    abstract fun pagamentoDao(): PagamentoDAO
}