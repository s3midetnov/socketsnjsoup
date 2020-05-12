object STest extends App {

  val x = scala.io.StdIn.readLine()
  val y = scala.io.StdIn.readLine()

  val xx = x.toInt
  val yy = y.toInt


  if ((xx + 1) % 5 == yy || (xx + 3) % 5 == yy) {
    print(x + " wins")

  }
  else {
    print(y + " wins")
  }
}
