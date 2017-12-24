trait FunctionalSet {
  type Set[T] = T => Boolean
  type IntSet = Set[Int]
  val restriction = 1000

  def isMember[T](element: T, set: Set[T]): Boolean = set(element)

  def forall(set: IntSet, predicate: Int => Boolean): Boolean = {
    def checkPredicate(element: Int): Boolean = {
      if (element < -restriction)
        true
      else if (isMember(element, set))
        predicate(element) && checkPredicate(element - 1)
      else
        checkPredicate(element - 1)
    }
    checkPredicate(restriction)
  }
}

