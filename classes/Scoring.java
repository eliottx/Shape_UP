package utt.xjy_szy.lo02_projet.game;
/**
 * the interface of Scoring, Visitor Pattern
 * @see Person
 * @see Carpet
 * @see Card
 * @author Jiayin XU
 * @author Zhengyang SU
 */
public interface Scoring {
	
	/**
	 * calculate the score of player
	 * @param c the carpet
	 * @see Person
	 * @see Carpet
	 * @see Card
	 * @return the score
	 */
	public int Scoring(Carpet c);

}
