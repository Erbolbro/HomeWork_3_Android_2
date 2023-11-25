class Store {
    private val products = mapOf(
        1 to Product("iphone 6", 7000),
        2 to Product("iphone 7", 8000),
        3 to Product("iphone 8+", 10000),
        4 to Product("iphone 11", 20000),
        5 to Product("iphone 11 pro", 30000),
        5 to Product("iphone xs ", 20000)

    )

    fun printAllProducts() {
        products.forEach { (id, product) ->
            println("ID: $id, Название: ${product.name}, Цена: ${product.price}")
        }
    }

    fun buy(productId: Int, user: User) {
        when (productId) {
            in products.keys -> {
                val product = products[productId]!!
                val totalPrice = product.price

                if (totalPrice <= user.balance) {
                    user.balance -= totalPrice

                    println("Вы купили: ${product.name}")
                    println("Списано с баланса: $totalPrice")
                    println("Адрес доставки: ${user.address}")
                    println("Остаток на балансе: ${user.balance}")
                } else {
                    println("Недостаточно средств на балансе")
                }
            }
            else -> {
                println("Вы ввели неверный ID товара")
            }
        }
    }
}
