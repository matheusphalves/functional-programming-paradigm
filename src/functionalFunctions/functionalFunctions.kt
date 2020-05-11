package functionalFunctions

import data_structures.NodeList

//MAP - maps all the elements in a list and applies each values to a function to generate a new value. A new list is created
//FILTER - Create a new data structure, where each value agree a condition determinate by a function.
//REDUCE - Reduce all the values to a single representative value
fun <Int>map(no: NodeList<Int>?, f:(Int) -> Int):NodeList<Int>?{
    if(no==null)
        return null
    else
        return NodeList(f(no.info), map(no.prox, f))
}

fun <Int>filter(no:NodeList<Int>?, f:(Int) -> Boolean):NodeList<Int>?{
    if(no==null)
        return null
    else{
        if(f(no.info))
            return NodeList(no.info,filter(no.prox,f))
        else
            return filter(no.prox,f)
    }
}

fun <Int>reduce(no:NodeList<Int>?, value:Int, f:(Int, Int) -> Int):Int{
    if(no!=null)
        return f(no.info, reduce(no.prox, value, f))
    else
        return value
}

//EXAMPLES
fun main():Unit{
    val list = NodeList(1, NodeList(2, NodeList(10, NodeList(4, NodeList(3, null)))))
    val mapList = map(list, {x:Int -> x*20})
    val filterList = filter(list, {x:Int -> x%2!=0})
    val reduceList = reduce(list, 0, {x:Int, y:Int -> x + y})

    println(mapList)
    println(filterList)
    println(reduceList)


}