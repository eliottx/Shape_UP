package utt.xjy_szy.lo02_projet.game;

/**
 * the interface of Strategy, the Strategy Pattern
 * @author Jiayin XU
 * @author Zhengyang SU
 */
public interface Strategy {
	
	/**
	 * the strategy of virtuel player
	 * @param carpet the carpet
	 * @param card the card on hand
	 */
	public void PlayStrategy(Carpet carpet,Card card);

}
