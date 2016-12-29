package ltsa.lts;

public class ThreeValuedModelCheckerOutput implements LTSOutput {

	private boolean overApproximationCheckPerformed = false;
	private boolean underApproximationCheckPerformed = false;

	private ModelCheckerResult result = ModelCheckerResult.FALSE;

	public ModelCheckerResult getResult() {
		return this.result;
	}

	@Override
	public void out(String str) {
		this.check(str);
	}

	@Override
	public void outln(String str) {
		this.check(str);
	}

	@Override
	public void clearOutput() {

	}

	private void check(String str) {
		if(str.startsWith("ERROR line")){
			System.out.println(str);
		}
		if (!overApproximationCheckPerformed) {
			if (str.contains("satisfies")) {
				result = ModelCheckerResult.TRUE;
				overApproximationCheckPerformed = true;
			} else {
				if (str.contains("does not satisfy")) {
					result = ModelCheckerResult.MAYBE;
					overApproximationCheckPerformed = true;
				} else {
					if (str.contains("No deadlocks/errors")) {
						result = ModelCheckerResult.TRUE;
						overApproximationCheckPerformed = true;
					}
				}
			}
		} else {
			if (!underApproximationCheckPerformed
					&& !(result == ModelCheckerResult.TRUE)) {
				if (str.contains("does not satisfy")) {
					result = ModelCheckerResult.FALSE;
					underApproximationCheckPerformed = true;
				} else {
					if (str.contains("No deadlocks/errors")) {
						result = ModelCheckerResult.MAYBE;
						underApproximationCheckPerformed = true;
					}
					else{
						if (str.contains("satisfies")) {
							result = ModelCheckerResult.MAYBE;
							underApproximationCheckPerformed = true;
						}
					}
				}
			}
		}
	}
}
