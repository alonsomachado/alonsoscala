var lista = List("Eu", "gosto", "muito", "de", "programar", "em", "Scala");
//lista.fold(0) ((acc, elem) => if (elem.conta % 2 == 0) acc+elem else acc)
var word = "TransForMe"
def contemCaracter(lista : List[String], a: Char) ={ //Exercicio 3.1
  lista.filter(x => x.contains(a))
}
contemCaracter(lista, 'm')

def contaCaracteres(lista : List[String]) ={ //Exercicio 3.2
  //lista.map(elem => elem.length).sum (Solucao de outro)
  //lista.foldLeft(0)((acc, elem) => acc + elem.size) (Solucao de professor)
  lista.flatten.size
}
contaCaracteres(lista)

def paraMaiusculas(lista : List[String]) ={ //Exercicio 3.3
  //lista.toCharArray.toUpperCase
  lista.map( _.toUpperCase() )
  //word.toUpperCase()
}
paraMaiusculas(lista)

def paraMaiustulasN(lista : List[String], n: Int) ={ //Exercicio 3.4
  //lista.toCharArray.toUpperCase
  lista.filter(_.size > n).map( _.toUpperCase() )
  //word.toUpperCase()
}
paraMaiustulasN(lista,3)

def imprimeCharAChar(lista : List[String]) ={ //Exercicio 3.5
  //lista.foreach(x => x.toCharArray.foreach(println)) (Solucao de professor)
  lista.flatten.foreach( elem => println(elem))
}
imprimeCharAChar(lista)
def tamanhos(lista : List[String]) ={ //Exercicio 3.6
  lista.map(elem => (elem,elem.size))
}
tamanhos(lista)

def histogramaCaracteres(lista : List[String]) ={ //Exercicio 3.7
 // lista.flatten.map(elem => (elem,1)).groupBy(x => x._1)
  lista.map(string => string.toCharArray.map(elem => (elem,1))).flatten.groupBy(x => x._1).map(elem => (elem._1, elem._2.size)).toList.sorted
}
histogramaCaracteres(lista)


def listaDeCaracteres(lista : List[String]) ={ //Exercicio 3.8
  //lista.flatMap(elem => elem.toList).distinct
  lista.map(elem => elem.toCharArray).flatten.distinct.sorted
}
listaDeCaracteres(lista)