package utt.xjy_szy.lo02_projet.game;

/**
 * the Context Class, the Strategy Pattern
 * the property is strategy
 * @author Jiayin XU
 * @author Zhengyang SU
 */
public class Context {
	
	private Strategy strategy;
	/**
	 * the constructor of Context Class
	 * @param strategy the strategy
	 */
	public Context(Strategy strategy) {
		// TODO Auto-generated constructor stub
		this.strategy = strategy;
	}
	
	/**
	 * execute the strategy 
	 * @param carpet the carpet of game
	 * @param card the card in hand
	 */
	public void executeStrategy(Carpet carpet,Card card) {
		strategy.PlayStrategy(carpet,card);	
	}
}
