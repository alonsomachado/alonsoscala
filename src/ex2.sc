var lista = List(1,-1,3,9,0,12,-4,-5,0,2);
var listateste = List(1,2,3,4,-7,9,10);
var listapares = List(2,4,6,8,10);

def maximo(lista : List[Int]) ={ //Exercicio 2.1
  lista reduceLeft ((left, right) => if (left > right) left else right)
}
maximo(listateste)

def media (lista: List[Int]) = { //Exercicio 2.2
  lista.reduceLeft ((acc, elem) => acc + elem) / lista.length.toFloat
}
media(listateste)
media(lista)

def intervalo (lista: List[Int], a:Int, b:Int) = { //Exercicio 2.3
  lista.filter(x =>  x >= a && x <= b)
}
intervalo(lista, 3, 20)

def somatorioPares(lista: List[Int]): Int ={ //Exercicio 2.4
 //Usar Filter depois Reduce
  //lista.reduceLeft ((acc, elem) => if (elem % 2 == 0) acc+elem else acc)
  lista.fold(0) ((acc, elem) => if (elem % 2 == 0) acc+elem else acc)
}
somatorioPares(listapares)
somatorioPares(lista)
def todosPares(lista: List[Int]): Boolean ={ //Exercicio 2.5
  //Usar Filter depois Reduce
  lista.forall( _ % 2 == 0)
}
todosPares(listapares)

def toCardinals(lista: List[Int]) ={ //Exercicio 2.6
  lista.foreach( elem => {
    (1 to Math.abs(elem)).foreach(_ => print("#"))
    println()
  })
}
toCardinals(lista)

def paraPositivos(lista: List[Int]) ={ //Exercicio 2.7
  lista.map(Math.abs)
}
paraPositivos(lista)

def histogramaNumeros(lista: List[Int]): List[(Int,Int)] ={ //Exercicio 2.8
  lista.map(elem => (elem,1)).groupBy(x => x._1).map(elem => (elem._1, elem._2.size)).toList

}
histogramaNumeros(lista)






