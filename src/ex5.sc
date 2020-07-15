//var myDocumentList = io.Source.fromURL(getClass.getResource("/datasets/ign4.csv")).getLines.toList.drop(1)

def carregar() ={
  scala.io.Source.fromFile("C:\\Users\\alons\\IdeaProjects\\untitled\\src\\datasets\\ign4.csv")
  //scala.io.Source.fromFile("C:/Users/alons/IdeaProjects/untitled/src/ign_v2.csv")
  //scala.io.Source.fromFile("C:\\Users\\alons\\Downloads\\ign_v2.csv")
    .getLines()
    .toList
    .map(linha => linha.split("\t"))
    .drop(1) //Drop 1 para retirar o HEADER
}

def melhorjogo() ={ //Exercicio 5.1
  val lista = carregar()
  lista.map( x => (x(2), x(5).toFloat))
    .groupBy(x => x._2)
    //.filter(x => x._2 > max  )
    //.reduce((left,right) => if(left._2 > right._2) left else right)
}
melhorjogo()

def jogosPorGenero() ={ //Exercicio 5.2
  val data = carregar()
  data.groupBy(line => line(6)).map( x => (x._1, x._2.length))
}
jogosPorGenero()

def scoreMedioJogo(name: String) ={ //Exercicio 5.3
  val data = carregar()
  val score = data.filter(list => list(2).contains(name)).map(list => list(5).toFloat)

  score.reduceLeft((acc,elem) => acc + elem) /score.size
}
scoreMedioJogo("Tekken")

def scoreMedioGenero(): Map[String,Double] ={ //Exercicio 5.4
  val data = carregar()
  data.groupBy(line => line(6))
    .map(x => (x._1, x._2.foldLeft(0.0) ((acc,line) => acc + line(5).toFloat) / x._2.length))

}
scoreMedioGenero()

def melhorPiorGenero(mapa: Map[String,Double]) ={
  (mapa.reduce((par1,par2) => if (par1._2 > par2._2) par1 else par2), mapa.reduce((par1,par2) => if (par1._2 > par2._2) par2 else par1))
}
melhorPiorGenero(scoreMedioGenero())
