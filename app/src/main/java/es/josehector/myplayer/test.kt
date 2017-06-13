package es.josehector.myplayer

/**
 * Created by josehector on 3/06/17.
 */


fun test4(myInt: Int?) {
    val myInt: Int? = null
    val myLong: Long = myInt?.toLong() ?: 0L
}

fun test3() {
    val sum = 9 addition 10
}

infix fun Int.addition(other: Int) = this + other


fun test2(items: List<MediaItem>){
    val urlList: List<String> = items
            .filter { it.type == MediaItem.Type.PHOTO }
            .sortedBy { it.title }
            .map { it.thumbUrl }
}


fun doAsync(x: Int, callback: (String) -> Unit){
    //Background
   callback("finished")
}

fun test1() {
    doAsync(20) {result -> print(result)}
}


open class Person(name: String, val age: Int) {
    var name: String = name
        get() = "Name: $field"
        set(value) {
            if (value != field) {
                field = value
            }
        }
}

//class Developer : Person {
    //constructor(name: String) : super(name)
    //constructor(age: Int) : super(age)
//}

fun test() {
    val sum = {a: Int, b: Int -> a + b}
    applyOp(2,3,sum)

    applyOp(2,3){x,y -> x - y}
}

fun applyOp(x: Int, y:Int, f: (Int,Int) -> Int): Int {
    return f(x,y)
}