package high_order_functions

//01. Generate the following function: f(x) = a*x + b
fun generateFunction(a:Int, b:Int): (Int) -> Int = {x:Int -> a*x + b}

//02. Generate the following function f(x) = a*x. The term 'a' (a integer value) must be included by function parameter. Examples: f(x) = 2*x; f(x) = 3*x
fun f1(value:Int):(Int) -> Int = {x:Int -> value*x}

//03. Receive two high order functions and sum them
fun sum(f:(Int) -> Int, g:(Int) -> Int):(Int) -> Int = {x:Int -> f(x) + g(x)}

//04. Compare two functions and return the bigger function for the same point
fun biggerFunction(f:(Int) -> Int, g:(Int) -> Int):(Int) -> Int =
    { x: Int ->//retorn the bigger function
        when {
            f(x) > g(x) -> f(x)
            else -> g(x)
        }
    }

//05. Intern functions; you must return a new function where is compose by herself. There is a index which determinate how must times the 'composition' might occur.
//Example, for f(x) = 2*x and exp = 2 result -> f(f(x)) = 2*(2*x) = 4*x
fun internFunctions(f:(Int) -> Int, exp:Int): (Int) -> Int{

    if(exp<=1)
        return {x:Int -> f(x)} //função mais interna
    else{
        val a = internFunctions(f, exp-1) //aqui será formada a composição de funções
        return {x:Int -> f(a(x))}
        //função atual possui a composição interna como argumento
    }
}
