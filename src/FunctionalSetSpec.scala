
object FunctionalSetSpec extends FunctionalSet with App {

  // Should return true if set contains the number, false if does not
  val testContains = (x : Int) => x == 10
  assert(isMember(10, testContains))
  assertFalse(isMember(1, testContains))

  val testPredicate = (x : Int) => x > 5

  // Forall should returns true when all elem satisfy predicate
  val test1Set = (x : Int) => x == 10
  assert(forall(test1Set, testPredicate))

  // Forall should return false when predicate not satisfied
  val test2Set = (x : Int) => x == 1
  assertFalse(forall(test2Set, testPredicate))

  // Forall should return false when predicate not satisfied with multiple inputs
  val test3Set = (x : Int) => 1 <= x && x <= 10
  assertFalse(forall(test3Set, testPredicate))

  //Sets with values over 1000 should return true since it is outside the bounds
  val upperBoundedSet = (x : Int) => 1001 <= x && x <= 1002
  assert(forall(upperBoundedSet, testPredicate))

  //Sets with values under 1000 should return true since it is outside the bounds
  val lowerBoundedSet = (x : Int) => -2000 <= x && x <= -1001
  assert(forall(lowerBoundedSet, testPredicate))


  def assertFalse(x: Boolean) = assert(!x)


}
