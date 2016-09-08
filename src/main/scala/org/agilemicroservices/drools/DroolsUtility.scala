package org.agilemicroservices.drools

import org.drools.model.DSL._
import org.drools.model.{Rule, Variable}
import org.drools.pojorule.PojoRuleAnalyzer
import org.drools.pojorule.PojoRuleAnalyzer.toRule
import org.reflections.Reflections
import org.drools.model.DSL._

import scala.collection.JavaConversions._
import scala.collection.mutable.ListBuffer

object DroolsUtility {

  implicit def javaBigDecimal2bigDecimal(x: java.math.BigDecimal): BigDecimal = BigDecimal(x)
  implicit def bigDecimal2JavaBigDecimal(x: BigDecimal): java.math.BigDecimal = x.bigDecimal

  def getRulesFromPackage(packageToScan : String ) : Array[Rule] = {
      val reflections = new Reflections(packageToScan)

      val annotatedClasses = reflections.getTypesAnnotatedWith(classOf[DroolsRule])
      val rules = new ListBuffer[Rule]()

      for ( clazz  <- annotatedClasses) {
        println (clazz.getName)
        rules += PojoRuleAnalyzer.toRule(clazz)
      }

      return rules.toArray
   }
}
