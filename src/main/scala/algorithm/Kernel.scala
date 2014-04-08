package algorithm

object Kernel {

  //��˹�˺���
  def GuassionKernel(xj: LabeledFeature,
    xi: LabeledFeature): Double = {
    val sum = 0.0
    val zips = xj.features.zip(xi.features)
    val va = zips.map(t => (t._1.toDouble - t._2.toDouble)
      * (t._1.toDouble - t._2.toDouble))
    math.exp(-1 * va.reduce(_ + _) / 0.4)
  }

  //���Ժ˺���
  def linearKernel(xj: LabeledFeature,
    xi: LabeledFeature): Double = {

    xi.features.zip(xj.features).
      map(t => t._1.toDouble * t._2.toDouble).reduce(_ + _)

  }

  //����ʽ�˺���
  def polymonialKernel(xj: LabeledFeature,
    xi: LabeledFeature): Double = {
    val p = 3
    val sum = linearKernel(xj, xi)
    math.pow(sum + 1, p)
  }

  //�ڻ������Ժ˺���
  def innerProduct(a1: LabeledFeature,
    a2: LabeledFeature): Double = {
    a1.features.zip(a2.features).map(t => {
      t._1.toDouble * t._2.toDouble
    }).sum
  }

  //RBF�˺���
  def rbfKernel(xj: LabeledFeature,
    xi: LabeledFeature): Double = {
    //e^-(gamma * <x-y, x-y>^2)
    val sum = 0.0
    val zips = xj.features.zip(xi.features)
    val va = zips.map(t => (t._1.toDouble - t._2.toDouble) *
      (t._1.toDouble - t._2.toDouble))

    val gama = 0.01
    math.exp(-gama * va.reduce(_ + _))

  }
}