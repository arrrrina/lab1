 internal class Circle(property: Double) : Figure(property) {
    init{
        println("Circle(property=$property)")
    }
     override fun getPerimeter() : Double {
        return 2 * Math.PI * property
    }
     override fun getArea() : Double{
        return Math.PI * property * property
    }
}