package superlord.prehistoricfauna.entity.ai;

import superlord.prehistoricfauna.entity.ai.PrehistoricEntityTypeAI;

public interface IPrehistoricAI {

	PrehistoricEntityTypeAI.Moving aiMovingType();

	PrehistoricEntityTypeAI.Activity aiActivityType();

	PrehistoricEntityTypeAI.Attacking aiAttackType();

	PrehistoricEntityTypeAI.Climbing aiClimbType();

	PrehistoricEntityTypeAI.Following aiFollowType();

	PrehistoricEntityTypeAI.Jumping aiJumpType();

	PrehistoricEntityTypeAI.Response aiResponseType();

	PrehistoricEntityTypeAI.Stalking aiStalkType();

	PrehistoricEntityTypeAI.Taming aiTameType();

	PrehistoricEntityTypeAI.Untaming aiUntameType();

	PrehistoricEntityTypeAI.WaterAbility aiWaterAbilityType();

}