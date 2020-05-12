package sockets


import java.io.PrintWriter
import java.net.{ServerSocket, Socket}
import java.util.Scanner


object Server extends App {

  val srv: ServerSocket = new ServerSocket(1337)
  println("server started")

  val player1: Socket = srv.accept(); //wait for connection ...
  val toP1 = new PrintWriter(player1.getOutputStream, true)
  val fromP1 = new Scanner(player1.getInputStream)
  toP1.println("i Player 1 welcome to game, enter your name:") //greet

  val player2: Socket = srv.accept(); //wait for connection ...
  val toP2 = new PrintWriter(player2.getOutputStream, true)
  val fromP2 = new Scanner(player2.getInputStream)
  toP2.println("i Player 2 welcome to game, enter your name:") //greet

  val p1Name = fromP1.nextLine()
  val p2Name = fromP2.nextLine()


  //  println(s"player 1 name: $p1Name")
  //  println(s"player 2 name: $p2Name")

  def sendall(st: String): Unit = {
    println(st)
    toP1.println(st)
    toP2.println(st)
  }

  sendall(s"player 1 name: $p1Name")
  sendall(s"player 2 name: $p2Name")


  var p1: Integer = 0
  var all: Integer = 0
  var p2 = all - p1

  def numer(s: String): Int = {
    if (s == "Камень") return 2
    if (s == "Ножницы") return 0
    if (s == "Бумага") return 1
    if (s == "Ящерица") return 3
    if (s == "Спок") return 4
    if (s == "Счет") return 2020
    if (s == "Конец") return 5050
    else return 0;
  }

  def resul(x: Int, y: Int): Unit = {
    if (x == 5050 || y == 5050) System.exit(0)
    else {
      if (x == 2020 || y == 2020) sendall(p1 + ":" + p2)
      else {
        if ((x + 1) % 5 == y || (x + 3) % 5 == y) {
          sendall(p1Name + " won")
          p1 += 1
          all += 1
        }
        else {
          sendall(p2Name + " won")
          all += 1
        }
      }
    }
  }


  while (true) {
    game()
  }

  //  sendall("now you'll choose")
  def game(): Unit = {
    sendall(s"i enter your figure")
    val p1ch = fromP1.nextLine()
    println(p1ch)
    val p2ch = fromP2.nextLine()
    println(p2ch)
    val p1fig = numer(p1ch)
    val p2fig = numer(p2ch)
    resul(p1fig, p2fig)
  }




  /*


        if (p2fig == p1fig) {
          sendall(s"draw")
        }
        else {
          all = all + 1
          if (((p2fig > p1fig) & !(p2fig == 3 & p1fig == 1)) || (p2fig == 1 & p1fig == 3)) {
            val fedB = p2Name + " " + "won"
            sendall(fedB)
          }
          else {
            val fedB = p1Name + " " + "won"
            sendall(fedB)
            p1 = p1 + 1
            all = all + 1
          }
        }












  def resol(): Unit = {
    val p1Com = fromP1.nextLine()
    val p2Com = fromP2.nextLine()


      if (p1Com == "score" || p2Com == "score") {
        sendall("send score")
        sendall(p1 + ":" + p2)
        resol()
      }
      else {
        if (p1Com == "game" || p2Com == "game") {
          sendall("game mode")
          game()
        }
    }

  } // making decisions based on user's choices






  }
*/
}
