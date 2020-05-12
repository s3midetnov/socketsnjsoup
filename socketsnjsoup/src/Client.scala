package sockets

import java.io.PrintWriter
import java.net.Socket
import java.util.Scanner

object Client extends App {

  val srv: Socket = new Socket("localhost", 1337)
  val toServer = new PrintWriter(srv.getOutputStream, true)
  val fromServer = new Scanner(srv.getInputStream)

  println(fromServer.nextLine()) //greet
  val name = scala.io.StdIn.readLine() //
  //if (fromServer.hasNextLine) println(fromServer.nextLine())
  toServer.println(name) //send name

  while (true) {
    val word = fromServer.nextLine()
      println(word)
      if (word.charAt(0) == 'i') {
        val resp = scala.io.StdIn.readLine()
        toServer.println(resp)
      }
  }
}
