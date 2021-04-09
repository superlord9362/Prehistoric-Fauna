package superlord.prehistoricfauna.util;

import javax.annotation.Nullable;

import net.minecraft.entity.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.eventbus.api.Cancelable;
import superlord.prehistoricfauna.entity.PrehistoricEntity;
import superlord.prehistoricfauna.entity.ThreeStageAgeEntity;

@Cancelable
public class BabyThreeStageSpawnEvent extends net.minecraftforge.eventbus.api.Event
{
    private final MobEntity parentA;
    private final MobEntity parentB;
    private final PlayerEntity causedByPlayer;
    private ThreeStageAgeEntity child;

    public BabyThreeStageSpawnEvent(MobEntity parentA, MobEntity parentB, @Nullable ThreeStageAgeEntity proposedChild)
    {
        //causedByPlayer calculated here to simplify the patch.
        PlayerEntity causedByPlayer = null;
        if (parentA instanceof PrehistoricEntity) {
            causedByPlayer = ((PrehistoricEntity)parentA).getLoveCause();
        }

        if (causedByPlayer == null && parentB instanceof PrehistoricEntity)
        {
            causedByPlayer = ((PrehistoricEntity)parentB).getLoveCause();
        }

        this.parentA = parentA;
        this.parentB = parentB;
        this.causedByPlayer = causedByPlayer;
        this.child = proposedChild;
    }

    public MobEntity getParentA()
    {
        return parentA;
    }

    public MobEntity getParentB()
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
