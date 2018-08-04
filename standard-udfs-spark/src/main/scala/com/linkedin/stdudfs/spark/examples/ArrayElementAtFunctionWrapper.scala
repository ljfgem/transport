package com.linkedin.stdudfs.spark.examples

import java.util

import com.google.common.collect.ImmutableList
import com.linkedin.stdudfs.api.udf.{StdUDF, TopLevelStdUDF}
import com.linkedin.stdudfs.examples.ArrayElementAtFunction
import com.linkedin.stdudfs.spark.StdUdfWrapper
import org.apache.spark.sql.catalyst.expressions.Expression


case class ArrayElementAtFunctionWrapper(expressions: Seq[Expression]) extends StdUdfWrapper(expressions) {

  override protected def getTopLevelUdfClass: Class[_ <: TopLevelStdUDF] = classOf[ArrayElementAtFunction]

  override protected def getStdUdfImplementations: util.List[_ <: StdUDF] = ImmutableList.of(
    new ArrayElementAtFunction()
  )
}
