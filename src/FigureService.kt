interface FigureService {
    fun addSquare(property: Double)
    fun addCircle(property: Double)
    fun getPerimeter(): Double
    fun getArea(): Double
}
object FigureServiceImpl : FigureService {
    private val figures = mutableListOf<Figure>()


    override fun addSquare(property: Double) {
        if(property <= 0){
            throw BadPropertyException()
        }
        figures.add(Square(property))
    }

    override fun addCircle(property: Double) {
        if(property <= 0){
            throw BadPropertyException()
        }
        figures.add(Circle(property))
    }

    override fun getPerimeter(): Double {
        return figures.sumOf {it.getPerimeter()}
    }

    override fun getArea(): Double {
        return figures.sumOf {it.getArea()}
    }
}