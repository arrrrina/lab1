import FigureServiceImpl.addCircle
import FigureServiceImpl.addSquare
import FigureServiceImpl.getArea
import FigureServiceImpl.getPerimeter

interface ConsoleService {
    fun work()
}
object ConsoleServiceImpl : ConsoleService {
    private fun getOperation(number: String) : Operation {
       return when(number){
            "1" -> Operation.INSERT
            "2" -> Operation.GET_AREA
            "3" -> Operation.GET_PERIMETER
            "4" -> Operation.EXIT
            else -> throw WrongOperationTypeException();
        }
    }

    override fun work() {
        while (true) {
            println("Введите тип операции, которую хотите исполнить:\n1) добавить фигуру\n2) получить площадь всех фигур\n3) получить периметр всех фигур\n4) завершить выполнение")
            val number = readln();
            try {
                val operation = getOperation(number)
                when (operation) {
                    Operation.INSERT -> addFigure()
                    Operation.GET_AREA -> { println(getArea()) }
                    Operation.GET_PERIMETER -> { println(getPerimeter()) }
                    Operation.EXIT -> break
                }
            }
            catch (e : WrongOperationTypeException){
                println("Введен неизвестный тип операции $number")
            }
        }
    }
    private fun addFigure(){
        println("Введите тип фигуры, который хотите добавить:\n1) Круг\n2) Квадрат")
        val figure = readln()
        println("Введите величину")
        val input = readln()
        try {
            val property = input.toDouble()
            when (figure){
                "1" -> addCircle(property)
                "2" -> addSquare(property)
                else -> println("Неправильный ввод")
            }
        }
        catch (e: NumberFormatException) {
            println("Введено неверное значение параметра property $input")
        }
        catch (e: BadPropertyException) {
            println("Введено неверное значение параметра property $input")
        }
    }
}