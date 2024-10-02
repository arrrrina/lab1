internal class Square(property: Double): Figure(property) {
    init{
        println("Square(property=$property)")
    }
    override fun getPerimeter() : Double {
        return 4 * property
    }
    override fun getArea() : Double{
        return property * property
    }
}