package com.example.basicsandroid.model

import java.math.BigDecimal

data class Product(
    val name: String = "",
    val price: BigDecimal = BigDecimal(0.0), val description: String = ""
) : java.io.Serializable {


}
