package coda.gummybear.common.items;

import coda.gummybear.init.GBEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import coda.gummybear.common.entities.GummyBearEntity;

public class GummyBearItem extends Item {
    public GummyBearItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        InteractionHand hand = context.getHand();
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Direction direction = context.getClickedFace();
        ItemStack itemstack = player.getItemInHand(hand);
        BlockState blockstate = level.getBlockState(pos);
        GummyBearEntity bear = GBEntities.GUMMY_BEAR.get().create(level);

        if (!level.isClientSide && bear != null) {
            BlockPos blockpos1;
            if (blockstate.getCollisionShape(level, pos).isEmpty()) {
                blockpos1 = pos;
            } else {
                blockpos1 = pos.relative(direction);
            }
            bear.moveTo(blockpos1.getX() + 0.5F, blockpos1.getY() + 0.5F, blockpos1.getZ() + 0.5F);
            bear.tame(player);
            bear.finalizeSpawn((ServerLevel) level, level.getCurrentDifficultyAt(player.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
            player.getItemInHand(hand).shrink(1);
            level.playSound(player, player.blockPosition(), SoundEvents.PANDA_AMBIENT, SoundSource.NEUTRAL, 1.0F, 1.0F);
            level.addFreshEntity(bear);
        }

        player.awardStat(Stats.ITEM_USED.get(this));
        if (!player.isCreative()) {
            itemstack.shrink(1);
        }

        return InteractionResult.SUCCESS;
    }
}