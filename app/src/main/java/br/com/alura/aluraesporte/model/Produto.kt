package br.com.alura.aluraesporte.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity
class Produto(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val nome: String,
    val preco: BigDecimal
)
