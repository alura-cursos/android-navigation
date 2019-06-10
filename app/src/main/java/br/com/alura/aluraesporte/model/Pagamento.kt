package br.com.alura.aluraesporte.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity(
    foreignKeys = [ForeignKey(
        entity = Produto::class,
        parentColumns = ["id"],
        childColumns = ["produtoId"]
    )],
    indices = [Index("produtoId")]
)
class Pagamento(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val numeroCartao: Int,
    val dataValidade: String,
    val cvc: Int,
    val preco: BigDecimal,
    val produtoId: Long
)