package MTSSynthesis.controller.model.gr;

import MTSTools.ac.ic.doc.mtstools.model.LTS;
import MTSTools.ac.ic.doc.mtstools.model.impl.MTSAdapter;
import MTSSynthesis.controller.game.gr.StrategyState;
import MTSSynthesis.controller.game.gr.concurrency.TransientFunction;
import MTSSynthesis.controller.game.gr.concurrency.TransientGameSolver;
import MTSSynthesis.controller.game.util.GRGameBuilder;
import MTSSynthesis.controller.game.util.GameStrategyToLTSBuilder;
import MTSSynthesis.controller.game.util.GenericLTSStrategyStateToStateConverter;
import MTSSynthesis.controller.model.GRGameControlProblem;
import MTSSynthesis.controller.model.gr.concurrency.GRCGame;

public class TransientControlProblem<S,A,M> extends GRGameControlProblem<S, A, M> {
	
	GRGame<S> g;

	public TransientControlProblem(LTS<S, A> environment, GRControllerGoal<A> grControllerGoal){
		super(environment, grControllerGoal);
	}
	
	@Override
	protected LTS<S, A> primitiveSolve() {
		return new GenericLTSStrategyStateToStateConverter<S, A, Integer>().transform(rawSolve()); 
	}
	
	@Override
	public	LTS<StrategyState<S, Integer>, A>  rawSolve(){
		GRCGame<S> cgame = new GRGameBuilder<S, A>().buildGRCGameFrom(new MTSAdapter<S,A>(environment), grControllerGoal);
		g = cgame;
		TransientFunction<S> function = new TransientFunction<S>(environment.getStates());
		TransientGameSolver<S,A> solver = new TransientGameSolver<S,A>(cgame, environment, function, cgame.getGoal().getGuarantee(cgame.getGoal().getGuarantees().size()).getStateSet());
		LTS<StrategyState<S, Integer>, A> result = GameStrategyToLTSBuilder.getInstance().buildLTSFrom(environment,solver.buildStrategy());
		result.removeUnreachableStates();
		return result;
	}
	
	@Override
	public GRGame<S> getGRGame() {
		return g;
	}
}
