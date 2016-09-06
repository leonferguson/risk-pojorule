package org.agilemicroservices.drools

import org.drools.model.Rule
import org.drools.pojorule.PojoRuleAnalyzer.toRule
import org.reflections.Reflections

import scala.collection.JavaConversions._
import scala.collection.mutable.ListBuffer

object DroolsUtility {

  def getRulesFromPackage(packageToScan : String ) : Array[Rule] = {
      val reflections = new Reflections(packageToScan)

      val annotatedClasses = reflections.getTypesAnnotatedWith(classOf[DroolsRule])
      val rules = new ListBuffer[Rule]()

      for ( clazz  <- annotatedClasses) {
        println (clazz.getName)
        rules += toRule(clazz)
      }

      return rules.toArray
   }
}
