package org.speckle

import scala.language.experimental.macros
import scala.reflect.makro.Context

object Macros {

  /*
   * Describe a method, usually using "#" when preceeding instance methods
   * and "." when preceeding static methods or fucntions.
   */
  def describe(description: String): Unit = macro specify

  /*
   * The implementation of the describe and context macros is the specify
   * function.
   */
  def specify(c: Context)(description: c.Expr[String]): c.Expr[Unit] = {
    import c.mirror._
    reify(description.eval.r)
  }
}
