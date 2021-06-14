package utt.xjy_szy.lo02_projet.game;
/**
 * the interface of Element, the Visitor Pattern
 * @author Jiayin XU
 * @author Zhengyang SU
 */
public interface Element {
	
	/**
	 * acceptor of Visitor pattern
	 * @param p person
	 * @param c carpet
	 * @author Jiayin XU
	 * @author Zhengyang SU
	 */
	public void accept(Carpet c);
}
