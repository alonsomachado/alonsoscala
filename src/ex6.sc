//var myDocumentList = io.Source.fromURL(getClass.getResource("/datasets/ign4.csv")).getLines.toList.drop(1)

def carregar() ={
  scala.io.Source.fromFile("C:\\Users\\alons\\IdeaProjects\\untitled\\src\\datasets\\ufo_sighting_data.csv")
  //scala.io.Source.fromFile("C:/Users/alons/IdeaProjects/untitled/src/ign_v2.csv")
  //scala.io.Source.fromFile("C:\\Users\\alons\\Downloads\\ign_v2.csv")
    .getLines()
    .toList
    .map(linha => linha.split(","))
    //.drop(1) //Drop 1 para retirar o HEADER
}

def UfosPorEstado() ={
  carregar().drop(1).filter(line => line(3) == "us")
    .groupBy(line => line(2))
    .map(x => (x._1, x._2.length))

}
UfosPorEstado()

def UfosEmPortugal() ={
  carregar().drop(1)
    .filter(_(1).toLowerCase().contains("portugal"))
    .map(line => (line(1), line(7)))
}
UfosEmPortugal()

