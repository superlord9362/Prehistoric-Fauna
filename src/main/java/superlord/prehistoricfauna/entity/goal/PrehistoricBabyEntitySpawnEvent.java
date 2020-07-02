package superlord.prehistoricfauna.entity.goal;

import javax.annotation.Nullable;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.eventbus.api.Cancelable;
import superlord.prehistoricfauna.entity.PrehistoricStagedEntity;
import superlord.prehistoricfauna.entity.ThreeStageAgeEntity;

@Cancelable
public class PrehistoricBabyEntitySpawnEvent extends net.minecraftforge.eventbus.api.Event
{
    private final PrehistoricStagedEntity parentA;
    private final PrehistoricStagedEntity parentB;
    private final PlayerEntity causedByPlayer;
    private ThreeStageAgeEntity child;

    public PrehistoricBabyEntitySpawnEvent(PrehistoricStagedEntity parentA, PrehistoricStagedEntity parentB, @Nullable ThreeStageAgeEntity proposedChild)
    {
        //causedByPlayer calculated here to simplify the patch.
        PlayerEntity causedByPlayer = null;
        if (parentA instanceof PrehistoricStagedEntity) {
            causedByPlayer = ((PrehistoricStagedEntity)parentA).getLoveCause();
        }

        if (causedByPlayer == null && parentB instanceof PrehistoricStagedEntity)
        {
            causedByPlayer = ((PrehistoricStagedEntity)parentB).getLoveCause();
        }

        this.parentA = parentA;
        this.parentB = parentB;
        this.causedByPlayer = causedByPlayer;
        this.child = proposedChild;
    }

    public PrehistoricStagedEntity getParentA()
    {
        return parentA;
    }

    public PrehistoricStagedEntity getParentB()
    {
        return parentB;
    }

    @Nullable
    public PlayerEntity getCausedByPlayer()
    {
        return causedByPlayer;
    }

    @Nullable
    public ThreeStageAgeEntity getChild()
    {
        return child;
    }

    public void setChild(ThreeStageAgeEntity proposedChild)
    {
        child = proposedChild;
    }
}